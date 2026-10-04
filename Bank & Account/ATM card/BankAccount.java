public class BankAccount {
    private String accountNumber;
    private String accountHolderFullName;
    private double currentAccountBalance;
    private int accountSecurityPin;

    public BankAccount(String accountHolderFullName, double initialDepositAmount, int accountSecurityPin) {
        this("", accountHolderFullName, initialDepositAmount, accountSecurityPin);
    }

    public BankAccount(String accountNumber, String accountHolderFullName, double initialDepositAmount, int accountSecurityPin) {
        if (initialDepositAmount < 0.0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.accountHolderFullName = accountHolderFullName;
        this.currentAccountBalance = initialDepositAmount;
        this.accountSecurityPin = accountSecurityPin;
    }

    public boolean validateSecurityPin(int inputSecurityPin) {
        return this.accountSecurityPin == inputSecurityPin;
    }

    public boolean enterPin(int pin) {
        return validateSecurityPin(pin);
    }

    public double checkBalance() {
        return this.currentAccountBalance;
    }

    public String getName() {
        return this.accountHolderFullName;
    }

    public void changeMyName(String name) {
        this.accountHolderFullName = name;
    }

    public void withdraw(double withdrawalAmount) {
        if (withdrawalAmount > 0.0 && withdrawalAmount <= this.currentAccountBalance) {
            this.currentAccountBalance = this.currentAccountBalance - withdrawalAmount;
        }
    }

    public void deposit(double depositAmount) {
        if (depositAmount <= 0.0) {
            throw new IllegalArgumentException("Deposit amount must be strictly greater than zero.");
        }
        this.currentAccountBalance = this.currentAccountBalance + depositAmount;
    }

    public void withdraw(double withdrawalAmount, int inputSecurityPin) {
        if (!validateSecurityPin(inputSecurityPin)) {
            throw new IllegalArgumentException("Incorrect PIN entered.");
        }
        if (withdrawalAmount <= 0.0) {
            throw new IllegalArgumentException("Withdrawal amount must be strictly greater than zero.");
        }
        if (withdrawalAmount > this.currentAccountBalance) {
            throw new IllegalArgumentException("Insufficient balance to complete withdrawal.");
        }
        this.currentAccountBalance = this.currentAccountBalance - withdrawalAmount;
    }

    public double getBalance(int inputSecurityPin) {
        if (!validateSecurityPin(inputSecurityPin)) {
            throw new IllegalArgumentException("Incorrect PIN entered.");
        }
        return this.currentAccountBalance;
    }

    public void updateAccountHolderName(String updatedFullName, int inputSecurityPin) {
        if (!validateSecurityPin(inputSecurityPin)) {
            throw new IllegalArgumentException("Incorrect PIN entered.");
        }
        if (updatedFullName == null || updatedFullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account name cannot be empty.");
        }
        this.accountHolderFullName = updatedFullName;
    }

    public void updateSecurityPin(int currentSecurityPin, int newSecurityPin) {
        if (!validateSecurityPin(currentSecurityPin)) {
            throw new IllegalArgumentException("Incorrect current PIN entered.");
        }
        this.accountSecurityPin = newSecurityPin;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountName() {
        return this.accountHolderFullName;
    }
}
