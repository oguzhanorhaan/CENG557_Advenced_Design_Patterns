using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class DeliveryState_PAID : IDeliveryState
    {
        public void Handle(Delivery delivery)
        {
            Console.WriteLine("Delivery state updated to PAID");
            delivery.DeliveryState = new DeliveryState_LOADED();
        }
    }
}
