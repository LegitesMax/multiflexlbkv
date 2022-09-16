using Billbee.Api.Client.Model;
using CommonBase.Extensions;
using Frontend.AspMvc.Models;
using Frontend.Logic.Controllers;
using Frontend.Logic.Entities.Orders;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using PdfSharp.Drawing;
using PdfSharp.Drawing.Layout;
using PdfSharp.Pdf;
using System.Diagnostics;
using System.Drawing;
using System.Text;

namespace Frontend.AspMvc.Controllers
{
    public class HomeController : Controller
    {

        public static string status { get; set; } = "open";

        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public async Task<IActionResult> IndexAsync()
        {
            HttpClient client = new HttpClient();

            var productJson = await client.GetStringAsync("http://127.0.0.1:8080/Product/categoryAndColor");
            var model = GetOrdereItems();

            return View(model);
        }

        public IActionResult OpenOrders(object sender, EventArgs e)
        {
            status = "open";
            return View("Index", GetOrdereItems());
        }
        public IActionResult CanceledOrders(object sender, EventArgs e)
        {
            status = "canceled";
            return View("Index", GetCanceledItems());
        }
        public IActionResult ReadyOrders(object sender, EventArgs e)
        {
            status = "ready";
            return View("Index", GetReadyItems());
        }

        public void CreatePdf()
        {
            bool done = false;

            var test = status;

            if (status == "open")
            {
                var data = GetOrdereItems();
                if (data != null) done = ExportPdf(data, "Offene Bestellungen");

                else done = false;
            }
            if (status == "canceled")
            {
                var data = GetCanceledItems();
                if (data != null) done = ExportPdf(data, "Stornierte Bestellungen");
                else done = false;
            }
            if (status == "ready")
            {
                var data = GetReadyItems();
                if (data != null) done = ExportPdf(data, "Fertige Bestellungen");
                else done = false;
            }

            if (done == true) ViewData["pdfStatus"] = "succses";
            else ViewData["pdfStatus"] = "error";

            //return View("Index");
        }

        public IList<Logic.Entities.Orders.Order>? GetOrdereItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetOrderedOrders();

            var result = JsonConvert.DeserializeObject<IList<Logic.Entities.Orders.Orders>>(data);

            var orderResult = new List<Logic.Entities.Orders.Order>();
            foreach (var item in result)
            {
                orderResult.Add(new Logic.Entities.Orders.Order(item.OrderItems, item.ShippingAddress));
            }

            return orderResult;
        }

        public IList<Logic.Entities.Orders.Order>? GetCanceledItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetCancledOrders();

            var result = JsonConvert.DeserializeObject<IList<Logic.Entities.Orders.Order>>(data);

