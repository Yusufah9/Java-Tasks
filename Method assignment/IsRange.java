public class IsRange {
    
    public static boolean isRange(int n, int low, int high) {
        return n >= low && n <= high;
    }
    
    public static void main(String[] args) {
        System.out.println(isRange(5, 1, 10)); 
    }
}
