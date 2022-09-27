namespace Frontend.Logic.Entities.Orders
{
    /// <summary>
    /// Entiti Order for Database
    /// </summary>
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
