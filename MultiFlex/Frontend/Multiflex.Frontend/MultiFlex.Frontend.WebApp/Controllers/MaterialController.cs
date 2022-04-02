using ElectronNET.API;
using Microsoft.AspNetCore.Mvc;
using Multiflex.Frontend.WebApp.Controllers.Commom;
using Multiflex.Frontend.WebApp.Models;
using Newtonsoft.Json.Linq;
using System;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace Multiflex.Frontend.WebApp.Controllers
{
    public class MaterialController : Controller
    {
        public IActionResult Index()
        {
            Electron.IpcMain.On("loadMaterialAndLieferanten", async (arg) =>
            {
                var mainWindow = Electron.WindowManager.BrowserWindows.First();
                using var httpCliet = new HttpClient();
                //Console.WriteLine("geht");
                var requestlieferant = Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
                });
                var requestMaterial = Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/ware/material");
                });
                //Console.WriteLine(requestlieferant);
                var json = JArray.Parse(await requestlieferant);
                var json2 = JArray.Parse(await requestMaterial);
                Console.WriteLine("Json: Lieferant");
                Console.WriteLine(json);
                Console.WriteLine("Json: Material");
                Console.WriteLine(json2);

                Electron.IpcMain.Send(mainWindow, "getloadMaterialAndLieferanten-reply", json.ToString(), json2.ToString());
            });
            Electron.IpcMain.On("open-add-window", async (arg) =>
            {
                var logic = new Logic();
                BrowserWindow win = await logic.AddWindow("/Material/Add");
                win.Show();
            });

            Electron.IpcMain.On("open-delete-window", async (arg) =>
            {
                var logic = new Logic();
                BrowserWindow win = await logic.AddWindow("/Material/Delete");
                win.Show();
            });
            return View();
        }
    }
}
