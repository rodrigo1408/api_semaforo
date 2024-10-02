package com.resultx.semaforo_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resultx.semaforo_backend.enums.Estado;
import com.resultx.semaforo_backend.model.Semaforo;

@RestController
@RequestMapping("/api/semaforo")
public class SemaforoController {
	
	private final Semaforo semaforo;
	
	public SemaforoController(Semaforo semaforo) {
		this.semaforo = semaforo;
	}
	
	//Obtendo o estado atual do semáforo
	@GetMapping("/estado")
	public Estado getEstado() {
		return semaforo.getEstadoAtual();
	}
	
	// Endpoint para ativar ou desativar o controle manual
    @PostMapping("/controle-manual/{ativo}")
    public String ativarControleManual(@PathVariable boolean ativo) {
    	semaforo.setControleManual(ativo);
    	if(ativo) {
    		return "Controle manual ativado.";
    	} else {
    		return "Controle manual desativado. Semáforo voltou ao modo automático.";
    	}
    }
    
    // Endpoint para alterar o estado manualmente (somente quando o controle manual está ativo)
    @PostMapping("/estado-manual/{novoEstado}")
    public String alterarEstadoManual(@PathVariable Estado novoEstado) {
    	semaforo.setEstadoManual(novoEstado);
    	 return "O estado do semáforo foi alterado manualmente para: " + novoEstado;
    }
}
