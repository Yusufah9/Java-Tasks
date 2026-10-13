
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NubanTest {
    private Nuban nubanValidator;

    @BeforeEach
    public void startWith(){
        nubanValidator = new Nuban();
    }

    @Test
    public void test_GuarantyTrust_AccountNumberGenerated_withValidLength(){
        String generatedAccountNumber = nubanValidator.createAccountNumber(BankCodes.GUARANTYTRUSTBANK);
        assertEquals(13, generatedAccountNumber.length());
    }

    @Test
    public void test_ZenithBank_AccountNumberGenerated_withValidLength(){
        String generatedAccountNumber = nubanValidator.createAccountNumber(BankCodes.ZENITHBANK);
        assertEquals(13, generatedAccountNumber.length());
        assertTrue(nubanValidator.isValid(generatedAccountNumber));
    }

    @Test
    public void test_AccountNumber_Is_AValid_AccountNumber(){
        assertTrue(nubanValidator.isValid("0110000014579"));
        assertTrue(nubanValidator.isValid("0110000000220"));
        assertFalse(nubanValidator.isValid("0110000014578"));
        assertFalse(nubanValidator.isValid("9990000014579"));
        assertFalse(nubanValidator.isValid(null));
    }
}

// javac -cp "test/junit-platform-console-standalone-1.11.0.jar:Account" Account/*.java test/*.java

// java -jar test/junit-platform-console-standalone-1.11.0.jar execute -cp "Account:test:." --scan-class-path



