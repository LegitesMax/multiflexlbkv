namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Materials
    /// </summary>
    public class Material
    {
        [JsonProperty("id")]
        public int Id { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; } = String.Empty;

        [JsonProperty("value")]
        public int Value { get; set; }

        [JsonProperty("minValue")]
        public int minValue { get; set; }
    }
}
