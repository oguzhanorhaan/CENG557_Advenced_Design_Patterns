using System;
using System.Collections.Generic;
using System.IO;
using System.Xml.Serialization;
using CENG557_Oguzhan_Orhan.Business.Interfaces;
using CENG557_Oguzhan_Orhan.Business.Models;

namespace CENG557_Oguzhan_Orhan.DataAccess
{
    public class XmlHelper : IFileHelper
    {
        public List<IRole> readFile<IRole>(string path)
        {
            XmlSerializer xs = new XmlSerializer(typeof(List<IRole>));
            using (var sr = new StreamReader(path))
            {
               var list = (List<IRole>)xs.Deserialize(sr);
                return list;
            }
        }

        public void writeFileTo<IRole>(string path, List<IRole> list)
        {
            XmlSerializer xs = new XmlSerializer(typeof(List<IRole>));
            TextWriter tw = new StreamWriter(path);
            xs.Serialize(tw, list);
        }
    }
}
