import java.util.Scanner;

public class DivisibilityByThree {

    public static boolean isDivisibleByThree(int n) {
        if (n % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int userInput = scanner.nextInt();

        boolean result = isDivisibleByThree(userInput);

        System.out.println("Is the number evenly divisible by 3? " + result);

   
    }
}

