using System;
using CENG557_Oguzhan_Orhan.Presentation;

namespace CENG557_Oguzhan_Orhan
{
    class Program
    {
        private static AbstractConsole console;
        static void Main(string[] args)
        {
            //TODO: Load data
            launchConsole();
       
        }

        private static void launchConsole()
        {
            Console.WriteLine("Welcome to the Courrier System!\n Please choose your login type: \n" +
           "1. Courrier Admin \n" +
           "2. Client\n"+
           "3. Seller");
            var readed_value = Console.ReadLine();
            if (readed_value.ToString() == "1")
            {
                console = new CourrierAdminConsole();

            }
            else if (readed_value.ToString() == "2")
            {
                console = new ClientConsole();

            }
            else if (readed_value.ToString() == "3")
            {
                console = new SellerConsole();
            }
            else
            {
                Console.WriteLine("Please enter a valid value");
                launchConsole();
                return;
            }

            var choosen_option=console.showLoginOrRegisterMessage();

            if (choosen_option == "1") // LOGIN
            {
                console.goToLogin();
            }
            else if (choosen_option == "2") // REGISTER
            {
                console.goToSignUp();
            }
            else
            {
                Console.WriteLine("Please enter a valid value");
                launchConsole();
                return;
            }

        }

    }
}
