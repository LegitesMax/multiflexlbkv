namespace Frontend.AspMvc.Models
{
    public class Model
    {
        public List<Product>? Products { get; set; }
        public Category? Categories { get; set; }
        public Material? Materials { get; set; }
        public Color? Colors { get; set; }
        public Size? Sizes { get; set; }
        public IList<Logic.Entities.Orders.Order>? Orders { get; set; }

    }
}
