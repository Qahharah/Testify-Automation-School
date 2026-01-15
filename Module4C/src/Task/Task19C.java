package Task;

class ClassA {
    String name = "SaifurRahman";
}

public class Task19C extends ClassA {

    String name = "Adam";

    public static void main(String[] args) {
        Task19C obj = new Task19C();

        System.out.println("Parent name: " + obj.getParentName());
        System.out.println("Child name: " + obj.name);
    }

    public String getParentName() {
        return super.name;
    }
}
