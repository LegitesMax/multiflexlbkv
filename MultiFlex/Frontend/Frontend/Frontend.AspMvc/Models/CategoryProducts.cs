namespace Frontend.AspMvc.Models
{
    public class CategoryProducts
    {
        public CategoryDto category { get; set; }
        public List<ProductDto> products { get; set; } = new();

    }
}
