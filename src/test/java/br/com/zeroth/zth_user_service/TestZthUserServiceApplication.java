package br.com.zeroth.zth_user_service;

import org.springframework.boot.SpringApplication;

public class TestZthUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ZthUserServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
