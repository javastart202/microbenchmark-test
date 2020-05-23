package manual;

import employee.Employee;
import employee.EmployeeReader;
import employee.EmployeeStats;
import org.openjdk.jmh.annotations.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManualTest {
       public static void main(String[] args) throws FileNotFoundException {

              ManualExecution.repeatExecute(ManualTest::testEmployeeSimpleSearch, 5);
              ManualExecution.repeatExecute(ManualTest::testEmployeeSortAndBinarySearch, 5);

       }


       public static Employee testEmployeeSortAndBinarySearch() {
              List<Employee> employees = null;
              try {
                     employees = EmployeeReader.readEmployeesScanner();
              } catch (IOException e) {
                     throw new IllegalArgumentException("nie mozna wczytac pliku");
              }
              System.out.println("size = " + employees.size());


              Employee employee = EmployeeStats
                  .binarySearch(employees, new Employee("120306", "Dudley", "Coffin", 60136));
              System.out.println("Found : {} " + employee);
              return employee;
       }


       public static void testEmployeeSimpleSearch() {
              List<Employee> employees = null;
              try {
                     employees = EmployeeReader.readEmployeesScanner();
              } catch (IOException e) {
                     throw new IllegalArgumentException("nie mozna wczytac pliku");
              }

              System.out.println("size = " + employees.size());

              Employee employee = EmployeeStats
                  .simpleSearch(employees, new Employee("120306", "Dudley", "Coffin", 60136));

              System.out.println("Found : {} " + employee);
       }


       private static void testScannerEmployeeRead() {
              List<Employee> employees = null;
              try {
                     employees = EmployeeReader.readEmployeesScanner();
              } catch (IOException e) {
                     throw new IllegalArgumentException("nie mozna wczytac pliku");
              }

       }

       private static void testBufferedReaderEmployeeRead() {
              List<Employee> employees = null;
              try {
                     employees = EmployeeReader.readEmployeesBufferReader();
              } catch (IOException e) {
                     throw new IllegalArgumentException("nie mozna wczytac pliku");
              }

       }

}
