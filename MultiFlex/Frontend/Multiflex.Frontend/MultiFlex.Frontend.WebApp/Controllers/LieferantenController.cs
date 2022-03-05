using ElectronNET.API;
using Microsoft.AspNetCore.Mvc;
using Multiflex.Frontend.WebApp.Models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace Multiflex.Frontend.WebApp.Controllers
{
    public class LieferantenController : Controller
    {
        public IActionResult Index()
        {
            //Electron.IpcMain.On("loadLieferanten", async (arg) =>
            //{
            //    var mainWindow = Electron.WindowManager.BrowserWindows.First();
            //    var httpCliet = new HttpClient();

            //    var requestlieferant = await Task.Run(() =>
            //    {
            //        return httpCliet.GetStringAsync("http://localhost:8080/Lieferant");
            //    });

            //    Console.WriteLine(requestlieferant);
            //    var json = JArray.Parse(requestlieferant);
            //    Console.WriteLine("Json1: Lieferant");
            //    Console.WriteLine(json);

            //    Electron.IpcMain.Send(mainWindow, "getLieferant-reply", json.ToString());
            //    //LieferantDto lieferanten = JsonConvert.DeserializeObject<LieferantDto>(requestlieferant);
            //    //Electron.IpcMain.Send(mainWindow, "getLieferant-reply", lieferanten);
            //});

            return View();
        }
    }
}
