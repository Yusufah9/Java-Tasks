
import java.util.Random;

public class Nuban {
    private int[] numbers = {3,7,3,3,7,3,3,7,3,3,7,3};

    public String createAccountNumber(BankCodes bank){
        if(bank.getBankCode() == null) return null;
        
        Random generator = new Random();
        int randomNum = 100_000 + generator.nextInt(900_000);
        String serial = String.format("%09d", randomNum);
        
        String accountBase = bank.getBankCode() + serial;
        return accountBase + getCheckDigit(accountBase);
    }

    public boolean isValid(String accountNo){
        if(accountNo == null) return false;
        if(accountNo.length() != 13) return false;
        return matchesCheckDigit(accountNo);
    }

    private boolean matchesCheckDigit(String accountNo){
        int lastDigit = Character.getNumericValue(accountNo.charAt(12));
        int expectedDigit = getCheckDigit(accountNo);
        return lastDigit == expectedDigit;
    }

    private boolean checkBankCode(String accountNo){
        
        String prefix = "" + accountNo.charAt(0) + accountNo.charAt(1) + accountNo.charAt(2);
        
        for(BankCodes item : BankCodes.values()){
            if(item.getBankCode().equals(prefix)){
                return true;
            }
        }
        return false;
    }

    private int calculateSum(String accountNo){
        if(!checkBankCode(accountNo)) return -1;
        int total = 0;
        for(int counter = 0; counter < numbers.length; counter++){
            int currentDigit = Character.getNumericValue(accountNo.charAt(counter));
            total += (currentDigit * numbers[counter]);
        }
        return total;
    }

    private int getCheckDigit(String accountNo){
        int sumResult = calculateSum(accountNo);
        return (10 - (sumResult % 10)) % 10;
    }
}
