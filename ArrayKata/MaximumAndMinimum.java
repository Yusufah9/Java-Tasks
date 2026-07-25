import java.util.Scanner;

public class MaximumAndMinimum {

    public static int[] maximumAndMinimum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int count = 1; count < numbers.length; count++) {
            if (numbers[count] < min) {
                min = numbers[count];
            }
            if (numbers[count] > max) {
                max = numbers[count];
            }
        }

        return new int[] { min, max };
    }

    public static int maximumIn(int[] numbers) {
        if (numbers == null || numbers.length == 0);
        int max = numbers[0];
        for (int loopCount = 1; loopCount < numbers.length; loopCount++) {
            if (numbers[loopCount] > max) {
                max = numbers[loopCount];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] userInput = new int[6];

        System.out.println("Enter 6 integer numbers:");
        for (int counter = 0; counter < 6; counter++) {
            userInput[counter] = scanner.nextInt();
        }

        int[] result = maximumAndMinimum(userInput);
        System.out.println("Minimum: " + result[0] + ", Maximum: " + result[1]);
        
    }
}
