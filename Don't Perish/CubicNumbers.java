import java.util.Scanner;

public class CubicNumbers {
    
    public static int cube(int number) {
        return number * number * number;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int userNumber = input.nextInt();
        
        int result = cube(userNumber);
        System.out.println("The cube of " + userNumber + " is: " + result);
        
    }
}

