package com.cambio.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cambio.demo.model.TipoCambio;
import com.cambio.demo.service.TipoCambioService;


@RestController
//@RequestMapping("/api")
public class TipoCambioController{
	
	@Autowired
	private TipoCambioService tipoCambioService;
	
	@GetMapping("/tipocambio")
	public ResponseEntity<List<TipoCambio>> listar() {
		return ResponseEntity.ok().body(tipoCambioService.listarTipoCambio().blockingFirst());
	}
	
	@GetMapping("/tipocambio/{id}")
	public ResponseEntity<TipoCambio> obtenerTipoCambio(@PathVariable long id){
		return ResponseEntity.ok().body(this.tipoCambioService.obtenerTipoCambio(id).blockingFirst());
	}
	
	@PostMapping("/tipocambio")
	public ResponseEntity<TipoCambio> crearTipoCambio(@RequestBody TipoCambio tipoCambio){
		return ResponseEntity.ok().body(this.tipoCambioService.crearTipoCambio(tipoCambio).blockingFirst());
	}
	
	@PutMapping("/tipocambio/{id}")
	public ResponseEntity<TipoCambio> actualizarTipoCambio(@PathVariable Long id, @RequestBody TipoCambio tipoCambio){
		tipoCambio.setId(id);
		return ResponseEntity.ok().body(this.tipoCambioService.actualizarTipoCambio(tipoCambio).blockingFirst());
	}
	
	@DeleteMapping("/tipocambio/{id}")
	public HttpStatus eliminarTipoCambio(@PathVariable Long id) {
		this.tipoCambioService.eliminarTipoCambio(id);
		return HttpStatus.OK;
	}
	
	@PostMapping("/aplicarcambio")
	public ResponseEntity<TipoCambio> aplicarTipoCambio(@RequestBody TipoCambio tipoCambio) {
		return ResponseEntity.ok().body(this.tipoCambioService.aplicarTipoCambio(tipoCambio).blockingFirst());
	}


}
