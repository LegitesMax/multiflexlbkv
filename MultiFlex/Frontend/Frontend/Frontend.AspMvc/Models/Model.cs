using Frontend.AspMvc.Models.Database;

namespace Frontend.AspMvc.Models
{
    public class Model
    {
        public List<Product>? Products { get; set; } = new();
        public List<Category>? Categories { get; set; } = new();
        public List<Material>? Materials { get; set; } = new();
        public List<Color>? Colors { get; set; } = new();
        public List<Size>? Sizes { get; set; } = new();
        public SubscribeModel sub { get; set; } = new();
        public IList<Logic.Entities.Orders.Order>? Orders { get; set; }

    }
}
