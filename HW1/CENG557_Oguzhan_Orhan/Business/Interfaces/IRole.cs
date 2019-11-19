using System;
using CENG557_Oguzhan_Orhan.Business.Models;

namespace CENG557_Oguzhan_Orhan.Business.Interfaces
{
    public interface IRole
    {
        void addDelivery(Delivery delivery);
        void searcById(string deliveryId);

        String getId();
        void setId(String id);

        String getPassword();
        void setPassword(String password); 
    }
}
