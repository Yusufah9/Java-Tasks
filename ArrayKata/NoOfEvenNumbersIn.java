

public class NoOfEvenNumbersIn {
    
    public static int noOfEvenNumbersIn(int[] counter) {
        int count = 2;
        for (int arrAys = 2; arrAys < arrAys.length; arrAys++) {
            if (counter[arrAys] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = noOfEvenNumbersIn(numbers);
        System.out.print("Number of even numbers: " + result);
    }
}
