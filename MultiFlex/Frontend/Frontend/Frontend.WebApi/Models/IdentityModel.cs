//@CodeCopy
//MdStart
using Frontend.Logic.Contracts;
using System.ComponentModel.DataAnnotations;

namespace Frontend.WebApi.Models
{
    /// <summary>
    /// The model with the identity property.
    /// </summary>
    public abstract partial class IdentityModel : IIdentifyable
    {
        /// <summary>
        /// ID of the model (primary key)
        /// </summary>
        [Key]
        public int Id { get; set; }
    }
}
//MdEnd
