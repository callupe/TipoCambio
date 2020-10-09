package com.cambio.demo.service;

import java.util.List;

import com.cambio.demo.model.TipoCambio;

import io.reactivex.rxjava3.core.Observable;

public interface TipoCambioService {

	Observable<TipoCambio> crearTipoCambio(TipoCambio tipoCambio);
	
	Observable<TipoCambio> actualizarTipoCambio(TipoCambio tipoCambio);
	
	Observable<List<TipoCambio>> listarTipoCambio();
	
	Observable<TipoCambio> obtenerTipoCambio(Long id);
	
	void eliminarTipoCambio(Long id);
	
	Observable<TipoCambio> aplicarTipoCambio(TipoCambio tipoCambio);
	
}
