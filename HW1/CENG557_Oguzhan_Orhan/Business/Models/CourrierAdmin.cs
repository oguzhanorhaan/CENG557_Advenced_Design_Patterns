using System;
using System.Collections.ObjectModel;
using CENG557_Oguzhan_Orhan.Business.Interfaces;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class CourrierAdmin : IRole
    {
        private Collection<Delivery> deliveries = new ObservableCollection<Delivery>();
        private String adminId, password;

        public CourrierAdmin(string v,string password)
        {
        }

        public void addDelivery(Delivery delivery)
        {
            deliveries.Add(delivery);
        }

        public String getId()
        {
            return adminId;
        }

        public string getPassword()
        {
            return password;
        }

        public void searcById(string deliveryId)
        {
            throw new NotImplementedException();
        }

        public void setId(String id)
        {
            this.adminId = id;
        }

        public void setPassword(string password)
        {
            this.password = password;
        }
    }
}
