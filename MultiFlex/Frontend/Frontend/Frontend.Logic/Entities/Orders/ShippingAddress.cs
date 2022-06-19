

using Frontend.Logic.Entities.Catigory;

namespace Frontend.Logic.Entities.Orders
{
    public class ShippingAddress
    {
        public string? Country { get; set; }
        public string? CountryISO2 { get; set; }
    }

    public class RootShippingAddress
    {
        public ShippingAddress ShippingAddress { get; set; } = new ShippingAddress();
    }
}
