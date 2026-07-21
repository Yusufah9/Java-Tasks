import java.util.Scanner;

public class Remainder {

    public static int getRemainder(int num1, int num2) {
        return num1 % num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number (numerator): ");
        int firstInput = scanner.nextInt();

        System.out.print("Enter the second number (denominator): ");
        int secondInput = scanner.nextInt();

        int result = getRemainder(firstInput, secondInput);

        System.out.println("The remainder is: " + result);
    }
}

