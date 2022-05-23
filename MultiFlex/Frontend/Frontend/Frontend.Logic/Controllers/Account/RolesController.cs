//@CodeCopy
//MdStart
#if ACCOUNT_ON
namespace Frontend.Logic.Controllers.Account
{
    [Modules.Security.Authorize("SysAdmin", "AppAdmin")]
    public sealed partial class RolesController : GenericController<Entities.Account.Role>
    {
        public RolesController()
        {
        }

        public RolesController(ControllerObject other) : base(other)
        {
        }
    }
}
#endif
//MdEnd
