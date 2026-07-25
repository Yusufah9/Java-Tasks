public class OddNumbersIn {
    
    public static int oddNumbersIn(int[] counters) {
        int count = 0;
        for (int arrAys = 0; arrAys < arrAys.length; arrAys+=2) {
            if (counter[arrAys] % 2 != 0) {
                count+= 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = oddNumbersIn(numbers);
        System.out.print("Number of odd numbers: " + result);
    }
}
