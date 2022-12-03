using Frontend.AspMvc.Models;

namespace Frontend.AspMvc.Controllers
{
    public class HashSingleton
    {
        private static HashSingleton? instance = null;
        private static string DataHasCode = "";
        private static string ProductHasCode = "";
        private static string MaterialHasCode = "";
        public static HttpClient client { get; set; } = new HttpClient();
        public static Model Model = new Model();

        private HashSingleton() { }
        public static async Task<HashSingleton> getInstanceAsync()
        {
            if (instance == null)
            {
                instance = new HashSingleton();
            }
            return instance;
        }

        public static bool CheckPoductHashCode()
        {
            var result = false;
            if (DataHasCode == client.GetStringAsync("http://127.0.0.1:9000/Hash/Product").Result) result = true;
            else
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://127.0.0.1:9000/Hash/Product");
                });
                result = true;
                ProductHasCode = resultHash.Result;
            }
            return result;
        }

        public static bool CheckMaterialHashCode()
        {
            var result = false;

            if (DataHasCode == client.GetStringAsync("http://127.0.0.1:9000/Hash/Material").Result) result = true;
            else
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://127.0.0.1:9000/Hash/Material");
                });
                result = true;
                MaterialHasCode = resultHash.Result;
            }

            return result;
        }

        public static bool CheckColorHashCode()
        {
            var result = false;

            if (DataHasCode == client.GetStringAsync("http://127.0.0.1:9000/Hash/Color").Result) result = true;
            else
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://127.0.0.1:9000/Hash/Color");
                });
                result = true;
                MaterialHasCode = resultHash.Result;
            }

            return result;
        }

        public static bool CheckHashCode()
        {
            bool result = false;

            if (DataHasCode == client.GetStringAsync("http://127.0.0.1:9000/Hash").Result) result = true;

            if (DataHasCode != client.GetStringAsync("http://127.0.0.1:9000/Hash").Result)
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
