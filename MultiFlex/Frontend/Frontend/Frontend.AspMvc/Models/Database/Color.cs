namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Colors
    /// </summary>
    public class Color
    {
        [JsonProperty("id")]
        public int? Id { get; set; }

        [JsonProperty("Name")]
        [MaxLength(64)]
        public string Name { get; set; } = string.Empty;

        [JsonProperty("colorCode")]
        [MaxLength(64)]
        public string ColorCode { get; set; } = string.Empty;

        [JsonProperty("products")]
        public List<Product>? Products { get; set; }
    }
}
