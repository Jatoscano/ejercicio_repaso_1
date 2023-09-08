package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Vehiculo;

public interface VehiculoService {

	public void registrar(Vehiculo vehiculo);
	public void guardar(Vehiculo vehiculo);
	public Vehiculo buscar(String placa);
	public void borrar(String placa);
	
	public void actualizarVehiculo(Vehiculo vehiculo, String placa, String tipo);
}
