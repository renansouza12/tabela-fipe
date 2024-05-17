package com.renan.tabelafipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renan.tabelafipe.principal.Principal;

@SpringBootApplication
public class TabelafipeApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(TabelafipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var principal = new Principal();
		principal.displayMenu();
	}

}
