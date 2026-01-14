package Task;

import java.util.Scanner;

public class Task10 {

    // Method to verify visitor
    public static void verifyVisitor(String input) {
        if (input.equalsIgnoreCase("Testify")) {
            System.out.println("Welcome to Testify Trainings!");
        } else {
            System.out.println("Access denied. You are not registered for Testify Trainings.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Type 'Testify' to confirm you are here for Testify Trainings: ");
        String visitorInput = scanner.nextLine();

        // Invoke the method
        verifyVisitor(visitorInput);

        scanner.close();
    }
}
