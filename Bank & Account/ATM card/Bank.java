import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList accountsList;
    private int generatedAccountNumberCounter;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accountsList = new ArrayList();
        this.generatedAccountNumberCounter = 1000;
    }

    public BankAccount createAccount(String customerFullName, double initialDepositAmount, int securityPin) {
        if (initialDepositAmount < 0.0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        
        this.generatedAccountNumberCounter = this.generatedAccountNumberCounter + 1;
        String generatedAccountNumber = "ACC" + this.generatedAccountNumberCounter;

        BankAccount newlyCreatedAccount = new BankAccount(
            generatedAccountNumber, 
            customerFullName, 
            initialDepositAmount, 
            securityPin
        );

        this.accountsList.add(newlyCreatedAccount);
        return newlyCreatedAccount;
    }

    public BankAccount findAccount(String targetAccountNumber) {
        int totalAccountsCount = this.accountsList.size();

        for (int accountCount = 0; accountCount < totalAccountsCount; accountCount++) {
            BankAccount currentAccount = (BankAccount) this.accountsList.get(accountCount);
            
            if (currentAccount.getAccountNumber().equalsIgnoreCase(targetAccountNumber)) {
                return currentAccount;
            }
        }

        throw new IllegalArgumentException("Account not found with account number: " + targetAccountNumber);
    }

    public void deposit(String targetAccountNumber, double depositAmount) {
        BankAccount targetAccount = findAccount(targetAccountNumber);
        targetAccount.deposit(depositAmount);
    }

    public void withdraw(String sourceAccountNumber, double withdrawalAmount, int securityPin) {
        BankAccount sourceAccount = findAccount(sourceAccountNumber);
        sourceAccount.withdraw(withdrawalAmount, securityPin);
    }

    public void transfer(String sourceAccountNumber, String destinationAccountNumber, double transferAmount, int securityPin) {
        BankAccount sourceAccount = findAccount(sourceAccountNumber);
        BankAccount destinationAccount = findAccount(destinationAccountNumber);

        sourceAccount.withdraw(transferAmount, securityPin);
        destinationAccount.deposit(transferAmount);
    }

    public double checkBalance(String targetAccountNumber, int securityPin) {
        BankAccount targetAccount = findAccount(targetAccountNumber);
        return targetAccount.getBalance(securityPin);
    }

    public int getNumberOfRegisteredAccounts() {
        return this.accountsList.size();
    }

    public String getBankName() {
        return this.bankName;
    }
}
