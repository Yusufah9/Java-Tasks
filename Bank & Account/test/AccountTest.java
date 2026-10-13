

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account customerAccountObject;
    private final String validSecretPin = "5544";
    private final String wrongSecretPin = "9988";

    @BeforeEach
    public void prepareAccountBeforeEachTest() {
        customerAccountObject = new Account(validSecretPin);
    }

    @Test
    public void testThatIDepositFiveThousandAndTheAccountBalanceReflectsCorrectly(){
        
        assertEquals(0.0, customerAccountObject.getBalance(validSecretPin));
        customerAccountObject.deposit(5_000);
        assertEquals(5000.0, customerAccountObject.getBalance(validSecretPin));
    }

    @Test
    public void testThatIDepositNegativeFiveThousandAndTheBalanceRemainsUnchanged(){
        
        assertEquals(0.0, customerAccountObject.getBalance(validSecretPin));
        try {
            customerAccountObject.deposit(-5_000);
        }
        catch (IllegalArgumentException exceptionRef){
       
        }
        
        assertEquals(0.0, customerAccountObject.getBalance(validSecretPin));
    }

    @Test
    public void testThatIWithdrawTwoThousandFromFiveThousandAndBalanceIsThreeThousand() {
      
        assertEquals(0.0, customerAccountObject.getBalance(validSecretPin));
        customerAccountObject.deposit(5_000);
        assertEquals(5000.0, customerAccountObject.getBalance(validSecretPin));
        customerAccountObject.withdraw(2000, validSecretPin);
        
        assertEquals(3000.0, customerAccountObject.getBalance(validSecretPin));
    }

    @Test
    public void testThatICantWithdrawNegativeAmountFromAccount(){
        assertEquals(0.0, customerAccountObject.getBalance(validSecretPin));
        customerAccountObject.deposit(5_000);
        try {
            customerAccountObject.withdraw(-2000, validSecretPin);
        }catch (IllegalArgumentException exceptionRef){
          
        }
        assertEquals(5000.0, customerAccountObject.getBalance(validSecretPin));
    }

    @Test
    public void testThatICantWithdrawMoneyUsingAnIncorrectPinNumber(){
        assertEquals(0.0, customerAccountObject.getBalance(validSecretPin));
        customerAccountObject.deposit(5_000);
        assertThrows(IllegalArgumentException.class, () -> customerAccountObject.withdraw(2000, wrongSecretPin));
        assertEquals(5000.0, customerAccountObject.getBalance(validSecretPin));
    }

    @Test
    public void testToCheckAccountBalanceWithAnIncorrectPinThrowsError(){
        assertThrows(IllegalArgumentException.class, () -> customerAccountObject.getBalance(wrongSecretPin));
    }
}

// javac -cp "test/junit-platform-console-standalone-1.11.0.jar:Account" Account/*.java test/*.java

// java -jar test/junit-platform-console-standalone-1.11.0.jar execute -cp "Account:test:." --scan-class-path

