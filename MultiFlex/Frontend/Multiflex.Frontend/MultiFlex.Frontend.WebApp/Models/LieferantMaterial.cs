using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class LieferantMaterial
    {
        private static int Counter = 0;
        public LieferantMaterial()
        {
            id = ++Counter;
        }

        public int id { get; set; }
        public int lieferzeit { get; set; }
        public string lieferat_name { get; set; }
        public string ware_name { get; set; }
        public List<int> waren_ids { get; set; }
        public string weblink { get; set; }

    }
}
