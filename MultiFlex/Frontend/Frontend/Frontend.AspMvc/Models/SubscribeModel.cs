namespace Frontend.AspMvc.Models
{
    public class SubscribeModel
    {
        public string Opereations { get; set; } = string.Empty;
        public string Name { get; set; } = string.Empty;
        public int? Value { get; set; }
        public int? MinValue { get; set; }
        public SizeSubscribeModel? Size { get; set; }
        public CategorySubscribeModel? Category { get; set; }
    }

    public class SizeSubscribeModel
    {
        public int Size { get; set; }
        public List<Product> Products { get; set; } = new();
    }

    public class CategorySubscribeModel
    {
        public string Name { get; set; } = String.Empty;
        public string Acronym { get; set; } = String.Empty;
        public List<Product> Products { get; set; } = new();
    }

}
