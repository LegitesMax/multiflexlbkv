using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class SupplierDto : IdentityModel
    {
        public string name { get; set; }
        public string link { get; set; }
        public int deliveryTime { get; set; }
        public List<int> ware_ids { get; set; }
    }
}
