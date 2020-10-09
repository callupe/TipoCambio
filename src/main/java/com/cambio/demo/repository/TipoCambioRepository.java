package com.cambio.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cambio.demo.model.TipoCambio;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {
	
	@Query("select p from TipoCambio p where p.monedaOrigen = ?1 and p.monedaDestino = ?2")
	public List<TipoCambio> listAll(String keyword1, String keyword12);

}
