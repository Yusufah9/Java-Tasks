import java.util.Scanner;

public class CelsiusToFahrenheit {

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double userInput = scanner.nextDouble();

        double result = convertCelsiusToFahrenheit(userInput);

        System.out.println("The temperature in Fahrenheit is: " + result);

    }
}

