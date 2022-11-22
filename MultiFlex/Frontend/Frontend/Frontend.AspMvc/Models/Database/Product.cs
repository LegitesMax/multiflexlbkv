using Frontend.AspMvc.Models.Database;
using System.Text.Json.Serialization;

namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Product
    /// </summary>
    public class Product
    {
        [JsonProperty("id")]
        public int? Id { get; set; }

        [JsonProperty("name")]
        [JsonPropertyName("name")]
        [MaxLength(64)]
        public string Name { get; set; } = string.Empty;

        [JsonProperty("value")]
        [JsonPropertyName("value")]
        public double Value { get; set; } = new double();

        [JsonProperty("minValue")]
        [JsonPropertyName("minValue")]
        public double MinValue { get; set; } = new double();

        

        [JsonProperty("size")]
        [JsonPropertyName("size")]
        public Size Size { get; set; } = new Size();

        [JsonProperty("color")]
        [JsonPropertyName("color")]
        public Color? Color { get; set; }

        [JsonProperty("category")]
        [JsonPropertyName("category")]
        public Category? Category { get; set; }




        [JsonProperty("productionFormula")]
        [JsonPropertyName("productionFormula")]
        public List<ProductionFormula>? ProductionFormula { get; set; }
        [JsonProperty("productionLog")]
        [JsonPropertyName("productionLog")]
        public List<ProductionLog>? ProductionLogs{ get; set; }
    }
}
