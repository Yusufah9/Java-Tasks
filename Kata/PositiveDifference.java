import java.util.Scanner;

public class PositiveDifference {

    public static int positiveDifference(int number1, int number2) {
        return Math.abs(number1 - number2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int userInput1 = scanner.nextInt();

        System.out.println("Enter an integer: ");
        int userInput2 = scanner.nextInt();

        
        int differenceResult = positiveDifference(userInput1, userInput2);

        System.out.println("The difference between the two numbers is " + differenceResult);

    }
}
