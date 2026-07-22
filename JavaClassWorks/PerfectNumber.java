

//Write a method for a sum of all the factors of a number including one and returns true or false  if it is a perfect number

import java.util.Scanner;

public class PerfectNumber {

    public static boolean isPerfectNumber(int n) {
        if (n <= 1) {
            return false;
        }

        int sum = 1;

        for (int count = 2; count * count <= n; count++) {
            if (n % count == 0) {
                sum += count;
                
                if (count != n / count) {
                    sum += n / count;
                }
            }
        }

        return sum == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (isPerfectNumber(num)) {
            System.out.println(num + " is a perfect number.");
        } else {
            System.out.println(num + " is not a perfect number.");
        }
    }
}

