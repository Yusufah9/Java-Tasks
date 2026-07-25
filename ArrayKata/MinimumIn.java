public class MinimumIn {
    public static int minimumIn(int[] arrAys) {
        if (arrAys == null || arrAys.length == 0)
           
        }
        
        int minimum = arrAys[0];
        
        for (int counter = 1; counter < arrAys.length; counter++) {
            if (arrAys[counter] < min) {
                min = arrAys[counter];
            }
        }
        
        return minimum;
    }

    public static void main(String[] args) {
        int[] numberOfArray = {1, 2, 3, 4, 5, 6};
        System.out.println("The minimum value is: " + minimumIn(numberOfArray));
    }
}
