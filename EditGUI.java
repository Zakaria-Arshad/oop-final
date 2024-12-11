import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditGUI {
    private JTextField titleField;
    private JTextField urlField;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> difficultyComboBox;
    private JTextArea notesArea;
    private JCheckBox completedCheckBox;
    private JButton saveChangesButton;
    private JButton cancelButton;

    private LeetCodeTrackerSystem system;
    private Question currentQuestion;

    public EditGUI(LeetCodeTrackerSystem system, Question currentQuestion) {
        System.out.println("EditGUI constructor called");
        this.system = system;
        this.currentQuestion = currentQuestion;

        titleField = new JTextField(currentQuestion.getTitle(), 20);
        urlField = new JTextField(currentQuestion.getUrl(), 20);
        typeComboBox = new JComboBox<>(new String[]{"Array", "String", "Tree", "Graph"});
        difficultyComboBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        completedCheckBox = new JCheckBox("Completed", currentQuestion.isCompleted());
        notesArea = new JTextArea(currentQuestion.getNoteContent(), 5, 20);

        saveChangesButton = new JButton("Save Changes");
        cancelButton = new JButton("Cancel");
        
        // getting the data structure and difficulty for question
        typeComboBox.setSelectedItem(currentQuestion.getDataStructureType());
        difficultyComboBox.setSelectedItem(currentQuestion.getDifficulty());

        initUI();
        addActionListeners();
    }

    private void initUI() {
        JFrame frame = new JFrame("Edit Question");
        JPanel panel = new JPanel();

        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("URL:"));
        panel.add(urlField);
        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Difficulty:"));
        panel.add(difficultyComboBox);
        panel.add(completedCheckBox);
        panel.add(new JLabel("Notes:"));
        panel.add(notesArea);
        panel.add(saveChangesButton);
        panel.add(cancelButton);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addActionListeners() {
        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentQuestion.setTitle(titleField.getText());
                currentQuestion.setUrl(urlField.getText());
                currentQuestion.setDataStructureType((String) typeComboBox.getSelectedItem());                
                currentQuestion.setDifficulty((String) difficultyComboBox.getSelectedItem());
                currentQuestion.setCompleted(completedCheckBox.isSelected());
                currentQuestion.setNoteContent(notesArea.getText());

                // edit the question
                system.getQuestionManager().editQuestion(currentQuestion, currentQuestion);
                JOptionPane.showMessageDialog(null, "Changes saved!");
                ((JFrame) SwingUtilities.getWindowAncestor(saveChangesButton)).dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) SwingUtilities.getWindowAncestor(cancelButton)).dispose();
            }
        });
    }
}

