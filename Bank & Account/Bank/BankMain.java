

import java.util.Scanner;

public class BankMain {
    public static void main(String[] commandLineArguments) {
        Scanner userInputScanner = new Scanner(System.in);
        Bank apexBank = new Bank("Guaranty Trust Bank");

        boolean isApplicationRunning = true;

        while (isApplicationRunning) {
            System.out.println("\n==========================================");
            System.out.println("       WELCOME TO " + apexBank.getBankName().toUpperCase());
            System.out.println("==========================================");
            System.out.println("1. Create New Bank Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Account Balance");
            System.out.println("6. Find Account Details");
            System.out.println("7. View Total Registered Accounts");
            System.out.println("8. Exit Application");
            System.out.print("Please enter your choice (1-8): ");

            int userMenuChoice = userInputScanner.nextInt();
            userInputScanner.nextLine(); 

            switch (userMenuChoice) {
                case 1:
                    System.out.print("Enter Customer Full Name: ");
                    String customerFullName = userInputScanner.nextLine();

                    System.out.print("Enter Initial Deposit Amount: ");
                    double initialDepositAmount = userInputScanner.nextDouble();

                    System.out.print("Create a 4 or 5-digit PIN: ");
                    int newAccountSecurityPin = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        BankAccount createdAccount = apexBank.createAccount(
                            customerFullName, 
                            initialDepositAmount, 
                            newAccountSecurityPin
                        );
                        System.out.println("Account created successfully!");
                        System.out.println("Account Name   : " + createdAccount.getAccountName());
                        System.out.println("Account Number : " + createdAccount.getAccountNumber());
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Error: " + caughtException.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAccountNumber = userInputScanner.nextLine();

                    System.out.print("Enter Amount to Deposit: ");
                    double amountToDeposit = userInputScanner.nextDouble();
                    userInputScanner.nextLine();

                    try {
                        apexBank.deposit(depositAccountNumber, amountToDeposit);
                        System.out.println("Deposit of " + amountToDeposit + " was successful.");
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Deposit Failed: " + caughtException.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawalAccountNumber = userInputScanner.nextLine();

                    System.out.print("Enter Amount to Withdraw: ");
                    double amountToWithdraw = userInputScanner.nextDouble();

                    System.out.print("Enter Account Security PIN: ");
                    int withdrawalSecurityPin = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        apexBank.withdraw(withdrawalAccountNumber, amountToWithdraw, withdrawalSecurityPin);
                        System.out.println("Withdrawal of " + amountToWithdraw + " was successful.");
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Withdrawal Failed: " + caughtException.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Sender (Source) Account Number: ");
                    String sourceAccountNumber = userInputScanner.nextLine();

                    System.out.print("Enter Receiver (Destination) Account Number: ");
                    String destinationAccountNumber = userInputScanner.nextLine();

                    System.out.print("Enter Amount to Transfer: ");
                    double amountToTransfer = userInputScanner.nextDouble();

                    System.out.print("Enter Sender Account PIN: ");
                    int senderSecurityPin = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        apexBank.transfer(
                            sourceAccountNumber, 
                            destinationAccountNumber, 
                            amountToTransfer, 
                            senderSecurityPin
                        );
                        System.out.println("Transfer of " + amountToTransfer + " completed successfully.");
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Transfer Failed: " + caughtException.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    String balanceCheckAccountNumber = userInputScanner.nextLine();

                    System.out.print("Enter Security PIN: ");
                    int balanceCheckSecurityPin = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        double currentAccountBalance = apexBank.checkBalance(
                            balanceCheckAccountNumber, 
                            balanceCheckSecurityPin
                        );
                        System.out.println("Current Available Balance: " + currentAccountBalance);
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Unable to check balance: " + caughtException.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Enter Account Number to Search: ");
                    String searchAccountNumber = userInputScanner.nextLine();

                    try {
                        BankAccount foundAccount = apexBank.findAccount(searchAccountNumber);
                        System.out.println("--- Account Details ---");
                        System.out.println("Account Number: " + foundAccount.getAccountNumber());
                        System.out.println("Holder Name   : " + foundAccount.getAccountName());
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Search Failed: " + caughtException.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Total Accounts in " + apexBank.getBankName() + ": " + apexBank.getNumberOfRegisteredAccounts());
                    break;

                case 8:
                    System.out.println("Thank you for banking with " + apexBank.getBankName() + ". Have a great day!");
                    isApplicationRunning = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please choose an option between 1 and 8.");
            }
        }

        userInputScanner.close();
    }
}
