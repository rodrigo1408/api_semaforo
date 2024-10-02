package com.resultx.semaforo_backend.enums;

public enum Estado {

	VERMELHO("vermelho"), 
	AMARELO("amarelo"),
	VERDE("verde");

	private String estadoAtual;

	Estado(String estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getEstadoAtual() {
		return estadoAtual;
	}
}
