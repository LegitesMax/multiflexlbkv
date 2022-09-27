using Newtonsoft.Json;

namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Category
    /// </summary>
    public class Category
    {
        [JsonProperty("id")]
        public int Id { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("acronym")]
        public string Acronym { get; set; }

        [JsonProperty("products")]
        public List<Product> Products { get; set; }
    }
}
