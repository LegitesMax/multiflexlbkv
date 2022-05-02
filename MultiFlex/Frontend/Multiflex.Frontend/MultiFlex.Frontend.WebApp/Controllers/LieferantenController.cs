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

       // private static List<Models.SupplierDto> lieferanten = new();

        private static List<Models.MaterialDto> material = new();
        private static List<Models.SupplierDto> lieferatnen = new();
        private static List<Models.SupplierMaterial> lfmt = new();
        private static List<string> alreadyadded = new List<string>();

        #region crap
        //public async Task<ActionResult> Index()
        //{
        //    #region crap
        //    //Electron.IpcMain.On("loadLieferanten", async (arg) =>
        //    //{
        //    //    var mainWindow = Electron.WindowManager.BrowserWindows.First();
        //    //    using var httpCliet = new HttpClient();
        //    //    //Console.WriteLine("geht");
        //    //    var requestlieferant = Task.Run(() =>
        //    //    {
        //    //        return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
        //    //    });
        //    //    var json = JArray.Parse(await requestlieferant);
        //    //    //Console.WriteLine(requestlieferant);
        //    //    Console.WriteLine("Json: Lieferant");
        //    //    Console.WriteLine(json);

        //    //    var items = System.Text.Json.JsonSerializer.Deserialize<Models.LieferantDto[]>(json.ToString());
        //    //    lieferanten.AddRange(items);

        //    //    Electron.IpcMain.Send(mainWindow, "getLieferant-reply", items);
        //    //});

        //    //Electron.IpcMain.On("open-add-window", async (arg) =>
        //    //{
        //    //    //var logic = new Logic();
        //    //    //BrowserWindow win = await logic.AddWindow("/Lieferanten/Add");
        //    //    //win.Show();
        //    //    var path = "/Lieferanten/Add";
        //    //    var options = new BrowserWindowOptions();
        //    //    //{
        //    //    //    Fullscreenable = false,
        //    //    //    Minimizable = false,
        //    //    //    SkipTaskbar = false,
        //    //    //    EnableLargerThanScreen = false,
        //    //    //    AutoHideMenuBar = true,
        //    //    //    TitleBarStyle = TitleBarStyle.hiddenInset
        //    //    //};
        //    //    options.Show = false;
        //    //    path = $"http://localhost:{BridgeSettings.WebPort}{path}";
        //    //    var browserWindow = await Electron.WindowManager.CreateWindowAsync(options, path);
        //    //    browserWindow.Show();
        //    //});

        //    //Electron.IpcMain.On("open-delete-window", async (arg) =>
        //    //{
        //    //    //var logic = new Logic();
        //    //    //BrowserWindow win = await logic.AddWindow("/Lieferanten/Delete");
        //    //    var path = "/Lieferanten/Delete";
        //    //    var options = new BrowserWindowOptions
        //    //    {
        //    //        Fullscreenable = false,
        //    //        Minimizable = false,
        //    //        SkipTaskbar = false,
        //    //        EnableLargerThanScreen = false,
        //    //        AutoHideMenuBar = true,
        //    //        TitleBarStyle = TitleBarStyle.hiddenInset
        //    //    };
        //    //    options.Show = false;
        //    //    path = $"http://localhost:{BridgeSettings.WebPort}{path}";
        //    //    var browserWindow = await Electron.WindowManager.CreateWindowAsync(options, path);
        //    //    browserWindow.Show();
        //    //    //win.Show();
        //    //});
        //    #endregion crap
        //    Stopwatch stopWatch1 = new Stopwatch();
        //    stopWatch1.Start();
        //    //lieferanten = new();
        //    using var httpCliet = new HttpClient();

        //    Stopwatch stopWatch = new Stopwatch();

        //    stopWatch.Start();
        //    var requestlieferant = Task.Run(() =>
        //        {
        //            return httpCliet.GetStringAsync("http://localhost:8080/supplier");
        //        });
        //    stopWatch.Stop();

        //    System.Console.WriteLine("Databse: " + stopWatch.Elapsed);

        //    stopWatch.Reset();
        //    stopWatch.Start();
        //    var items = Task.Run(() =>
        //    {
        //        return System.Text.Json.JsonSerializer.Deserialize<Models.SupplierDto[]>(requestlieferant.Result.ToString());
        //    });
        //    stopWatch.Stop();
        //    System.Console.WriteLine("JSONparse" + stopWatch.Elapsed);

        //    //stopWatch.Reset();
        //    //stopWatch.Start();
        //    //_ = Task.Run(() =>
        //    //{
        //    //    lieferanten.AddRange(items.Result);
        //    //});
        //    //stopWatch.Stop();
        //    //System.Console.WriteLine(stopWatch.Elapsed);

        //    stopWatch1.Stop();
        //    System.Console.WriteLine($"Gesammt: {stopWatch1.Elapsed}");
        //    return View(items.Result);
        //}

        //public static Task<Models.SupplierDto[]> GetAllAsync()
        //{
        //    return Task.Run(() => lieferanten.ToArray());
        //}
        //public static Task<Models.SupplierDto?> GetByIdAsync(int id)
        //{
        //    return Task.Run(() => lieferanten.FirstOrDefault(s => s.id == id));
        //}

        #endregion crap

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
                lieferant.link = model.link;
                lieferant.deliveryTime = model.deliveryTime;

                using var httpCliet = new HttpClient();
                var json = JsonConvert.SerializeObject(lieferant);
                var data = new StringContent(json, Encoding.UTF8, "application/json");

                System.Console.WriteLine(data.ToString());

                await httpCliet.PostAsync("http://localhost:8080/supplier/add", data);

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

                await httpCliet.DeleteAsync("http://localhost:8080/supplier/delete/" + model.id);

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View(model);
            }
        }
        #endregion delete

        /////
        public async Task<ActionResult> Index()
        {
            Stopwatch stopWatch = new Stopwatch();
            Stopwatch stopWatch2 = new Stopwatch();
            stopWatch2.Start();
            stopWatch.Start();

            lfmt.Clear();
            material.Clear();
            lieferatnen.Clear();
            alreadyadded.Clear();

            using var httpCliet = new HttpClient();
            
            stopWatch.Start();
            {
                var x1 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/supplier");
                var y1 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/ware/material");

            }
            System.Console.WriteLine($"http: {stopWatch.ElapsedMilliseconds} ");
            {
                var x2 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/supplier");
                var y2 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/ware/material");

            }
            System.Console.WriteLine($"http: {stopWatch.ElapsedMilliseconds} ");
            {
                var x3 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/supplier");
                var y3 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/ware/material");

            }
            System.Console.WriteLine($"http: {stopWatch.ElapsedMilliseconds} ");
            {
                var x4 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/supplier");
                var y4 = await httpCliet.GetStringAsync("http://127.0.0.1:8080/ware/material");

            }
            System.Console.WriteLine($"http: {stopWatch.ElapsedMilliseconds} ");

            var supplier = await httpCliet.GetStringAsync("http://127.0.0.1:8080/supplier");
                var materialData = await httpCliet.GetStringAsync("http://127.0.0.1:8080/ware/material");

            
            stopWatch.Stop();
            System.Console.WriteLine("Database: " + stopWatch.Elapsed);
            stopWatch.Reset();

            //stopWatch.Start();
            //var json1 = JArray.Parse(await requestlieferant);
            //var json2 = JArray.Parse(await requestMaterial);
            //stopWatch.Stop();
            //System.Console.WriteLine("JSON-Parse: " + stopWatch.Elapsed);
            //stopWatch.Reset();

            stopWatch.Start();
            var items1 = Task.Run(() =>
            {
                return System.Text.Json.JsonSerializer.Deserialize<Models.SupplierDto[]>(supplier);
            });
            var items2 = Task.Run(() =>
            {
                return System.Text.Json.JsonSerializer.Deserialize<Models.MaterialDto[]>(materialData);
            });

            stopWatch.Stop();
            System.Console.WriteLine("JSON-Deserialize: " + stopWatch.Elapsed);
            stopWatch.Reset();

            stopWatch.Start();

            lieferatnen.AddRange(items1.Result);
            material.AddRange(items2.Result);

            stopWatch.Stop();
            System.Console.WriteLine("AddRange: " + stopWatch.Elapsed);
            stopWatch.Reset();

            stopWatch.Start();

            bool notaddedyet = false;

            foreach (var item in items2.Result)
            {
                foreach (var item2 in items1.Result)
                {
                    if (item2.ware_ids.Contains(item.id))
                    {
                        notaddedyet = false;
                        foreach (var suplyername in alreadyadded)
                        {
                            if (suplyername == item2.name)
                            {
                                notaddedyet = true;
                            }
                        }
                        if (!notaddedyet)
                        {
                            alreadyadded.Add(item2.name);
                        }
                        if (!notaddedyet)
                        {
                            lfmt.Add(
                                new Models.SupplierMaterial
                                {
                                    ware_name = item.name,
                                    deliveryTime = item2.deliveryTime,
                                    supplier_name = item2.name,
                                    link = item2.link
                                }
                            );
                        }
                        else
                        {
                            lfmt.Add(
                                new Models.SupplierMaterial
                                {
                                    ware_name = item.name,
                                    deliveryTime = item2.deliveryTime,
                                    supplier_name = "NotExisting",
                                    link = item2.link
                                }
                            );
                        }
                        notaddedyet = false;
                    }
                }
            }

           // var models = await GetAllAsync();
            stopWatch.Stop();
            System.Console.WriteLine("Add to List: " + stopWatch.Elapsed);
            System.Console.WriteLine("Gesamt: " + stopWatch2.Elapsed);
            return View(lfmt);
        }

        public static Task<Models.SupplierMaterial[]> GetAllAsync()
        {
            return Task.Run(() => lfmt.ToArray());
        }

        public static Task<Models.SupplierMaterial?> GetByIdAsync(int Id)
        {
            return Task.Run(() => lfmt.FirstOrDefault(s => s.id == Id));
        }
    }
}
