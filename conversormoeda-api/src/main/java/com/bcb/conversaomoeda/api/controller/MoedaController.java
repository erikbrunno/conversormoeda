package com.bcb.conversaomoeda.api.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcb.conversaomoeda.api.assembler.MoedaModelAssembler;
import com.bcb.conversaomoeda.api.model.MoedaModel;
import com.bcb.conversaomoeda.domain.model.Moeda;
import com.bcb.conversaomoeda.domain.service.CadastroMoedaService;

@RestController
@RequestMapping("/moedas")
public class MoedaController {
	
	@Autowired
	private CadastroMoedaService cadastroMoeda;
	
	@Autowired
	private MoedaModelAssembler moedaModelAssembler;
	
	@GetMapping
	public ResponseEntity<List<MoedaModel>> listar() {

		List<Moeda> todasMoedas = cadastroMoeda.consultar();
		List<MoedaModel> moedasModel = moedaModelAssembler.toCollectionModel(todasMoedas);

		return ResponseEntity.ok()
				.cacheControl(CacheControl.maxAge(3, TimeUnit.SECONDS))
				.body(moedasModel);
	}
}
