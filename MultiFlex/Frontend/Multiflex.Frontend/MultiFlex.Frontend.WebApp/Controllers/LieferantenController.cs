using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Multiflex.Frontend.WebApp.Controllers
{
    public class LieferantenController : Controller
    {

        private static List<Models.SupplierDto> lieferanten = new();

        public async Task<ActionResult> Index()
        {
            #region crap
            //Electron.IpcMain.On("loadLieferanten", async (arg) =>
            //{
            //    var mainWindow = Electron.WindowManager.BrowserWindows.First();
            //    using var httpCliet = new HttpClient();
            //    //Console.WriteLine("geht");
            //    var requestlieferant = Task.Run(() =>
            //    {
            //        return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
            //    });
            //    var json = JArray.Parse(await requestlieferant);
            //    //Console.WriteLine(requestlieferant);
            //    Console.WriteLine("Json: Lieferant");
            //    Console.WriteLine(json);

            //    var items = System.Text.Json.JsonSerializer.Deserialize<Models.LieferantDto[]>(json.ToString());
            //    lieferanten.AddRange(items);

            //    Electron.IpcMain.Send(mainWindow, "getLieferant-reply", items);
            //});

            //Electron.IpcMain.On("open-add-window", async (arg) =>
            //{
            //    //var logic = new Logic();
            //    //BrowserWindow win = await logic.AddWindow("/Lieferanten/Add");
            //    //win.Show();
            //    var path = "/Lieferanten/Add";
            //    var options = new BrowserWindowOptions();
            //    //{
            //    //    Fullscreenable = false,
            //    //    Minimizable = false,
            //    //    SkipTaskbar = false,
            //    //    EnableLargerThanScreen = false,
            //    //    AutoHideMenuBar = true,
            //    //    TitleBarStyle = TitleBarStyle.hiddenInset
            //    //};
            //    options.Show = false;
            //    path = $"http://localhost:{BridgeSettings.WebPort}{path}";
            //    var browserWindow = await Electron.WindowManager.CreateWindowAsync(options, path);
            //    browserWindow.Show();
            //});

            //Electron.IpcMain.On("open-delete-window", async (arg) =>
            //{
            //    //var logic = new Logic();
            //    //BrowserWindow win = await logic.AddWindow("/Lieferanten/Delete");
            //    var path = "/Lieferanten/Delete";
            //    var options = new BrowserWindowOptions
            //    {
            //        Fullscreenable = false,
            //        Minimizable = false,
            //        SkipTaskbar = false,
            //        EnableLargerThanScreen = false,
            //        AutoHideMenuBar = true,
            //        TitleBarStyle = TitleBarStyle.hiddenInset
            //    };
            //    options.Show = false;
            //    path = $"http://localhost:{BridgeSettings.WebPort}{path}";
            //    var browserWindow = await Electron.WindowManager.CreateWindowAsync(options, path);
            //    browserWindow.Show();
            //    //win.Show();
            //});
            #endregion crap
            Stopwatch stopWatch1 = new Stopwatch();
            stopWatch1.Start();
            //lieferanten = new();
            using var httpCliet = new HttpClient();

            Stopwatch stopWatch = new Stopwatch();

            stopWatch.Start();
            var requestlieferant = Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
                });
            stopWatch.Stop();

            System.Console.WriteLine(stopWatch.Elapsed);

            stopWatch.Reset();
            stopWatch.Start();
            var items = Task.Run(() =>
            {
                return System.Text.Json.JsonSerializer.Deserialize<Models.SupplierDto[]>(requestlieferant.Result.ToString());
            });
            stopWatch.Stop();
            System.Console.WriteLine(stopWatch.Elapsed);

            stopWatch.Reset();
            stopWatch.Start();
            _ = Task.Run(() =>
            {
                lieferanten.AddRange(items.Result);
            });
            stopWatch.Stop();
            System.Console.WriteLine(stopWatch.Elapsed);

            stopWatch1.Stop();
            System.Console.WriteLine(stopWatch1.Elapsed);
            return View(items.Result);
        }

        public static Task<Models.SupplierDto[]> GetAllAsync()
        {
            return Task.Run(() => lieferanten.ToArray());
        }
        public static Task<Models.SupplierDto?> GetByIdAsync(int id)
        {
            return Task.Run(() => lieferanten.FirstOrDefault(s => s.id == id));
        }

        #region Add
        public ActionResult Add()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Add(Models.SupplierDto model)
        {
            try
            {
                var lieferant = new Models.SupplierDao();

                lieferant.name = model.name;
                lieferant.link = model.weblink;
                lieferant.deliveryTime = model.lieferzeit;

                using var httpCliet = new HttpClient();
                var json = JsonConvert.SerializeObject(lieferant);
                var data = new StringContent(json, Encoding.UTF8, "application/json");

                System.Console.WriteLine(data.ToString());

                await httpCliet.PostAsync("http://localhost:8080/lieferant/add", data);

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
        #endregion Add

        #region delete
        public async Task<ActionResult> DeleteAsync(int id)
        {
            var model = await GetByIdAsync(id);
            return View(model);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Delete(int id, Models.SupplierDto model)
        {
            try
            {
                using var httpCliet = new HttpClient();

                await httpCliet.DeleteAsync("http://localhost:8080/lieferant/delete/" + model.id);

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View(model);
            }
        }
        #endregion delete
    }
}
