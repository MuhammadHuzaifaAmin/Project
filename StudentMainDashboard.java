import java.awt.*;
import java.awt.event.*;

public class StudentMainDashboard extends Frame implements ActionListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, logoutBtn;
    Panel contentPanel;
    CardLayout cardLayout;

    public StudentMainDashboard() {
        // Set layout FIRST before adding components
        this.setLayout(new BorderLayout());
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setSize(500, 500);
        this.setBackground(new Color(20, 120, 120));
        this.setTitle("Student Main Dashboard");

        Font font = new Font("Sansarif", Font.BOLD, 20);

        // Sidebar panel for buttons (use FlowLayout or GridLayout)
        Panel headerPanel = new Panel(new GridLayout(1, 7, 10, 10));
        headerPanel.setBackground(Color.DARK_GRAY);

        btn1 = new Button("Profile");
        btn1.setFont(font);
        btn1.setBackground(Color.CYAN);
        btn1.addActionListener(this);
        headerPanel.add(btn1);

        btn2 = new Button("Request Room");
        btn2.setFont(font);
        btn2.setBackground(Color.CYAN);
        btn2.addActionListener(this);
        headerPanel.add(btn2);

        btn3 = new Button("Mess Menu");
        btn3.setFont(font);
        btn3.setBackground(Color.CYAN);
        btn3.addActionListener(this);
        headerPanel.add(btn3);

        btn4 = new Button("Fee Details");
        btn4.setFont(font);
        btn4.setBackground(Color.CYAN);
        btn4.addActionListener(this);
        headerPanel.add(btn4);

        btn5 = new Button("Complaints");
        btn5.setFont(font);
        btn5.setBackground(Color.CYAN);
        btn5.addActionListener(this);
        headerPanel.add(btn5);

        btn6 = new Button("Add Visitor");
        btn6.setFont(font);
        btn6.setBackground(Color.CYAN);
        btn6.addActionListener(this);
        headerPanel.add(btn6);

        // logout button
        logoutBtn = new Button("Logout");
        logoutBtn.setFont(font);
        logoutBtn.setBackground(Color.RED);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.addActionListener(this);
        headerPanel.add(logoutBtn);

        // Add header panel to NORTH
        this.add(headerPanel, BorderLayout.NORTH);

        // CardLayout for content switching
        cardLayout = new CardLayout();
        contentPanel = new Panel(cardLayout);

        // Add panels with string identifiers
        contentPanel.add(new ProfilePanel(), "PROFILE");
        contentPanel.add(new RoomRequestPanel(), "REQUEST");
        contentPanel.add(new MessMenuPanel(false), "MESS");
        contentPanel.add(new FeeDetailsPanel(), "FEE");
        contentPanel.add(new ComplaintsPanel(), "COMPLAINTS");
        contentPanel.add(new AddVisitorPanel(), "AddVISITOR");

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
        } else if (e.getSource() == btn5) {
            cardLayout.show(contentPanel, "COMPLAINTS");
        } else if (e.getSource() == btn6) {
            cardLayout.show(contentPanel, "AddVISITOR");
            contentPanel.revalidate();
            contentPanel.repaint();
        } else if (e.getSource() == logoutBtn) {
            this.dispose();
            new first();
        }

    }

    public static void main(String[] args) {
        new StudentMainDashboard();
    }
}

// Student Profile Panel
class ProfilePanel extends Panel {
    Label name, name1, father, father1, id, id1, room, room1;

    public ProfilePanel() {
        this.setLayout(new BorderLayout());
        Font font = new Font("SansSerif", Font.BOLD, 20);
        Font font1 = new Font("SaneSarif", Font.BOLD, 25);
        Font font2 = new Font("SansSerif", Font.TYPE1_FONT, 20);
        Label profileLabel = new Label("Student Profile", Label.CENTER);
        profileLabel.setForeground(Color.BLUE);
        profileLabel.setBackground(Color.WHITE);
        profileLabel.setFont(font1);
        this.add(profileLabel, BorderLayout.NORTH);
        Panel leftPanel = new Panel(new GridLayout(5, 2, 10, 10));
        name = new Label("Name: ");
        name.setFont(font);
        // Change as per each student
        name1 = new Label("Ali Ahmad");
        name1.setFont(font2);
        name1.setForeground(Color.green);
        father = new Label("Father's Name: ");
        father.setFont(font);
        // Change as per each student
        father1 = new Label("John Doe");
        father1.setFont(font2);
        father1.setForeground(Color.ORANGE);
        id = new Label("ID: ");
        id.setFont(font);
        // Change as per each student
        id1 = new Label("S12345");
        id1.setFont(font2);
        id1.setForeground(Color.ORANGE);
        room = new Label("Room No: ");
        room.setFont(font);
        // Change as per each student
        room1 = new Label("101");
        room1.setFont(font2);
        room1.setForeground(Color.ORANGE);
        leftPanel.add(name);
        leftPanel.add(name1);
        leftPanel.add(father);
        leftPanel.add(father1);
        leftPanel.add(id);
        leftPanel.add(id1);
        leftPanel.add(room);
        leftPanel.add(room1);
        this.add(leftPanel, BorderLayout.CENTER);
    }
}

// Room Request Panel - request room and view room details
class RoomRequestPanel extends Panel implements ActionListener {
    Label name, father, id;
    TextField nameField, fatherField, idField;
    Button submitButton;

