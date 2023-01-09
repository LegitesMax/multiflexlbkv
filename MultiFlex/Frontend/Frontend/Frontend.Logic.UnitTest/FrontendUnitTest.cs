using Frontend.AspMvc.Controllers;
using Frontend.AspMvc.Models.Database;
using Microsoft.AspNetCore.Mvc;
using System.Net;
using System.Net.Http;
using System.Net.Http.Json;

namespace Frontend.Logic.UnitTest
{
    [TestClass]
    public class FrontendUnitTest
    {
        [TestMethod]
        public void OpenIndexWindow()
        {
            var controller = new HomeController();
            var result = controller.Details() as ViewResult;
            Assert.AreEqual("Index", result.ViewName);
        }

        [TestMethod]
        public void StartIndexWithString_StringHolZ_StringFromViewIsHolz()
        {
            var controller = new HomeController();
            var result = controller.Details1() as ViewResult;

            string product = (string)result.ViewData.Model;
            Assert.AreEqual("Holz", product);
        }






        [TestMethod]
        public void AddSize_CorrectSize_ResponseCode201()
        {
            var client = new HttpClient();
            Frontend.AspMvc.Models.Size size = new AspMvc.Models.Size();
            size.size = 24;
            size.Description = "1M";
            var response = client.PostAsJsonAsync("http://127.0.0.1:9000/Size/add", size).Result;

            Assert.AreEqual(HttpStatusCode.Created, response.StatusCode);
        }
        [TestMethod]
        public void EditSize_CorrectSize_ResponseCode201()
        {
            var client = new HttpClient();
            Frontend.AspMvc.Models.Size size = new AspMvc.Models.Size();

            size.size = 24;
            size.Description = "1M";
            var response = client.PutAsJsonAsync("http://127.0.0.1:9000/Size/updateBySize", size).Result;


            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
        }

        
    }
}
