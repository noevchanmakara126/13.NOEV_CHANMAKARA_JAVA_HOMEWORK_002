import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Random;
import java.util.Scanner;

public class AccountSeviceImp implements AccountService {
    final int CUSTOMER_MAX = 100;

    Scanner sc = new Scanner(System.in);
    CheckingAcc[] checkingAcc = new CheckingAcc[CUSTOMER_MAX];
    SavingAcc[] savingAcc = new SavingAcc[CUSTOMER_MAX];
    Control control = new Control();
    static int customerCount = 2;

    @Override
    public void diplayAccInfo() {
        Table table = new Table(8, BorderStyle.UNICODE_BOX_HEAVY_BORDER_WIDE, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.CENTER);
        table.setColumnWidth(7, 0, 0);
        table.addCell("Account Information", cellStyle, 8);
        table.addCell("Account Type", cellStyle);
        table.addCell("Account ID", cellStyle);
        table.addCell("Account Name", cellStyle);
        table.addCell("Account DOB", cellStyle);
        table.addCell("Account Gender", cellStyle);
        table.addCell("Account Phone", cellStyle);
        table.addCell("Account Amount", cellStyle);
        checkingAcc[0] = new CheckingAcc("Checking", "11111111", "Mey", "15-02-2004", "Famale", "078295989", 1000.0);
        savingAcc[1] = new SavingAcc("Saving", "11111111", "Makara", "26-01-2004", "Male", "078295989", 100.1, 0.5);
        for (int i = 0; i <= customerCount; i++) {
            if (checkingAcc[i] != null) {
//                System.out.println(checkingAcc[i].getUsername() + " - " + checkingAcc[i].getPhoneNumber());
                table.addCell("", 7);
                table.addCell(checkingAcc[i].getAcctype(), cellStyle);
                table.addCell(checkingAcc[i].getAccId(), cellStyle);
                table.addCell(checkingAcc[i].getUsername(), cellStyle);
                table.addCell(checkingAcc[i].getDob(), cellStyle);
                table.addCell(checkingAcc[i].getGender(), cellStyle);
                table.addCell(checkingAcc[i].getPhoneNumber(), cellStyle);
                table.addCell(String.valueOf(checkingAcc[i].getAmount()), cellStyle);
            }
            if (savingAcc[i] != null) {
                table.addCell("", 7);
                table.addCell(savingAcc[i].getAcctype(), cellStyle);
                table.addCell(savingAcc[i].getAccId(), cellStyle);
                table.addCell(savingAcc[i].getUsername(), cellStyle);
                table.addCell(savingAcc[i].getDob(), cellStyle);
                table.addCell(savingAcc[i].getGender(), cellStyle);
                table.addCell(savingAcc[i].getPhoneNumber(), cellStyle);
                table.addCell(String.valueOf(savingAcc[i].getAmount()), cellStyle);
                table.addCell(String.valueOf(savingAcc[i].getRate()), cellStyle);
            }
        }
        System.out.println(table.render());
    }

