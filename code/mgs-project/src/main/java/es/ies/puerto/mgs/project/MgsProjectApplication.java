package es.ies.puerto.mgs.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:cxf-service.xml")
//@ComponentScan(basePackages = "es.ies.puerto.mgs.project")
public class MgsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MgsProjectApplication.class, args);
	}

}
