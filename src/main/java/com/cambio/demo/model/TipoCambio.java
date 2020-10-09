package com.cambio.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipoCambio")
public class TipoCambio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "monedaOrigen")
	private String monedaOrigen;
	
	@Column(name = "monedaDestino")
	private String monedaDestino;
	
	@Column(name = "tipoCambio")
	private BigDecimal tipoCambio;
	
	private BigDecimal montoOrigen;
	private BigDecimal montoDestino;
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(BigDecimal tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public BigDecimal getMontoOrigen() {
		return montoOrigen;
	}
	public void setMontoOrigen(BigDecimal montoOrigen) {
		this.montoOrigen = montoOrigen;
	}
	public BigDecimal getMontoDestino() {
		return montoDestino;
	}
	public void setMontoDestino(BigDecimal montoDestino) {
		this.montoDestino = montoDestino;
	}
	
	
}
