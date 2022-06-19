using Frontend.Logic.Entities.Orders;

namespace Frontend.Logic.Entities.Catigory
{
    public class Category : CategoryColorProducts
    {
        public int id { get; set; }
        public string name { get; set; }
        public string acronym { get; set; }
        public List<int> product_ids { get; set; }
    }
}
