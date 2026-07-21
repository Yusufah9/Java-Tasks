import java.util.Scanner;

public class PrintingStars {

    public static void printStars(int count) {
  
        for (int counter = 0; counter < count; counter++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of stars to print: ");
        int userInput = scanner.nextInt();

        printStars(userInput);
    }
}

