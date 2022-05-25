package sjpowa.group.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// We implements Serializable to help the transformation of the Java class
// because this class will send data to the database
// it will sent to the front-end as JSON
// so it's a class that is gonna have different type of streams
// For this reason it's always good practice to make classes like this
// implemented with Serializable
@Entity
@Table(name = "EmployeesAngular")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // it should work without strategy,
														// but we want to be specific
	@Column(nullable = false, updatable = false)
	private Long id;
	@Column(name="first_name", nullable = false)
	private String name;
	@Column(name="email", nullable = false)
	private String email;
	@Column(name = "job_title", nullable = false)
	private String jobTitle;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "image_url", nullable = false)
	private String imageUrl; // we want to point to the location where the img has to be stored
							 // so imageUrl is gonna hold the location
	@Column(nullable = false, updatable = false)
	private String employeeCode;
	
	// EMPTY CTOR
	public Employee() {
		
	}
	
	// CTOR
	public Employee(Long id,
					String name,
					String email,
					String jobTitle,
					String phone,
					String imageUrl,
					String employeeCode) {
								super();
								this.id = id;
								this.name = name;
								this.email = email;
								this.jobTitle = jobTitle;
								this.phone = phone;
								this.imageUrl = imageUrl;
								this.employeeCode = employeeCode;
							}

	// GETTERS and SETTERS
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Override
	public String toString() {
		return "Employee"
				+ " [id=" + id
				+ ", name=" + name
				+ ", email="+ email
				+ ", jobTitle=" + jobTitle +
				", phone=" + phone
				+ ", imageUrl=" + imageUrl
				+ ", employeeCode=" + employeeCode
				+ "]";
	}
	
}