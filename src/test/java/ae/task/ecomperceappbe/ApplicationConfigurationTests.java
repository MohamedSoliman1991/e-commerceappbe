package ae.task.ecomperceappbe;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import ae.task.ecomperceappbe.controllers.eshopController;
@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationConfigurationTests {

	@Autowired
    ApplicationContext ac;

	@Test
	void contextLoads() {
		eshopController mobileController = ac.getBean(eshopController.class);
        assertNotNull(mobileController);
	}

}
