import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CompareById implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getId(),e2.getId());
    }

    public static class EmployeeManager implements java.io.Serializable {

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
        public void Clear()
        {
            this.list.clear();
        }



    }
}