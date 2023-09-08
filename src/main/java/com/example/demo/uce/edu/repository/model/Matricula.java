package com.example.demo.uce.edu.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Matricula {

	private LocalDateTime fechaMatricula;
	private BigDecimal valor;
	private Vehiculo placa;
	private Propietario cedula;
	
	//To String
	@Override
	public String toString() {
		return "Matricula [fechaMatricula=" + fechaMatricula + ", \nvalor=" + valor + ", \nplaca=" + placa + ", \ncedula="
				+ cedula + "]";
	}

	//Get and Set
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Vehiculo getPlaca() {
		return placa;
	}

	public void setPlaca(Vehiculo placa) {
		this.placa = placa;
	}

	public Propietario getCedula() {
		return cedula;
	}

	public void setCedula(Propietario cedula) {
		this.cedula = cedula;
	}
}
