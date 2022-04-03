using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class LieferantDao
    {
        public string name { get; set; }
        public string weblink { get; set; }
        public int lieferzeit { get; set; }
        public List<int> waren_ids { get; set; }
    }
}
