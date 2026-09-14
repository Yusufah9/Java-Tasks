

public class CreditCard {

    private String cardNumber;
    private int[] cardDigits;

    public CreditCard(String cardNumber) {
        setCardNumber(cardNumber);
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        this.cardDigits = convertStringToArray(cardNumber);
    }

    public int[] getCardDigits() {
        return this.cardDigits;
    }

    public int getCardLength() {
        return this.cardNumber != null ? this.cardNumber.length() : 0;
    }

    public String getCardType() {
        if (cardNumber == null) {
            return "Invalid Card";
        }
        if (cardNumber.startsWith("4")) {
            return "Visa Cards";
        }
        if (cardNumber.startsWith("5")) {
            return "MasterCard";
        }
        if (cardNumber.startsWith("37")) {
            return "American Express Cards";
        }
        if (cardNumber.startsWith("6")) {
            return "Discover cards";
        }
        return "Invalid Card";
    }

    private int[] convertStringToArray(String number) {
        if (number == null || number.isEmpty()) {
            return new int[0];
        }

        int[] digits = new int[number.length()];
        for (int countIndex = 0; countIndex < number.length(); countIndex++) {
            char characterr = number.charAt(countIndex);
            if (Character.isDigit(characterr)) {
                digits[characterr] = Character.getNumericValue(characterr);
            } else {
                return new int[0];
            }
        }
        return digits;
    }

    public int calculateDoubleEvenPlaces() {
        if (cardDigits == null || cardDigits.length == 0) {
            return 0;
        }

        int totalSum = 0;
        for (int IndexCount = cardDigits.length - 2; IndexCount >= 0; IndexCount -= 2) {
            int doubled = cardDigits[IndexCount] * 2;
            if (doubled > 9) {
                totalSum += (doubled / 10) + (doubled % 10);
            } else {
                totalSum += doubled;
            }
        }
        return totalSum;
    }

    public int calculateOddPlaces() {
        if (cardDigits == null || cardDigits.length == 0) {
            return 0;
        }

        int totalSum = 0;
        for (int IndexCount = cardDigits.length - 1; IndexCount >= 0; IndexCount -= 2) {
            totalSum += cardDigits[IndexCount];
        }
        return totalSum;
    }

    public boolean isValid() {
        if (cardDigits == null || cardDigits.length < 13 || cardDigits.length > 16) {
            return false;
        }

        int sum = calculateDoubleEvenPlaces() + calculateOddPlaces();
        return sum % 10 == 0;
    }

    public String getValidityStatus() {
        return isValid() ? "Valid" : "Invalid";
    }
}
