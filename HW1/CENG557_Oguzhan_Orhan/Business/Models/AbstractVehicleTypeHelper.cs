using System;
namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public abstract class AbstractVehicleTypeHelper
    {
        protected AbstractVehicleTypeHelper _nextHandler;
        public AbstractVehicleTypeHelper NextHandler { set { _nextHandler = value; } }
        public abstract void handleVehicleType(Delivery delivery,int volume);
    }
}
