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
using Product = Frontend.AspMvc.Models.Product;

namespace Frontend.AspMvc.Controllers
{
    public class HomeController : Controller
    {
        private static string status = "open";
        private static string indexStatus = "product";
        private static string DataJsonOpen = "open";
        private static string DataJsonCacnceled = "canceled";
        private static string DataJsonReady = "ready";
        public HttpClient client { get; set; } = new HttpClient();


        private readonly ILogger<HomeController> _logger;
        //public HomeController(ILogger<HomeController> logger)
        //{
        //    _logger = logger;
        //}

        public ActionResult Details()
        {

            return View("Index");
        }
        public ActionResult Details1()
        {

            return View("Index", "Holz");

        }


        [HttpPost]
        public async Task<IActionResult> SubscribeAsync()
        {
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }

        //first index load
        public async Task<IActionResult> IndexAsync()
        {
            HashSingleton.LoadAllDataAsync();
            //await SetCategoriesAsync();
            SetOrders();

            return View(HashSingleton.Model);
        }


        public void SetOrders()
        {
            var stopwatch = new Stopwatch();
            stopwatch.Start();

            if (status == "open" && OrderSingleton.OpenHashCode != DataJsonOpen)
            {
                HashSingleton.Model.Orders = GetOrdereItems();
                ViewData["pdfStatus"] = "open";
            }
            if (status == "canceled" && OrderSingleton.CanceledHashCode != DataJsonCacnceled)
            {
                HashSingleton.Model.Orders = GetCanceledItems();
                ViewData["pdfStatus"] = "canceled";
            }
            if (status == "ready" && OrderSingleton.ReadyHashCode != DataJsonReady)
            {
                HashSingleton.Model.Orders = GetReadyItems();
                ViewData["pdfStatus"] = "ready";
            }

            stopwatch.Stop();
            Console.WriteLine("GetOrders() - " + stopwatch.Elapsed);
        }
        public async Task SetCategoriesAsync(bool firstLoad = false)
        {
            var stopwatch = new Stopwatch();
            stopwatch.Start();

            if (/*HashSingleton.CheckPoductHashCode() == false &&*/ indexStatus == "product")
            {
                var productJson = await client.GetStringAsync("http://multiflex-backend:9000/Category/Product");
                HashSingleton.Model.Categories = JsonConvert.DeserializeObject<List<Models.Category>>(productJson);
                ViewData["index"] = "product";
            }
            if (/*HashSingleton.CheckMaterialHashCode() == false &&*/ indexStatus == "material")
            {
                var productJson = await client.GetStringAsync("http://multiflex-backend:9000/Category/Material");
                HashSingleton.Model.Categories = JsonConvert.DeserializeObject<List<Models.Category>>(productJson);
                ViewData["index"] = "material";
            }
            if (HashSingleton.CheckColorHashCode() == false)
            {
                var colorJson = await client.GetStringAsync("http://127.0.0.1:9000/Color");
                HashSingleton.Model.Colors = JsonConvert.DeserializeObject<List<Models.Color>>(colorJson);
            }

            stopwatch.Stop();
            Console.WriteLine("SetCategoriesAsync() - " + stopwatch.Elapsed);
        }

        #region actions

        //Index loads / genereal loads
        public async Task<IActionResult> GetMaterials()
        {
            indexStatus = "material";

            await SetCategoriesAsync();
            SetOrders();

            return View("Index", HashSingleton.Model);
        }
        public async Task<IActionResult> GetProducts()
        {
            indexStatus = "product";

            await SetCategoriesAsync();
            SetOrders();

            return View("Index", HashSingleton.Model);
        }

        //Order loads

