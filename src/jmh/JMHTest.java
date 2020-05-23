package jmh;

import employee.Employee;
import employee.EmployeeReader;
import employee.EmployeeStats;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class JMHTest {


       public void init() {
              // Do nothing
       }

       @Benchmark
       @Fork(value = 1, warmups = 1)
       @Measurement(time = 1, timeUnit = TimeUnit.SECONDS, iterations = 5)
       @Warmup(iterations = 2)
       @BenchmarkMode(Mode.AverageTime)
       @OutputTimeUnit(TimeUnit.MILLISECONDS)
       public static List<Employee> testScannerEmployeeRead() {
              List<Employee> employees = new ArrayList<>();
              try {
                     employees = EmployeeReader.readEmployeesScanner();
              } catch (IOException e) {
                     throw new IllegalArgumentException("nie mozna wczytac pliku");
              }
              return employees;

       }

       @Benchmark
       @Fork(value = 1, warmups = 1)
       @Measurement(time = 1, timeUnit = TimeUnit.SECONDS, iterations = 5)
       @Warmup(iterations = 2)
       @BenchmarkMode(Mode.AverageTime)
       @OutputTimeUnit(TimeUnit.MILLISECONDS)
       public static  List<Employee> testBufferedReaderEmployeeRead(Blackhole bh) {
              List<Employee> employees = new ArrayList<>();
              try {
                     employees = EmployeeReader.readEmployeesBufferReader();
              } catch (IOException e) {
                     throw new IllegalArgumentException("nie mozna wczytac pliku");
              }
              return employees;

       }

}
