namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Size
    /// </summary>
    public class Size
    {
        [JsonProperty("id")]
        public int Id { get; set; }

        [JsonProperty("size")]
        public int Sizes { get; set; }

        [JsonProperty("products")]
        public List<Product> Products { get; set; }
    }
}
