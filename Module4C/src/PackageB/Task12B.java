package PackageB;

public class Task12B {

    public static void main(String[] args) {
        Task12B b = new Task12B();
        b.accessB();
    }

    private void accessB() {
        System.out.println("Private access from PackageB");
    }
}
