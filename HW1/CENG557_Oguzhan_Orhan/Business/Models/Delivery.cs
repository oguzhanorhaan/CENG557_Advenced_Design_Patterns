using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;
using CENG557_Oguzhan_Orhan.Business.Models.Enums;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class Delivery
    {
        private string _deliveryID { get; set; }

        private IDeliveryState _deliveryState { get; set; }

        private int _volume = 0;

        protected VEHICLE_TYPE vehicle_type;

        private string senderId;
        private string receiverID;

        internal void setVehicleType(VEHICLE_TYPE type)
        {
            vehicle_type = type;
        }

        VEHICLE_TYPE getVehicleType()
        {
            return vehicle_type;
        }

        public Delivery()
        {
            DeliveryState = new DeliveryState_ORDERED();
        }

        public IDeliveryState DeliveryState
        {
            get { return _deliveryState; }
            set
            {
                _deliveryState = value;
            }
        }

        public string getDeliveryId()
        {
            return _deliveryID;
        }

        public void updateDeliveryState(IRole role)
        {
            if (role is CourrierAdmin)
            {
                DeliveryState.Handle(this);
            }
        }

        public int getVolume()
        {
            return _volume;
        }

        public void setVolume(int volume)
        {
            _volume = volume;
            VehicleTypeHelper.setVehicleType(this,volume);
        }

        public string getSenderId()
        {
            return this.senderId;
        }

        public void setSenderId(string senderId)
        {
            this.senderId = senderId;
        }

        public string getReceiverId()
        {
            return this.receiverID;
        }

        public void setReceiverId(string receiverId)
        {
            this.receiverID = receiverId;
        }
    }
}

