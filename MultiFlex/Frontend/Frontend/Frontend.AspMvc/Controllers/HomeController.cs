using Microsoft.AspNetCore.Mvc;
using Frontend.AspMvc.Models;
using System.Diagnostics;
using Frontend.Logic.Controllers;
using Newtonsoft.Json;
using Frontend.Logic.Entities.Orders;
using PdfSharp.Drawing;
using PdfSharp.Pdf;
using PdfSharp.Drawing.Layout;
using System.Text;

namespace Frontend.AspMvc.Controllers
{
    public class HomeController : Controller
    {
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

            ViewData["orderStatus"] = "open";

            return View(model);
        }

        public IActionResult OpenOrders(object sender, EventArgs e)
        {
            ViewData["orderStatus"] = "open";
            return View("Index", GetOrdereItems());
        }

        public IActionResult CanceledOrders(object sender, EventArgs e)
        {
            ViewData["orderStatus"] = "canceled";
            return View("Index", GetCanceledItems());
        }

        public IActionResult ReadyOrders(object sender, EventArgs e)
        {
            ViewData["orderStatus"] = "ready";
            return View("Index", GetReadyItems());
        }

        public IActionResult CreateOpenPdf(object sender, EventArgs e)
        {
            ViewData["pdfStatus"] = "open";
            CreatePdf();

            ViewData["orderStatus"] = "open";
            return View("Index", GetOrdereItems());
        }
        public IActionResult CreateCanceledPdf(object sender, EventArgs e)
        {
            ViewData["pdfStatus"] = "canceled";
            CreatePdf();

            ViewData["orderStatus"] = "canceled";
            return View("Index", GetCanceledItems());
        }
        public IActionResult CreateReadyPdf(object sender, EventArgs e)
        {
            ViewData["pdfStatus"] = "ready";
            CreatePdf();

            ViewData["orderStatus"] = "ready";
            return View("Index", GetReadyItems());
        }

        public void CreatePdf()
        {
            bool done = false;

            var test = ViewData["pdfStatus"];

            if (ViewData["pdfStatus"] == "open")
            {
                var data = GetOrdereItems();
                if (data != null) done = ExportPdf(data, "Offene Bestellungen");
                else done = false;
            }
            if (ViewData["pdfStatus"] == "canceled")
            {
                var data = GetCanceledItems();
                if (data != null) done = ExportPdf(data, "Stornierte Bestellungen");
                else done = false;
            }
            if (ViewData["pdfStatus"] == "ready")
            {
                var data = GetReadyItems();
                if (data != null) done = ExportPdf(data, "Versandbereite Bestellungen");
                else done = false;
            }

            if (done == true) ViewData["pdfStatus"] = "succses";
            else ViewData["pdfStatus"] = "error";

            //return View("Index");
        }

        public IList<RootOrderItem>? GetOrdereItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetOrderedOrders();

            var result = JsonConvert.DeserializeObject<IList<RootOrderItem>>(data);

            return result;
        }

        public IList<RootOrderItem>? GetCanceledItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetCancledOrders();

            var result = JsonConvert.DeserializeObject<IList<RootOrderItem>>(data);

            return result;
        }

        public IList<RootOrderItem>? GetReadyItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetReadyOrders();

            var result = JsonConvert.DeserializeObject<IList<RootOrderItem>>(data);

            return result;
        }

        public static bool ExportPdf(IEnumerable<RootOrderItem> data, string status)
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
                        shippingadresses.Add(item.ShippingAddress.Country);
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


                int el1_width = 80;//Breite der Ersten Reihe
                int el2_width = 380;//breite der zweiten Reihe

                // page structure options
                double lineHeight = 20;
                int marginLeft = 20;
                int marginTop = 20;

                int el_height = 30;
                int rect_height = 17;

                int interLine_X_1 = 2;
                int interLine_X_2 = 2 * interLine_X_1;

                int offSetX_1 = el1_width;
                int offSetX_2 = el1_width + el2_width;

                XSolidBrush rect_style1 = new XSolidBrush(XColors.LightGray);
                XSolidBrush rect_style2 = new XSolidBrush(XColors.DarkGreen);
                XSolidBrush rect_style3 = new XSolidBrush(XColors.Red);

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

                        tf.DrawString("Mänge", fontParagraph, XBrushes.White,
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

            string filename = $"C:\\Users\\{Environment.UserName}\\Downloads\\{status}.pdf";

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
