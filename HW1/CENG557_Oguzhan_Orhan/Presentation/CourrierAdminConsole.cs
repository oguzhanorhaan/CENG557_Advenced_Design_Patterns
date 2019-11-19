using System;
using CENG557_Oguzhan_Orhan.Business.Models;

namespace CENG557_Oguzhan_Orhan.Presentation
{
    public class CourrierAdminConsole : AbstractConsole
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
                    var result = isAnAdmin(id, password);
                    var admin= dataManager.getAdminFromList(id);
                    if (!result)
                    {
                        Console.Write("Admin id and password not match");
                        goToLogin();
                        return;
                    }
                    else
                    {
                        showAvaibleOperations(admin);
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

        private void showAvaibleOperations(CourrierAdmin admin)
        {
            Console.WriteLine("1. Search Item\n" +
                "2. Update item status");
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
                        showAvaibleOperations(admin);
                        return;
                    }
                }
                else
                {
                    Console.WriteLine("Please enter a valid value");
                    showAvaibleOperations(admin);
                    return;
                }

            }
            else if (readedValue == "2")
            {
                Console.WriteLine("enter the delivery id for updating delivery status");
                var delivery_id = Console.ReadLine();
                var delivery = dataManager.getDeliveryFromList(delivery_id);
                if (delivery != null)
                {
                    delivery.updateDeliveryState(admin);
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

        private Boolean isAnAdmin(string id, string password)
        {
            //Check if seller list contains the entered id
            if (dataManager.getAdminFromList(id, password) != null)
            {
                return true;
            }
            return false;
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
                dataManager.saveAdmin(id.ToString(), password);
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
            Console.WriteLine("Dear admin, please enter your 6 digit user id or create an account");
            return ShowLoginOption();
        }
    }
}
