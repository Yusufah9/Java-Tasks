
   public class LowestCommonMultiples {
    private int[] numbers;

    public LowestCommonMultiples(int[] numbers) {
        this.numbers = numbers;
    }

    public int calculateLcm() {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        
        int lcm = numbers[0];
        for (int count = 1; count < numbers.length; count++) {
            lcm = findPairLcm(lcm, numbers[count]);
        }
        return lcm;
    }


   // javac -cp "junit-platform-console-standalone-1.11.0.jar:." LowestCommonMultiples.java TestLowestCommonMultiples.java

// java -jar junit-platform-console-standalone-1.11.0.jar --class-path . --select-class TestLoweestCommonMultiples



