import java.util.Scanner;

public class PizzaWahala {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        
        final int sapaSizeSlice = 4;
        final int sapaSizePrice = 2500;

        final int smallMoneySlice = 6;
        final int smallMoneyPrice = 2900;

        final int bigBoysSlice = 8;
        final int bigBoysPrice = 4000;

        final int odogwuSlice = 12;
        final int odogwuPrice = 5200;

        System.out.print("What is the number of your guests? ");
        int numberOfGuest = scanner.nextInt();

        System.out.println("\nSelect Pizza Type You Want:");
        System.out.println("1. Sapa size");
        System.out.println("2. Small Money");
        System.out.println("3. Big boys");
        System.out.println("4. Odogwu");
        System.out.print("Enter Your choice That You Want (1-4): ");
        int pizzaChoice = scanner.nextInt();

        int slicesPerBox = 0;
        int pricePerBox = 0;

        switch (pizzaChoice) {
            case 1:
                slicesPerBox = sapaSizeSlice;
                pricePerBox = sapaSizePrice;
                break;
            case 2:
                slicesPerBox = smallMoneySlice;
                pricePerBox = smallMoneyPrice;
                break;
            case 3:
                slicesPerBox = bigBoysSlice;
                pricePerBox = bigBoysPrice;
                break;
            case 4:
                slicesPerBox = odogwuSlice;
                pricePerBox = odogwuPrice;
                break;
            default:
                System.out.println("Please enter from 1- 4 as Yiur options.");
                return;
        }

        int boxesToBuy = numberOfGuest / slicesPerBox;
        int totalSlices = boxesToBuy * slicesPerBox;
        int leftoverSlices = totalSlices - numberOfGuest;
        int totalPrice = boxesToBuy * pricePerBox;

        System.out.println("\n    Order Summary:    ");
        System.out.println("Number of boxes of pizza to buy = " + boxesToBuy + " boxes");
        System.out.println("Number left over slices after serving = " + leftoverSlices + " slices");
        System.out.println("Price = " + totalPrice);
    }
}
