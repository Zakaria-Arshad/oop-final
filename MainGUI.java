import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private JButton browseButton;
    private JButton addQuestionButton;
    private JLabel titleLabel;

    private LeetCodeTrackerSystem system;

    // Constructor
    public MainGUI(LeetCodeTrackerSystem system) {
        this.system = system;
    
        // Initialize components
        titleLabel = new JLabel("LeetCode Tracker");
        browseButton = new JButton("Browse Questions");
        addQuestionButton = new JButton("Add Question");
    
        // Set up the GUI
        initUI();
    
        // Add action listeners
        addActionListeners();
    }

    private void initUI() {
        JFrame frame = new JFrame("Main GUI");
        JPanel panel = new JPanel();

        panel.add(titleLabel);
        panel.add(browseButton);
        panel.add(addQuestionButton);

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void addActionListeners() {
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BrowseGUI(system);
            }
        });

        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddQuestionGUI(system);
            }
        });
    }
}
