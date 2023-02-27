using Frontend.AspMvc.Models;

namespace Frontend.AspMvc.Controllers
{
    public class HashSingleton
    {
        private static HashSingleton? instance = null;
        public static bool FirstLoad = false;
        public static string DataHasCode = "";
        public static string ProductHasCode = "";
        public static string MaterialHasCode = "";
        public static string ColorHasCode = "";

        public static HttpClient client { get; set; } = new HttpClient();
        public static Model Model = new Model();

        private HashSingleton() { }
        public static HashSingleton getInstanceAsync()
        {
            if (instance == null)
            {
                instance = new HashSingleton();
            }
            return instance;
        }


        public static async void LoadAllDataAsync()
        {
            ProductHasCode = client.GetStringAsync("http://multiflex2.ddns.net/api/Hash/Product").Result;
            MaterialHasCode = client.GetStringAsync("http://multiflex2.ddns.net/api/Material").Result;
            ColorHasCode = client.GetStringAsync("http://multiflex2.ddns.net/api/Color").Result;

            if (FirstLoad == false || CheckHashCode() == false)
            {
                var productJson = await client.GetStringAsync("http://multiflex2.ddns.net/api/Category/Product");
                HashSingleton.Model.Categories = JsonConvert.DeserializeObject<List<Models.Category>>(productJson);

                var colorJson = await client.GetStringAsync("http://multiflex2.ddns.net/api/Color");
                HashSingleton.Model.Colors = JsonConvert.DeserializeObject<List<Models.Color>>(colorJson);
            }
            FirstLoad = true;
        }

        public static bool CheckPoductHashCode()
        {
            var result = false;
            if (ProductHasCode == client.GetStringAsync("http://multiflex2.ddns.net/api/Hash/Product").Result) result = true;
            else
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://multiflex2.ddns.net/api/Hash/Product");
                });
                result = false;
                ProductHasCode = resultHash.Result;
            }
            return result;
        }

        public static bool CheckMaterialHashCode()
        {
            var result = false;

            if (MaterialHasCode == client.GetStringAsync("http://multiflex2.ddns.net/api/Hash/Material").Result) result = true;
            else
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://multiflex2.ddns.net/api/Hash/Material");
                });
                result = false;
                MaterialHasCode = resultHash.Result;
            }

            return result;
        }

        public static bool CheckColorHashCode()
        {
            var result = false;

            if (MaterialHasCode == client.GetStringAsync("http://multiflex2.ddns.net/api/Hash/Color").Result) result = true;
            else
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://multiflex2.ddns.net/api/Hash/Color");
                });
                result = false;
                MaterialHasCode = resultHash.Result;
            }

            return result;
        }

        public static bool CheckHashCode()
        {
            bool result = false;

            if (DataHasCode == client.GetStringAsync("http://multiflex2.ddns.net/api/Hash").Result) result = true;

            if (DataHasCode != client.GetStringAsync("http://multiflex2.ddns.net/api/Hash").Result)
            {
                var resultHash = Task.Run(() =>
                {
                    return client.GetStringAsync("http://multiflex2.ddns.net/api/Hash");
                });
                result = false;
                DataHasCode = resultHash.Result;
            }
            return result;
        }

    }
}
