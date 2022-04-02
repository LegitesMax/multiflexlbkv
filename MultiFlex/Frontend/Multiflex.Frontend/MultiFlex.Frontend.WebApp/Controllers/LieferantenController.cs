using ElectronNET.API;
using ElectronNET.API.Entities;
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
    public class LieferantenController : Controller
    {
        public IActionResult Index()
        {
            Electron.IpcMain.On("loadLieferanten", async (arg) =>
            {
                var mainWindow = Electron.WindowManager.BrowserWindows.First();
                using var httpCliet = new HttpClient();
                //Console.WriteLine("geht");
                var requestlieferant = Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
                });
                //Console.WriteLine(requestlieferant);
                var json = JArray.Parse(await requestlieferant);
                Console.WriteLine("Json: Lieferant");
                Console.WriteLine(json);

                Electron.IpcMain.Send(mainWindow, "getLieferant-reply", json.ToString());
            });

            Electron.IpcMain.On("open-add-window", async (arg) =>
            {
                //var logic = new Logic();
                //BrowserWindow win = await logic.AddWindow("/Lieferanten/Add");
                //win.Show();
                var path = "/Lieferanten/Add";
                var options = new BrowserWindowOptions();
                //{
                //    Fullscreenable = false,
                //    Minimizable = false,
                //    SkipTaskbar = false,
                //    EnableLargerThanScreen = false,
                //    AutoHideMenuBar = true,
                //    TitleBarStyle = TitleBarStyle.hiddenInset
                //};
                options.Show = false;
                path = $"http://localhost:{BridgeSettings.WebPort}{path}";
                var browserWindow = await Electron.WindowManager.CreateWindowAsync(options, path);
                browserWindow.Show();
            });

            Electron.IpcMain.On("open-delete-window", async (arg) =>
            {
                //var logic = new Logic();
                //BrowserWindow win = await logic.AddWindow("/Lieferanten/Delete");
                var path = "/Lieferanten/Delete";
                var options = new BrowserWindowOptions
                {
                    Fullscreenable = false,
                    Minimizable = false,
                    SkipTaskbar = false,
                    EnableLargerThanScreen = false,
                    AutoHideMenuBar = true,
                    TitleBarStyle = TitleBarStyle.hiddenInset
                };
                options.Show = false;
                path = $"http://localhost:{BridgeSettings.WebPort}{path}";
                var browserWindow = await Electron.WindowManager.CreateWindowAsync(options, path);
                browserWindow.Show();
                //win.Show();
            });

            return View();
        }
    }
}
