using Newtonsoft.Json;

namespace Multiflex.Frontend.WebApp.Controllers
{
    public class Regal
    {
        [JsonProperty("Id")]
        public int Id { get; set; }
        [JsonProperty("Name")]
        public string Name { get; set; }
        [JsonProperty("Max_anzahl_faecher")]
        public int Max_anzahl_faecher { get; set; }
    }
}
