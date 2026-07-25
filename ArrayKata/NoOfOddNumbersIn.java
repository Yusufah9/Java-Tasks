public class NoOfOddNumbersIn {
    
    public static int noOfOddNumbersIn(int[] counter) {
        int count = 0;
        for (int arrAys = 0; arrAys < arrAys.length; arrAys++) {
            if (counter[arrAys] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = noOfOddNumbersIn(numbers);
        System.out.print("Number of odd numbers: " + result);
    }
}
