//@CodeCopy
//MdStart
using System.Text.Json;

namespace Frontend.AspMvc.Extensions
{
    public static partial class SessionExtensions
    {
        public static void Set<T>(this ISession session, string key, T? value)
        {
            string strValue = System.Text.Json.JsonSerializer.Serialize(value);

            session.SetString(key, strValue);
        }

        public static T? Get<T>(this ISession session, string key)
        {
            var strValue = session.GetString(key);

            return strValue == null ? default : System.Text.Json.JsonSerializer.Deserialize<T>(strValue);
        }
    }
}
//MdEnd
