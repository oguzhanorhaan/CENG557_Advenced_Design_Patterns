using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class DeliveryState_INTRANSFER : IDeliveryState
    {
        public void Handle(Delivery delivery)
        {
            Console.WriteLine("Delivery state updated to IN_TRANSFER");
            delivery.DeliveryState = new DeliveryState_RECEIVED();
        }
    }
}
