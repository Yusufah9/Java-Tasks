import java.util.Scanner;

public class SumOfTwoNumbers {

    public static int addNumbers(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstInput = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondInput = scanner.nextInt();

        int result = addNumbers(firstInput, secondInput);

        System.out.println("The sum of the two numbers is: " + result);

      
    }
}

