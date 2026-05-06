import java.awt.*;
import java.awt.event.*;

public class StudentLogin extends Frame implements ActionListener {
    Label l1, l2, l3;
    TextField tf1, tf2;
    Button btn1, btn2;

    // constructor
    public StudentLogin() {
        this.setTitle("Student Login");
        this.setSize(270, 400);
        setBackground(Color.BLUE);
        setResizable(false);
        setVisible(true);
        this.setLayout(new GridLayout(7, 1));
        Font font = new Font("Sansarif", Font.CENTER_BASELINE, 15);

        l1 = new Label("                      Student Name");
        l1.setFont(font);
        this.add(l1);
        tf1 = new TextField(20);
        tf1.setFont(font);
        this.add(tf1);
        l2 = new Label("                       Password");
        l2.setFont(font);
        this.add(l2);
        tf2 = new TextField(20);
        tf2.setEchoChar('*');
        this.add(tf2);
        btn1 = new Button("Login");
        btn1.setFont(font);
        btn1.setBackground(Color.GREEN);
        this.add(btn1);
        btn1.addActionListener(this);
        l3 = new Label("  Sign Up if you don't have account ");
        l3.setForeground(Color.pink);
        l3.setFont(font);
        this.add(l3);
        btn2 = new Button("sign Up");
        btn2.setFont(font);
        btn2.setBackground(Color.YELLOW);
        this.add(btn2);
        btn2.addActionListener(this);

        this.setVisible(true);

        // Window close handler
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1 && tf1.getText().equals("Huzaifa") && tf2.getText().equals("1234")) {
            this.dispose();
            new StudentMainDashboard();
        } else if (e.getSource() == btn2) {
            this.dispose();
            new StudentSignUp();
        }
    }
}
