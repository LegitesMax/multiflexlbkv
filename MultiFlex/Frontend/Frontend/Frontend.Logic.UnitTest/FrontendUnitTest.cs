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
            size.Description = "2M";
            var response = client.PutAsJsonAsync("http://127.0.0.1:9000/Size/updateBySize", size).Result;


            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
        }




        [TestMethod]
        public void AddCategorie_CorrectCategorie_ResponseCode201()
        {
            var client = new HttpClient();
            Frontend.AspMvc.Models.Category category = new AspMvc.Models.Category();
            category.Name = "UnitTest";
            category.Acronym = "UT";
            category.Type = Type.Material;
            var response = client.PostAsJsonAsync("http://127.0.0.1:9000/Category/add", category).Result;

            Assert.AreEqual(HttpStatusCode.Created, response.StatusCode);
        }
        [TestMethod]
        public void EditCategorie_CorrectCategorie_ResponseCode201()
        {
            var client = new HttpClient();
            Frontend.AspMvc.Models.Category category = new AspMvc.Models.Category();
            category.Name = "UnitTest";
            category.Acronym = "UT1";
            category.Type = Type.Material;
            var response = client.PutAsJsonAsync("http://127.0.0.1:9000/Category/updateByName", category).Result;


            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
        }








        //[TestMethod]
        //public void AddMaterial_CorrectMaterial_ResponseCode201()
        //{
        //    var client = new HttpClient();
        //    Frontend.AspMvc.Models.Material material = new AspMvc.Models.Material();

        //    material.MinValue = 5;
        //    material.Name= "UnitTest";
        //    material.Value= 5;



        //    var response = client.PostAsJsonAsync("http://127.0.0.1:9000/Material/add", material).Result;

        //    Assert.AreEqual(HttpStatusCode.Created, response.StatusCode);
        //}
        [TestMethod]
        public void EditMaterial_CorrectMaterial_ResponseCode201()
        {
            var client = new HttpClient();
            Frontend.AspMvc.Models.Material material = new AspMvc.Models.Material();
            material.MinValue = 5;
            material.Name = "Folie 49 29";
            material.Value = 5;
            var response = client.PutAsJsonAsync("http://127.0.0.1:9000/Article/updateByName", material).Result;


            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
        }

        [TestMethod]
        public void AddProduct_CorrectProduct_ResponseCode201()
        {
            var client = new HttpClient();
            Frontend.AspMvc.Models.Product product = new AspMvc.Models.Product();

            product.Name = "TE 49 34";
            product.Value= 5;
            product.MinValue= 5;



            var response = client.PostAsJsonAsync("http://127.0.0.1:9000/Product/add", product).Result;

            Assert.AreEqual(HttpStatusCode.Created, response.StatusCode);
        }
        [TestMethod]
        public void EditProduct_CorrectProduct_ResponseCode201()
        {
            var client = new HttpClient();
            Frontend.AspMvc.Models.Product product = new AspMvc.Models.Product();
            product.Name = "TE 49 34";
            product.Value = 10;
            product.MinValue = 10;
            var response = client.PutAsJsonAsync("http://127.0.0.1:9000/Article/updateByName", product).Result;


            Assert.AreEqual(HttpStatusCode.OK, response.StatusCode);
        }



    }
}
