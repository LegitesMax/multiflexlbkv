using Microsoft.AspNetCore.Mvc;
using Frontend.AspMvc.Models;
using System.Diagnostics;
using Frontend.Logic.Controllers;
using Newtonsoft.Json;
using Frontend.Logic.Entities.Orders;

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
            return View("Index", GetOrdereItems());
        }

        public IActionResult ReadyOrders(object sender, EventArgs e)
        {
            ViewData["orderStatus"] = "ready";
            return View("Index", GetOrdereItems());
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
            var data = orderController.GetOrderedOrders();

            var result = JsonConvert.DeserializeObject<IList<RootOrderItem>>(data);

            return result;
        }

        public IList<RootOrderItem>? GetReadyItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetOrderedOrders();

            var result = JsonConvert.DeserializeObject<IList<RootOrderItem>>(data);

            return result;
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
