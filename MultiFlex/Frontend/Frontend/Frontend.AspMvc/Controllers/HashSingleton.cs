using Frontend.AspMvc.Models;

namespace Frontend.AspMvc.Controllers
{
    public class HashSingleton
    {
        private static HashSingleton? instance = null;
        private static string DataHasCode = "";
        public static HttpClient client { get; set; } = new HttpClient();
        public static Model Model = new Model();

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

            if (DataHasCode == client.GetStringAsync("http://127.0.0.1:9000/Hash").Result) result = true;

            if (DataHasCode != client.GetStringAsync("http://127.0.0.1:9000/Hash").Result)
            {
                Task.Run(() =>
                {
                    var categoryJson = client.GetStringAsync("http://127.0.0.1:9000/Category/Material");
                    Model.Categories = JsonConvert.DeserializeObject<List<Models.Category>>(categoryJson.Result);

                    var productJson = client.GetStringAsync("http://127.0.0.1:9000/Category/Product");
                    Model.Categories = JsonConvert.DeserializeObject<List<Models.Category>>(productJson.Result);
                }).Wait();

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
