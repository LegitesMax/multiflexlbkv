namespace Multiflex.Frontend.WebApp.Models.Dto
{
    public class ShelfDto : IdentityModel
    {
        public int maxAmount { get; set; }
        public int position { get; set; }
        public int regal_id { get; set; }
        public int ware_id { get; set; }
    }
}
