//@CodeCopy
//MdStart

using Frontend.Logic.Controllers;

namespace Frontend.Logic.Facades
{
    public abstract partial class FacadeObject
    {
        internal ControllerObject ControllerObject { get; private set; }

        protected FacadeObject(ControllerObject controllerObject)
        {
            ControllerObject = controllerObject;
        }
    }
}

//MdEnd
