import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount savingsAccount;

    @BeforeEach
    public void startWith() {
        savingsAccount = new BankAccount("Yusuf Umaru", 0.0, 33556);
    }

    @Test
    void testThatIHaveAccount_BalanceIsCheckedWithPin() {
        assertTrue(savingsAccount.enterPin(33556));
        assertEquals(0, savingsAccount.checkBalance());
    }

    @Test
    void testThatIHaveAnAccountAndIcanChangeMyName() {
        savingsAccount = new BankAccount("Umaru", 0.0, 33556);
        String name = "Yusuf Umaru";
        savingsAccount.changeMyName(name);
        assertEquals("Yusuf Umaru", savingsAccount.getName());
    }

    @Test
    void testThatThereIsAnAccountInWhichIcanMakeDeposit() {
        savingsAccount.deposit(6000);
        assertEquals(6000, savingsAccount.checkBalance());
    }

    @Test
    void testIHaveAccount_ICanWithdrawFromIt() {
        savingsAccount.deposit(6000);
        assertTrue(savingsAccount.enterPin(33556));
        savingsAccount.withdraw(1000);
        assertEquals(5000, savingsAccount.checkBalance());
    }

    @Test
    void testThatIHaveAnAccountAndICantWithdrawMoreThanTheBalanceIhave() {
        savingsAccount.deposit(6000);
        assertTrue(savingsAccount.enterPin(33556));
        savingsAccount.withdraw(7000);
        assertEquals(6000, savingsAccount.checkBalance());
    }
}

// javac -cp "junit-platform-console-standalone-1.11.0.jar:." BankAccount.java BankAccountTest.java

// java -jar junit-platform-console-standalone-1.11.0.jar --class-path . --select-class BankAccountTest
