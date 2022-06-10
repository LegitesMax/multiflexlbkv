//@CodeCopy
//MdStart
#if ACCOUNT_ON
namespace Frontend.AspMvc.Models.Account
{
    public partial class Role : VersionModel
    {
        public string Designation { get; set; } = string.Empty;
        public string Description { get; set; } = string.Empty;
    }
}
#endif
//MdEnd
