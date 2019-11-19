using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using CENG557_Oguzhan_Orhan.Business.Interfaces;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class Client : IRole
    {
        private Collection<Delivery> myOrders = new ObservableCollection<Delivery>();

        private String clientId, password;

        public Client(string clientId, string password)
        {
            this.clientId = clientId;
            this.password = password;
        }

        public void addDelivery(Delivery delivery)
        {
            myOrders.Add(delivery);
        }

        public void searcById(string deliveryId)
        {
            throw new NotImplementedException();
        }
       
        public void buyNewProduct(Delivery delivery)
        {
            addDelivery(delivery);
        }

        public String getId()
        {
            return clientId;
        }

        public void setId(String id)
        {
            this.clientId = id;
        }

        public string getPassword()
        {
            return password;
        }

        public void setPassword(string password)
        {
            this.password = password;
        }
    }
}
