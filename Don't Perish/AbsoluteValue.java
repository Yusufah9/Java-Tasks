import java.util.Scanner;

public class AbsoluteValueCalculator {

    public static int getAbsoluteValue(int n) {
        if (n < 0) {
            return n * -1;
        }
        return n; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int userInput = scanner.nextInt();

    
        int result = getAbsoluteValue(userInput);

        System.out.println("The absolute value is: " + result);

    
    }
}

