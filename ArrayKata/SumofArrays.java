import java.util.Scanner;

public class SumOfArrays {

    public static int sumOfArray(int[] numbers) {
        int sum = 0;
        
        for (int number : numbers) {
            sum += number;
        }
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Enter the number of arrays that you want: ");
        int arrAySize = scanner.nextInt();
        
        int[] userArray = new int[arrAySize];
        
        System.out.println("Enter " + arrAySize + " integers:");
        for (int count = 0; count < arrAySize; count++) {
            userArray[count] = scanner.nextInt();
        }
        
        int totalSum = sumOfArray(userArray);
        System.out.println("The sum of the elements is: " + totalSum);
        
    }
}
