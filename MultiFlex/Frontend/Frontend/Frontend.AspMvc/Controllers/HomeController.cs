using Microsoft.AspNetCore.Mvc;
using Frontend.AspMvc.Models;
using System.Diagnostics;
using Frontend.Logic.Controllers;
using Newtonsoft.Json;
using Frontend.Logic.Entities.Orders;
using PdfSharp.Drawing;
using PdfSharp.Pdf;
using PdfSharp.Drawing.Layout;


namespace Frontend.AspMvc.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            var model = GetOrdereItems();

            ViewData["orderStatus"] = "canceled";

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

        public IActionResult CreatePdf(object sender, EventArgs e)
        {
            var done = ExportPdf();

            if(done == true ) ViewData["pdfStatus"] = "succses";
            else ViewData["pdfStatus"] = "error";


            return View("Index");
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

        public static bool ExportPdf()
        {
            //var orderController = new OrderController();
            //var data = orderController.GetOrderedOrders();
            //var result = JsonConvert.DeserializeObject<IList<RootOrderItem>>(data);
            var result = false;

            PdfDocument document = new PdfDocument();
            document.Info.Title = "DataPDF";

            for (int p = 0; p < 1; p++)
            {
                // Page Options
                PdfPage pdfPage = document.AddPage();
                pdfPage.Height = 842;//842
                pdfPage.Width = 590;

                // Get an XGraphics object for drawing
                XGraphics graph = XGraphics.FromPdfPage(pdfPage);

                // Text format
                XStringFormat format = new XStringFormat();
                format.LineAlignment = XLineAlignment.Near;
                format.Alignment = XStringAlignment.Near;
                var tf = new XTextFormatter(graph);

                XFont fontParagraph = new XFont("test", 12, XFontStyle.Bold);

                // Row elements
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

                for (int i = 0; i < 30; i++)
                {
                    double dist_Y = lineHeight * (i + 1);
                    double dist_Y2 = dist_Y - 2;

                    if (i == 0) //Erster Durchgang (Header)
                    {
                        graph.DrawRectangle(rect_style2, marginLeft, marginTop, pdfPage.Width - 2 * marginLeft, rect_height);

                        tf.DrawString("column1", fontParagraph, XBrushes.White,
                                      new XRect(marginLeft, marginTop, el1_width, el_height), format);

                        tf.DrawString("column2", fontParagraph, XBrushes.White,
                                      new XRect(marginLeft + offSetX_1 + interLine_X_1, marginTop, el2_width, el_height), format);

                        tf.DrawString("column3", fontParagraph, XBrushes.White,
                                      new XRect(marginLeft + offSetX_2 + 2 * interLine_X_2, marginTop, el1_width, el_height), format);

                        // Erste Elemente Hier schon mitgeben
                        //text1
                        graph.DrawRectangle(rect_style1, marginLeft, dist_Y2 + marginTop, el1_width, rect_height);
                        tf.DrawString("text1", fontParagraph, XBrushes.Black,
                                      new XRect(marginLeft, dist_Y + marginTop, el1_width, el_height), format);
                        //text2
                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_1 + interLine_X_1, dist_Y2 + marginTop, el2_width, rect_height);
                        tf.DrawString(
                            "text2",
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_1 + interLine_X_1, dist_Y + marginTop, el2_width, el_height),
                            format);


                        //text3

                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_2 + interLine_X_2, dist_Y2 + marginTop, el1_width, rect_height);
                        tf.DrawString(
                            "text3",
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_2 + 2 * interLine_X_2, dist_Y + marginTop, el1_width, el_height),
                            format);

                    }
                    else  //Alle Anderen Durchgänge (Tabelle)
                    {

                        //if (i % 2 == 1)
                        //{
                        //  graph.DrawRectangle(TextBackgroundBrush, marginLeft, lineY - 2 + marginTop, pdfPage.Width - marginLeft - marginRight, lineHeight - 2);
                        //}

                        //text1
                        graph.DrawRectangle(rect_style1, marginLeft, marginTop + dist_Y2, el1_width, rect_height);
                        tf.DrawString(

                            "text1",
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft, marginTop + dist_Y, el1_width, el_height),
                            format);

                        //text2
                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_1 + interLine_X_1, dist_Y2 + marginTop, el2_width, rect_height);
                        tf.DrawString(
                            "text2",
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_1 + interLine_X_1, marginTop + dist_Y, el2_width, el_height),
                            format);


                        //text3

                        graph.DrawRectangle(rect_style1, marginLeft + offSetX_2 + interLine_X_2, dist_Y2 + marginTop, el1_width, rect_height);
                        tf.DrawString(
                            "text3",
                            fontParagraph,
                            XBrushes.Black,
                            new XRect(marginLeft + offSetX_2 + 2 * interLine_X_2, marginTop + dist_Y, el1_width, el_height),
                            format);

                    }

                }


            }

            //File.s
            string filename = "C:\\Users\\fabsc\\Desktop\\test\\HelloWorld.pdf";
            //document.Save(filename);

            var isExported = document.CanSave(ref filename);

            if(isExported == false)
            {
                result = false;
            }
            else
            {
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
