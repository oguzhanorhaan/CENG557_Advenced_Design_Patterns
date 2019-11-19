using System;
using System.Collections.ObjectModel;
using CENG557_Oguzhan_Orhan.Business.Interfaces;

namespace CENG557_Oguzhan_Orhan.Business.Models
{
    public class Seller : IRole
    {
        private Collection<Delivery> my_sales = new ObservableCollection<Delivery>();
        private String sellerId, password;

        public Seller(string id, string password)
        {
            this.sellerId = id;
            this.password = password;
        }

        public void addDelivery(Delivery delivery)
        {
            my_sales.Add(delivery);
        }

        public String getId()
        {
            return sellerId;
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
            this.sellerId = id;
        }

        public void setPassword(string password)
        {
            this.password = password;
        }
    }
}
