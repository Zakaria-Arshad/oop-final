public class Main {
    public static void main(String[] args) {
        LeetCodeTrackerSystem system = new LeetCodeTrackerSystem();

        // call the start method
        system.start();

        new MainGUI(system);
    }
}