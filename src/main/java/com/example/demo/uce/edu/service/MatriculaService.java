package com.example.demo.uce.edu.service;

import java.math.BigDecimal;

import com.example.demo.uce.edu.repository.model.Matricula;

public interface MatriculaService {

	public void registrar(Matricula matricula);
	public void guardar(Matricula matricula);
	public Matricula buscar(BigDecimal valor);
	public void eliminar(BigDecimal valor);
	
	public void crearMatricula(String cedula, String placa, BigDecimal valor);
}
