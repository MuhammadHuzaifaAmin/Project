import java.awt.*;
import java.awt.event.*;

public class ManagerMainDashboard extends Frame implements ActionListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    Panel sidebar, contentPanel;
    Label l1;

    public ManagerMainDashboard() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setSize(500, 500);
        this.setBackground(Color.BLUE);
        this.setTitle("Manager Main Dashboard");
        this.setLayout(new BorderLayout());
        // side bar
        sidebar = new Panel();
        sidebar.setLayout(new GridLayout(1, 6, 10, 10));
        Font font = new Font("Sansarif", Font.ROMAN_BASELINE, 16);
        // Buttons and its design
        btn1 = new Button("Add Room");
        btn1.setFont(font);
        btn1.setBackground(Color.YELLOW);
        btn2 = new Button("View Requests");
        btn2.setFont(font);
        btn2.setBackground(Color.YELLOW);
        btn3 = new Button("Remove Students");
        btn3.setFont(font);
        btn3.setBackground(Color.YELLOW);
        btn4 = new Button("Display Students");
        btn4.setFont(font);
        btn4.setBackground(Color.YELLOW);
        btn5 = new Button("Add PAyments");
        btn5.setFont(font);
        btn5.setBackground(Color.YELLOW);
        btn6 = new Button("View Visitors");
        btn6.setFont(font);
        btn6.setBackground(Color.YELLOW);
        btn7 = new Button("Mess Menu");
        btn7.setFont(font);
        btn7.setBackground(Color.YELLOW);

        sidebar.add(btn1);
        sidebar.add(btn2);
        sidebar.add(btn3);
        sidebar.add(btn4);
        sidebar.add(btn5);
        sidebar.add(btn6);
        sidebar.add(btn7);

        // registerinf the components
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        // adding sidebar to the Frame
        this.add(sidebar, BorderLayout.NORTH);

        // content panel details
        contentPanel = new Panel();
        l1 = new Label();
        l1.setText("Welcome to the Hostel Management System of PIEAS ");
        Font font1 = new Font("SansSerif", Font.BOLD, 40);
        l1.setFont(font1);
        contentPanel.add(l1);
        this.add(contentPanel, BorderLayout.CENTER);

        // Window close handler
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {

        }
    }

}
