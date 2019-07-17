import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.io.*;
import java.util.List;

public class EmployeeManager {

    private LinkedList<Employee> list = new LinkedList<Employee>();


    public void Add(Employee e){
        list.add(e);
    }

    public List sortBySalary(){
        LinkedList ones = new LinkedList(this.list);
        Collections.sort(ones, new CompareBySalary());
        return ones;
    }
    public List sortByName(){
        LinkedList ones = new LinkedList(this.list);
        Collections.sort(ones, new CompareByName());
        return ones;
    }
    public List sortByID(){
        LinkedList ones = new LinkedList(this.list);
        Collections.sort(ones, new CompareById());
        return ones;
    }
    public LinkedList getListOfEmployee()
    {
        return list;
    }


}
