import javax.swing.*;
import java.awt.*;

public class EditWindow implements WindowHelper {

    public EditWindow(DefaultListModel model,JList list){
        JFrame editWindow  = new JFrame();
        Container contentPane = editWindow.getContentPane();
        SpringLayout springLayout = new SpringLayout();
        Employee selected=(Employee)model.getElementAt(list.getSelectedIndex());

        contentPane.setLayout(springLayout);

        JLabel labelForName= new JLabel("Nazwisko:");
        JTextField fieldForName = CreateField(100,20);


        fieldForName.setText(selected.getName());

        JLabel labelForSalary = new JLabel("Pensja:");
        JTextField fieldForSalary= CreateField(100,20);
        fieldForSalary.setText(selected.getSalaryString());

        JButton ok= CreateButton("OK");

        ok.addActionListener(actionEvent12 -> {
            String name = fieldForName.getText();
            float salary = Float.parseFloat(fieldForSalary.getText());
            Employee tmp = new Employee(name,salary);
            model.setElementAt(tmp,list.getSelectedIndex());
            RefreshList(model,list);
            editWindow.dispose();
        });

        InsertLayout(contentPane,springLayout,labelForName,fieldForName,labelForSalary,fieldForSalary,ok);
        contentPane.setPreferredSize(new Dimension(300,100));
        editWindow.pack();
        editWindow.setVisible(true);
    }

    @Override
    public JButton CreateButton(String name) {
        JButton tmp=  new JButton(name);
        return tmp;
    }

    @Override
    public JTextField CreateField(int width, int height)
    {
        JTextField tmp = new JTextField();
        tmp.setPreferredSize(new Dimension(width,height));
        return tmp;
    }

    @Override
    public void InsertLayout(Container contentPane, SpringLayout springLayout, JLabel labelForName, JTextField fieldForName, JLabel labelForSalary, JTextField fieldForSalary, JButton ok) {
        contentPane.add(labelForName);
        contentPane.add(fieldForName);

        springLayout.putConstraint(SpringLayout.WEST,fieldForName,100,SpringLayout.WEST,contentPane);

        contentPane.add(labelForSalary);
        contentPane.add(fieldForSalary);

        springLayout.putConstraint(SpringLayout.NORTH,fieldForSalary,30,SpringLayout.NORTH,contentPane);
        springLayout.putConstraint(SpringLayout.WEST,fieldForSalary,100,SpringLayout.WEST,contentPane);

        springLayout.putConstraint(SpringLayout.NORTH,labelForSalary,30,SpringLayout.NORTH,contentPane);
        springLayout.putConstraint(SpringLayout.WEST,labelForSalary,10,SpringLayout.WEST,contentPane);

        springLayout.putConstraint(SpringLayout.NORTH,ok,10,SpringLayout.SOUTH,fieldForSalary);
        springLayout.putConstraint(SpringLayout.WEST,ok,100,SpringLayout.WEST,contentPane);
        contentPane.add(ok);
    }

    @Override
    public void RefreshList(DefaultListModel newModel, JList list)
    {
        list.setModel(newModel);
    }
}
