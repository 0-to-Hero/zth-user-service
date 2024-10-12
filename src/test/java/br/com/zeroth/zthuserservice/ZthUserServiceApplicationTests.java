package br.com.zeroth.zthuserservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ZthUserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
