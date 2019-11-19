using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;
using static System.Console;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class DeliveryState_ORDERED : IDeliveryState
    {
        public void Handle(Delivery delivery)
        {
            WriteLine("Delivery state updated to ORDERED");
            delivery.DeliveryState = new DeliveryState_PAID();
        }
    }
}
