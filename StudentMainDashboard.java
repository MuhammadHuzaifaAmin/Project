import java.awt.*;
import java.awt.event.*;

public class StudentMainDashboard extends Frame implements ActionListener {
    Button btn1, btn2, btn3, btn4;
    Panel contentPanel;
    CardLayout cardLayout; // Store reference to control cards

    public StudentMainDashboard() {
        // Set layout FIRST before adding components
        this.setLayout(new BorderLayout());
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setSize(500, 500);
        this.setBackground(Color.BLUE);
        this.setTitle("Student Main Dashboard");

        Font font = new Font("Sansarif", Font.BOLD, 20);

        // Sidebar panel for buttons (use FlowLayout or GridLayout)
        Panel sidebar = new Panel(new FlowLayout());
        sidebar.setBackground(Color.DARK_GRAY);

        btn1 = new Button("Profile");
        btn1.setFont(font);
        btn1.setBackground(Color.CYAN);
        btn1.addActionListener(this);
        sidebar.add(btn1);

        btn2 = new Button("Request Room");
        btn2.setFont(font);
        btn2.setBackground(Color.CYAN);
        btn2.addActionListener(this);
        sidebar.add(btn2);

        btn3 = new Button("Mess Menu");
        btn3.setFont(font);
        btn3.setBackground(Color.CYAN);
        btn3.addActionListener(this);
        sidebar.add(btn3);

        btn4 = new Button("Fee Details");
        btn4.setFont(font);
        btn4.setBackground(Color.CYAN);
        btn4.addActionListener(this);
        sidebar.add(btn4);

        // Add sidebar to NORTH
        this.add(sidebar, BorderLayout.NORTH);

        // CardLayout for content switching
        cardLayout = new CardLayout();
        contentPanel = new Panel(cardLayout);

        // Add panels with string identifiers
        contentPanel.add(new Label("Student Profile Page", Label.CENTER), "PROFILE");
        contentPanel.add(new Label("Room Request Form Here", Label.CENTER), "REQUEST");
        contentPanel.add(new MessMenuPanel(false), "MESS"); // Your separate class
        contentPanel.add(new Label("Fee Details Page", Label.CENTER), "FEE");

        // Add content panel to CENTER
        this.add(contentPanel, BorderLayout.CENTER);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Use stored cardLayout reference + correct panel
        if (e.getSource() == btn1) {
            cardLayout.show(contentPanel, "PROFILE");
        } else if (e.getSource() == btn2) {
            cardLayout.show(contentPanel, "REQUEST");
        } else if (e.getSource() == btn3) {
            cardLayout.show(contentPanel, "MESS");
        } else if (e.getSource() == btn4) {
            cardLayout.show(contentPanel, "FEE");
        }
    }

    public static void main(String[] args) {
        new StudentMainDashboard();
    }
}
