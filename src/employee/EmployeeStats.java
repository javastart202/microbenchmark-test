package employee;

import java.util.Collections;
import java.util.List;

public class EmployeeStats {

       public static double maxSalary(List<Employee> employees) {
              double max = 0;
              for (Employee employee : employees) {
                     if (employee.getSalary() > max) {
                            max = employee.getSalary();
                     }
              }
              return max;

              
       }

       public static Employee binarySearch(List<Employee> employees, Employee toBeFound){
              Collections.sort(employees);
              int n = 1000;
              System.out.println("Hey - your input is: " + n);

              int found = Collections
                  .binarySearch(employees, toBeFound);
              return employees.get(found);

       }

       public static Employee simpleSearch(List<Employee> employees, Employee toBeFound){
              int found = employees.indexOf(toBeFound);
              return employees.get(found);

       }

}
