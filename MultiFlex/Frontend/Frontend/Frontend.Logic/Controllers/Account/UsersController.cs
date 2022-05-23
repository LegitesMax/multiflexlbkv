//@CodeCopy
//MdStart
#if ACCOUNT_ON
namespace Frontend.Logic.Controllers.Account
{
    public sealed partial class UsersController : GenericController<Entities.Account.User>
    {
        public UsersController()
        {
        }

        public UsersController(ControllerObject other) : base(other)
        {
        }
    }
}
#endif
//MdEnd
