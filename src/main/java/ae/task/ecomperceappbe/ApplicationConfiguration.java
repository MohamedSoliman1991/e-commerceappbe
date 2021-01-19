package ae.task.ecomperceappbe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ae.task.ecomperceappbe.models.*;
@SpringBootApplication
@ComponentScan(basePackages = {"ae.task.ecomperceappbe"})
@EntityScan("ae.task.ecomperceappbe.models")
@EnableJpaRepositories("ae.task.ecomperceappbe.daos")
public class ApplicationConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfiguration.class, args);
	}

//	@Bean
//	CommandLineRunner runner(@Autowired MobileCatalougeService mobileCatalougeService) {
//		return args -> {
//			// read json and write to db
//			ObjectMapper mapper = new ObjectMapper();
//			TypeReference<List<User>> typeReference = new TypeReference<List<User>>(){};
//			InputStream inputStream = TypeReference.class.getResourceAsStream("/mobileDatabase.json");
//			try {
//				List<User> Mobiledata = mapper.readValue(inputStream,typeReference);
//				mobileCatalougeService.save(Mobiledata);
//				System.out.println("Data Saved!");
//			} catch (IOException e){
//				System.out.println("Unable to save Data: " + e.getMessage());
//			}
//		};
//	}
}
