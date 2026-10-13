

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static Bank gtBank = new Bank(BankCodes.GUARANTYTRUSTBANK);

    private static void displayMainMenu(){
    
        showText("""
            1. Create An Account
            2. Deposit
            3. Withdraw
            4. Transfer
            5. Check Balance
            6. Exit
            """);
            
        char menuOption = getConsoleInput("Enter your option: ").charAt(0);
        switch (menuOption){
            case '1':
                createNewAccount();
                break;
            case '2':
                makeDeposit();
                break;
            case '3':
                makeWithdrawal();
                break;
            case '4':
                makeTransfer();
                break;
            case '5':
                checkAccountBalance();
                break;
            case '6':
                exitApp();
                break;
            default:
                showText("Invalid choice");
                displayMainMenu();
                break;
        }
    }

    private static void exitApp(){
        showText("Thank you for using GTBank self service");
    }

    private static void checkAccountBalance() {
        try{
            String accNum = getConsoleInput("Enter your account number: ");
            String passcode = getConsoleInput("Please Enter your pin to confirm your identity: ");
            showText("Your balance is " + gtBank.checkBalance(accNum, passcode));
        }catch (IllegalArgumentException err){
            showText(err.getMessage());
        }
        finally {
            displayMainMenu();
        }
    }

    private static void makeTransfer() {
        try{
            String senderAcc = getConsoleInput("Enter the sender's account number: ");
            String receiverAcc = getConsoleInput("Enter the receiver's account number: ");
            double cashAmount = convertTextToInt(getConsoleInput("How much do you want to transfer: "));
            String senderPasscode = getConsoleInput("Please Enter your pin to confirm your identity: ");
            gtBank.transfer(cashAmount, senderAcc, receiverAcc, senderPasscode);
            showText("transferred successfully>>>>>>>>>>>>>>>>>>>>>");
        }catch (IllegalArgumentException err){
            showText(err.getMessage());
        }
        finally {
            displayMainMenu();
        }
    }

    private static void makeWithdrawal() {
        try{
            double cashAmount = convertTextToInt(getConsoleInput("How much do you want to withdraw: "));
            String accNum = getConsoleInput("Enter the account number: ");
            String passcode = getConsoleInput("Enter your pin");
            gtBank.withdraw(accNum, cashAmount, passcode);
            showText(cashAmount + " withdrew successfully >>>>>>>>>>>>>\nYour new balance is : " + gtBank.checkBalance(accNum, passcode));
        }catch (IllegalArgumentException err){
            showText(err.getMessage());
        }finally {
            displayMainMenu();
        }
    }

    private static void makeDeposit() {
        try{
            double cashAmount = convertTextToInt(getConsoleInput("How much do you want to deposit: "));
            String accNum = getConsoleInput("Enter the account number: ");
            gtBank.deposit(accNum, cashAmount);
            showText(cashAmount + " deposited successfully >>>>>>>>>>>>>");
        }catch (IllegalArgumentException err){
            showText(err.getMessage());
        }finally {
            displayMainMenu();
        }
    }

    private static void createNewAccount() {
        try{
            String custName = getConsoleInput("Enter your preferably account name: ");
            String passcode = getConsoleInput("Enter your pin");
            String accNum = gtBank.createAccount(custName, passcode);
            showText("Your account number is : " + accNum + "\nAccount created Successfully>>>>>>");
        }catch (IllegalArgumentException err){
            showText(err.getMessage());
        }
        finally{
            displayMainMenu();
        }
    }

    private static void showText(String textMsg){
        System.out.println(textMsg);
    }

    private static String getConsoleInput(String promptMsg){
        Scanner scanObj = new Scanner(System.in);
        showText(promptMsg);
        return scanObj.nextLine();
    }

    private static int convertTextToInt(String numericText){
        verifyDigitsOnly(numericText);
        return Integer.parseInt(numericText);
    }

    private static String verifyDigitsOnly(String numericText){
        for(int indexCount = 0; indexCount < numericText.length(); indexCount++){
            if(!Character.isDigit(numericText.charAt(indexCount))) {
                throw new IllegalArgumentException("Please enter only numbers");
            }
        }
        return numericText;
    }
}
