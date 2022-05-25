package sjpowa.group.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	// When we try to run the application from a domain
	// that tries to open stuff on another domain
	// We have the CORS Policy that will block the access..
	// So if we don't give, in here, the access
	// to our Angular http Address
	// We do not have the permission to get the information we want
	// ==============================================================
	// An application running in a run domain cannot access resources
	// in another domain or application running in another domain
	// Spring Boot Application running on localhost:8080
	// Angular running on localhost:4200
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		// So down here, after all the permission that we give and at which address we give,
		// we have to pass that configuration to a Url course configuration
		// so, because this is all url based, we say: Hey create this, down here,
		// create this new object, which is an Url based configuration,
		// and
		// pass our configuration, which is the regular course configuration
		// and
		// we set that to all the routes in the application which is the root route
		// of the application, which is /**
		// and
		// then we return a new Course Filter
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}