package pe.edu.pe.Hospital.Inventory.Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class HospitalInventoryManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalInventoryManagementServiceApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
