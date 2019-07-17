import java.io.*;
import java.util.LinkedList;

public class CsvBuilder {
    CompareById.EmployeeManager tmp;
    StringBuilder str;
    String result;


    public CsvBuilder(CompareById.EmployeeManager e)
    {
        tmp=e;
    }

    private Object[] PrepareList()
    {
        LinkedList<Employee> x =tmp.getListOfEmployee();
        Object [] o = x.toArray();
            return o;

    }

    private String TransformToCsvFormat()
    {
      Object []preparedList= PrepareList();
      this.str= new StringBuilder();
      for(Object element:preparedList)
      {
          str.append(element.toString()+"\n");
      }
        String result = str.toString();
        result= result.replace(" ",",");
      return result;
    }

    private String [] GetRowsFromCsv(String data)
    {
        return data.split("\n");
    }

    private String[] getColumnsFromCsv(String data)
    {
        return data.split(",");
    }
    public void Save() throws IOException
    {

        PrintWriter data  = null;
        data = new PrintWriter(new File("data.csv"));
        data.write(this.TransformToCsvFormat());
        data.flush();
        data.close();

    }

    public void Load(String pathToFile)  throws FileNotFoundException,IOException{
        File file = new File(pathToFile);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder dataFromFile = new StringBuilder();
        String element;
        while((element=br.readLine())!=null)
            dataFromFile.append(element+"\n");
        String [] csvRows= this.GetRowsFromCsv(dataFromFile.toString());
        this.tmp.Clear();
        for(String extractedRow:csvRows){
                String[] listOfValues = this.getColumnsFromCsv(extractedRow);
                Employee e= new Employee(listOfValues[1],Float.valueOf(listOfValues[2]));
                tmp.Add(e);
                e=null;
        }


    }

}
