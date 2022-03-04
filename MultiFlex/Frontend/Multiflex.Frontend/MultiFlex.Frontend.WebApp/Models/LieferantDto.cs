using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class LieferantDto
    {
        public int Id { get; set; }
        public string name { get; set; }
        public string weblink { get; set; }
        public int lieferzeit { get; set; }
        public List<int> material_ids { get; set; }

    }
}
