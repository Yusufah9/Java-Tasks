import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindrome(String text) {
        String cleanText = text.toLowerCase();
        
        String reversedText = new StringBuilder(cleanText).reverse().toString();
        
        return cleanText.equals(reversedText);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String userInput = scanner.nextLine();

        boolean result = isPalindrome(userInput);

        System.out.println("Is it a palindrome? " + result);

    }
}

