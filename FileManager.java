import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    // load the questions from the questions.txt file: title;url;type;difficulty;completed;notes
    public List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    questions.add(new Question(
                    parts[0], parts[1], parts[2], parts[3],
                    Boolean.parseBoolean(parts[4]), parts[5]
                ));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading questions file: " + e.getMessage());
        }
        return questions;
    }

    // write to file. this is called whenever an update is made to make sure the written file is always up to date
    public void saveQuestions(List<Question> questions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Question q : questions) {
                writer.write(String.format("%s;%s;%s;%s;%b;%s;\n",
                    q.getTitle(), q.getUrl(), q.getDataStructureType(),
                    q.getDifficulty(), q.isCompleted(), q.getNoteContent()));
            }
        } catch (IOException e) {
            System.err.println("Error writing questions file: " + e.getMessage());
        }
    }
}
