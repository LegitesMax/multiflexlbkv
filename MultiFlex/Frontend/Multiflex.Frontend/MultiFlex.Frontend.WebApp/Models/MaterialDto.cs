using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class MaterialDto
    {
        public int bestand { get; set; }
        public List<object> faecher { get; set; }
        public int id { get; set; }
        public int maxbestand { get; set; }
        public int minbestand { get; set; }
        public string name { get; set; }
    }
}
