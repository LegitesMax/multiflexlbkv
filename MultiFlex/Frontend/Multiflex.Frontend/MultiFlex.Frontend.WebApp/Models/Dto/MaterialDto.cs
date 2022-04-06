using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class MaterialDto : IdentityModel
    {
        public int stock { get; set; }
        public int maxAmount { get; set; }
        public int minAmount { get; set; }
        public List<object> shelf_ids { get; set; }
        public string name { get; set; }
    }
}
