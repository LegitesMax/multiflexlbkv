using Newtonsoft.Json;
using System.Text.Json.Serialization;

namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Category
    /// </summary>
    public class Category
    {
        [JsonProperty("id")]
        public int? Id { get; set; }

        [JsonProperty("name")]
        [JsonPropertyName("name")]
        [MaxLength(64)]
        public string Name { get; set; } = String.Empty;

        [JsonProperty("acronym")]
        [JsonPropertyName("acronym")]
        [MaxLength(8)]
        public string Acronym { get; set; } = String.Empty;

        [JsonProperty("type")]
        [JsonPropertyName("type")]
        public Database.Type? Type { get; set; }

        [JsonProperty("products")]
        [JsonPropertyName("products")]
        public List<Product>? Products { get; set; }
    }
}
