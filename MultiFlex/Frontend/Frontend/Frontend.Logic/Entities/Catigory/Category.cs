namespace Frontend.AspMvc.Models
{
    public class Category
    {
        public int id { get; set; }
        public string name { get; set; }
        public string acronym { get; set; }
        public List<int> product_ids { get; set; }
    }
}
