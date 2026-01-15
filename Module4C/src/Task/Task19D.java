package Task;

public class Task19D {

    String name = "Delta";

    public void printName(String name) {
        System.out.println("Instance name: " + this.name);
        System.out.println("User entered name: " + name);
    }

    public static void main(String[] args) {
        Task19D obj = new Task19D();
        obj.printName("Yusuf");
    }
}
