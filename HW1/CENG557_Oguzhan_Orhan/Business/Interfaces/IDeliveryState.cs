using System;
using CENG557_Oguzhan_Orhan.Business.Models;

namespace CENG557_Oguzhan_Orhan.Business.Interfaces
{
    public interface IDeliveryState
    {
        void Handle(Delivery delivery);
    }
}
