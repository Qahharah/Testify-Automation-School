package Task;

import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {

        // Create a 2D array with 4 rows and 3 columns
        String[][] fruits = new String[4][3];

        // Fill only the first column
        fruits[0][0] = "Lemon";
        fruits[1][0] = "Peach";
        fruits[2][0] = "Apple";
        fruits[3][0] = "Kiwi";

        // Print the 2D array
        System.out.println(Arrays.deepToString(fruits));
    }
}
