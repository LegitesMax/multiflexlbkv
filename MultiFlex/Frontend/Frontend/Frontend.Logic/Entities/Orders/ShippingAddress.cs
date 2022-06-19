

namespace Frontend.Logic.Entities.Orders
{
    public class ShippingAddress : Product
    {
        public string? Country { get; set; }
        public string? CountryISO2 { get; set; }
    }

    public class RootShippingAddress
    {
        public ShippingAddress ShippingAddress { get; set; } = new ShippingAddress();
    }
}
