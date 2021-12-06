using ElectronNET.API;
using ElectronNET.API.Entities;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Multiflex.Frontend.Webapp
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }
        
        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddRazorPages();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapRazorPages();
            });
            // Open the Electron-Window here
            //var browserWindowOptions = new BrowserWindowOptions { Width = 1200, Height = 600, AutoHideMenuBar=true, Fullscreen=true};
            //Task.Run(async () => await Electron.WindowManager.CreateWindowAsync(browserWindowOptions));

            Bootstrap();
        }

        public async void Bootstrap()
        {
            var options = new BrowserWindowOptions
            {
                Width = 1200,
                Height = 600,
                Show = false
            };
            var mainWindow = await Electron.WindowManager.CreateWindowAsync(options);
            mainWindow.Maximize();
            mainWindow.OnReadyToShow += () =>
            {
                mainWindow.Show();
            };

            var menu = new MenuItem[]
            {

                new MenuItem()
                {
                    Label = "File",
                    Submenu = new MenuItem[]
                    {
                        new MenuItem()
                        {
                            Label = "Exit",
                            Click = () => {Electron.App.Exit();  }
                        }
                    }
                }
            };
            Electron.Menu.SetApplicationMenu(menu);
        }
    }
}
