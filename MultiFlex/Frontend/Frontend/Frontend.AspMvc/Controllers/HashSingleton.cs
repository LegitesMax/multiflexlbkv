namespace Frontend.AspMvc.Controllers
{
    public class HashSingleton
    {
        private static HashSingleton? instance = null;
        private static string DataHasCode = "";
        public static HttpClient client { get; set; } = new HttpClient();

        private HashSingleton() { }
        public static async Task<HashSingleton> getInstanceAsync()
        {
            if (instance == null)
            {
                instance = new HashSingleton();
                DataHasCode = await client.GetStringAsync("http://127.0.0.1:9000/Hash");
            }
            return instance;
        }

        public static bool CheckHashCode()
        {
            bool result = false;

            var test = client.GetStringAsync("http://127.0.0.1:9000/Hash").Result;
            var test2 = DataHasCode;

            if (test.Equals(test2) == false)
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://127.0.0.1:9000/Hash");
                });
                result = true;
                DataHasCode = resultHash.Result;
            }
            return result;
        }

    }
}
