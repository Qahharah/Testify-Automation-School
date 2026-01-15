package Task;

public class Task15B extends Task15A {

    public void cookDinner() {
        System.out.println("Cooking dinner at home");
    }

    public void watchMovie() {
        System.out.println("Watching a movie to relax");
    }

    public static void main(String[] args) {

        Task15B dailyLife = new Task15B();

        // Parent class methods
        dailyLife.wakeUp();
        dailyLife.commuteToWork();
        dailyLife.buyGroceries();

        // Child class methods
        dailyLife.cookDinner();
        dailyLife.watchMovie();
    }
}