        /// <summary>
        /// Set Status Open Get All Open Order Items
        /// </summary>
        /// <param Name="sender">sender</param>
        /// <param Name="e">event</param>
        /// <returns>Return to Index Page</returns>
        public IActionResult OpenOrdersAsync(object sender, EventArgs e)
        {
            status = "open";

            SetOrders();
            return View("Index", HashSingleton.Model);
        }
        /// <summary>
        /// Set Status cancled Get All cancled Order Items
        /// </summary>
        /// <param Name="sender">sender</param>
        /// <param Name="e">event</param>
        /// <returns>Return to Index Page</returns>
        public ActionResult CanceledOrdersAsync(object sender, EventArgs e)
        {
            status = "canceled";

            SetOrders();
            return View("Index", HashSingleton.Model);
        }
        /// <summary>
        /// Set Status redy Get All orders that are redy
        /// </summary>
        /// <param Name="sender">sender</param>
        /// <param Name="e">event</param>
        /// <returns>Return to Index Page</returns>
        public IActionResult ReadyOrdersAsync(object sender, EventArgs e)
        {
            status = "ready";

            SetOrders();
            return View("Index", HashSingleton.Model);
        }


        /// <summary>
        /// Create PDF File for each Order (open,canceled,ready)
        /// </summary>
        /// <returns>return to Index Page</returns>
        public async Task<ViewResult> CreatePdfAsync()
        {
            bool done = false;

            var test = status;

            if (status == "open")
            {
                var data = GetOrdereItems();
                HashSingleton.Model.Orders = data;
                if (data != null) done = ExportPdf(data, "Offene Bestellungen");

                else done = false;
            }
            if (status == "canceled")
            {
                var data = GetCanceledItems();
                HashSingleton.Model.Orders = data;
                if (data != null) done = ExportPdf(data, "Stornierte Bestellungen");
                else done = false;
            }
            if (status == "ready")
            {
                var data = GetReadyItems();
                HashSingleton.Model.Orders = data;
                if (data != null) done = ExportPdf(data, "Fertige Bestellungen");
                else done = false;
            }

            if (done == true) ViewData["pdfStatus"] = "succses";
            else ViewData["pdfStatus"] = "error";

            await SetCategoriesAsync();
            return View("Index", HashSingleton.Model);
        }

        #endregion actions

        //BillBee Requests

        /// <summary>
        /// Get all orders from the ordered Items
        /// </summary>
        /// <returns>returns all ordered items</returns>
        public IList<Logic.Entities.Orders.Order>? GetOrdereItems(bool firstLoad = false)
        {
            var orderController = new OrderController();
            var data = orderController.GetOrderedOrders();

            if (OrderSingleton.OpenHashCode == String.Empty || OrderSingleton.OpenHashCode != DataJsonOpen)
            {
                DataJsonOpen = data;
                OrderSingleton.OpenHashCode = data;
            }
            return DeseializeJsonString(data);
        }

        /// <summary>
        /// Get all canceled orders from the orders
        /// </summary>
        /// <returns>returns canceled order items</returns>
        public IList<Logic.Entities.Orders.Order>? GetCanceledItems(bool firstLoad = false)
        {
            var orderController = new OrderController();
            var data = orderController.GetCancledOrders();

            if (OrderSingleton.CanceledHashCode == String.Empty || OrderSingleton.CanceledHashCode != DataJsonCacnceled)
            {
                DataJsonCacnceled = data;
                OrderSingleton.CanceledHashCode = data;
            }
            return DeseializeJsonString(data);
        }

        /// <summary>
        /// To get the Items for Shipping
        /// </summary>
        /// <returns>return List of all Ready for shipping Items</returns>
        public IList<Logic.Entities.Orders.Order>? GetReadyItems(bool firstLoad = false)
        {
            var orderController = new OrderController();
            var data = orderController.GetReadyOrders();

            if (OrderSingleton.ReadyHashCode == String.Empty || OrderSingleton.ReadyHashCode != DataJsonReady)
            {
                DataJsonReady = data;
                OrderSingleton.ReadyHashCode = data;
            }
            return DeseializeJsonString(data);
        }
        public List<Logic.Entities.Orders.Order> DeseializeJsonString(string data)
        {
            var result = JsonConvert.DeserializeObject<IList<Logic.Entities.Orders.Orders>>(data);
            var orderResult = new List<Logic.Entities.Orders.Order>();

            if (result != null)
            {
                foreach (var item in result!)
                {
                    orderResult.Add(new Logic.Entities.Orders.Order(item.OrderItems!, item.ShippingAddress));
                }
            }

            return orderResult;
        }

