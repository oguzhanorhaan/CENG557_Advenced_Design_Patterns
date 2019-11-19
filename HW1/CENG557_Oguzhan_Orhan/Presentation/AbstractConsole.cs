using System;
using CENG557_Oguzhan_Orhan.DataAccess;

namespace CENG557_Oguzhan_Orhan.Presentation
{
    public  abstract class AbstractConsole
    {
        public DataManager dataManager = new DataManager();

        public string ShowLoginOption()
        {
            Console.WriteLine(
               "1. Login \n" +
               "2. Create Account");
            return Console.ReadLine().ToString();
        }

        public abstract void goToLogin();
        public abstract void goToSignUp();

        public abstract string showLoginOrRegisterMessage();
    }
}
