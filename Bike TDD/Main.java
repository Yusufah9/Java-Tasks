
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bike bike = new Bike();

        System.out.println("=== AUTOMATIC BIKE SIMULATOR ===");

        int choice = -1;

        while (choice != 5) {
            System.out.println("\n--------------------------------");
            
            if (bike.isBikeEngineOn()) {
                System.out.println("Engine Status : ON");
            } else {
                System.out.println("Engine Status : OFF");
            }

            System.out.println("Current Speed : " + bike.getSpeed() + " mph");
            System.out.println("Current Gear  : " + bike.getGear());
            System.out.println("--------------------------------");
            System.out.println("1. Turn Engine ON");
            System.out.println("2. Turn Engine OFF");
            System.out.println("3. Accelerate");
            System.out.println("4. Decelerate");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            if (choice == 1) {
                bike.turnOn();
                System.out.println("Engine is turned ON.");
            } else if (choice == 2) {
                bike.turnOff();
                System.out.println("Engine is turned OFF.");
            } else if (choice == 3) {
                if (bike.isBikeEngineOn()) {
                    bike.accelerate();
                    System.out.println("Accelerated!");
                } else {
                    System.out.println("Cannot accelerate while the engine is OFF!");
                }
            } else if (choice == 4) {
                if (bike.isBikeEngineOn()) {
                    bike.decelerate();
                    System.out.println("Decelerated!");
                } else {
                    System.out.println("Cannot decelerate while the engine is OFF!");
                }
            } else if (choice == 5) {
                System.out.println("Exiting simulator...");
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
