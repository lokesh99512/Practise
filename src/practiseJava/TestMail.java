package practiseJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TestMail {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1, "demo", 20, 15000));
		employees.add(new Employee(2, "ramu", 21, 10000));
		employees.add(new Employee(3, "raju", 29, 20000));
		employees.add(new Employee(4, "raju", 30, 300000));

		//System.out.println(employees.stream().distinct().collect(Collectors.toList()));
		
//		List<Integer> emp = employees.stream().distinct().filter(e -> e.getAge() > 25)
//				.map(e -> (int) (e.getSalary() * 0.1)).collect(Collectors.toList());
//
//		System.out.println(emp);
//
//		List<String> distinctEmployees = employees.stream().map(Employee::getName).distinct()
//				.collect(Collectors.toList());
//		System.out.println(distinctEmployees);
//
//		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
//
//		Map<Boolean, List<Integer>> oddEvenNumbersMap = listOfIntegers.stream()
//				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
//
//		for (Entry<Boolean, List<Integer>> entry : oddEvenNumbersMap.entrySet()) {
//			if (entry.getKey()) {
//				System.out.println("even number ---------------");
//			} else {
//				System.out.println("odd number ---------------");
//			}
//
//			for (Integer entry2 : entry.getValue()) {
//				System.out.println(entry2);
//			}
//		}
		//System.out.println(oddEvenNumbersMap);
		
//
//		 System.out.println(employees.stream().filter(e ->
//		 e.getName().startsWith("r")).collect(Collectors.toList()));
//
//		System.out.println(employees.stream().map(e -> new StringBuilder(e.getName()).reverse().toString())
//				.collect(Collectors.toList()));

	//	String loki = "loki is a good boy";
//		
//		for(int i=loki.length()-1;i>=0;i--) {
//			System.out.print(loki.charAt(i));
//		}
//
//
	//	System.out.println(new StringBuilder(loki).reverse().toString());
//
//		 List<Integer> emp1=employees.stream().filter(e-> e.getAge() >25).map(e->
//		 (int)(e.getSalary()*1.1)).collect(Collectors.toList());
//
//		System.out.println(emp1);
//
//		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
//		System.out.println(listOfStrings.stream().distinct().collect(Collectors.toList()));
//
//		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
//		System.out.println(decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
//		
//		List<String> listOfStrings1 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
//		System.out.println(listOfStrings1.stream().collect(Collectors.joining(",", "[", "]")));
//
//		
//		 List<Integer> maxandmin = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//		 System.out.println(maxandmin.stream().max(Comparator.naturalOrder()).get());
//		 System.out.println(maxandmin.stream().min(Comparator.naturalOrder()).get());
//		 
//		 
//		  List<Integer> malitpleOfFive = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//		  malitpleOfFive.stream().filter(e-> e% 5==0).forEach(System.out::println);
//		  
//		  List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//		  
//		  List<String> filterString=strings.stream().filter(i-> !i.isBlank()).collect(Collectors.toList());
//		  
//		  String megerSting=filterString.stream().collect(Collectors.joining(", "));
//		  System.out.println(megerSting);
//		  
		  
		  
//		  Long count=strings.stream().filter(i-> i.isBlank()).count();
		  
//		  System.out.println(count);
		  
		  
//		  System.out.println(filterString);
//		  List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//		  
//		  List<Integer> uniqueIntegers= numbers.stream().sorted().distinct().map(i->i*i).collect(Collectors.toList());
//		  
//		  System.out.println(uniqueIntegers);
		 
	}

}
