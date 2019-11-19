using System;
using CENG557_Oguzhan_Orhan.Business.Interfaces;
using CENG557_Oguzhan_Orhan.Business.Models;

namespace CENG557_Oguzhan_Orhan.Presentation
{
    public class ClientConsole : AbstractConsole
    {
        public override void goToLogin()
        {
            Console.WriteLine("Please enter your id");
            var id = Console.ReadLine().ToString();
            if (!String.IsNullOrWhiteSpace(id))
            {
                Console.WriteLine("Please enter your password");
                var password = Console.ReadLine().ToString();
                if (!String.IsNullOrWhiteSpace(password))
                {
                    var result = isACustomer(id, password);
                    if (!result)
                    {
                        Console.Write("Customer id and password not match");
                        goToLogin();
                        return;
                    }
                    else
                    {
                        Client client = dataManager.getCustomerInList(id, password);
                        showAvaibleOperations(client);
                    }
                }
            }
            else
            {
                Console.WriteLine("Please enter a valid value");
                ShowLoginOption();
                return;
            }
        }

        private void showAvaibleOperations(Client client)
        {
            Console.WriteLine("1. Search Item\n" +
                "2. Buy new item");
            var readedValue = Console.ReadLine().ToString();
            if (readedValue == "1")
            {
                Console.WriteLine("Please enter the deliveryId");
                var readedId = Console.ReadLine();
                if (!String.IsNullOrWhiteSpace(readedId))
                {
                    var item = dataManager.getDeliveryFromList(readedId);
                    if (item != null)
                    {
                        Console.WriteLine(item.ToString());
                    }
                    else
                    {
                        Console.WriteLine("Product not found");
                        showAvaibleOperations(client);
                        return;
                    }
                }
                else
                {
                    Console.WriteLine("Please enter a valid value");
                    showAvaibleOperations(client);
                    return;
                }

            }
            else if (readedValue == "2")
            {
                Console.WriteLine("enter the seller id for buying product");
                var seller_id=Console.ReadLine();
                var seller=dataManager.getSellerFromList(seller_id);
                if (seller != null)
                {
                    Delivery delivery = new Delivery();
                    delivery.setReceiverId(client.getId());
                    delivery.setSenderId(seller.getId());
                    Random rnd = new Random();
                    int volume = rnd.Next(1, 50);
                    delivery.setVolume(volume);
                    client.buyNewProduct(delivery);
                    seller.addDelivery(delivery);
                }
                else
                {
                    Console.WriteLine("Please enter a valid value");
                }

            }

            else
            {
                Console.WriteLine("Please enter a valid value");
            }
        }


        public override void goToSignUp()
        {
            Random rnd = new Random();
            int id = rnd.Next(1000000, 999999); // 6 digit unique ID 
            Console.WriteLine("Please create a 6 digit password");
            var password = Console.ReadLine().ToString();
            if (!String.IsNullOrWhiteSpace(password))
            {
                Console.WriteLine("Your id is " + id + ", your password is " + password + ", please keep them");
                // Save to seller list
                dataManager.saveClient(id.ToString(), password);
            }
            else
            {
                Console.WriteLine("Please enter a valid value");
                goToSignUp();
                return;
            }
        }

        public override string showLoginOrRegisterMessage()
        {
            Console.WriteLine("Dear client, please enter your 6 digit user id and password or create an account");
            return ShowLoginOption();
        }

        private Boolean isACustomer(string id, string password)
        {
            //Check if seller list contains the entered id
            if (dataManager.getCustomerInList(id, password) != null)
            {
                return true;
            }
            return false;
        }
    }
}
