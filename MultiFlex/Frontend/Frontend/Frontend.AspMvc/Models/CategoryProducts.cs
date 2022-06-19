namespace Frontend.AspMvc.Models
{
    public class CategoryProducts
    {
        public Category category { get; set; }
        public List<Product> products { get; set; }
    }
}
