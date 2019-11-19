using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class DeliveryState_LOADED : IDeliveryState
    {
        public void Handle(Delivery delivery)
        {
            Console.WriteLine("Delivery state updated to LOADED");
            delivery.DeliveryState = new DeliveryState_INTRANSFER();
        }
    }
}
