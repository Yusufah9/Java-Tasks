import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void testThatAnewBankIsCreated() {
        bank = new Bank("Guaranty Trust Bank");
    }

    @Test
    public void testThatBankCanCreateAnAccount() {
        BankAccount createdAccount = bank.createAccount("Yusuf Umaru", 5000.0, 33556);

        assertNotNull(createdAccount);
        int expectedRegisteredAccountsCount = 1;
        int actualRegisteredAccountsCount = bank.getNumberOfRegisteredAccounts();
        assertEquals(expectedRegisteredAccountsCount, actualRegisteredAccountsCount);

        double expectedBalance = 5000.0;
        double actualBalance = createdAccount.getBalance(33556);
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testThatBankCanFindAnAccountByAccountNumber() {
        BankAccount createdAccount = bank.createAccount("Yusuf Umaru", 8000.0, 33556);
        String generatedAccountNumber = createdAccount.getAccountNumber();

        BankAccount retrievedAccount = bank.findAccount(generatedAccountNumber);

        assertNotNull(retrievedAccount);
        String expectedAccountHolderName = "Yusuf Umaru";
        String actualAccountHolderName = retrievedAccount.getAccountName();
        assertEquals(expectedAccountHolderName, actualAccountHolderName);
    }

    @Test
    public void testThatSearchingNonExistentAccountThrowsException() {
        bank.createAccount("Yusuf Umaru", 5000.0, 33556);

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                bank.findAccount("INVALID_ACCOUNT_NUMBER");
            }
        });
    }

    @Test
    public void testThatMoneyCanBeDepositedIntoAccountThroughBank() {
        BankAccount createdAccount = bank.createAccount("Yusuf Umaru", 2000.0, 33556);
        String accountNumber = createdAccount.getAccountNumber();

        bank.deposit(accountNumber, 3000.0);

        double expectedBalance = 5000.0;
        double actualBalance = bank.checkBalance(accountNumber, 33556);
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testThatMoneyCanBeWithdrawnFromAccountThroughBank() {
        BankAccount createdAccount = bank.createAccount("Yusuf Umaru", 7000.0, 33556);
        String accountNumber = createdAccount.getAccountNumber();

        bank.withdraw(accountNumber, 2000.0, 33556);

        double expectedBalance = 5000.0;
        double actualBalance = bank.checkBalance(accountNumber, 33556);
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testThatWithdrawalWithInvalidPinThrowsException() {
        BankAccount createdAccount = bank.createAccount("Yusuf Umaru", 7000.0, 33556);
        String accountNumber = createdAccount.getAccountNumber();

        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                bank.withdraw(accountNumber, 2000.0, 99999);
            }
        });
    }

    @Test
    public void testThatBankCanTransferMoneyBetweenTwoAccounts() {
        BankAccount senderAccount = bank.createAccount("Yusuf Umaru", 10000.0, 33556);
        BankAccount receiverAccount = bank.createAccount("Amina Bello", 4000.0, 11223);

        String senderAccountNumber = senderAccount.getAccountNumber();
        String receiverAccountNumber = receiverAccount.getAccountNumber();

        bank.transfer(senderAccountNumber, receiverAccountNumber, 3000.0, 33556);

        double expectedSenderBalance = 7000.0;
        double actualSenderBalance = bank.checkBalance(senderAccountNumber, 33556);
        assertEquals(expectedSenderBalance, actualSenderBalance);

        double expectedReceiverBalance = 7000.0;
        double actualReceiverBalance = bank.checkBalance(receiverAccountNumber, 11223);
        assertEquals(expectedReceiverBalance, actualReceiverBalance);
    }
}
