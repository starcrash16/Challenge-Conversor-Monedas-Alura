package com.alura.ConversorMonedas;

import Principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorMonedasApplication {

	public static void main(String[] args) {
            Principal principal = new Principal();
            principal.muestraElMenu();	
        }

}
