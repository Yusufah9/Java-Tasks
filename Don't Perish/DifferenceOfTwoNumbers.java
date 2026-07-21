import java.util.Scanner;

public class DifferenceOfTwoNumbers {

    public static int subtractNumbers(int num1, int num2) {
        return num1 - num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstInput = scanner.nextInt();

        System.out.print("Enter the second number (to be subtracted): ");
        int secondInput = scanner.nextInt();

        int result = subtractNumbers(firstInput, secondInput);

        System.out.println("The difference is: " + result);

    }
}

