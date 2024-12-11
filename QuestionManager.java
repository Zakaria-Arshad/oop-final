import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    private List<Question> questions;
    private FileManager fileManager;

    public QuestionManager(FileManager fileManager) {
        this.fileManager = fileManager;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
        // DEBUG PRINT, CAN DELETE IT 
        System.out.println(questions);
        saveQuestions();
    }


    public void editQuestion(Question oldQuestion, Question updatedQuestion) {
        int index = this.questions.indexOf(oldQuestion);
        if (index != -1) {
            this.questions.set(index, updatedQuestion);
        }
        saveQuestions();
    }

    public void deleteQuestion(Question question) {
        this.questions.remove(question);
        saveQuestions();
    }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(this.questions);
    }

    public List<Question> filterQuestionsByCompletion(boolean completed) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question q : this.questions) {
            if (q.isCompleted() == completed) {
                filteredQuestions.add(q);
            }
        }
        return filteredQuestions;
    }
    
    public List<Question> filterQuestionsByType(String type) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question q : questions) {
            if (q.getDataStructureType().equalsIgnoreCase(type)) {
                filteredQuestions.add(q);
            }
        }
        return filteredQuestions;
    }
    

    public void loadQuestions() {
        this.questions = fileManager.loadQuestions();
        System.out.println(this.questions + "HI");
    }

    public void saveQuestions() {
        fileManager.saveQuestions(this.questions);
    }
}

