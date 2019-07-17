import java.util.Comparator;

public class CompareByName implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return String.CASE_INSENSITIVE_ORDER.compare(e1.getName(), e2.getName());
    }
}
