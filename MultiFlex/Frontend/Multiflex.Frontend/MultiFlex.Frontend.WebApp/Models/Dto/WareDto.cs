using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models.Dto
{
    public class WareDto : IdentityModel
    {
        public int maxAmount { get; set; }
        public int minAmount { get; set; }
        public string name { get; set; }
        public List<int> shelf_ids { get; set; }
        public int stock { get; set; }
    }
}
