import java.util.Scanner;

public class SmallerOfTwoNumbers {

    public static int getSmaller(int num1, int num2) {
        if (num1 < num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int firstInput = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int secondInput = scanner.nextInt();

        int result = getSmaller(firstInput, secondInput);

        System.out.println("The smaller number is: " + result);

    }
}



