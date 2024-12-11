public class Main {
    public static void main(String[] args) {
        LeetCodeTrackerSystem system = new LeetCodeTrackerSystem();

        system.start();

        new MainGUI(system);
    }
}