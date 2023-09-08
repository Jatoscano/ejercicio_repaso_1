package com.example.demo.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Propietario;

@Repository
public class PropietarioRepositoryImpl implements PropietarioRepository{

	private static List<Propietario> baseDatos = new ArrayList<>();	
	
	@Override
	public void insertar(Propietario propietario) {
		
		this.baseDatos.add(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		
		this.eliminar(propietario.getCedula());
		this.insertar(propietario);
	}

	@Override
	public Propietario seleccionar(String cedula) {

		Propietario propietarioEncontrado = new Propietario();
		for(Propietario propietario : baseDatos) {
			if(cedula.equals(propietario.getCedula())) {
				propietarioEncontrado = propietario;
			}
		}
		return propietarioEncontrado;
	}

	@Override
	public void eliminar(String cedula) {
		
		Propietario propietario = this.seleccionar(cedula);
		this.baseDatos.remove(propietario);
	}

}
