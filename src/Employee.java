import java.lang.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Employee implements java.io.Serializable {
    private String Name;
    private int Id;
    private float Salary;
    private static final AtomicInteger count = new AtomicInteger(0);

public Employee(String Name, float Salary)
{
    this.Name = Name;
    this.Salary = Salary;
    this.Id = count.incrementAndGet();

}

public void setName(String Name)
{
    this.Name= Name;
}

public void setSalary(float Salary)
{
    this.Salary=Salary;
}

    public void raiseSalary(float value)
    {
        if(value>0)
        {
            this.Salary+=value;
        }
    }

    public String toString(){
        return this.Id+" "+this.Name+" "+this.Salary;
    }

    public String getName()
    {
        return this.Name;
    }

    public int getId(){return this.Id;}
    public float getSalary(){
        return this.Salary;
    }
    public String getSalaryString()
    {
        return String.valueOf(Salary);
    }


}
