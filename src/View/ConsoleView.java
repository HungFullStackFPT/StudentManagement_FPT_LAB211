package View;

import java.util.Scanner;

public class ConsoleView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static String getInput() {
        return scanner.nextLine();
    }

    public static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return getIntInput();
        }
    }
}