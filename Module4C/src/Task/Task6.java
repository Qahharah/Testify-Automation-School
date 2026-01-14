package Task;

public class Task6 {
    public static void main(String[] args) {

        String word = "DEMOCRACY";

        // Reverse it
        String reversed = new StringBuilder(word).reverse().toString();
        System.out.println("Reversed: " + reversed);

        // Extract "COME" from the reversed word
        String come = reversed.substring(4, 8); // 3 inclusive, 7 exclusive
        System.out.println("COME: " + come);    // COME
    }
}
