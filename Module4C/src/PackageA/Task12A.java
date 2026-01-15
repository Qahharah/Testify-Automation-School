package PackageA;

import PackageB.Task12B;

public class Task12A {

    public static void main(String[] args) {
        Task12A a = new Task12A();
        a.accessA();

        // This must NOT work (private access)
        // Task12B b = new Task12B();
        // b.accessB();
    }

    public void accessA() {
        System.out.println("Public access from PackageA");
    }
}
