using System;
using System.Collections.Generic;

namespace CENG557_Oguzhan_Orhan.Business.Interfaces
{
    public interface IFileHelper
    {
       List<T> readFile<T>(string path);
       void writeFileTo<T>(string path, List<T> list);
    }
}
