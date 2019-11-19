using System;
using System.Collections.Generic;
using System.IO;
using CENG557_Oguzhan_Orhan.Business.Interfaces;
using CENG557_Oguzhan_Orhan.Business.Models;
using Newtonsoft.Json;

namespace CENG557_Oguzhan_Orhan.DataAccess
{
    public class JsonHelper : IFileHelper
    {
        
        public List<Delivery> readFile<Delivery>(string path)
        {
            using (StreamReader r = new StreamReader(path))
            {
                string json = r.ReadToEnd();
                List<Delivery> items = JsonConvert.DeserializeObject<List<Delivery>>(json);
                return items;
            }
        }

        public void writeFileTo<Delivery>(string path, List<Delivery> list)
        {
            string json = JsonConvert.SerializeObject(list.ToArray());

            //write string to file
            System.IO.File.WriteAllText(path, json);
        }
    }
}
