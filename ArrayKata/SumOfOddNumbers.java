public class SumOfOddNumbers {
    public static int sumOfOddNumbersIn(int[] numbers) {
        int sum = 0;
        
        if (numbers == null) {
            return 0;
        }
        
        for (int number : numbers) {
            if (number % 2 != 0) {
                sum += number; 
            }
        }
        
        return sum;
    }
}

public static void main(String[] args) {

  System.out.println("The sum of Odd numbers are: " + sum);

}

}

}


