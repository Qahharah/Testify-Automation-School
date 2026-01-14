package Task;

public class Task3 {
    public static void main(String[] args) {

        int age = 25;

        // Method 1: Using + operator
        System.out.println("My age is " + age);

        // Method 2: Using concat()
        String message = "My age is ".concat(String.valueOf(age));
        System.out.println(message);
    }
}
