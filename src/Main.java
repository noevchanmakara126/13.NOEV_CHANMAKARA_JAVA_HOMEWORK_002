import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Control control = new Control();
        AccountSeviceImp accountSeviceimp = new AccountSeviceImp();
        CheckingAcc checkingAcc = new CheckingAcc();
        SavingAcc savingAcc = new SavingAcc();
        do {
            control.menu();
            String op ="";
            boolean exit = false;
            while (!exit){
                System.out.printf("Please Choose Option : ");
                 op = sc.nextLine();
                if(op.matches("^[1-9{1}]$")){
                    exit = true;
                }
                else {
                    System.out.println("Invalid Option");
                }
            }
            int option = Integer.parseInt(op);
            switch (option){
                case 1 -> {
                    control.menuCreateAccount();
                    String chosen = sc.nextLine();
                    boolean wrong = false;
                    Integer chosing = 0;
                    while(!wrong){

                        if (chosen.matches("^[1-2]$")){
                            wrong = true;
                        }
                        else {
                            System.out.println("Invalid Option");
                        }
                    }
                    chosing = Integer.parseInt(chosen);
                    switch (chosing){
                        case 1 -> {
                         accountSeviceimp.checkingAccountCreation();
                        }
                        case 2 -> {
                            accountSeviceimp.savingAccountCreation();
                        }
                        default -> {
                            System.out.println("Invalid Option");
                            return;
                        }
                    }

                }
                case 2 -> {control.menuCreateAccount();
                    System.out.printf("Please Selection Account Type : ");
                    String acctyes = sc.nextLine();
                    Integer accty = 0;
                    boolean wrong = false;
                    while (!wrong){
                        if (acctyes.matches("^[1-3]$")){
                            wrong = true;
                        }
                        else {
                            System.out.println("Invalid Option");
                        }
                    }
                    System.out.printf("Enter Amount to Deposit : ");
                    String amount = sc.nextLine();
                    Double finalAmount = 0.0;
                    while(!wrong){
                        if (amount.matches("^[1-9]$")){
                            wrong = true;
                        }
                        else {
                            System.out.println("Invalid Option");
                        }
                    }
                    accty = Integer.valueOf(acctyes);
                    finalAmount= Double.parseDouble(amount);
                    accountSeviceimp.deposit(finalAmount,accty);
                    System.out.println("Deposit Successful");


                }
                case 3 -> {
                    control.menuCreateAccount();
                    System.out.printf("Please Selection Account Type : ");
                    String acctyes = sc.nextLine();
                    Integer accty = 0;
                    boolean wrong = false;
                    while (!wrong) {
                        if (acctyes.matches("^[1-3]$")) {
                            wrong = true;
                        } else {
                            System.out.println("Invalid Option");
                            acctyes = sc.nextLine();
                        }
                    }
                    wrong = false;

                    // Get and validate amount
                    System.out.printf("Enter Amount to Withdraw : ");
                    String amount = sc.nextLine();
                    Double finalAmount = 0.0;

                    while (!wrong) {
                        if (amount.matches("^\\d+(\\.\\d{1,2})?$")) {
                            wrong = true;
                        } else {
                            System.out.println("Invalid Amount. Please enter a valid number.");
                            amount = sc.nextLine();
                        }
                    }

                    accty = Integer.valueOf(acctyes);
                    finalAmount = Double.parseDouble(amount);
                    accountSeviceimp.withdraw(finalAmount, accty);
                    System.out.println("Withdrawal Successful");

                }

                case 4 -> {
                    int accty = 0;
                    while (true) {
                        System.out.print("Please Select Account Type (1. Checking -> Saving, 2. Saving -> Checking): ");
                        String acctyes = sc.nextLine();
                        if (acctyes.matches("^[1-2]$")) {
                            accty = Integer.parseInt(acctyes);
                            break;
                        } else {
                            System.out.println("Invalid Option. Please enter 1 or 2.");
                        }
                    }
                    double finalAmount = 0.0;
                    while (true) {
                        System.out.print("Enter Amount to Transfer: ");
                        String amount = sc.nextLine();
                        if (amount.matches("^\\d+(\\.\\d{1,2})?$")) {
                            finalAmount = Double.parseDouble(amount);
                            break;
                        } else {
                            System.out.println("Invalid Amount. Please enter a valid number.");
                        }
                    }
                    accountSeviceimp.transfer(finalAmount, accty);
                }
                case 5 -> { accountSeviceimp.diplayAccInfo();
                }
                case 6 -> {
                    System.out.println("Thanks you for choosing our Back ");
                    System.out.println("Come to us Next time");
                    System.exit(0);
                }

            }
        }while (true);

    }
}