public class OfficeEmployee extends Employee {
   private int OfficeEmployeeKey;
   private String NameOfKey;

   public OfficeEmployee(String Name, float Salary)
    {
        super(Name,Salary);
    }

    public int getOfficeEmployeeKey() {
        return OfficeEmployeeKey;
    }

    public void setOfficeEmployeeKey(int officeEmployeeKey) {
        OfficeEmployeeKey = officeEmployeeKey;
    }

    public String getNameOfKey() {
        return NameOfKey;
    }

    public void setNameOfKey(String nameOfKey) {
        NameOfKey = nameOfKey;
    }


}
