using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace Multiflex.Logic
{
    public class RegalDbContext : DbContext
    {
        private static string ConnectionString => "Data Source=multiflex3.ddns.net,3306; Database=test; User Id=root; Passwort=admin";

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(ConnectionString);

            base.OnConfiguring(optionsBuilder);
        }
    }
}
