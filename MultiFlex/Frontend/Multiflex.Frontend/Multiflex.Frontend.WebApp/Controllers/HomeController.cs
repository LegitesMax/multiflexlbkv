using ElectronNET.API;
using ElectronNET.API.Entities;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Multiflex.Frontend.WebApp.Models;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
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
            Electron.IpcMain.On("async-msg", (args) =>
            {
                var mainWindow = Electron.WindowManager.BrowserWindows.First();
                Electron.IpcMain.Send(mainWindow, "asynchronous-reply", "pong");
            });
            Electron.IpcMain.On("open-add-window", async (args) =>
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
                
                //browserWindow.OnMove += UpdateReply;
                //browserWindow.OnResize += UpdateReply;
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
        private async void UpdateReply()
        {
            var browserWindow = Electron.WindowManager.BrowserWindows.Last();
            var size = await browserWindow.GetSizeAsync();
            var position = await browserWindow.GetPositionAsync();
            string message = $"Size: {size[0]},{size[1]} Position: {position[0]},{position[1]}";

            var mainWindow = Electron.WindowManager.BrowserWindows.First();
            Electron.IpcMain.Send(mainWindow, "add-window-reply", message);
        }
    }
}
