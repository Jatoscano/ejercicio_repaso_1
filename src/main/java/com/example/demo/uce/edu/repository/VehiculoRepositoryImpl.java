package com.example.demo.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements VehiculoRepository{

	private static List<Vehiculo> baseDatos = new ArrayList<>();
	@Override
	public void insertar(Vehiculo vehiculo) {
		
		this.baseDatos.add(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.eliminar(vehiculo.getPlaca());
		this.insertar(vehiculo);;
		
	}

	@Override
	public Vehiculo seleccionar(String placa) {
	
		Vehiculo vehiculoEncontrado = new Vehiculo();
		for(Vehiculo vehiculo : baseDatos) {
			if(placa.equals(vehiculo.getPlaca())) {
				vehiculoEncontrado = vehiculo;
			}
		}
		return vehiculoEncontrado;
	}

	@Override
	public void eliminar(String placa) {
		
		Vehiculo vehiculo = this.seleccionar(placa);
		this.baseDatos.remove(vehiculo);
	}

}
