using ElectronNET.API;
using Microsoft.AspNetCore.Mvc;
using Multiflex.Frontend.WebApp.Controllers.Commom;
using Multiflex.Frontend.WebApp.Models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Multiflex.Frontend.WebApp.Controllers
{
    public class MaterialController : Controller
    {
        private static List<Models.MaterialDto> material = new();
        private static List<Models.LieferantDto> lieferatnen = new();
        private static List<Models.LieferantMaterial> lfmt = new();

        public async Task<ActionResult> Index()
        {
            #region crap
            //Electron.IpcMain.On("loadMaterialAndLieferanten", async (arg) =>
            //{
            //    var mainWindow = Electron.WindowManager.BrowserWindows.First();
            //    using var httpCliet = new HttpClient();
            //    //Console.WriteLine("geht");
            //    var requestlieferant = Task.Run(() =>
            //    {
            //        return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
            //    });
            //    var requestMaterial = Task.Run(() =>
            //    {
            //        return httpCliet.GetStringAsync("http://localhost:8080/ware/material");
            //    });
            //    //Console.WriteLine(requestlieferant);
            //    var json = JArray.Parse(await requestlieferant);
            //    var json2 = JArray.Parse(await requestMaterial);
            //    Console.WriteLine("Json: Lieferant");
            //    Console.WriteLine(json);
            //    Console.WriteLine("Json: Material");
            //    Console.WriteLine(json2);

            //    Electron.IpcMain.Send(mainWindow, "getloadMaterialAndLieferanten-reply", json.ToString(), json2.ToString());
            //});
            //Electron.IpcMain.On("open-add-window", async (arg) =>
            //{
            //    var logic = new Logic();
            //    BrowserWindow win = await logic.AddWindow("/Material/Add");
            //    win.Show();
            //});

            //Electron.IpcMain.On("open-delete-window", async (arg) =>
            //{
            //    var logic = new Logic();
            //    BrowserWindow win = await logic.AddWindow("/Material/Delete");
            //    win.Show();
            //});
            #endregion crap

            material = new();
            lieferatnen = new();
            lfmt = new();

            using var httpCliet = new HttpClient();

            var requestlieferant = Task.Run(() =>
            {
                return httpCliet.GetStringAsync("http://localhost:8080/lieferant");
            });

            var requestMaterial = Task.Run(() =>
            {
                return httpCliet.GetStringAsync("http://localhost:8080/ware/material");
            });

            var json1 = JArray.Parse(await requestlieferant);
            var json2 = JArray.Parse(await requestMaterial);

            var items1 = System.Text.Json.JsonSerializer.Deserialize<Models.LieferantDto[]>(json1.ToString());
            var items2 = System.Text.Json.JsonSerializer.Deserialize<Models.MaterialDto[]>(json2.ToString());

            lieferatnen.AddRange(items1);
            material.AddRange(items2);

            foreach (var item in material)
            {
                foreach (var item2 in lieferatnen)
                {
                    if (item2.waren_ids.Contains(item.id))
                    {
                        lfmt.Add(
                            new Models.LieferantMaterial
                            {
                                ware_name = item.name,
                                lieferzeit = item2.lieferzeit,
                                lieferat_name = item2.name,
                                weblink = item2.weblink
                            }
                        );
                    }
                }
            }

            var models = await GetAllAsync();
            return View(models);
        }

        public static Task<Models.LieferantMaterial[]> GetAllAsync()
        {
            return Task.Run(() => lfmt.ToArray());
        }

        public static Task<Models.LieferantMaterial?> GetByIdAsync(int Id)
        {
            return Task.Run(() => lfmt.FirstOrDefault(s => s.id == Id));
        }

        #region Add
        //public ActionResult Add()
        //{
        //    return View();
        //}

        //[HttpPost]
        //[ValidateAntiForgeryToken]
        //public async Task<ActionResult> Add(Models.MaterialDto model)
        //{
        //    try
        //    {
        //        var lieferant = new Models.MaterialDao();

        //        lieferant.name = model.name;
        //        lieferant.weblink = model.weblink;
        //        lieferant.lieferzeit = model.lieferzeit;

        //        using var httpCliet = new HttpClient();
        //        var json = JsonConvert.SerializeObject(lieferant);
        //        var data = new StringContent(json, Encoding.UTF8, "application/json");

        //        System.Console.WriteLine(data.ToString());

        //        await httpCliet.PostAsync("http://localhost:8080/lieferant/add", data);

        //        return RedirectToAction(nameof(Index));
        //    }
        //    catch
        //    {
        //        return View();
        //    }
        //}
        #endregion Add

        #region delete
        public async Task<ActionResult> DeleteAsync(int id)
        {
            var model = await GetByIdAsync(id);
            return View(model);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Delete(int id, Models.LieferantMaterial model)
        {
            try
            {
                using var httpCliet = new HttpClient();

                await httpCliet.DeleteAsync("http://localhost:8080/lieferant/delete/" + model.id);
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
