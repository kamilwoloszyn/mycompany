class PhysicalEmployee extends Employee{
    private int PhyshicalEmployeeKey;
    private String NameOfKey;


    public PhysicalEmployee(String Name, float Salary) {
        super(Name, Salary);
    }

    public int getPhysialEmployeeKey(){
        return PhyshicalEmployeeKey;
    }

    public String getPhychicalEmployeekey(){
        return NameOfKey;
    }

    public void setPhychicalEmployeekey(int val)
    {
        if(PhyshicalEmployeeKey!=0)
        {
            this.PhyshicalEmployeeKey=val;
        }
    }

    public void setNameOfKey(String nameOfKey) {
        NameOfKey = nameOfKey;
    }
}