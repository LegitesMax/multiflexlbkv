using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Frontend.Logic.Entities.Orders
{
    /// <summary>
    /// Entiti Product for Database
    /// </summary>
    public class Product
    {
        public string? SKU { get; set; }
        public string? SkuOrId { get; set; }
        public string? Quantity { get; set; }
    }
}
