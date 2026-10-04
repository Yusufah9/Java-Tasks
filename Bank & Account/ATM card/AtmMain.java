

import java.util.Scanner;

public class AtmMain {
    public static void main(String[] commandLineArguments) {
        Scanner userInputScanner = new Scanner(System.in);

        // Setting up Bank infrastructure with pre-registered accounts for testing
        Bank centralBank = new Bank("Guaranty Trust Bank");
        BankAccount primarySampleAccount = centralBank.createAccount("Yusuf Umaru", 15000.0, 33556);
        BankAccount secondarySampleAccount = centralBank.createAccount("Amina Bello", 5000.0, 11223);

        Atm automatedTellerMachine = new Atm(centralBank);

        System.out.println("==================================================");
        System.out.println("       ATM SYSTEM INITIALIZED SUCCESSFULLY        ");
        System.out.println("==================================================");
        System.out.println("Test Card 1: " + primarySampleAccount.getAccountNumber() + " | PIN: 33556");
        System.out.println("Test Card 2: " + secondarySampleAccount.getAccountNumber() + " | PIN: 11223");

        boolean isTerminalPowerOn = true;

        while (isTerminalPowerOn) {
            if (!automatedTellerMachine.isSessionAuthenticated()) {
                System.out.println("\n--------------------------------------------------");
                System.out.println("       ATM STANDBY: PLEASE INSERT CARD            ");
                System.out.println("--------------------------------------------------");
                System.out.println("1. Insert Card & Enter PIN");
                System.out.println("2. Shut Down ATM Terminal");
                System.out.print("Select action (1-2): ");

                int standbyMenuChoice = userInputScanner.nextInt();
                userInputScanner.nextLine();

                switch (standbyMenuChoice) {
                    case 1:
                        System.out.print("Insert Card (Enter Account Number): ");
                        String inputAccountNumber = userInputScanner.nextLine();

                        System.out.print("Enter Card PIN: ");
                        int inputSecurityPin = userInputScanner.nextInt();
                        userInputScanner.nextLine();

                        boolean isLoginSuccessful = automatedTellerMachine.insertCardAndAuthenticate(
                            inputAccountNumber, 
                            inputSecurityPin
                        );

                        if (isLoginSuccessful) {
                            System.out.println("\nAuthentication Successful!");
                            System.out.println("Welcome, " + automatedTellerMachine.getActiveAccountHolderName());
                        } else {
                            System.out.println("\nAuthentication Failed: Invalid Account Number or PIN.");
                        }
                        break;

                    case 2:
                        System.out.println("Powering off ATM terminal. Goodbye!");
                        isTerminalPowerOn = false;
                        break;

                    default:
                        System.out.println("Invalid selection. Please choose 1 or 2.");
                }
            } else {
                System.out.println("\n--------------------------------------------------");
                System.out.println(" ATM SESSION - ACCOUNT: " + automatedTellerMachine.getActiveAccountNumber());
                System.out.println("--------------------------------------------------");
                System.out.println("1. Inquire Balance");
                System.out.println("2. Deposit Cash");
                System.out.println("3. Withdraw Cash");
                System.out.println("4. Transfer Funds");
                System.out.println("5. Eject Card / Finish Session");
                System.out.print("Choose transaction (1-5): ");

                int activeSessionMenuChoice = userInputScanner.nextInt();
                userInputScanner.nextLine();

                switch (activeSessionMenuChoice) {
                    case 1:
                        System.out.print("Enter PIN to confirm: ");
                        int balanceCheckPin = userInputScanner.nextInt();
                        userInputScanner.nextLine();

                        try {
                            double availableBalance = automatedTellerMachine.checkBalance(balanceCheckPin);
                            System.out.println("Current Balance: $" + availableBalance);
                        } catch (IllegalArgumentException caughtException) {
                            System.out.println("Error: " + caughtException.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Enter Cash Deposit Amount: ");
                        double cashDepositAmount = userInputScanner.nextDouble();
                        userInputScanner.nextLine();

                        try {
                            automatedTellerMachine.deposit(cashDepositAmount);
                            System.out.println("Cash deposit of $" + cashDepositAmount + " accepted successfully.");
                        } catch (IllegalArgumentException caughtException) {
                            System.out.println("Deposit Rejected: " + caughtException.getMessage());
                        }
                        break;

                    case 3:
                        System.out.print("Enter Cash Withdrawal Amount: ");
                        double cashWithdrawalAmount = userInputScanner.nextDouble();

                        System.out.print("Enter PIN: ");
                        int cashWithdrawalPin = userInputScanner.nextInt();
                        userInputScanner.nextLine();

                        try {
                            automatedTellerMachine.withdraw(cashWithdrawalAmount, cashWithdrawalPin);
                            System.out.println("Dispensing cash: $" + cashWithdrawalAmount);
                            System.out.println("Please take your cash.");
                        } catch (IllegalArgumentException caughtException) {
                            System.out.println("Withdrawal Declined: " + caughtException.getMessage());
                        }
                        break;

                    case 4:
                        System.out.print("Enter Destination Account Number: ");
                        String destinationAccountNumber = userInputScanner.nextLine();

                        System.out.print("Enter Amount to Transfer: ");
                        double fundsTransferAmount = userInputScanner.nextDouble();

                        System.out.print("Enter PIN: ");
                        int fundsTransferPin = userInputScanner.nextInt();
                        userInputScanner.nextLine();

                        try {
                            automatedTellerMachine.transfer(
                                destinationAccountNumber, 
                                fundsTransferAmount, 
                                fundsTransferPin
                            );
                            System.out.println("Transfer of $" + fundsTransferAmount + " to account " + destinationAccountNumber + " was successful.");
                        } catch (IllegalArgumentException caughtException) {
                            System.out.println("Transfer Declined: " + caughtException.getMessage());
                        }
                        break;

                    case 5:
                        automatedTellerMachine.ejectCard();
                        System.out.println("Card ejected. Please take your card. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid selection. Please choose an option between 1 and 5.");
                }
            }
        }

        userInputScanner.close();
    }
}
