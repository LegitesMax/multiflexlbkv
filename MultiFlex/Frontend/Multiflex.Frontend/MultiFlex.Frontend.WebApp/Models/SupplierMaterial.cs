using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class SupplierMaterial
    {
        private static int Counter = 0;
        public SupplierMaterial()
        {
            id = ++Counter;
        }

        public int id { get; set; }
        public int deliveryTime { get; set; }
        public string supplier_name { get; set; }
        public string ware_name { get; set; }
        public List<int> ware_ids { get; set; }
        public string link { get; set; }

    }
}
