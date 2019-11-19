using System;
using System.Collections.Generic;
using CENG557_Oguzhan_Orhan.Business.Interfaces;
using CENG557_Oguzhan_Orhan.Business.Models;
using Newtonsoft.Json;

namespace CENG557_Oguzhan_Orhan.DataAccess
{
    public class DataManager
    {
        List<Delivery> deliveryList;
        List<IRole> adminList;
        List<IRole> sellerList;
        List<IRole> buyerList;

        IFileHelper jsonHelper;
        IFileHelper xmlHelper;

        public DataManager()
        {
             jsonHelper = FileHelperFactory.GetFileHelper(Business.Models.Enums.FILE_TYPE.JSON);
             xmlHelper = FileHelperFactory.GetFileHelper(Business.Models.Enums.FILE_TYPE.XML);
             init();
        }

        private void init()
        {
            deliveryList = jsonHelper.readFile<Delivery>(Constants.DELIVERY_LIST_PATH);
            adminList = xmlHelper.readFile<IRole>(Constants.ADMIN_LIST_PATH);
            sellerList = xmlHelper.readFile<IRole>(Constants.SELLER_LIST_PATH);
            buyerList = xmlHelper.readFile<IRole>(Constants.CLIENT_LIST_PATH);
        }

        internal IRole getSellerFromList(string id, string password)
        {
            foreach (IRole seller in sellerList)
            {
                if (seller.getId() == id && seller.getPassword() == password)
                {
                    return seller;
                }
            }
            return null;
        }

        public IRole getSellerFromList(string id)
        {
            foreach (IRole seller in sellerList)
            {
                if (seller.getId() == id)
                {
                    return seller;
                }
            }
            return null;
        }



        internal Client getCustomerInList(string id, string password)
        {
            foreach (Client buyer in buyerList)
            {
                if (buyer.getId() == id && buyer.getPassword() == password)
                {
                    return buyer;
                }
            }
            return null;
        }

        internal void saveAdmin(string v, string password)
        {
            IRole admin = new CourrierAdmin(v,password);
            buyerList.Add(admin);
            xmlHelper.writeFileTo(Constants.ADMIN_LIST_PATH, buyerList);
        }

        internal void saveSeller(string v, string password)
        {
            IRole seller = new Seller(v, password);
            sellerList.Add(seller);
            xmlHelper.writeFileTo(Constants.SELLER_LIST_PATH, sellerList);
        }

        internal void saveClient(string v, string password)
        {
            IRole client = new Client(v,password);
            buyerList.Add(client);
            xmlHelper.writeFileTo(Constants.CLIENT_LIST_PATH, buyerList);
        }

        
        internal CourrierAdmin getAdminFromList(string id, string password)
        {
            foreach (CourrierAdmin admin in adminList)
            {
                if (admin.getId() == id && admin.getPassword() == password)
                {
                    return admin;
                }
            }
            return null;
        }

        internal CourrierAdmin getAdminFromList(string id)
        {
            foreach (CourrierAdmin admin in adminList)
            {
                if (admin.getId() == id)
                {
                    return admin;
                }
            }
            return null;
        }

        public  Delivery getDeliveryFromList(string deliveryId)
        {
            foreach (var delivery in deliveryList)
            {
                if (delivery.getDeliveryId() == deliveryId)
                {
                    return delivery;
                }
            }

            return null;
        }
    }
}
