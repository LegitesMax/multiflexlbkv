using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Text;
using System.Threading.Tasks;

namespace Frontend.Logic.Entities.Materials
{
    public class Material : VersionEntity
    {

        public string Name { get; set; } = string.Empty;

        public string Designation { get; set; } = string.Empty;

        public int StorageSize { get; set; }

        public int StorageMin { get; set; }

    }
}
