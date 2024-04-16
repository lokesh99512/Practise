package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();
        
        employeeList.stream().map(Employee :: getProjects).distinct().forEach(System.out::println);
        
        employeeList.stream().map(Employee :: getFirstName).sorted().forEach(System.out::println);
        
        int n = employeeList.size();

        List<Employee> sortedBySalary = employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        // Retrieve the nth employee (index n-1)
        Employee nthHighestEmployee = sortedBySalary.get(n - 3);

        // Print the names of all employees with the salary equal to the nth highest employee's salary
        System.out.println("Employees with the " + (n-3) + "th highest salary:");
        employeeList.stream()
                .filter(employee -> employee.getSalary() == nthHighestEmployee.getSalary())
                .map(Employee::getSalary)
                .forEach(System.out::println);
    
        
      
        outerloop: // Label for the outer loop
            for (int i = 0; i < 5; i++) {
               if(i%2==0) {
            	   System.out.println(i+" = even number");
               }else {
            	   System.out.println(i+" = odd number");
               }
            }
        
        
        List<Integer> integers= Arrays.asList(1,2,3,4,5,6,6,8,9);
        
       System.out.println( integers.stream().distinct().filter(i-> i%2==0).mapToInt(Integer :: intValue).sum());
       
                         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  System.out.println(employeeList.stream().filter(i-> i.getFirstName().startsWith("A")).map(i->i.getFirstName()+" "+i.getLastName()).collect(Collectors.toList()));
        
     
 // System.out.println(employeeList.stream().filter(i-> i.getId().startsWith("2023")).map(i->i.getFirstName()+" "+i.getLastName()).collect(Collectors.toList()));
  

 
 //System.out.println(employeeList.stream().map(Employee :: getSalary).distinct().collect(Collectors.toList()));

 
 
// if(optionalDouble.isPresent()) {
//	 System.out.println(optionalDouble.get());
// }
  // employeeList.stream().filter(i-> i.getProjects().size()>2).forEach(System.out::println);
  
   
 
 //  System.out.println(employees.size());
  }
}