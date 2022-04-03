using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Multiflex.Frontend.WebApp.Controllers
{
    public class LieferantenController : Controller
    {

        private static List<Models.LieferantDto> lieferanten = new();

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

            lieferanten = new();
            using var httpCliet = new HttpClient();

            var requestlieferant = Task.Run(() =>
                {
                    return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
                });


            var json = JArray.Parse(await requestlieferant);
            var items = System.Text.Json.JsonSerializer.Deserialize<Models.LieferantDto[]>(json.ToString());

            foreach (var item in items)
            {
                System.Console.WriteLine(item);
            }

            lieferanten.AddRange(items);

            var models = await GetAllAsync();
            return View(models);
        }

        public static Task<Models.LieferantDto[]> GetAllAsync()
        {
            return Task.Run(() => lieferanten.ToArray());
        }

        public static Task<Models.LieferantDto?> GetByIdAsync(int id)
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
        public async Task<ActionResult> Add(Models.LieferantDto model)
        {
            try
            {
                System.Console.WriteLine(model.id + model.name + model.weblink + model.lieferzeit);
                using var httpCliet = new HttpClient();

                var json = JsonConvert.SerializeObject(model);
                var data = new StringContent(json, Encoding.UTF8, "application/json");
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
        public async Task<ActionResult> Delete(int id, Models.LieferantDto model)
        {
            try
            {
                using var httpCliet = new HttpClient();

                var json = JsonConvert.SerializeObject(model);
                var data = new StringContent(json, Encoding.UTF8, "application/json");

                await httpCliet.PostAsync("http://localhost:8080/lieferant/delete/" + model.id, data);

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
