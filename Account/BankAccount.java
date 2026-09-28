public class BankAccount {
    private String name;
    private double balance;
    private int pin;

    public BankAccount(String accountName, double balance, int pin) {
        this.name = accountName;
        this.balance = balance;
        this.pin = pin;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean enterPin(int pin) {
        return this.pin == pin;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
    }

    public String getName() {
        return name;
    }

    public void changeMyName(String name) {
        this.name = name;
    }
}
