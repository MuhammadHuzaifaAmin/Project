import java.awt.*;
import java.awt.event.*;

public class StudentSignUp extends Frame implements ActionListener {
    Label l1, l2, l3;
    TextField tf1, tf2, tf3;
    Button btn1;

    public StudentSignUp() {
        this.setTitle("Student Sign Up");
        this.setSize(350, 500);
        this.setResizable(false);
        this.setBackground(Color.BLUE);
        this.setLayout(new GridLayout(7, 1));

        // fonts
        Font font = new Font("Sansarif", Font.CENTER_BASELINE, 15);
        l1 = new Label("Name");
        l1.setFont(font);
        add(l1);
        tf1 = new TextField(30);
        tf1.setFont(font);
        add(tf1);
        l2 = new Label("Father Name");
        l2.setFont(font);
        add(l2);
        tf2 = new TextField(30);

        add(tf2);
        l3 = new Label("Set Password");
        l3.setFont(font);
        add(l3);
        tf3 = new TextField(8);
        tf3.setEchoChar('*');

        add(tf3);
        btn1 = new Button("Sign Up");
        btn1.setFont(font);
        btn1.setBackground(Color.GREEN);
        add(btn1);
        btn1.addActionListener(this);
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
            this.dispose();
            new StudentLogin();
        } else {

        }
    }
}
