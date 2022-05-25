package sjpowa.group.employeemanager;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sjpowa.group.employeemanager.model.Employee;
import sjpowa.group.employeemanager.service.EmployeeService;

// This class will represent our controller
// so we use the @RestController Annotation
@RestController
@RequestMapping("/employee") // I want to give to this class a default URL
							 // so all employee resource will have /employee
							 // to use this service
public class EmployeeResource {
	
	private final EmployeeService employeeService;

	// We want to have access to the Service
	// to use then all the CRUD methods
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// ========================================================================
	// GET ALL EMPLOYEES
	
	// ResponseEntity:
	// ResponseEntity is meant to represent the entire HTTP response.
	// You can control anything that goes into it: status code, headers, and body.
	
	// to return an HTTP response we use ResponseEntity
	// and we have to pass in it what kind of data
	// that's gonna be in the body
	@GetMapping("/all") // so /employee/all is the full path to return all the employees
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees =  employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	// ========================================================================
	
	
	@GetMapping("/find/{id}") // this path will be added to the default path /employee set on this class
	// With @PathVariable we want to match the {id} from the path of @GetMapping("/find/{id}")
	// and ("id") of @PathVariable("id") Long id
	// we have also declared Long id to say, yo this is a Long type
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee =  employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	// ========================================================================
	// POST METHOD
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
				// in addEmployee(empl-obj-JSON) parameter
				// we expect to receive from the user
				// the entire employee object in JSON format
		// so with @RequestBody annotation we say that we want
		// to convert the JSON format we receive in Employee Object
		// so then we can have access to the employee from the body
		
		// so after we get the Employee converted from the JSON format
		// we create a new Employee obj with its class
		// and we simply use the add method(we pass in here the JSON employee converted)
		// through our Service class
		Employee newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
		
	}
	
	// ========================================================================
	// PUT METHOD - UPDATE
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
				// in updateEmployee(empl-obj-JSON) parameter
				// we expect to receive from the user
				// the entire employee object in JSON format
		// so with @RequestBody annotation we say that we want
		// to convert the JSON format we receive in Employee Object
		// so then we can have access to the employee from the body
		
		// so after we get the Employee converted from the JSON format
		// we create a new Employee obj with its class
		// and we simply use the update method(we pass in here the JSON employee obj converted)
		// through our Service class
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
		
	}
	
	// ========================================================================
	// DELETE
	
	// With @PathVariable we want to match the {id} from the path of @GetMapping("/find/{id}")
	// and ("id") of @PathVariable("id") Long id
	// we have also declared Long id to say, yo this is a Long type
	
	// in ResponseEntity<?> we use the question mark because
	// this method haven't to return anything
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
