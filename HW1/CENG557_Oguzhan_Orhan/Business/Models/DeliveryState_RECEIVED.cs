using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class DeliveryState_RECEIVED : IDeliveryState
    {
        public void Handle(Delivery delivery)
        {
            Console.WriteLine("Delivery state updated to RECEIVED");
            delivery.DeliveryState = new DeliveryState_ORDERED();
        }
    }
}
