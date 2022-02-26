using ElectronNET.API;
using ElectronNET.API.Entities;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Multiflex.Frontend.WebApp.Models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

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
            
            Electron.IpcMain.On("searchRegal", async (arg) =>
            {
                var mainWindow = Electron.WindowManager.BrowserWindows.First();
                var httpCliet = new HttpClient();

                var requestRegal = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync($"http://localhost:8080/regal/{arg}");
                });
                Console.WriteLine(requestRegal);

                var requestWare = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/ware");
                });

                Console.WriteLine(requestWare);
                var requestFach = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/fach");
                });

                Console.WriteLine(requestWare);
                var json1 = JArray.Parse(requestRegal);
                var json2 = JArray.Parse(requestWare);
                var json3 = JArray.Parse(requestFach);
                Console.WriteLine("Json1");
                Console.WriteLine(json1);
                //Console.WriteLine("Json2");
                //Console.WriteLine(json2);
                //Console.WriteLine("Json3");
                //Console.WriteLine(json3);

                Electron.IpcMain.Send(mainWindow, "getSearchedRegal-reply", json1.ToString(), json2.ToString(), json3.ToString());
            });

            Electron.IpcMain.On("loadFinished", async (arg) =>
            {
                var mainWindow = Electron.WindowManager.BrowserWindows.First();
                var httpCliet = new HttpClient();

                var requestRegal = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/regal");
                });
                Console.WriteLine(requestRegal);
                var requestWare = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/ware");
                });
                Console.WriteLine(requestWare);
                var requestFach = await Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/fach");
                });
                Console.WriteLine(requestFach);
                var json1 = JArray.Parse(requestRegal);
                var json2 = JArray.Parse(requestWare);
                var json3 = JArray.Parse(requestFach);
                Console.WriteLine("Json1: Regal");
                Console.WriteLine(json1);
                Console.WriteLine("Json2: Ware");
                Console.WriteLine(json2);
                Console.WriteLine("Json3: Fach");
                Console.WriteLine(json3);

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
            Electron.IpcMain.On("add-regal", (arg) =>
            {
                //Console.WriteLine(arg);
                var httpCliet = new HttpClient();
                var path = $"http://localhost:{BridgeSettings.WebPort}";
                httpCliet.BaseAddress = new Uri(path);
                var input = new string[] { "Regal-3", "20" };
                //var json = JsonConvert.SerializeObject(arg);
                var json = JsonConvert.SerializeObject(input);
                var data = new StringContent(json, Encoding.UTF8, "application/json");
                var result = httpCliet.PostAsync("/regal/addRegal", data);
                //await httpCliet.SendAsync(arg);

            });
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
