package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Propietario;

public interface PropietarioService {

	public void registrar(Propietario propietario);
	public void guardar(Propietario propietario);
	public Propietario buscar(String cedula);
	public void borrar(String cedula);
}
