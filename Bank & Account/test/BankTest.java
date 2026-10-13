


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank gtBankInstance;
    private final String clientPinCode = "5544";
    private final String clientFullName = "Yusuf Yaru Umaru";

    @BeforeEach
    public void initializeBankBeforeEveryTest(){
        gtBankInstance = new Bank(BankCodes.GUARANTYTRUSTBANK);
    }

    @Test
    public void testThatCreatingABankAccountGeneratesValidNumberAndIncrementsCustomerCount(){
        String generatedAccountNumber = gtBankInstance.createAccount(clientFullName, clientPinCode);
        assertEquals(13, generatedAccountNumber.length());
        assertEquals(1, gtBankInstance.numberOfCustomers());
    }

    @Test
    public void testThatIDepositFiveThousandIntoTheCustomerAccountSuccessfully(){
        String generatedAccountNumber = gtBankInstance.createAccount(clientFullName, clientPinCode);
        gtBankInstance.deposit(generatedAccountNumber, 5_000);
        assertEquals(5_000.0, gtBankInstance.checkBalance(generatedAccountNumber, clientPinCode));
    }

    @Test
    public void testThatIDepositFiveThousandAndWithdrawTwoThousandLeavesCorrectBalance(){
        String generatedAccountNumber = gtBankInstance.createAccount(clientFullName, clientPinCode);
        gtBankInstance.deposit(generatedAccountNumber, 5_000);
        
        gtBankInstance.withdraw(generatedAccountNumber, 2_000, clientPinCode);
        assertEquals(3_000.0, gtBankInstance.checkBalance(generatedAccountNumber, clientPinCode));
    }

    @Test
    public void testThatTransferringFundsBetweenSenderAndReceiverAccountsSucceeds(){
        String senderAccountNumber = gtBankInstance.createAccount(clientFullName, clientPinCode);
        String receiverAccountNumber = gtBankInstance.createAccount("Yusuf Ibrahim", "5611");
        gtBankInstance.deposit(senderAccountNumber, 5000);
        
        gtBankInstance.transfer(3000, senderAccountNumber, receiverAccountNumber, clientPinCode);
        assertEquals(2000.0, gtBankInstance.checkBalance(senderAccountNumber, clientPinCode));
        assertEquals(3000.0, gtBankInstance.checkBalance(receiverAccountNumber, "5611"));
        assertEquals(2, gtBankInstance.numberOfCustomers());
    }

    @Test
    public void testThatTransferringMoreThanAvailableBalanceThrowsIllegalArgumentException(){
        String senderAccountNumber = gtBankInstance.createAccount(clientFullName, clientPinCode);
        String receiverAccountNumber = gtBankInstance.createAccount("Yusuf Ibrahim", "5611");
        gtBankInstance.deposit(senderAccountNumber, 3000);
        
        assertThrows(IllegalArgumentException.class, () -> gtBankInstance.transfer(5000, senderAccountNumber, receiverAccountNumber, clientPinCode));
        assertEquals(3000.0, gtBankInstance.checkBalance(senderAccountNumber, clientPinCode));
        assertEquals(0.0, gtBankInstance.checkBalance(receiverAccountNumber, "5611"));
        assertEquals(2, gtBankInstance.numberOfCustomers());
    }

    @Test
    public void testThatTransferringToAnUnknownAccountNumberThrowsIllegalArgumentException(){
        String senderAccountNumber = gtBankInstance.createAccount(clientFullName, clientPinCode);
        gtBankInstance.deposit(senderAccountNumber, 5000);
        
        assertThrows(IllegalArgumentException.class, () -> gtBankInstance.transfer(3000, senderAccountNumber, "0581234567890", clientPinCode));
        assertEquals(5000.0, gtBankInstance.checkBalance(senderAccountNumber, clientPinCode));
        assertEquals(1, gtBankInstance.numberOfCustomers());
    }

    @Test
    public void testThatCheckingBalanceOnUnattachedValidNubanAccountThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> gtBankInstance.checkBalance("0580000014588", "6950"));
    }
}
