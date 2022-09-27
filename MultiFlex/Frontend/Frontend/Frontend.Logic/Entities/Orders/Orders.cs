using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Frontend.Logic.Entities.Orders
{
    /// <summary>
    /// Entiti Orders for Database
    /// </summary>
    public class Orders
    {
        public ShippingAddress ShippingAddress { get; set; } = new();
        public OrderItems[]? OrderItems { get; set; }
    }
}
