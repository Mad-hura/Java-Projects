package com.lumen.streamsassignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {
	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(new Employee("Margot","California",111),
				new Employee("Kate","NewYork",222),
				new Employee("Jack","Italy",333),
				new Employee("Karan","California",444));
		employees.stream()
		          .forEach(System.out::println);
		System.out.println("\"Employees in California: ");
		employees.stream()
		         .filter(str->str.getCity().equals("California"))
		         .collect(Collectors.toList())
		         .forEach(System.out::println);
		System.out.println("Employees after sorting: ");
		employees.stream()
		         .sorted((emp1, emp2) -> emp1.getName().compareTo(emp2.getName()))
				 .forEach(emp -> System.out.println(emp));
		System.out.println("Employees by Id: ");
		String empid=employees.stream()
		         .filter(emp -> emp.getEmployeeId() == (333))
		         .map(Employee::getName)
		         .findFirst()
		         .orElseThrow(() -> new RuntimeException("NO employee with this Id"));
		System.out.print(empid);
		System.out.println();
		
		System.out.println("Employees name starts with K: ");
		String empK = employees.stream()
				 .filter(str->str.getName().startsWith("K"))
			     .map(Employee::getName)
				 .findFirst()
			     .orElse("not in first place");
	    System.out.println(empK);
				 
				                
		         

		
		
	}

}
