package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class EmployeeRepository {
	private final Map<Integer, Employee> store = Map.of(
			101, new Employee(101, "Ananad", "CSE"),
			102, new Employee(102, "Divya", "ECE"),
			103, new Employee(103, "Ravi", "IT")
			);
	public Employee findById(int id) {
		return store.get(id);
	}
}
