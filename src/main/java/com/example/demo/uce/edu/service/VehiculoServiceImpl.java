package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.VehiculoRepository;
import com.example.demo.uce.edu.repository.model.Vehiculo;

@Service
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Override
	public void registrar(Vehiculo vehiculo) {
		
		System.out.println("Estamos verificando datos...");
		this.vehiculoRepository.insertar(vehiculo);
		System.out.println("Vehiculo registrado...");
	}

	@Override
	public void guardar(Vehiculo vehiculo) {
		
		System.out.println("Se esta realizando las actualizaciones...");
		this.vehiculoRepository.actualizar(vehiculo);
		System.out.println("Cambios realizados de manera correcta....");
	}

	@Override
	public Vehiculo buscar(String placa) {
		
		System.out.println("Se estan buscando el Vehiculo correspondiente...");
		System.out.println("Busqueda Finalizada...");
		return this.vehiculoRepository.seleccionar(placa);
	}

	@Override
	public void borrar(String placa) {
		
		System.out.println("Estamos realizando la transaccion correspondiente...");
		this.vehiculoRepository.eliminar(placa);
		System.out.println("Transaccion Finalizada");
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo, String placa, String tipo) {
		//1. Ver el vechiculo anterior
		System.out.println("Vehiculo antes de la actualizacion: "+ vehiculo);
		
		//2. Creamos el vehiculo actualizado
		Vehiculo vehiculoActualizar = new Vehiculo();
		vehiculoActualizar = vehiculo;
		
		//3. Colocamos los datos a actualizar
		vehiculoActualizar.setPlaca(placa);
		vehiculoActualizar.setTipo(tipo);
		
	    //4. Registramos nuestro vehiculo actualizado 
		this.vehiculoRepository.insertar(vehiculoActualizar);
		System.out.println("Vehiculo Actualizado: "+ vehiculoActualizar);
	}
	
	

	
}
