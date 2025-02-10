public interface AccountService {

        double deposit(double amount ,int type);
        double withdraw(double amount,int type);
       double transfer(double amount,int type);
        void diplayAccInfo();
        void checkingAccountCreation();
        void savingAccountCreation();
        void transferToSaving(double amount, int accountIndex);
        void ToChecking(double amount, int accountIndex);
}
