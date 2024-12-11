import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddQuestionGUI {
    private JTextField titleField;
    private JTextField urlField;
    private JTextField notesField;
    private JComboBox<String> typeComboBox;
    private JComboBox<String> difficultyComboBox;
    private JCheckBox completedCheckBox;
    private JButton submitButton;
    private JButton cancelButton;
    private LeetCodeTrackerSystem system;

    public AddQuestionGUI(LeetCodeTrackerSystem system) {
        this.system = system;

        titleField = new JTextField(20);
        urlField = new JTextField(20);
        notesField = new JTextField(20);
        typeComboBox = new JComboBox<>(new String[]{"Array", "String", "Tree", "Graph"});
        difficultyComboBox = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        completedCheckBox = new JCheckBox("Completed");
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        initUI();
        addActionListeners();
    }

    private void initUI() {
        JFrame frame = new JFrame("Add Question");
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
        panel.add(notesField);
        panel.add(submitButton);
        panel.add(cancelButton);

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addActionListeners() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submit button clicked");
                System.out.println("notes: "+ notesField.getText());
                Question question = new Question(
                        titleField.getText(),
                        urlField.getText(),
                        (String) typeComboBox.getSelectedItem(),
                        (String) difficultyComboBox.getSelectedItem(),
                        completedCheckBox.isSelected(),
                        notesField.getText()
                );
                system.getQuestionManager().addQuestion(question);
                // print in console
                System.out.println("Question added: " + question);

                ((JFrame) SwingUtilities.getWindowAncestor(submitButton)).dispose();
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

