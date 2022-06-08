using Billbee.Api.Client;
using Billbee.Api.Client.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace BillBeeQueries
{
    internal class Queries
    {
        static void Login()
        {
            //Console.WriteLine("Beware, uncommenting lines may harm your productive data!");
            //Console.WriteLine("Abort if you are not sure to proceed or press any key to continue.");
            //Console.ReadKey();


            #region Initialization

            // Creating an individual logger, that implements ILogger
            ILogger logger = new Logger();

            // Creating new instance of ApiClient
            string configPath = "/usr/psw.json";
            ApiClient client;

            if (File.Exists(configPath))
            {
                // From config file
                client = new ApiClient(configPath, logger: logger);
            }
            else
            {
                // from naual given config
                client = new ApiClient(logger: logger);
                // Enter your api key here. If you don't have an api key. Please contact support@billbee.de with a description on what you would like to do, to get one.
                client.Configuration.ApiKey = "";
                // Enter the username of your main account here.
                client.Configuration.Username = "";
                // Enter the password of your api here.
                client.Configuration.Password = "";
            }
            // Test the configuration
            if (client.TestConfiguration())
            {
                logger.LogMsg("Api test successful", LogSeverity.Info);
            }
            else
            {
                logger.LogMsg("Api test failed. Please control your configuration", LogSeverity.Error);
                //Console.WriteLine("Press any key to continue");
                //Console.ReadKey();
            }

            #endregion

            GetOrdes(client);

        }
        public static void GetProducts(ApiClient client)
        {
            var products = client.Products.GetProducts(1, 2);
            var customFields = client.Products.GetCustomFields(1, 2);

            string jsonString = JsonSerializer.Serialize(products.Data);
            string jsonString2 = JsonSerializer.Serialize(customFields.Data);

            File.WriteAllText(@"products.json", jsonString, Encoding.UTF8);
            File.WriteAllText(@"customFields.json", jsonString2, Encoding.UTF8);

            //File.WriteAllLines(path, createText, Encoding.UTF8);
        }
        public static void GetOrdes(ApiClient client)
        {
            //NICHT GLEICHER TAG SONST PROBLEME
            var date = new DateTime(2022, 06, 04);
            var date2 = new DateTime(2022, 06, 06);

            var orderState = new List<OrderStateEnum>() { OrderStateEnum.Storniert };

            var orders = client.Orders.GetOrderList(minOrderDate: date, maxOrderDate: date2, orderStateId: orderState, pageSize: 50);

            string jsonString = JsonSerializer.Serialize(orders.Data);


            File.WriteAllText(@"orders.json", jsonString, Encoding.UTF8);

        }
    }
}
