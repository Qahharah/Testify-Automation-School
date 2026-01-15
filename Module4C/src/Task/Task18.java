package Task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task18 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int age;

        while (true) {
            try {
                System.out.print("How old are you? Enter your age: ");
                age = input.nextInt();

                System.out.println("Nice. Your age is: " + age);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (e.g., 18, 25, 30).");
                input.nextLine();
            }
        }

        input.close();
    }
}
