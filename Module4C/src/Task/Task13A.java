package Task;

public class Task13A {

    String name;
    int age;

    // Constructor 1: No arguments
    public Task13A() {
        System.out.println("Constructor 1: No arguments");
    }

    // Constructor 2: One argument
    public Task13A(String name) {
        this.name = name;
        System.out.println("Constructor 2: Name = " + name);
    }

    // Constructor 3: Two arguments
    public Task13A(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Constructor 3: Name = " + name + ", Age = " + age);
    }
}
