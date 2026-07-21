import java.util.Scanner;

public class DecimalDivision {

    public static double divideTwoNumbers(int num1, int num2) {
        return (double) num1 / num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number (numerator): ");
        int firstInput = scanner.nextInt();

        System.out.print("Enter the second number (denominator): ");
        int secondInput = scanner.nextInt();

        double result = divideTwoNumbers(firstInput, secondInput);

        System.out.println("The division result is: " + result);
    }
}

