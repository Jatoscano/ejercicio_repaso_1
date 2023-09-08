package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Vehiculo;

public interface VehiculoRepository {

	public void insertar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
	public Vehiculo seleccionar(String placa);
	public void eliminar(String placa);
	
}
