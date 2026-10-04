
import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] commandLineArguments) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("     ACCOUNT ONBOARDING REGISTRATION      ");
        System.out.println("==========================================");
        System.out.print("Enter Your Full Name: ");
        String initialCustomerFullName = userInputScanner.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double startingDepositAmount = userInputScanner.nextDouble();

        System.out.print("Set 4 or 5-digit PIN: ");
        int initialSecurityPin = userInputScanner.nextInt();
        userInputScanner.nextLine();

        String generatedDefaultAccountNumber = "ACC-STANDALONE-101";
        BankAccount activeAccount = new BankAccount(
            generatedDefaultAccountNumber,
            initialCustomerFullName,
            startingDepositAmount,
            initialSecurityPin
        );

        System.out.println("\nAccount initialized successfully for " + activeAccount.getAccountName());
        System.out.println("Account Number assigned: " + activeAccount.getAccountNumber());

        boolean isApplicationRunning = true;

        while (isApplicationRunning) {
            System.out.println("\n==========================================");
            System.out.println("        BANK ACCOUNT MANAGEMENT           ");
            System.out.println("==========================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Make Deposit");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Update Account Holder Name");
            System.out.println("5. Change Security PIN");
            System.out.println("6. Display Account Information");
            System.out.println("7. Exit Application");
            System.out.print("Select an option (1-7): ");

            int userMenuChoice = userInputScanner.nextInt();
            userInputScanner.nextLine();

            switch (userMenuChoice) {
                case 1:
                    System.out.print("Enter PIN: ");
                    int balanceCheckPin = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        double currentBalance = activeAccount.getBalance(balanceCheckPin);
                        System.out.println("Available Balance: " + currentBalance);
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Error: " + caughtException.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = userInputScanner.nextDouble();
                    userInputScanner.nextLine();

                    try {
                        activeAccount.deposit(depositAmount);
                        System.out.println("Successfully deposited: " + depositAmount);
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Error: " + caughtException.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawalAmount = userInputScanner.nextDouble();

                    System.out.print("Enter PIN: ");
                    int withdrawalPin = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        activeAccount.withdraw(withdrawalAmount, withdrawalPin);
                        System.out.println("Successfully withdrawn: " + withdrawalAmount);
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Error: " + caughtException.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter new full name: ");
                    String updatedFullName = userInputScanner.nextLine();

                    System.out.print("Enter PIN for confirmation: ");
                    int nameUpdatePin = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        activeAccount.updateAccountHolderName(updatedFullName, nameUpdatePin);
                        System.out.println("Account name updated to: " + activeAccount.getAccountName());
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Error: " + caughtException.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter current PIN: ");
                    int currentPinInput = userInputScanner.nextInt();

                    System.out.print("Enter new PIN: ");
                    int newPinInput = userInputScanner.nextInt();
                    userInputScanner.nextLine();

                    try {
                        activeAccount.updateSecurityPin(currentPinInput, newPinInput);
                        System.out.println("Security PIN changed successfully.");
                    } catch (IllegalArgumentException caughtException) {
                        System.out.println("Error: " + caughtException.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("--- Account Information ---");
                    System.out.println("Account Number : " + activeAccount.getAccountNumber());
                    System.out.println("Account Holder : " + activeAccount.getAccountName());
                    break;

                case 7:
                    System.out.println("Session ended. Goodbye!");
                    isApplicationRunning = false;
                    break;

                default:
                    System.out.println("Invalid selection. Please choose an option between 1 and 7.");
            }
        }

        userInputScanner.close();
    }
}
