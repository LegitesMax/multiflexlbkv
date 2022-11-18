namespace Frontend.AspMvc.Models.Database
{
    public class ProductionFormula
    {
        [JsonProperty("id")]
        public int Id { get; set; }

        [JsonProperty("product")]
        public Product? Product { get; set; }
        [JsonProperty("material")]
        public Material? Material { get; set; }

        [JsonProperty("amount")]
        public double Amount { get; set; } = new double();
    }
}
