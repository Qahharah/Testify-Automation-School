package Task;

public class Task16BChild extends Task16BParent {

    @Override
    public void workout(String exercise) {
        System.out.println("Child: Intense gym session with " + exercise);
    }

    @Override
    public void lift(int weight) {
        System.out.println("Child: Power lifting " + weight + "kg with perfect form");
    }

    public static void main(String[] args) {
        Task16BChild gymGuy = new Task16BChild();

        gymGuy.workout("Bench Press");
        gymGuy.lift(80);
    }
}
