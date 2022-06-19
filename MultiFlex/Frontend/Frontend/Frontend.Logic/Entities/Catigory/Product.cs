using Frontend.Logic.Entities.Orders;

namespace Frontend.Logic.Entities.Catigory
{
    public class Product 
    {
        public int id { get; set; }
        public string name { get; set; }
        public int minValue { get; set; }
        public List<int> material_ids { get; set; }
        public string colorName { get; set; }
        public string colorCode { get; set; }
        public int value { get; set; }
    }
}