            return result;
        }

        public IList<Logic.Entities.Orders.Order>? GetReadyItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetReadyOrders();

            var result = JsonConvert.DeserializeObject<IList<Logic.Entities.Orders.Order>>(data);

            return result;
        }

        public static bool ExportPdf(IEnumerable<Logic.Entities.Orders.Order> data, string status)
        {
            var result = false;
            Encoding.RegisterProvider(CodePagesEncodingProvider.Instance);
            var shippingadresses = new List<string>();
            var sku = new List<string>();
            var quantity = new List<string>();
            if (data == null)
            {
                result = false;
            }
            else
            {
                result = true;
                foreach (var item in data)
                {
                    foreach (var item2 in item.OrderItems)
                    {
                        shippingadresses.Add(item.ShippingAddress.Country!);
                        sku.Add(item2.Product.SKU);
                        //quantity.Add(item2.Product.Quantity);
                        quantity.Add("1");
                    }
                }
            }
            //quantity.ForEach(x =>
            //{            
            //    if (x.IsNullOrEmpty())
            //    {
            //        x = "1";
            //    }
            //});
            //int count = 0;
            //foreach (var item in quantity)
            //{
            //    if (item == null)
            //    {
            //        quantity[count] = "1";
            //    }
            //    count++;
            //}



            PdfDocument document = new PdfDocument();
            document.Info.Title = "DataPDF";

            for (int p = 0; p < 1; p++)
            {
                // Page Options
                PdfPage pdfPage = document.AddPage();
                pdfPage.Height = 842;
                pdfPage.Width = 590;

                // Get an XGraphics object for drawing
                XGraphics graph = XGraphics.FromPdfPage(pdfPage);

                // Text format
                XStringFormat format = new XStringFormat();
                format.LineAlignment = XLineAlignment.Near;
                format.Alignment = XStringAlignment.Near;

                var tf = new XTextFormatter(graph);


                XFont fontParagraph = new XFont("Verdana", 8, XFontStyle.BoldItalic);
                XFont fontParagraph1 = new XFont("Verdana", 20, XFontStyle.BoldItalic);


                int el1_width = 80;//Breite der Ersten Reihe
                int el2_width = 380;//breite der zweiten Reihe

                // page structure options
                double lineHeight = 20;
                int marginLeft = 20;
                int marginTop = 55;

                int el_height = 30;
                int rect_height = 17;

                int interLine_X_1 = 2;
                int interLine_X_2 = 2 * interLine_X_1;

                int offSetX_1 = el1_width;
                int offSetX_2 = el1_width + el2_width;

                XSolidBrush rect_style1 = new XSolidBrush(XColors.LightGray);
                XSolidBrush rect_style2 = new XSolidBrush(XColors.DarkGreen);
                XSolidBrush rect_style3 = new XSolidBrush(XColors.Red);


                //tf.DrawString(status, fontParagraph, XBrushes.Black, new XRect(0, 0, 250, 140), format2);

                tf.DrawString(status, fontParagraph1, XBrushes.Black, new XRect(170, 10, 250, 140), XStringFormats.TopLeft);

                for (int i = 0; i < data!.Count() && result != false; i++)
                {
                    double dist_Y = lineHeight * (i + 1);
                    double dist_Y2 = dist_Y - 2;

                    if (i == 0)
                    {
                        graph.DrawRectangle(rect_style2, marginLeft, marginTop, pdfPage.Width - 2 * marginLeft, rect_height);

                        tf.DrawString("Land", fontParagraph, XBrushes.White,
                                      new XRect(marginLeft, marginTop, el1_width, el_height), format);

                        tf.DrawString("SKU", fontParagraph, XBrushes.White,
                                      new XRect(marginLeft + offSetX_1 + interLine_X_1, marginTop, el2_width, el_height), format);

                        tf.DrawString("Menge", fontParagraph, XBrushes.White,
                                      new XRect(marginLeft + offSetX_2 + 2 * interLine_X_2, marginTop, el1_width, el_height), format);

                        graph.DrawRectangle(rect_style1, marginLeft, dist_Y2 + marginTop, el1_width, rect_height);
                        tf.DrawString(shippingadresses[i], fontParagraph, XBrushes.Black,
                                      new XRect(marginLeft, dist_Y + marginTop, el1_width, el_height), format);

                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_1 + interLine_X_1, dist_Y2 + marginTop, el2_width, rect_height);
                        tf.DrawString(
                            sku[i],
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_1 + interLine_X_1, dist_Y + marginTop, el2_width, el_height),
                            format);


                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_2 + interLine_X_2, dist_Y2 + marginTop, el1_width, rect_height);
                        tf.DrawString(
                            quantity[i],
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_2 + 2 * interLine_X_2, dist_Y + marginTop, el1_width, el_height),
                            format);

                    }
                    else
                    {


                        graph.DrawRectangle(rect_style1, marginLeft, marginTop + dist_Y2, el1_width, rect_height);
                        tf.DrawString(

                            shippingadresses[i],
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft, marginTop + dist_Y, el1_width, el_height),
                            format);

                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_1 + interLine_X_1, dist_Y2 + marginTop, el2_width, rect_height);
                        tf.DrawString(
                            sku[i],
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_1 + interLine_X_1, marginTop + dist_Y, el2_width, el_height),
                            format);

                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_2 + interLine_X_2, dist_Y2 + marginTop, el1_width, rect_height);
                        tf.DrawString(
                            quantity[i],
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_2 + 2 * interLine_X_2, marginTop + dist_Y, el1_width, el_height),
                            format);

                    }

                }


            }

            //string filename = $"C:\\Users\\{Environment.UserName}\\Downloads\\{status}.pdf";
            string filename = Environment.GetEnvironmentVariable("USERPROFILE") + $@"\Downloads\{status}.pdf";

            var isExported = document.CanSave(ref filename);

            if (isExported == false)
            {
                result = false;
            }
            else
            {
                document.Save(filename);
                result = true;
            }

            return result;

        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
