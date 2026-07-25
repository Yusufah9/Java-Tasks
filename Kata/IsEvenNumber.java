import java.util.Scanner;

public class IsEvenNumber { 
    public static boolean isEven(int number) { 
        return number % 2 == 0;
    } 

    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        
        System.out.print("Enter your number: "); 
        int userInput = scanner.nextInt(); 
        
        if (isEven(userInput)) {
            System.out.println("The number " + userInput + " is an Even Number and that is true"); 
        } else {
            System.out.println("The number " + userInput + " is an Odd Number and that is false"); 
        }
        
    } 
}
