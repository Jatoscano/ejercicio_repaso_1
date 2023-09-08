package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.Propietario;
import com.example.demo.uce.edu.repository.model.Vehiculo;
import com.example.demo.uce.edu.service.MatriculaService;
import com.example.demo.uce.edu.service.PropietarioService;
import com.example.demo.uce.edu.service.VehiculoService;

@SpringBootApplication
public class EjercicioRepaso1Application implements CommandLineRunner{

	@Autowired
	private VehiculoService vehiculoService;
	
	@Autowired
	private PropietarioService propietarioService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioRepaso1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Creamos un Vehiculo
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Toyota");
		vehiculo.setPlaca("ABC-123");
		vehiculo.setTipo("pesado");
		vehiculo.setPrecio(new BigDecimal(12000));
		
		this.vehiculoService.registrar(vehiculo);
		System.out.println("Vehiculo: "+ vehiculo);
		
		//Actualizamos el Vehiculo
		this.vehiculoService.actualizarVehiculo(vehiculo, "CDE-456", "liviano");
		
		//Creamos el Propietario
		Propietario propietario = new Propietario();
		propietario.setNombre("Fernando");
		propietario.setApellido("Avila");
		propietario.setCedula("1234567890");
		propietario.setFechaNacimiento(LocalDateTime.of(1996, 10, 31, 12, 0));
		
		this.propietarioService.registrar(propietario);
		System.out.println("Propietario: "+ propietario);
		
		//Realizacion de Matricula
		Matricula matricula = new Matricula();
		matricula.setCedula(propietario);
		matricula.setPlaca(vehiculo);
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValor(new BigDecimal(4000));
		
		this.matriculaService.registrar(matricula);
		this.matriculaService.crearMatricula("1234567890", "CDE-456", new BigDecimal(4000));
	}
	
	

}
