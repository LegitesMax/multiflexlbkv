using ElectronNET.API;
using ElectronNET.API.Entities;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Multiflex.Frontend.WebApp.Models;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using System.Net.Http;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;

namespace Multiflex.Frontend.WebApp.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            /*Electron.IpcMain.On("async-msg", (args) =>
            {
                var mainWindow = Electron.WindowManager.BrowserWindows.First();
                Electron.IpcMain.Send(mainWindow, "asynchronous-reply", "pong");
            });*/
            Electron.IpcMain.On("open-add-window", async (arg) =>
            {
                //var mainWindow = Electron.WindowManager.BrowserWindows.First();
                //var browserWindow = await Electron.WindowManager.CreateWindowAsync();
                var options = new BrowserWindowOptions
                {
                    Fullscreenable = false,
                    Minimizable = false,
                    SkipTaskbar = false,
                    EnableLargerThanScreen = false,
                    AutoHideMenuBar = true,
                    TitleBarStyle = TitleBarStyle.hiddenInset
                };
                BrowserWindow win = await AddWindow("/Home/Add", options);
                win.Show();
            });
            Electron.IpcMain.On("loadFinished", async (arg) =>
            {
                var mainWindow = Electron.WindowManager.BrowserWindows.First();
                var httpCliet = new HttpClient();

                var stopwatch = new Stopwatch();

                stopwatch.Start();

               var requestRegal = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/regal");
                });

                var requestWare = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/ware");
                });

                var requestFach = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/fach");
                });

                var json1 = JArray.Parse(requestRegal);
                var json2 = JArray.Parse(requestWare);
                var json3 = JArray.Parse(requestFach);

                stopwatch.Stop();
                Console.WriteLine(stopwatch.Elapsed);

                 /*stopwatch.Reset();
                stopwatch.Start();
                var requestRegal = await httpCliet.GetStringAsync("http://localhost:8080/regal");
                var json1 = JArray.Parse(requestRegal);

                var requestWare = await httpCliet.GetStringAsync("http://localhost:8080/ware");
                var json2 = JArray.Parse(requestWare);

                var requestFach =  await httpCliet.GetStringAsync("http://localhost:8080/fach");
                var json3 = JArray.Parse(requestFach);
                stopwatch.Stop();
                Console.WriteLine(stopwatch.Elapsed);*/

                Console.WriteLine("strings erfolgreich gepares");
                Console.WriteLine(json1);
                Console.WriteLine();
                Console.WriteLine(json2);
                Console.WriteLine();
                Console.WriteLine(json3);
                Console.WriteLine("regale werden versendet");
                Electron.IpcMain.Send(mainWindow, "getRegal-reply", json1.ToString(), json2.ToString(), json3.ToString());
            });

            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }
        public IActionResult Add()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
        private async Task<BrowserWindow> AddWindow(string path, BrowserWindowOptions options)
        {
            options.Show = false;
            //path = Path.GetFullPath(@"../../../Views/Home/Add.cshtml");
            path = $"http://localhost:{BridgeSettings.WebPort}{path}";
            var browserWindow = await Electron.WindowManager.CreateWindowAsync(options, path);
            //path = Path.GetFullPath(@"../../../Views/Home/Add.cshtml");
            //browserWindow.LoadURL(path);
            //Console.WriteLine(path);
            //browserWindow.OnReadyToShow += () => browserWindow.Show();
            //browserWindow.Show();

            return browserWindow;
        }
    }
}
