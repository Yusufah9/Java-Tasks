
public class Account {
    private double moneyBalance;
    private String userPin;
    private String accountNumber;

    public Account(String defaultPin){
        checkPinLength(defaultPin);
        this.userPin = defaultPin;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(String inputPin) {
        verifyPin(inputPin);
        return moneyBalance;
    }

    public void deposit(double cashAmount) {
        verifyAmount(cashAmount);
        moneyBalance += cashAmount;
    }

    public void withdraw(double cashAmount, String inputPin) {
        verifyPin(inputPin);
        verifyAmount(cashAmount);
        boolean hasEnough = cashAmount <= moneyBalance;
        if(hasEnough) moneyBalance -= cashAmount;
    }

    private void checkPinLength(String pin){
        if(pin.length() != 4) throw new IllegalArgumentException("Please put a 4 digits Pin");
    }

    private void verifyPin(String inputPin){
        if(!userPin.equals(inputPin)) throw new IllegalArgumentException("Invalid pin");
    }

    private void verifyAmount(double amount){
        if(amount < 0) throw new IllegalArgumentException("Invalid amount");
    }
}