        //PDF
        /// <summary>
        /// Gnererate PDF File for the user with the data
        /// </summary>
        /// <param Name="data">The data of the Orders</param>
        /// <param Name="status">The Order State for the PDF title</param>
        /// <returns>boolen if export success</returns>
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
                        sku.Add(item2.Product.SKU!);
                        //quantity.Add(item2.Product.Quantity);
                        quantity.Add("1");
                    }
                }
            }

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

        #region interactions

        //Buttons Edit/Add/Remove
        public async Task<IActionResult> EditProductAsync(Model model)
        {
            var client = new HttpClient();
            var response = client.PutAsJsonAsync("http://multiflex-backend:9000/Article/updateByName", model.sub.Product).Result;

            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }
        public async Task<IActionResult> AddProduct(Model model)
        {
            //var data = new SubscribeModel { Name = model.sub.Product.Name, Value = (int?)model.sub.Product.Value, MinValue = (int?)model.sub.Product.MinValue,  Category = model.sub.Category, Size = model.sub.Size, Color = model.sub.Color};

            var client = new HttpClient();
            var response = client.PostAsJsonAsync("http://multiflex-backend:9000/Product/add", model.sub.Product).Result;

            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }


        public async Task<IActionResult> AddCategory(Model model)
        {

            var client = new HttpClient();
            var response = client.PostAsJsonAsync("http://multiflex-backend:9000/Category/add", model.sub.Category).Result;


            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }
        public async Task<IActionResult> EditCategory(Model model)
        {

            var client = new HttpClient();
            var response = client.PutAsJsonAsync("http://multiflex-backend:9000/Article/updateByName", model.sub.Category).Result;

            HashSingleton.Model.Orders = GetOrdereItems();
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="model"></param>
        /// <returns></returns>
        public async Task<IActionResult> AddColor(Model model)
        {


            var client = new HttpClient();
            var response = client.PostAsJsonAsync("http://multiflex-backend:9000/Color/add", model.sub.Color).Result;

            HashSingleton.Model.Orders = GetOrdereItems();
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }
        public async Task<IActionResult> EditColor(Model model)
        {
            var client = new HttpClient();
            var response = client.PutAsJsonAsync("http://multiflex-backend:9000/Color/updateByName", model.sub.Color).Result;

            HashSingleton.Model.Orders = GetOrdereItems();
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }

        /// <summary>
        /// /
        /// </summary>
        /// <param name="model"></param>
        /// <returns></returns>
        public async Task<IActionResult> AddSize(Model model)
        {
            var client = new HttpClient();
            var response = client.PostAsJsonAsync("http://multiflex-backend:9000/Size/add", model.sub.Size).Result;

            HashSingleton.Model.Orders = GetOrdereItems();
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }
        public async Task<IActionResult> EditSize(Model model)
        {
            var client = new HttpClient();
            var response = client.PutAsJsonAsync("http://multiflex-backend:9000/Size/updateBySize", model.sub.Size).Result;

            HashSingleton.Model.Orders = GetOrdereItems();
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }


        public async Task<IActionResult> AddMaterial(Model model)
        {
            var client = new HttpClient();
            var response = client.PostAsJsonAsync("http://multiflex-backend:9000/Material/add", model.sub.Material).Result;

            HashSingleton.Model.Orders = GetOrdereItems();
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }
        public async Task<IActionResult> EditMaterial(Model model)
        {
            var client = new HttpClient();
            var response = client.PutAsJsonAsync("http://multiflex-backend:9000/Article/updateByName", model.sub.Material).Result;

            HashSingleton.Model.Orders = GetOrdereItems();
            await SetCategoriesAsync();

            return View("Index", HashSingleton.Model);
        }

        #endregion interactions

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
