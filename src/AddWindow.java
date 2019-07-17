import javax.swing.*;
import java.awt.*;

public class AddWindow implements WindowHelper{

    JFrame addWindow;
    Container contentPane;
    SpringLayout springLayout;

    public AddWindow(DefaultListModel model, JList list)
    {
        JFrame addWindow = new JFrame();
        Container contentPane = addWindow.getContentPane();
        SpringLayout springLayout = new SpringLayout();

        contentPane.setLayout(springLayout);


        JLabel labelForName= new JLabel("Nazwisko:");
        JTextField fieldForName = CreateField(100,20);

        JLabel labelForSalary = new JLabel("Pensja:");
        JTextField fieldForSalary= CreateField(100,20);

        JButton ok= CreateButton("OK");

        InsertLayout(contentPane,springLayout,labelForName,fieldForName,labelForSalary,fieldForSalary,ok);


        contentPane.setPreferredSize(new Dimension(300,100));
        addWindow.pack();
        addWindow.setVisible(true);

        ok.addActionListener(actionEvent1 -> {
            try
            {
                String name = fieldForName.getText();
                float salary = Float.parseFloat(fieldForSalary.getText());
                Employee tmp = new Employee(name,salary);
                model.add(0,tmp);
                RefreshList(model,list);
                addWindow.dispose();

            }catch(NullPointerException e)
            {
                JFrame err = new JFrame();
                JOptionPane.showMessageDialog(addWindow,"Pola nie mogą być puste!");
                err.pack();

            }catch (NumberFormatException e)
            {
                JFrame err = new JFrame();
                JOptionPane.showMessageDialog(addWindow,"Nieprawidłowe dane");
                err.pack();
            }



        });
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
