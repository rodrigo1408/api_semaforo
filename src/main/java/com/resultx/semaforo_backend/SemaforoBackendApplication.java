package com.resultx.semaforo_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Habilita o agendamento de tarefas
public class SemaforoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SemaforoBackendApplication.class, args);
	}

}
