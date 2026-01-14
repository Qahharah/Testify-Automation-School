package Task;

public class Task5 {
    public static void main(String[] args) {

        int number = 3;
        //int number = 5;
        //int number2 = 15;

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (number % 3 == 0) {
            System.out.println("Fizz");
        } else if (number % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
    }
}
