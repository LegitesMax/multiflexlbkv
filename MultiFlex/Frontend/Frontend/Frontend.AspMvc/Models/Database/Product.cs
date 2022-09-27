namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Product
    /// </summary>
    public class Product
    {
        [JsonProperty("id")]
        public int Id { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("value")]
        public int Value { get; set; }

        [JsonProperty("minValue")]
        public int MinValue { get; set; }

        [JsonProperty("materials")]
        public List<object> Materials { get; set; }

        [JsonProperty("size")]
        public Size Size { get; set; }

        [JsonProperty("color")]
        public Color Color { get; set; }

        [JsonProperty("category")]
        public Category Category { get; set; }
    }
}
