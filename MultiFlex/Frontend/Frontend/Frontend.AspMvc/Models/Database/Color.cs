namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Colors
    /// </summary>
    public class Color
    {
        [JsonProperty("id")]
        public int Id { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("colorCode")]
        public string ColorCode { get; set; }

        [JsonProperty("products")]
        public List<Product> Products { get; set; }
    }
}
