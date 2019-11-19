using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;
using CENG557_Oguzhan_Orhan.Business.Models;
using CENG557_Oguzhan_Orhan.Business.Models.Enums;

namespace CENG557_Oguzhan_Orhan.DataAccess
{
    public class FileHelperFactory
    {
        public static IFileHelper GetFileHelper(FILE_TYPE fileType)
        {
            if (fileType == FILE_TYPE.JSON)
            {
                return new JsonHelper();
            }
            else if (fileType == FILE_TYPE.XML)
            {
                return new XmlHelper();
            }
            else return null;
        }
    }
}
