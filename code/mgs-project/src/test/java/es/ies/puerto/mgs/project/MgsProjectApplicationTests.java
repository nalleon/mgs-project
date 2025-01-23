package es.ies.puerto.mgs.project;

import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MgsProjectApplicationTests extends TestUtilities {

	@Mock
	private SpringApplicationBuilder springApplicationBuilder;
	@Test
	void contextLoads() {
		ServletInitializer servletInitializer = new ServletInitializer();
		when(springApplicationBuilder.sources(MgsProjectApplication.class)).thenReturn(springApplicationBuilder);

		SpringApplicationBuilder result = servletInitializer.configure(springApplicationBuilder);

		verify(springApplicationBuilder).sources(MgsProjectApplication.class);
		Assertions.assertEquals(springApplicationBuilder,result, MESSAGE_ERROR);
	}

	@Test
	void mainTest(){
		MgsProjectApplication.main(new String[]{});
	}

}
