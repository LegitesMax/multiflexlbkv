namespace Frontend.AspMvc.Models
{
    public class Model
    {
        public List<Product>? Products { get; set; }
        public List<Category>? Categories { get; set; }
        public List<Material>? Materials { get; set; }
        public List<Color>? Colors { get; set; }
        public List<Size>? Sizes { get; set; }
        public IList<Logic.Entities.Orders.Order>? Orders { get; set; }

    }
}
