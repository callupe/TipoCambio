package com.cambio.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cambio.demo.exception.ResourceNotFoundException;
import com.cambio.demo.model.TipoCambio;
import com.cambio.demo.repository.TipoCambioRepository;

import io.reactivex.rxjava3.core.Observable;

@Service
@Transactional
public class TipoCambioServiceImpl implements TipoCambioService {
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;

	@Override
	public Observable<TipoCambio> crearTipoCambio(TipoCambio tipoCambio) {
		return Observable.just(tipoCambioRepository.save(tipoCambio));
	}

	@Override
	public Observable<TipoCambio> actualizarTipoCambio(TipoCambio tipoCambio) {
		Optional<TipoCambio> tipoCambioDb = this.tipoCambioRepository.findById(tipoCambio.getId());
		
		if(tipoCambioDb.isPresent()) {
			TipoCambio tipoCambioUpdate = tipoCambioDb.get();
			tipoCambioUpdate.setMonedaOrigen(tipoCambio.getMonedaOrigen());
			tipoCambioUpdate.setMonedaDestino(tipoCambio.getMonedaDestino());
			tipoCambioUpdate.setTipoCambio(tipoCambio.getTipoCambio());
			
			this.tipoCambioRepository.save(tipoCambioUpdate);
			return Observable.just(tipoCambioUpdate);
		}else{
			throw  new ResourceNotFoundException("No se encontro el tipo de cambio con ID: " + tipoCambio.getId());
		}
	}

	@Override
	public Observable<List<TipoCambio>> listarTipoCambio() {
		return Observable.just(this.tipoCambioRepository.findAll());
	}

	@Override
	public Observable<TipoCambio> obtenerTipoCambio(Long id) {
		
		Optional<TipoCambio> tipoCambioDb = this.tipoCambioRepository.findById(id);
		
		if(tipoCambioDb.isPresent()) {
			return Observable.just(tipoCambioDb.get());
		}else {
			throw  new ResourceNotFoundException("No se encontro el tipo de cambio con ID: " + id);
		}
	}

	@Override
	public void eliminarTipoCambio(Long id) {
		
		Optional<TipoCambio> tipoCambioDb = this.tipoCambioRepository.findById(id);

		if(tipoCambioDb.isPresent()) {
			this.tipoCambioRepository.delete(tipoCambioDb.get());
		}else {
			throw  new ResourceNotFoundException("No se encontro el tipo de cambio con ID: " + id);
		}
	}
	
	@Override
	public Observable<TipoCambio> aplicarTipoCambio(TipoCambio tipoCambio) {
		List<TipoCambio> lista = tipoCambioRepository.listAll(tipoCambio.getMonedaOrigen(), tipoCambio.getMonedaDestino());
		
		if(lista.isEmpty()) {
			throw  new ResourceNotFoundException("No se encontro el tipo de cambio");
		}
		
		TipoCambio resultado = lista.get(0);		
		resultado.setMontoOrigen(tipoCambio.getMontoOrigen());
		resultado.setMontoDestino(tipoCambio.getMontoOrigen().multiply(resultado.getTipoCambio()));
		
		return Observable.just(resultado);
	}

}
