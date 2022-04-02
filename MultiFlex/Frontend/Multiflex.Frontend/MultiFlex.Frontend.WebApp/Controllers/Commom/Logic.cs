using ElectronNET.API;
using ElectronNET.API.Entities;
using System.Threading.Tasks;

namespace Multiflex.Frontend.WebApp.Controllers.Commom
{
    public class Logic
    {
        public async Task<BrowserWindow> AddWindow(string path)
        {
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

            return browserWindow;
        }
    }
}
