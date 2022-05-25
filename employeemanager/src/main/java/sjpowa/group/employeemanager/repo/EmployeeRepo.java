package sjpowa.group.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import sjpowa.group.employeemanager.model.Employee;

											// What class is this repo for
											// ,
											// type of the PK
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	// This method does not exists in JpaRepository
	// but we name it in this way
	// because Spring Boot is able to understand
	// that
	// we want to Find the Employee By Id
	// so it will make a Query for us
	Optional<Employee> findEmployeeById(Long id);

}
