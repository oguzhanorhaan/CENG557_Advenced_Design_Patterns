using System;
namespace CENG557_Oguzhan_Orhan.Presentation
{
    public class SellerConsole : AbstractConsole
    {
        public override void goToLogin()
        {
            Console.WriteLine("Please enter your id");
            var id=Console.ReadLine().ToString();
            if (!String.IsNullOrWhiteSpace(id))
            {
                Console.WriteLine("Please enter your password");
                var password=Console.ReadLine().ToString();
                if (!String.IsNullOrWhiteSpace(password))
                {
                    var result=isASeller(id, password);
                    if (!result)
                    {
                        Console.Write("Seller id and password not match");
                        goToLogin();
                        return;
                    }
                    else
                    {
                        showAvaibleOperations();
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

        private void showAvaibleOperations()
        {
            Console.WriteLine("1. Search Item\n");
            var readedValue=Console.ReadLine().ToString();
            if (readedValue == "1")
            {
                Console.WriteLine("Please enter the deliveryId");
                var readedId= Console.ReadLine();
                if (!String.IsNullOrWhiteSpace(readedId))
                {
                    var item=dataManager.getDeliveryFromList(readedId);
                    if (item != null)
                    {
                        Console.WriteLine(item.ToString());
                    }
                    else
                    {
                        Console.WriteLine("Product not found");
                        showAvaibleOperations();
                        return;
                    }
                }
                else
                {
                    Console.WriteLine("Please enter a valid value");
                    showAvaibleOperations();
                    return;
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
                Console.WriteLine("Your id is " + id + ", your password is " + password+", please keep them");
                // Save to seller list
                dataManager.saveSeller(id.ToString(), password);
            }
            
            else
            {
                Console.WriteLine("Please enter a valid value");
                goToSignUp();
                return;
            }
        }

        private Boolean isASeller(string id, string password)
        {
            //Check if seller list contains the entered id
            if (dataManager.getSellerFromList(id, password) != null)
            {
                return true;
            }
            return false;
        }

        public override string showLoginOrRegisterMessage()
        {
            Console.WriteLine("Dear seller, please enter your 6 digit user id and password or create an account");
            return ShowLoginOption();
        }
    }
}
