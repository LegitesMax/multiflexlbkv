using Frontend.AspMvc.Models.Database;

namespace Frontend.AspMvc.Models
{
    /// <summary>
    /// Database Model for Materials
    /// </summary>
    public class Material
    {
        [JsonProperty("id")]
        public int? Id { get; set; }

        [JsonProperty("Name")]
        [MaxLength(64)]
        public string Name { get; set; } = string.Empty;

        [JsonProperty("value")]
        public double Value { get; set; } 

        [JsonProperty("minValue")]
        public double MinValue { get; set; }



        [JsonProperty("size")]
        public Size Size { get; set; } = new Size();

        [JsonProperty("color")]
        public Color? Color { get; set; }

        [JsonProperty("category")]
        public Category? Category { get; set; }


        [JsonProperty("productionFormula")]
        public List<ProductionFormula>? ProductionFormula { get; set; }

    }

}
