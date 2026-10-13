
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accountList = new ArrayList<>();
    private BankCodes bankCodeType;

    public Bank(BankCodes bankCodeType) {
        this.bankCodeType = bankCodeType;
    }

    public BankCodes getBankCodes() {
        return bankCodeType;
    }

    private String generateAccountNumber() {
        Nuban nubanGen = new Nuban();
        return nubanGen.createAccountNumber(bankCodeType);
    }

    public String createAccount(String fullName, String secretPin) {
        String newAccountNumber = generateAccountNumber();
        Account newAccountObj = new Account(secretPin);
        newAccountObj.setAccountNumber(newAccountNumber);
        accountList.add(newAccountObj);
        return newAccountNumber;
    }

    public int numberOfCustomers(){
        return accountList.size();
    }

    public void deposit(String targetAccountNumber, double cashAmount) {
        Account targetAccount = findAccount(targetAccountNumber);
        targetAccount.deposit(cashAmount);
    }

    public double checkBalance(String targetAccountNumber, String secretPin){
        Account targetAccount = findAccount(targetAccountNumber);
        validateFoundAccount(targetAccount);
        return targetAccount.getBalance(secretPin);
    }

    public void withdraw(String targetAccountNumber, double cashAmount, String secretPin){
        Account targetAccount = findAccount(targetAccountNumber);
        validateFoundAccount(targetAccount);
        checkTransactionLimit(targetAccountNumber, cashAmount, secretPin);
        targetAccount.withdraw(cashAmount, secretPin);
    }

    private Account findAccount(String targetAccountNumber) {
    validateAccountNumber(targetAccountNumber);
    for(int index = 0; index < accountList.size(); index++){
    
        Account currentAccount = accountList.get(index);
        if(currentAccount.getAccountNumber().equals(targetAccountNumber)){
            return currentAccount;
        }
    }
    return null;
}
    public void transfer(double cashAmount, String sourceAccountNumber, String destinationAccountNumber, String secretPin) {
        validateAccountNumber(sourceAccountNumber);
        validateAccountNumber(destinationAccountNumber);
        withdraw(sourceAccountNumber, cashAmount, secretPin);
        deposit(destinationAccountNumber, cashAmount);
    }

    private void checkTransactionLimit(String targetAccountNumber, double cashAmount, String secretPin){
        Account targetAccount = findAccount(targetAccountNumber);
        validateFoundAccount(targetAccount);
        if(targetAccount.getBalance(secretPin) < cashAmount) throw new IllegalArgumentException("Insufficient balance");
    }

    private void validateAccountNumber(String accountNumber){
        Nuban nubanGen = new Nuban();
        if(!nubanGen.isValid(accountNumber)) throw new IllegalArgumentException("Invalid Account number");
    }

    private void validateFoundAccount(Account account){
        if(account == null) throw new IllegalArgumentException("Account hasn't been created");
    }
}
