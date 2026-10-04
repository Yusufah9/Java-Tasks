import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtmTest {

    private Bank bank;
    private BankAccount primaryAccount;
    private BankAccount secondaryAccount;
    private Atm atm;

    @BeforeEach
    public void setUp() {
        bank = new Bank("Guaranty Trust Bank");
        primaryAccount = bank.createAccount("Yusuf Umaru", 15000.0, 33556);
        secondaryAccount = bank.createAccount("Amina Bello", 5000.0, 11223);
        atm = new Atm(bank);
    }

    @Test
    public void testAtmInitializationFailsWithNullBank() {
        assertThrows(IllegalArgumentException.class, () -> new Atm(null));
    }

    @Test
    public void testAtmInitiallyHasNoActiveSession() {
        assertFalse(atm.isSessionAuthenticated());
    }

    @Test
    public void testInsertCardAndAuthenticateSuccess() {
        boolean isAuthenticated = atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertTrue(isAuthenticated);
        assertTrue(atm.isSessionAuthenticated());
        assertEquals(primaryAccount.getAccountNumber(), atm.getActiveAccountNumber());
        assertEquals("Yusuf Umaru", atm.getActiveAccountHolderName());
    }

    @Test
    public void testInsertCardWithInvalidAccountNumberFails() {
        boolean isAuthenticated = atm.insertCardAndAuthenticate("INVALID_ACCOUNT", 33556);

        assertFalse(isAuthenticated);
        assertFalse(atm.isSessionAuthenticated());
    }

    @Test
    public void testInsertCardWithIncorrectPinFails() {
        boolean isAuthenticated = atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 99999);

        assertFalse(isAuthenticated);
        assertFalse(atm.isSessionAuthenticated());
    }

    @Test
    public void testEjectCardResetsSession() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);
        assertTrue(atm.isSessionAuthenticated());

        atm.ejectCard();

        assertFalse(atm.isSessionAuthenticated());
        assertThrows(IllegalStateException.class, () -> atm.getActiveAccountNumber());
        assertThrows(IllegalStateException.class, () -> atm.getActiveAccountHolderName());
    }

    @Test
    public void testCheckBalanceWithoutActiveSessionThrowsException() {
        assertThrows(IllegalStateException.class, () -> atm.checkBalance(33556));
    }

    @Test
    public void testCheckBalanceWithValidPin() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        double actualBalance = atm.checkBalance(33556);
        assertEquals(15000.0, actualBalance);
    }

    @Test
    public void testCheckBalanceWithInvalidPinThrowsException() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertThrows(IllegalArgumentException.class, () -> atm.checkBalance(99999));
    }

    @Test
    public void testDepositWithoutActiveSessionThrowsException() {
        assertThrows(IllegalStateException.class, () -> atm.deposit(5000.0));
    }

    @Test
    public void testDepositCashSuccess() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        atm.deposit(5000.0);

        assertEquals(20000.0, atm.checkBalance(33556));
    }

    @Test
    public void testDepositZeroOrNegativeAmountThrowsException() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertThrows(IllegalArgumentException.class, () -> atm.deposit(0.0));
        assertThrows(IllegalArgumentException.class, () -> atm.deposit(-500.0));
    }

    @Test
    public void testWithdrawWithoutActiveSessionThrowsException() {
        assertThrows(IllegalStateException.class, () -> atm.withdraw(2000.0, 33556));
    }

    @Test
    public void testWithdrawCashWithValidPinSuccess() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        atm.withdraw(5000.0, 33556);

        assertEquals(10000.0, atm.checkBalance(33556));
    }

    @Test
    public void testWithdrawWithInvalidPinThrowsException() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(2000.0, 99999));
    }

    @Test
    public void testWithdrawMoreThanBalanceThrowsException() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(50000.0, 33556));
    }

    @Test
    public void testWithdrawZeroOrNegativeAmountThrowsException() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(0.0, 33556));
        assertThrows(IllegalArgumentException.class, () -> atm.withdraw(-500.0, 33556));
    }

    @Test
    public void testTransferWithoutActiveSessionThrowsException() {
        assertThrows(IllegalStateException.class, () -> 
            atm.transfer(secondaryAccount.getAccountNumber(), 2000.0, 33556)
        );
    }

    @Test
    public void testTransferFundsSuccess() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        atm.transfer(secondaryAccount.getAccountNumber(), 3000.0, 33556);

        assertEquals(12000.0, atm.checkBalance(33556));
        assertEquals(8000.0, bank.checkBalance(secondaryAccount.getAccountNumber(), 11223));
    }

    @Test
    public void testTransferWithInvalidPinThrowsException() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertThrows(IllegalArgumentException.class, () -> 
            atm.transfer(secondaryAccount.getAccountNumber(), 3000.0, 99999)
        );
    }

    @Test
    public void testTransferToNonExistentAccountThrowsException() {
        atm.insertCardAndAuthenticate(primaryAccount.getAccountNumber(), 33556);

        assertThrows(IllegalArgumentException.class, () -> 
            atm.transfer("NON_EXISTENT_ACC", 1000.0, 33556)
        );
    }
}
