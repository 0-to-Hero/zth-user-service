package br.com.zeroth.zthuserservice;

import org.springframework.boot.SpringApplication;

public class TestZthUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ZthUserServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
