using System;
using CENG557_Oguzhan_Orhan.Business.Models.Enums;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class VehicleTypeHelper
    {
      
        public static void setVehicleType(Delivery delivery,int volume)
        {

            AbstractVehicleTypeHelper motorcycle = new ConcreteHandlerMotorcycle();
            AbstractVehicleTypeHelper van = new ConcreteHandlerVan();
            AbstractVehicleTypeHelper truck = new ConcreteHandlerTruck();
            AbstractVehicleTypeHelper trailer = new ConcreteHandlerTrailer();

            motorcycle.NextHandler = van;
            van.NextHandler = truck;
            truck.NextHandler = trailer;
            trailer.NextHandler = motorcycle;

            motorcycle.handleVehicleType(delivery,volume);
        }
    }
}
