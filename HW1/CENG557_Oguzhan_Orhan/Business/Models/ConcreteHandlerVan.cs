using System;
namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class ConcreteHandlerVan : AbstractVehicleTypeHelper
    {
        public override void handleVehicleType(Delivery delivery,int volume)
        {
            if (volume >= 3 && volume <10)
            {
                delivery.setVehicleType(Enums.VEHICLE_TYPE.VAN);
            }

            else
            {
                if (_nextHandler != null)
                    _nextHandler.handleVehicleType(delivery,volume);
            }
        }
    }
}
