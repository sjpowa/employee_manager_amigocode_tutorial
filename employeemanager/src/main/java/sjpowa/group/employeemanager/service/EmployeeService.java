package sjpowa.group.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sjpowa.group.employeemanager.exception.UserNotFoundException;
import sjpowa.group.employeemanager.model.Employee;
import sjpowa.group.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {

		// EmployeeRepo has the Methods to execute and manage the data
		// then we have to inject it here to complete the operations
		private final EmployeeRepo employeeRepo;
		
		@Autowired
		public EmployeeService(EmployeeRepo employeeRepo) {
			this.employeeRepo = employeeRepo;
		}
		
		public Employee addEmployee(Employee employee) {
			// Before I create a New Employee
			// I want to generate the Employee Code
			// cuz I am not asking to the Employee to get
			// this Employee Code
			employee.setEmployeeCode(UUID.randomUUID().toString()); // we create random UUID and converted to String
			return employeeRepo.save(employee);
		}
		
		public List<Employee> findAllEmployees() {
			return employeeRepo.findAll();
		}
		
		// Remember OPTIONAL -> it is used to return the right obj
		// so if someone wants to find an Employee
		// and this Employee Id doesn't exist
		// it will return an error, the right obj
		public Employee findEmployeeById(Long id) {
			return employeeRepo.findEmployeeById(id)
					.orElseThrow(
							() -> new UserNotFoundException("User by id: " + id + " not found!"));
		}
		// orElseThrow Exception cannot be used with Optional
		// like on a method that return an Optional obj
		// public Optional<Employee> findEmployeeById(Long id)

		
		public Employee updateEmployee(Employee employee) {
			return employeeRepo.save(employee);
		}
		
		public void deleteEmployee(Long id) {
			employeeRepo.deleteById(id);
		}
		
}