    public RoomRequestPanel() {
        this.setLayout(new BorderLayout());
        Label roomRequestLabel = new Label("You can send room requests here", Label.CENTER);
        Font font = new Font("SansSerif", Font.BOLD, 24);
        roomRequestLabel.setFont(font);
        this.add(roomRequestLabel, BorderLayout.NORTH);

        // Form panel for room request
        Panel formPanel = new Panel(new GridLayout(3, 2, 10, 10));
        name = new Label("Name:");
        name.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameField = new TextField();
        nameField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        father = new Label("Father's Name:");
        father.setFont(new Font("SansSerif", Font.BOLD, 18));
        fatherField = new TextField();
        fatherField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        id = new Label("ID:");
        id.setFont(new Font("SansSerif", Font.BOLD, 18));
        idField = new TextField();
        idField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        formPanel.add(name);
        formPanel.add(nameField);
        formPanel.add(father);
        formPanel.add(fatherField);
        formPanel.add(id);
        formPanel.add(idField);
        this.add(formPanel, BorderLayout.CENTER);
        submitButton = new Button("Submit Room Request");
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
        this.add(submitButton, BorderLayout.SOUTH);
        // Add action listener for submit button (not implemented here)
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            submitButton.setLabel("Request Submitted");
            // Handle room request submission (not implemented here)
        }
    }
}

// Visitor Panel - manage visitor entries and exits
class AddVisitorPanel extends Panel implements ActionListener {
    Label visitorLabel, studentname, visitorname, studentId, relation;
    TextField visitorTf, studentnameTf, studentIdTf, relationTf;
    Button submitButton;

    public AddVisitorPanel() {
        this.setLayout(new BorderLayout());
        Font font = new Font("SansSerif", Font.BOLD, 24);
        visitorLabel = new Label("Visitor Management", Label.CENTER);
        visitorLabel.setFont(font);
        this.add(visitorLabel, BorderLayout.NORTH);

        Panel formPanel = new Panel(new GridLayout(4, 2, 10, 10));
        studentname = new Label("Student Name:");
        Font font1 = new Font("SansSerif", Font.BOLD, 18);
        studentname.setFont(font1);
        studentnameTf = new TextField(25);
        studentnameTf.setFont(font1);
        visitorname = new Label("Visitor Name:");
        visitorname.setFont(font1);
        visitorTf = new TextField(25);
        visitorTf.setFont(font1);
        studentId = new Label("Student ID:");
        studentId.setFont(font1);
        studentIdTf = new TextField(25);
        studentIdTf.setFont(font1);
        relation = new Label("Relation:");
        relation.setFont(font1);
        relationTf = new TextField(25);
        relationTf.setFont(font1);

        formPanel.add(studentname);
        formPanel.add(studentnameTf);
        formPanel.add(visitorname);
        formPanel.add(visitorTf);
        formPanel.add(studentId);
        formPanel.add(studentIdTf);
        formPanel.add(relation);
        formPanel.add(relationTf);
        this.add(formPanel, BorderLayout.CENTER);

        submitButton = new Button("Submit Visitor Entry");
        submitButton.setBackground(Color.GREEN);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("SanSerif", Font.BOLD, 18));
        this.add(submitButton, BorderLayout.SOUTH);
        // registering the button
        submitButton.addActionListener(this);
        // Add action listener for submit button (not implemented here)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            submitButton.setLabel("Visitor Entry Submitted");
            // Handle visitor entry submission (not implemented here)
        }
    }
}

// Fee Details Panel - view fee details and make payments
class FeeDetailsPanel extends Panel {
    Panel headerPanel;
    Label feeDetailsLabel, pendingFeesLabel, amount1, paidFeesLabel, amount2;

    public FeeDetailsPanel() {
        this.setLayout(new BorderLayout());
        headerPanel = new Panel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        feeDetailsLabel = new Label("Fee Details Page", Label.CENTER);
        feeDetailsLabel.setForeground(Color.BLUE);
        Font font = new Font("SansSerif", Font.BOLD, 24);
        feeDetailsLabel.setFont(font);
        headerPanel.add(feeDetailsLabel);
        this.add(headerPanel, BorderLayout.NORTH);

        Panel feePanel = new Panel(new GridLayout(2, 4, 20, 30));
        pendingFeesLabel = new Label("Pending Fees:");
        pendingFeesLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        amount1 = new Label("5000");
        amount1.setForeground(Color.RED);
        amount1.setFont(new Font("SansSerif", Font.PLAIN, 18));
        paidFeesLabel = new Label("Paid Fees:");
        paidFeesLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        amount2 = new Label("15000");
        amount2.setFont(new Font("SansSerif", Font.PLAIN, 18));
        feePanel.add(pendingFeesLabel);
        feePanel.add(amount1);
        feePanel.add(paidFeesLabel);
        feePanel.add(amount2);
        this.add(feePanel, BorderLayout.CENTER);
    }
}

// Complaints Panel - file complaints and view status
class ComplaintsPanel extends Panel implements ActionListener {
    TextArea complaintsArea;
    Button submitButton;

    public ComplaintsPanel() {
        this.setLayout(new BorderLayout());
        Font font = new Font("SansSerif", Font.BOLD, 24);
        Label complaintsLabel = new Label("Complaints Page", Label.CENTER);
        complaintsLabel.setFont(font);
        this.add(complaintsLabel, BorderLayout.NORTH);
        complaintsArea = new TextArea("Enter your complaint here...");
        complaintsArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        this.add(complaintsArea, BorderLayout.CENTER);
        submitButton = new Button("Submit Complaint");
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.GREEN);
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        this.add(submitButton, BorderLayout.SOUTH);
        // Add action listener for submit button (not implemented here)
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {

        }
    }
}
