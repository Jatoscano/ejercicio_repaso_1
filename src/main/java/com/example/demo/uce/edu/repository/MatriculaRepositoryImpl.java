package com.example.demo.uce.edu.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Matricula;

@Repository
public class MatriculaRepositoryImpl implements MatriculaRepository{

	private static List<Matricula> baseDatos = new ArrayList<>();
	
	@Override
	public void insertar(Matricula matricula) {
		
		this.baseDatos.add(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		
		this.eliminar(matricula.getValor());
		this.insertar(matricula);
	}

	@Override
	public Matricula seleccionar(BigDecimal valor) {
		
		Matricula matriculaEncontrada = new Matricula();
		for(Matricula matricula : baseDatos) {
			if(valor.equals(matricula.getValor())) {
				matriculaEncontrada = matricula;
			}
		}
		return matriculaEncontrada;
	}

	@Override
	public void eliminar(BigDecimal valor) {
		
		Matricula matricula = this.seleccionar(valor);
		this.baseDatos.remove(matricula);
	}

}
