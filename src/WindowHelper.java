import javax.swing.*;
import java.awt.*;

public interface WindowHelper {
    public JButton CreateButton(String name);
    public JTextField CreateField(int width, int height);
    public void InsertLayout(Container contentPane, SpringLayout springLayout, JLabel labelForName, JTextField fieldForName, JLabel labelForSalary, JTextField fieldForSalary, JButton ok);
    public void RefreshList(DefaultListModel newModel, JList list);
}
