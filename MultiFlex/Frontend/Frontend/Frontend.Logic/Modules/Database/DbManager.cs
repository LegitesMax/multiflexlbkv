#if DEVELOP_ON
using Frontend.Logic.DataContext;

namespace Frontend.Logic.Modules.Database
{
    public static class DbManager
    {
        public static Task DeleteDatabaseAsync()
        {
            var dbContext = new ProjectDbContext();

            return dbContext.Database.EnsureDeletedAsync();
        }
        public static Task MigrateDatabaseAsync()
        {
            var dbContext = new ProjectDbContext();

            return dbContext.Database.MigrateAsync();
        }
        public static Task CreateDatabaseAsync()
        {
            var dbContext = new ProjectDbContext();

            return dbContext.Database.EnsureCreatedAsync();
        }
    }
}
#endif
