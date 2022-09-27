using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Billbee.Api.Client.Enums;
using BillBeeQueries;

namespace Frontend.Logic.Controllers
{
    public class OrderController : GenericController<Entities.Orders.Order>
    {
        public OrderController()
        {
        }

        public OrderController(ControllerObject other) : base(other)
        {
        }

        private Queries query = new Queries();

        /// <summary>
        /// Gets all Orders
        /// </summary>
        /// <returns>returns all Orders in a string</returns>
        public string GetAllOrders()
        {
            var client = query.Login();

            var orders = client.Orders.GetOrderList(pageSize: 100);
            string result = JsonSerializer.Serialize(orders.Data);

            return result == null ? "Derzeit keine Bestellung" : result;
        }

        /// <summary>
        /// Gets all Ordered Orders
        /// </summary>
        /// <returns>returns all Ordered Orders in a string</returns>
        public string GetOrderedOrders()
        {
            var client = query.Login();

            var orderState = new List<OrderStateEnum>() { OrderStateEnum.Zahlung_erhalten};
            var orders = client.Orders.GetOrderList(orderStateId: orderState, pageSize: 50);

            string result = JsonSerializer.Serialize(orders.Data);

            return result == null ? "Derzeit keine offene Bestellung" : result;
        }
        /// <summary>
        /// Get all cancled orders
        /// </summary>
        /// <returns>returns all cancled orders in a string</returns>
        public string GetCancledOrders()
        {
            var client = query.Login();

            var orderState = new List<OrderStateEnum>() { OrderStateEnum.Storniert };
            var orders = client.Orders.GetOrderList(orderStateId: orderState, pageSize: 50, minOrderDate: DateTime.Today.AddDays(-1), maxOrderDate: DateTime.MaxValue);

            string result = JsonSerializer.Serialize(orders.Data);

            return result == null ? "Keine Stornierungen vorhanden" : result;
        }
        /// <summary>
        /// get all redy Orders
        /// </summary>
        /// <returns>Returns all orders that are redy in a string</returns>
        public string GetReadyOrders()
        {
            var client = query.Login();

            var orderState = new List<OrderStateEnum>() { OrderStateEnum.Versendet };
            var orders = client.Orders.GetOrderList(orderStateId: orderState, pageSize: 50, minOrderDate: DateTime.Today.AddDays(-2), maxOrderDate: DateTime.MaxValue);

            string result = JsonSerializer.Serialize(orders.Data);

            return result == null ? "Derzeit kein Packet fertiggestellt" : result;
        }
    }
}
