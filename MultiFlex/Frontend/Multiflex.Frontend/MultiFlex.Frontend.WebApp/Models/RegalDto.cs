using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Models
{
    public class RegalDto
    {
        public int Id { get; set; }
        public string name { get; set; }
        public int max_anzahl_faecher { get; set; }
        public List<int> fach_ids { get; set; }

        
    }
}
