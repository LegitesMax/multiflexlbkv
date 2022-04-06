using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class RegalDto : IdentityModel
    {
        public string name { get; set; }
        public int maxAmountShelfs { get; set; }
        public List<int> shelf_ids { get; set; }

        
    }
}
