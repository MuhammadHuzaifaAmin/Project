import java.awt.*;
import java.awt.event.*;

public class ManagerMainDashboard extends Frame implements ActionListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    Panel sidebar, contentPanel;
    Label l1;
    CardLayout cardLayout;

    public ManagerMainDashboard() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setSize(500, 500);
        this.setBackground(Color.BLUE);
        this.setTitle("Manager Main Dashboard");
        this.setLayout(new BorderLayout());
        // side bar
        sidebar = new Panel();
        sidebar.setLayout(new GridLayout(1, 7, 10, 10));
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

        // Cardlayout for each buttons
        cardLayout = new CardLayout();

        Panel homePanel;
        AddRoomPanel addRoomPanel;
        Panel viewRequestPanel;
        Panel removeStudentPanel;
        Panel displayStudentPanel;
        Panel paymentPanel;
        Panel visitorPanel;
        Panel messMenuPanel;

        // content panel details
        Font font1 = new Font("SansSerif", Font.BOLD, 40);
        contentPanel = new Panel(cardLayout);

        // HOME PANEL
        homePanel = new Panel();
        l1 = new Label("Welcome to the Hostel Management System of PIEAS");
        l1.setFont(font1);
        homePanel.add(l1);
        // ADDING ALL PANELS TO CARDLAYOUT
        contentPanel.add(homePanel, "HOME");
        addRoomPanel = new AddRoomPanel();
        contentPanel.add(addRoomPanel, "ADDROOM");
        // 2
        viewRequestPanel = new ViewRequestPanel();
        contentPanel.add(viewRequestPanel, "REQUEST");
        // 3
        removeStudentPanel = new RemoveStudentPanel();
        contentPanel.add(removeStudentPanel, "REMOVE");
        // 4
        displayStudentPanel = new DisplayStudentPanel();
        contentPanel.add(displayStudentPanel, "DISPLAY");
        // 5
        paymentPanel = new PaymentPanel();
        contentPanel.add(paymentPanel, "PAYMENT");
        // 6
        visitorPanel = new VisitorPanel();
        contentPanel.add(visitorPanel, "VISITOR");
        // 7
        messMenuPanel = new MessMenuPanel();
        contentPanel.add(messMenuPanel, "MESS");

        // ADD CONTENT PANEL TO FRAME
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
            cardLayout.show(contentPanel, "ADDROOM");
        }

        else if (e.getSource() == btn2) {
            cardLayout.show(contentPanel, "REQUEST");
        }

        else if (e.getSource() == btn3) {
            cardLayout.show(contentPanel, "REMOVE");
        }

        else if (e.getSource() == btn4) {
            cardLayout.show(contentPanel, "DISPLAY");
        }

        else if (e.getSource() == btn5) {
            cardLayout.show(contentPanel, "PAYMENT");
        }

        else if (e.getSource() == btn6) {
            cardLayout.show(contentPanel, "VISITOR");
        }

        else if (e.getSource() == btn7) {
            cardLayout.show(contentPanel, "MESS");
        }
    }

}

// addroompanel class
class AddRoomPanel extends Panel implements ActionListener {

    TextField roomNo, capacity;
    Button addBtn;
    Label l1;

    AddRoomPanel() {

        setLayout(new FlowLayout());
        l1 = new Label("");
        Font labelFont = new Font("SansSerif", Font.BOLD, 24);
        Font textFont = new Font("SansSerif", Font.PLAIN, 22);

        Label roomLabel = new Label("Room Number");
        roomLabel.setFont(labelFont);

        roomNo = new TextField(10);
        roomNo.setFont(textFont);

        Label capacityLabel = new Label("Capacity");
        capacityLabel.setFont(labelFont);

        capacity = new TextField(10);
        capacity.setFont(textFont);

        addBtn = new Button("Add Room");
        addBtn.setBackground(Color.GREEN);
        addBtn.setFont(labelFont);

        add(roomLabel);
        add(roomNo);

        add(capacityLabel);
        add(capacity);
        add(addBtn);
        add(l1);
        addBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            // String room = roomNo.getText();
            // String cap = capacity.getText();
            l1.setText("Room added successfully");
            roomNo.setText(" ");
            capacity.setText(" ");
        }
    }
}

// 2. view Request panel class
class ViewRequestPanel extends Panel {

}

// 3.remove student panel class
class RemoveStudentPanel extends Panel implements ActionListener {
    Label l1, l2, l3, l4, message;
    TextField tf1, tf2, tf3, tf4;
    Button btn1;

    RemoveStudentPanel() {
        setLayout(new GridLayout(5, 2));

        Font labelFont = new Font("SansSerif", Font.BOLD, 24);
        Font textFont = new Font("SansSerif", Font.PLAIN, 22);

        l1 = new Label("Student Name");
        l1.setFont(labelFont);

        tf1 = new TextField(20);
        tf1.setFont(textFont);

        l2 = new Label("Father Name");
        l2.setFont(labelFont);

        tf2 = new TextField(20);
        tf2.setFont(textFont);

        l3 = new Label("Student id");
        l3.setFont(labelFont);

        tf3 = new TextField(10);
        tf3.setFont(textFont);

        l4 = new Label("Room Number");
        l4.setFont(labelFont);

        tf4 = new TextField(10);
        tf4.setFont(textFont);

        btn1 = new Button("Remove Student");
        btn1.setFont(labelFont);
        btn1.setBackground(Color.GREEN);
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(this);

        message = new Label(" ");
        message.setForeground(Color.RED);
        message.setFont(labelFont);

        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(l3);
        add(tf3);
        add(l4);
        add(tf4);
        add(btn1);
        add(message);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            if (tf1.getText().equals("Wasif") && tf2.getText().equals("Khan") && tf3.getText().equals("1234")) {
                message.setText("            This Student is removed successfully");
            } else {
                message.setText("            This Student is not registered");
            }
        }
    }

}

// 4.display students panel
class DisplayStudentPanel extends Panel {
    Label id, name, father, fee;

    public DisplayStudentPanel() {
        this.setLayout(new BorderLayout());

        // hader panel
        Panel headerPanel = new Panel();
        headerPanel.setLayout(new GridLayout(1, 4));
        headerPanel.setBackground(Color.LIGHT_GRAY);
        Font font = new Font("Sansarif", Font.ROMAN_BASELINE, 15);
        id = new Label("id", Label.CENTER);
        id.setFont(font);
        headerPanel.add(id);
        name = new Label("Name", Label.CENTER);
        name.setFont(font);
        headerPanel.add(name);
        father = new Label("Father", Label.CENTER);
        father.setFont(font);
        headerPanel.add(father);
        fee = new Label("Fee", Label.CENTER);
        fee.setFont(font);
        headerPanel.add(fee);
        this.add(headerPanel, BorderLayout.NORTH);

    }
}

// 5.PaymentPanelClass
class PaymentPanel extends Panel {

}

// 6 Visitor Panel
class VisitorPanel extends Panel {

}

// 7 MessMenuPanel
class MessMenuPanel extends Panel {

}
