import java.util.Scanner;

public class DecimalNumber {

  
    public static double halfTheNumber(int n) {
        return n / 2.0; 
    }

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
       
        int userInput = scanner.nextInt();

     
        double result = halfTheNumber(userInput);

       
        System.out.println("Half of the number is: " + result);

    }
}


  // Method that takes an integer and returns half of it as a double (decimal)
  // Correctly initialize the Scanner object
 // Read the integer from the user
   // Call the method to calculate half
 // Display the decimal result
