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

            return View(model);
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }

        public IList<RootOrderItem>? GetOrdereItems()
        {
            var orderController = new OrderController();
            var data = orderController.GetOrderedOrders();

            var result = JsonConvert.DeserializeObject<IList<RootOrderItem>>(data);

            return result;
        }

    }
}
