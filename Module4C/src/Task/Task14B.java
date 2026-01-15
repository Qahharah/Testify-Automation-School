package Task;

public class Task14B {

    public static void main(String[] args) {

        Task14A square = new Task14A();

        square.setLength(5);
        square.setBreadth(5);

        int length = square.getLength();
        int breadth = square.getBreadth();
        int area = length * breadth;

        System.out.println(
                "The area of a square of length " + length +
                        " and breadth " + breadth +
                        " is " + area
        );
    }
}
