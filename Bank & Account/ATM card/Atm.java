
public class Atm {
    private Bank connectedBank;
    private BankAccount insertedCardAccount;
    private boolean isUserAuthenticated;

    public Atm(Bank connectedBank) {
        if (connectedBank == null) {
            throw new IllegalArgumentException("Bank connection cannot be null.");
        }
        this.connectedBank = connectedBank;
        this.insertedCardAccount = null;
        this.isUserAuthenticated = false;
    }

    public boolean insertCardAndAuthenticate(String targetAccountNumber, int securityPin) {
        try {
            BankAccount matchingAccount = this.connectedBank.findAccount(targetAccountNumber);
            
            if (matchingAccount.validateSecurityPin(securityPin)) {
                this.insertedCardAccount = matchingAccount;
                this.isUserAuthenticated = true;
                return true;
            }
        } catch (IllegalArgumentException caughtException) {
            return false;
        }

        return false;
    }

    public void ejectCard() {
        this.insertedCardAccount = null;
        this.isUserAuthenticated = false;
    }

    public double checkBalance(int securityPin) {
        validateActiveSession();
        return this.insertedCardAccount.getBalance(securityPin);
    }

    public void deposit(double depositAmount) {
        validateActiveSession();
        this.insertedCardAccount.deposit(depositAmount);
    }

    public void withdraw(double withdrawalAmount, int securityPin) {
        validateActiveSession();
        this.insertedCardAccount.withdraw(withdrawalAmount, securityPin);
    }

    public void transfer(String destinationAccountNumber, double transferAmount, int securityPin) {
        validateActiveSession();
        String currentAccountNumber = this.insertedCardAccount.getAccountNumber();
        this.connectedBank.transfer(currentAccountNumber, destinationAccountNumber, transferAmount, securityPin);
    }

    public boolean isSessionAuthenticated() {
        return this.isUserAuthenticated;
    }

    public String getActiveAccountNumber() {
        validateActiveSession();
        return this.insertedCardAccount.getAccountNumber();
    }

    public String getActiveAccountHolderName() {
        validateActiveSession();
        return this.insertedCardAccount.getAccountName();
    }

    private void validateActiveSession() {
        if (!this.isUserAuthenticated || this.insertedCardAccount == null) {
            throw new IllegalStateException("Operation failed: No active authenticated card session found.");
        }
    }
}
