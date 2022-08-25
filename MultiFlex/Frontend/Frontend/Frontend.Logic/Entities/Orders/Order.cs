namespace Frontend.Logic.Entities.Orders
{
    public class Order : VersionEntity
    {
        public Order() { }

        public Order(OrderItems[] orderItems, ShippingAddress shippingAddress)
        {
            OrderItems = orderItems;
            ShippingAddress = shippingAddress;
        }

        public OrderItems[] OrderItems { get; set; }

        public ShippingAddress ShippingAddress { get; set; } = new();

    }
}
