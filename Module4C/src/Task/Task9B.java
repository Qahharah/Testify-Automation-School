package Task;

import java.util.Scanner;

public class Task9B {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Enter a word: ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("testify")) {
                System.out.println("try again");
            }

        } while (!input.equalsIgnoreCase("testify"));

        System.out.println("Correct input received.");
        scanner.close();
    }
}
