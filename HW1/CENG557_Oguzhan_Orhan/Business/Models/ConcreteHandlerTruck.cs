using System;
namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class ConcreteHandlerTruck : AbstractVehicleTypeHelper
    {
        public override void handleVehicleType(Delivery delivery,int volume)
        {
            if (volume >=10 && volume < 30)
            {
                delivery.setVehicleType(Enums.VEHICLE_TYPE.TRUCK);
            }

            else
            {
                if (_nextHandler != null)
                    _nextHandler.handleVehicleType(delivery,volume);
            }
        }
    }
}
