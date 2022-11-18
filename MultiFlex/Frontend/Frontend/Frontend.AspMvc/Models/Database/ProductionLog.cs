namespace Frontend.AspMvc.Models.Database
{
    public class ProductionLog
    {
        [JsonProperty("id")]
        public int? Id { get; set; }

        [JsonProperty("product")]
        public Product? Product { get; set; }
    }
}
