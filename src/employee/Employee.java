package employee;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
       private String id;
       private String firstName;
       private String lastName;
       private double salary;

       public Employee(String id, String firstName, String lastName, double salary) {
              this.id = id;
              this.firstName = firstName;
              this.lastName = lastName;
              this.salary = salary;
       }

       @Override
       public boolean equals(Object o) {
              if (this == o) return true;
              if (!(o instanceof Employee)) return false;
              Employee employee = (Employee) o;
              return Double.compare(employee.salary, salary) == 0 &&
                      Objects.equals(id, employee.id) &&
                      Objects.equals(firstName, employee.firstName) &&
                      Objects.equals(lastName, employee.lastName);
       }

       @Override
       public int hashCode() {
              return Objects.hash(id, firstName, lastName, salary);
       }

       @Override
       public String toString() {
              return "Employee{" +
                  "id='" + id + '\'' +
                  ", firstName='" + firstName + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", salary=" + salary +
                  '}';
       }

       public String getId() {
              return id;
       }

       public void setId(String id) {
              this.id = id;
       }

       public String getFirstName() {
              return firstName;
       }

       public void setFirstName(String firstName) {
              this.firstName = firstName;
       }

       public String getLastName() {
              return lastName;
       }

       public void setLastName(String lastName) {
              this.lastName = lastName;
       }

       public double getSalary() {
              return salary;
       }

       public void setSalary(double salary) {
              this.salary = salary;
       }

       @Override
       public int compareTo(Employee o) {
              return Double.compare(this.salary, o.salary);
       }
}
