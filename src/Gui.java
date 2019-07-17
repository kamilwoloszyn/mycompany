import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;


public  class Gui extends JPanel{


    JList list;
    DefaultListModel<Object> model;

// to remove
    private JButton CreateButton(String name)
    {
        JButton tmp=  new JButton(name);
        return tmp;

    }


    //end


    private void RefreshList(DefaultListModel newModel, JList list){
        list.setModel(newModel);
    }

    public Gui(CompareById.EmployeeManager myList,JFrame frame)
    {

        setLayout(new BorderLayout(20,10));
        model = new DefaultListModel();

        for(int i=0;i<myList.getListOfEmployee().size();i++)
            model.add(0,myList.getListOfEmployee().get(i));

        list = new JList(model);
        JScrollPane pane = new JScrollPane(list);

        //tworze przyciski i podpinam event listener
        JButton addEmployee= CreateButton("Nowy");

        addEmployee.addActionListener(actionEvent -> {
        AddWindow newWindow = new AddWindow(model,list);
        });


        JButton deleteEmployee = CreateButton("Usuń");
        JButton editEmployee= CreateButton("Edytuj");

        deleteEmployee.addActionListener(actionEvent -> {
            int selectedIndex= list.getSelectedIndex();
            model.remove(selectedIndex);
            RefreshList(model,list);
        });

        editEmployee.addActionListener(actionEvent -> {
            EditWindow edit = new EditWindow(model,list);

        });


        add(pane,BorderLayout.PAGE_START);
        add(addEmployee,BorderLayout.LINE_START);
        add(deleteEmployee,BorderLayout.CENTER);
        add(editEmployee, BorderLayout.LINE_END);

    }

    public static void  main(String [] args)
    {
        PhysicalEmployee fizyczny = new PhysicalEmployee("Kowalski",1200);
        OfficeEmployee off = new OfficeEmployee("Jankowski",2000);

        CompareById.EmployeeManager emp= new CompareById.EmployeeManager();
        emp.Add(fizyczny);
        emp.Add(off);

        System.out.println(emp.getListOfEmployee().toString());

        try
        {
            //serialize file
            FileOutputStream fileOut = new FileOutputStream("output.ser");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();

            //deserialize file

            FileInputStream fileIn= new FileInputStream("output.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            CompareById.EmployeeManager e = (CompareById.EmployeeManager) in.readObject();
            LinkedList listOfEmployee= e.getListOfEmployee();
            PhysicalEmployee first =(PhysicalEmployee) listOfEmployee.get(0);
            System.out.println(first.getName());

            CsvBuilder fromEmp= new CsvBuilder(emp); //zapisuje
            fromEmp.Save();

//            fromEmp.Load("data.csv");

            System.out.println(emp.getListOfEmployee().toString());


        }

        catch(FileNotFoundException e)
        {
            System.out.println(e.toString());

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //run gui
       MainWindow nowy = new MainWindow(emp);
        nowy.run();

    }

}
