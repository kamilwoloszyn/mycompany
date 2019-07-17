import javax.swing.*;

public class MainWindow {

    public JFrame frame;

    public MainWindow(CompareById.EmployeeManager emp) {
        frame = new JFrame("Moja Firma");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Gui(emp, frame));
        frame.setSize(500, 200);

    }

    public void run() {

        if(this.frame !=null)
        {
            this.frame.setVisible(true);
        }
    }
}
