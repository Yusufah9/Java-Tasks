import java.util.Scanner;

public class PrimeFactors {

    public static int sumPrimeFactors(int n) {
        int sum = 0;
        int temporary = n;

        if (temporary % 2 == 0) {
            sum += 2;
            while (temporary % 2 == 0) {
                temporary /= 2;
            }
        }

        for (int prime = 3; prime * prime <= temporary; prime += 2) {
            if (temporary % prime == 0) {
                sum += prime;
                while (temporary % prime == 0) {
                    temporary /= prime;
                }
            }
        }

        if (temporary > 1) {
            sum += temporary;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(" Sum of Prime Factor");
        System.out.println("(Enter 0 or a negative number to exit)");

        while (true) {
            System.out.print("\nEnter a number: ");
            int userInput = scanner.nextInt();

            if (userInput <= 0) {
                System.out.println("Sentinel value received. Exiting program...");
                break; 
            }

            int sum = sumPrimeFactors(userInput);
            System.out.println("The sum of the prime factors of " + userInput + " is: " + sum);
        }

    }
}

