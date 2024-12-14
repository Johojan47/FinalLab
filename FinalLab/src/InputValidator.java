import java.util.Scanner;

public class InputValidator {

    public static int validatePositiveInt(Scanner scanner, String message) {
        int value = -1;
        while (value < 0) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
        return value;
    }
}
