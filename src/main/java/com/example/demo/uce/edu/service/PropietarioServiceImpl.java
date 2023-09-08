package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.PropietarioRepository;
import com.example.demo.uce.edu.repository.model.Propietario;

@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Override
	public void registrar(Propietario propietario) {
		
		System.out.println("Estamos verificando datos...");
		this.propietarioRepository.insertar(propietario);
		System.out.println("Propietario registrado...");
	}

	@Override
	public void guardar(Propietario propietario) {
		
		System.out.println("Se esta realizando las actualizaciones...");
		this.propietarioRepository.actualizar(propietario);
		System.out.println("Cambios realizados de manera correcta....");
	}

	@Override
	public Propietario buscar(String cedula) {
		
		System.out.println("Se estan buscando el Propietario correspondiente...");
		System.out.println("Busqueda Finalizada...");
		return this.propietarioRepository.seleccionar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		
		System.out.println("Estamos realizando la transaccion correspondiente...");
		this.propietarioRepository.eliminar(cedula);
		System.out.println("Transaccion Finalizada");
	}

}
