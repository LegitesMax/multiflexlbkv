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
        
    }
}
