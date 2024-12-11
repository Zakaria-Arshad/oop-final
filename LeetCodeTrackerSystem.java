public class LeetCodeTrackerSystem {
    private QuestionManager questionManager;
    private FileManager fileManager;

    public LeetCodeTrackerSystem() {
        fileManager = new FileManager("questions.txt");
        questionManager = new QuestionManager(fileManager);
    }

    // get question manager
    public QuestionManager getQuestionManager() {
        return questionManager;
    }

    public void start() {
        // loads questions when app starts
        questionManager.loadQuestions();
        // debug 
    }

    public void stop() {
        // save changes when app stops
        questionManager.saveQuestions();
    }
}
