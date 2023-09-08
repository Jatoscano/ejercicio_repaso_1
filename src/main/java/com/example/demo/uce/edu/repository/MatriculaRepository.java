package com.example.demo.uce.edu.repository;

import java.math.BigDecimal;

import com.example.demo.uce.edu.repository.model.Matricula;

public interface MatriculaRepository {

	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula seleccionar(BigDecimal valor);
	public void eliminar(BigDecimal valor);
}
