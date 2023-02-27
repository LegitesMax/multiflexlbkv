using Billbee.Api.Client;
using System.Text.Json;

namespace BillBeeQueries
{
    public class Queries
    {
        protected string ApiKey { get; set; } = String.Empty;
        protected string Username { get; set; } = String.Empty;
        protected string Password { get; set; } = String.Empty;

        private static Queries? instance = null;

        private Queries() { }
        public static Task<Queries> getInstanceAsync()
        {
            if (instance == null)
            {
                instance = new Queries();
            }
            return Task.FromResult(instance);
        }

        public static ApiClient Login()
        {
            #region Initialization

            // Creating an individual logger, that implements ILogger
            ILogger logger = new Logger();

            // Creating new instance of ApiClient

            string configPath = "/usr/psw.json";
            configPath = Environment.GetEnvironmentVariable("USERPROFILE") + @"\Desktop\tmp\psw.json";


            //#if Linux
            //        configPath = "/usr/psw.json";
            //#elif Windows
            //        configPath = Environment.GetEnvironmentVariable("USERPROFILE") + @"\Desktop\tmp\psw.json";
            //#endif
            ApiClient client;

            if (File.Exists(configPath))
            {
                //// From config file
                //client = new ApiClient(configPath, logger: logger);

                string value = File.ReadAllText(configPath);
                var data = Newtonsoft.Json.JsonConvert.DeserializeObject<ApiConfiguration>(value);

                client = new ApiClient(logger: logger);
                // Enter your api key here. If you don't have an api key. Please contact support@billbee.de with a description on what you would like to do, to get one.
                client.Configuration.ApiKey = data!.ApiKey;
                // Enter the username of your main account here.
                client.Configuration.Username = data!.Username;
                // Enter the password of your api here.
                client.Configuration.Password = data!.Password;
            }
            else
            {
                throw new Exception("Ping");
            }

            // Test the configuration
            if (client.TestConfiguration())
            {
                logger.LogMsg("Api test successful", LogSeverity.Info);
            }
            else
            {
                logger.LogMsg("Api test failed. Please control your configuration", LogSeverity.Error);
            }

            #endregion

            return client;
            //GetOrdes(client);
        }
        public void GetProducts(ApiClient client)
        {
            var products = client.Products.GetProducts(1, 2);
            var customFields = client.Products.GetCustomFields(1, 2);

            string jsonString = JsonSerializer.Serialize(products.Data);
            string jsonString2 = JsonSerializer.Serialize(customFields.Data);

           // File.WriteAllText(@"products.json", jsonString, Encoding.UTF8);
            //File.WriteAllText(@"customFields.json", jsonString2, Encoding.UTF8);

            //File.WriteAllLines(path, createText, Encoding.UTF8);
        }
    }
}
