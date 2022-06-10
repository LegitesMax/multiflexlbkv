//@CodeCopy
//MdStart
#if ACCOUNT_ON
using Frontend.Logic.Entities.Logging;

namespace Frontend.Logic.Controllers.Account
{
    internal sealed partial class ActionLogsController : GenericController<ActionLog>
    {
        public ActionLogsController()
        {
        }

        public ActionLogsController(ControllerObject other) : base(other)
        {
        }
    }
}
#endif
//MdEnd
