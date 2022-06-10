//@CodeCopy
//MdStart

namespace Frontend.Logic.Contracts
{
    public partial interface IVersionable : IIdentifyable
    {
        byte[]? RowVersion { get; }
    }
}
//MdEnd
