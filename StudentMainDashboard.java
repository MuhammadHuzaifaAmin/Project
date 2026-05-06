import java.awt.*;
import java.awt.event.*;

public class StudentMainDashboard extends Frame {
    Button btn1, btn2, btn3, btn4, btn5;

    public StudentMainDashboard() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setSize(500, 500);
        this.setBackground(Color.BLUE);
        this.setTitle("Student Main Dashboard");
        this.setLayout(new FlowLayout());

        Font font = new Font("Sansarif", Font.BOLD, 20);
        btn1 = new Button("Profile");
        btn1.setFont(font);
        btn1.setBackground(Color.CYAN);
        this.add(btn1);

        btn2 = new Button("Request Room");
        btn2.setFont(font);
        btn2.setBackground(Color.CYAN);
        this.add(btn2);

        btn3 = new Button("Mess Menu");
        btn3.setFont(font);
        btn3.setBackground(Color.CYAN);
        this.add(btn3);

        btn4 = new Button("Fee Deatils");
        btn4.setFont(font);
        btn4.setBackground(Color.CYAN);
        this.add(btn4);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);

    }
}
