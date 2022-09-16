namespace Frontend.AspMvc.Models
{
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
