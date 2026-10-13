


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        Bank gtBankSystem = new Bank(BankCodes.GUARANTYTRUSTBANK);

        String greetings = "Welcome to Guaranty Trust Self-Service Terminal";
        
        String menuOptionsText = """
                1. Create An Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Check Balance
                0. Exit
                """;
        
        System.out.println(greetings);
        System.out.println(menuOptionsText);
        System.out.print("Enter your option: ");
        String menuSelection = scannerInput.nextLine();

        while (!menuSelection.equals("0")) {
            switch (menuSelection){
               
                case "1":
                    System.out.print("Enter your preferably account name: ");
                    String custFullName = scannerInput.nextLine();
                    System.out.print("Enter your preferably transaction pin: ");
                    String custPin = scannerInput.nextLine();
                    try {
                        String newAccNumber = gtBankSystem.createAccount(custFullName, custPin);
                        System.out.printf("your account Number is : %s\naccount created successfully >>>>>>>>>>>>>>%n", newAccNumber);
                    } catch (IllegalArgumentException err) {
                        System.out.println("Error: " + err.getMessage());
                    }
                    break;
                    
                case "2":
                    System.out.print("How much do you want to deposit: ");
                    String depositStr = scannerInput.nextLine();
                    System.out.print("Enter the account number: ");
                    String depositAcc = scannerInput.nextLine();
                    try {
                        validateNumericInput(depositStr);
                        int depositAmount = Integer.parseInt(depositStr);
                        gtBankSystem.deposit(depositAcc, depositAmount);
                        System.out.println("amount deposited successfully >>>>>>>>>>>>>>>>>>");
                    }catch (IllegalArgumentException err){
                        System.out.println("Error: " + err.getMessage());
                    }
                    break;
                    
                case "3":
                    System.out.print("How much do you want to withdraw: ");
                    String withdrawStr = scannerInput.nextLine();
                    System.out.print("Enter the account number: ");
                    String withdrawAcc = scannerInput.nextLine();
                    System.out.print("Enter your pin: ");
                    String withdrawPin = scannerInput.nextLine();
                    try {
                        validateNumericInput(withdrawStr);
                        int withdrawAmount = Integer.parseInt(withdrawStr);
                        gtBankSystem.withdraw(withdrawAcc, withdrawAmount, withdrawPin);
                        System.out.println("amount withdrew successfully >>>>>>>>>>>>>>>>>>");
                    }catch (IllegalArgumentException err){
                        System.out.println("Error: " + err.getMessage());
                    }
                    break;
                    
                case "4":
                    System.out.print("How much do you want to transfer: ");
                    String transferStr = scannerInput.nextLine();
                    System.out.print("Enter the sender's account number: ");
                    String senderAccNum = scannerInput.nextLine();
                    System.out.print("Enter the receiver's account number: ");
                    String receiverAccNum = scannerInput.nextLine();
                    System.out.println("Please Enter your pin to confirm your identity: ");
                    String senderPinCode = scannerInput.nextLine();
                    try {
                        validateNumericInput(transferStr);
                        int transferAmount = Integer.parseInt(transferStr);
                        gtBankSystem.transfer(transferAmount, senderAccNum, receiverAccNum, senderPinCode);
                        System.out.println("amount transferred successfully >>>>>>>>>>>>>>>>>>");
                    }catch (IllegalArgumentException err){
                        System.out.println("Error: " + err.getMessage());
                    }
                    break;
                    
                case "5":
                    System.out.print("Enter the account number: ");
                    String balanceAcc = scannerInput.nextLine();
                    System.out.println("Please Enter your pin to confirm your identity: ");
                    String balancePin = scannerInput.nextLine();
                    try {
                        System.out.println("Your Balance is : " + gtBankSystem.checkBalance(balanceAcc, balancePin));
                    }catch (IllegalArgumentException err){
                        System.out.println("Error: " + err.getMessage());
                    }
                    break;
                    
                    
                default:
                    System.out.println("---Invalid option -> Please enter between 1- 5--");
                    break;
            }
            System.out.println(menuOptionsText);
            System.out.print("Enter your option: ");
            menuSelection = scannerInput.nextLine();
        }
        System.out.println("Thank you for your using our app, we hope to see you again rate it!!!");
    }

    private static void validateNumericInput(String textValue){
        for(int posCounter = 0; posCounter < textValue.length(); posCounter++){
            if(!Character.isDigit(textValue.charAt(posCounter))) {
                throw new IllegalArgumentException("Please enter only numbers");
            }
        }
    }
}
