namespace Frontend.AspMvc.Controllers
{
    public class OrderSingleton
    {

        private static OrderSingleton? instance = null;
        public static string OrderHashCode = String.Empty;

        private OrderSingleton() { }
        public static Task<OrderSingleton> getInstance()
        {
            if (instance == null)
            {
                instance = new OrderSingleton();
            }
            return Task.FromResult(instance);
        }

    }
}
