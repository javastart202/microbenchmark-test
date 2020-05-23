package employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeReader {

       protected static final String EMPLOYEES_1M = "employees500000.csv";

       public static List<Employee> readEmployeesScanner() throws FileNotFoundException {
              File file = new File(EMPLOYEES_1M);
              Scanner scanner = new Scanner(file);
              String s = scanner.nextLine();
              List<Employee> employees = new ArrayList<>();
              while (scanner.hasNextLine()) {
                     String line = scanner.nextLine();
                     String[] split = line.split(",");
                     Employee employee = new Employee(split[0], split[2], split[4], Double.parseDouble(split[25]));
                     employees.add(employee);
              }
              return employees;
       }

       public static List<Employee> readEmployeesBufferReader() throws IOException {
              String fileName = "employees500000.csv";
              try (
                      var fileReader = new FileReader(fileName);
                      var reader = new BufferedReader(fileReader);
              ) {
                     String nextLine =  reader.readLine();
                     List<Employee> employees = new ArrayList<>();

                     while ((nextLine = reader.readLine()) != null) {
                            String[] split = nextLine.split(",");
                            Employee employee = new Employee(split[0], split[2], split[4], Double.parseDouble(split[25]));
                            employees.add(employee);
                     }
                     return employees;

              }
       }
}
