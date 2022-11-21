namespace Frontend.AspMvc.Models
{
    public class SubscribeModel
    {
        public string Name { get; set; } = string.Empty;
        public int? Value { get; set; }
        public int? MinValue { get; set; }
        public Size Size { get; set; } = new();
        public Category Category { get; set; } = new();
        public Color Color { get; set; } = new();
        public Product Product { get; set; } = new();
        public Database.Type Type { get; set; } = new();
    }
}
