import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteGUI {
    private JLabel confirmationLabel;
    private JButton confirmButton;
    private JButton cancelButton;

    private LeetCodeTrackerSystem system;
    private Question currentQuestion;

    public DeleteGUI(LeetCodeTrackerSystem system, Question currentQuestion) {
        this.system = system;
        this.currentQuestion = currentQuestion;

        confirmationLabel = new JLabel("Are you sure you want to delete: " + currentQuestion.getTitle() + "?");
        confirmButton = new JButton("Confirm");
        cancelButton = new JButton("Cancel");

        initUI();
        addActionListeners();
    }

    private void initUI() {
        JFrame frame = new JFrame("Delete Question");
        JPanel panel = new JPanel();

        panel.add(confirmationLabel);
        panel.add(confirmButton);
        panel.add(cancelButton);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addActionListeners() {
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system.getQuestionManager().deleteQuestion(currentQuestion);
                JOptionPane.showMessageDialog(null, "Question deleted!");
                ((JFrame) SwingUtilities.getWindowAncestor(confirmButton)).dispose();
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
