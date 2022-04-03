using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class LieferantDto
    {
        public int id { get; set; }
        public int lieferzeit { get; set; }
        public string name { get; set; }
        public List<int> waren_ids { get; set; }
        public string weblink { get; set; }

    }
}