    //Checkingacc method
    @Override
    public void checkingAccountCreation() {
        System.out.println("Account Information");
        String usernames;
        while (true) {
            System.out.printf("Enter Username: ");
            usernames = sc.nextLine();
            if (!usernames.isEmpty()) {
                break;
            } else {
                System.out.println("❌ Username cannot be empty. Please try again.");
            }
        }

        String dobs;
        while (true) {
            System.out.printf("Enter Date of Birth [dd/mm/yyyy]: ");
            dobs = sc.nextLine();
            if (dobs.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                String[] dateParts = dobs.split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                // Check if the month is valid
                if (month < 1 || month > 12) {
                    System.out.println("Invalid month. Please use a month between 1 and 12.");
                    continue;
                }

                boolean validDay = false;
                if (month == 2) {
                    if (control.isLeapYear(year)) {
                        validDay = day >= 1 && day <= 29;
                    } else {
                        validDay = day >= 1 && day <= 28;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    validDay = day >= 1 && day <= 30;
                } else {
                    validDay = day >= 1 && day <= 31;
                }

                if (validDay) {
                    System.out.println("Date is valid.");
                    break;
                } else {
                    System.out.println("Invalid day for the given month and year.");
                }
            } else {
                System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            }
        }

        String genders;
        while (true) {
            System.out.printf("Enter Gender [Male/Female]: ");
            genders = sc.nextLine();
            if (genders.equalsIgnoreCase("Male") || genders.equalsIgnoreCase("Female")) {
                break;
            } else {
                System.out.println("❌ Invalid gender. Please enter 'Male' or 'Female'.");
            }
        }

        String phonenumbers;
        while (true) {
            System.out.printf("Enter Phone Number: ");
            phonenumbers = sc.nextLine();
            if (phonenumbers.matches("^\\d{10}$")) {
                break;
            } else {
                System.out.println("❌ Invalid phone number. Please enter a 10-digit phone number.");
            }
        }

        System.out.println("✅ Successfully Created Account");
        Random random = new Random();
        String accid = String.valueOf(1000000 + random.nextInt(90000000));
        checkingAcc[customerCount] = new CheckingAcc("Checking Account", accid, usernames, dobs, genders, phonenumbers, 0.0);
        ++customerCount;
    }

    //saving account method
    @Override
    public void savingAccountCreation() {
        String usernames;
        while (true) {
            System.out.printf("Enter Username: ");
            usernames = sc.nextLine();
            if (!usernames.isEmpty()) {
                break;
            } else {
                System.out.println("❌ Username cannot be empty. Please try again.");
            }
        }

        String dobs;
        while (true) {
            System.out.printf("Enter Date of Birth [dd/mm/yyyy]: ");
            dobs = sc.nextLine();
            if (dobs.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                String[] dateParts = dobs.split("/");
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                // Check if the month is valid
                if (month < 1 || month > 12) {
                    System.out.println("Invalid month. Please use a month between 1 and 12.");
                    continue;
                }

                boolean validDay = false;
                if (month == 2) {
                    if (control.isLeapYear(year)) {
                        validDay = day >= 1 && day <= 29;
                    } else {
                        validDay = day >= 1 && day <= 28;
                    }
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    validDay = day >= 1 && day <= 30;
                } else {
                    validDay = day >= 1 && day <= 31;
                }

                if (validDay) {
                    System.out.println("Date is valid.");
                    break;
                } else {
                    System.out.println("Invalid day for the given month and year.");
                }
            } else {
                System.out.println("Invalid date format. Please use dd/mm/yyyy.");
            }
        }

        String genders;
        while (true) {
            System.out.printf("Enter Gender [Male/Female]: ");
            genders = sc.nextLine();
            if (genders.equalsIgnoreCase("Male") || genders.equalsIgnoreCase("Female")) {
                break;
            } else {
                System.out.println("❌ Invalid gender. Please enter 'Male' or 'Female'.");
            }
        }

        String phonenumbers;
        while (true) {
            System.out.printf("Enter Phone Number: ");
            phonenumbers = sc.nextLine();
            if (phonenumbers.matches("^\\d{10}$")) {
                break;
            } else {
                System.out.println("❌ Invalid phone number. Please enter a 10-digit phone number.");
            }
        }

        System.out.println("Successfully Created Account");
        Random random = new Random();
        String accid = String.valueOf(1000000 + random.nextInt(90000000));
        savingAcc[customerCount] = new SavingAcc("Saving Account", accid, usernames, dobs, genders, phonenumbers, 0.0,0.0);
        ++customerCount;
    }

    @Override
    public void transferToSaving(double amount, int accountIndex) {
        if (checkingAcc[accountIndex] != null && savingAcc[accountIndex] != null) {
            if (checkingAcc[accountIndex].getAmount() >= amount) {
                double checkingBalance = checkingAcc[accountIndex].getAmount();
                double savingBalance = savingAcc[accountIndex].getAmount();
                checkingAcc[accountIndex].setAmount(checkingBalance - amount);
                savingAcc[accountIndex].setAmount(savingBalance + amount);
                System.out.println("Successfully transferred " + amount + " from Checking Account to Saving Account.");
            } else {
                System.out.println(" Insufficient funds in Checking Account.");
            }
        }
    }

    @Override
    public void ToChecking(double amount, int accountIndex) {
        if (checkingAcc[accountIndex] != null && savingAcc[accountIndex] != null) {
            if (savingAcc[accountIndex].getAmount() >= amount) {
                double savingBalance = savingAcc[accountIndex].getAmount();
                double checkingBalance = checkingAcc[accountIndex].getAmount();
                savingAcc[accountIndex].setAmount(savingBalance - amount);
                checkingAcc[accountIndex].setAmount(checkingBalance + amount);

                System.out.println("Successfully transferred " + amount + " from Saving Account to Checking Account.");
            } else {
                System.out.println("Insufficient funds in Saving Account.");
            }
        }
    }


    //Disposit method
    @Override
    public double deposit(double amount, int type) {
        if (type == 1) {
            for (int i = 0; i < customerCount; i++) {
                if (checkingAcc[i] != null) {
                    if (checkingAcc[i].getAmount() == 0) {
                        checkingAcc[i].setAmount(amount);
                        System.out.println("Successfully Deposited " + amount + " to Checking Acccount");
                    } else if (checkingAcc[i].getAmount() != 0) {
                        checkingAcc[i].setAmount(checkingAcc[i].getAmount() + amount);
                        System.out.println("Successfully Deposited " + amount + " to Checking Acccount");
                    }
                }

            }
        } else if (type == 2) {
            for (int i = 0; i < customerCount; i++) {
                if (savingAcc[i] != null) {
                    if (savingAcc[i].getAmount() == 0) {
                        savingAcc[i].setAmount(amount);
                        System.out.println("Successfully Deposited " + amount + " to Saving Acccount");
                    } else if (savingAcc[i].getAmount() != 0) {
                        savingAcc[i].setAmount(savingAcc[i].getAmount() + amount);
                        System.out.println("Successfully Deposited " + amount + " to Saving Acccount");
                    }
                }

            }
        }

        return amount;
    }

    //Withdray method
    @Override
    public double withdraw(double amount, int type) {
        if (type == 1) {
            for (int i = 0; i < customerCount; i++) {
                if (checkingAcc[i] != null) {
                    if (checkingAcc[i].getAmount() == 0) {
                        System.out.println("You don't have money in you account");
                    } else if (checkingAcc[i].getAmount() != 0) {
                        checkingAcc[i].setAmount(checkingAcc[i].getAmount() - amount);
                    }
                }

            }
        } else if (type == 2) {
            for (int i = 0; i < customerCount; i++) {
                if (savingAcc[i] != null) {
                    if (savingAcc[i].getAmount() == 0) {
                        System.out.println("You don't have money in you account");
                    } else if (savingAcc[i].getAmount() != 0) {
                        savingAcc[i].setAmount(savingAcc[i].getAmount() - amount);
                    }
                }

            }
        }
        return amount;
    }


    @Override
    public double transfer(double amount, int type) {
        for (int i = 0; i < customerCount; i++) {
            if (type == 1) {
                transferToSaving(amount, i);
            } else if (type == 2) {
              ToChecking(amount, i);
            }
        }
        return amount;
    }
}
