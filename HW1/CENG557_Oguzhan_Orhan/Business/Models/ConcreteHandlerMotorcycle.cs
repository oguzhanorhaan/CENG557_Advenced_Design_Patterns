using System;
namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class ConcreteHandlerMotorcycle : AbstractVehicleTypeHelper
    {
        public override void handleVehicleType(Delivery delivery, int volume)
        {
            if (volume < 3)
            {
                delivery.setVehicleType(Enums.VEHICLE_TYPE.MOTORCYCLE);
            }

            else
            {
                if (_nextHandler != null)
                    _nextHandler.handleVehicleType(delivery,volume);
            }
        }
    }
}
