package com.resultx.semaforo_backend.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.resultx.semaforo_backend.enums.Estado;

@Component
public class Semaforo {
	
	private static final Logger logger = LoggerFactory.getLogger(Semaforo.class);
	
	
	private Estado estadoAtual;
	private boolean controleManual;
	private long tempoVermelho = 10000; // 10 segundos
	private long tempoAmarelo = 5000; 	// 5  segundos
	private long tempoVerde = 15000; 	// 15 segundos

	public Semaforo() {
		this.estadoAtual = Estado.VERMELHO; // Começamos no vermelho por padrão
		this.controleManual = false; // Por padrão, o semáforo está em modo automático
		logger.info("Semáforo iniciado no estado: {}", estadoAtual);
	}

	public Estado getEstadoAtual() {
		return estadoAtual;
	}
	
	//Método para ativar/desativar o controle manual
	public void setControleManual(boolean controleManual) {
		this.controleManual = controleManual;
		if(controleManual) {
			logger.info("Semáforo agora está em modo manual.");
		}else {
			logger.info("Semáforo voltou ao modo automático.");
		}
	}
	
	// Método para definir o estado manualmente
	public void setEstadoManual(Estado novoEstado) {
		if(controleManual) {
			this.estadoAtual = novoEstado;
			logger.info("Estado do semáforo alterado manualmente para: {}", novoEstado);
		}else {
			logger.warn("Tentativa de controle manual enquanto o modo automático está ativo.");
		}
	}

	// Método agendado para mudar o estado do semáforo automaticamente
	@Scheduled(fixedRate = 1000) // Executa a cada segundo para verificar a troca
	public void atualizarEstadoAutomatico() throws InterruptedException {
		switch (estadoAtual) {
		case VERMELHO:
			Thread.sleep(tempoVermelho);
			estadoAtual = Estado.VERDE;
			break;
		case VERDE:
			Thread.sleep(tempoVerde);
			estadoAtual = Estado.AMARELO;
			break;
		case AMARELO:
			Thread.sleep(tempoAmarelo);
			estadoAtual = Estado.VERMELHO;
			break;
		}
		logger.info("Semáforo mudou automaticamente para: {}", estadoAtual);
	}
}
