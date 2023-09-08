package com.example.demo.uce.edu.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.MatriculaRepository;
import com.example.demo.uce.edu.repository.PropietarioRepository;
import com.example.demo.uce.edu.repository.VehiculoRepository;
import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.Propietario;
import com.example.demo.uce.edu.repository.model.Vehiculo;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Autowired
	@Qualifier("pesado")
	private CobroService cobro;
	
	@Override
	public void registrar(Matricula matricula) {
		System.out.println("Estamos verificando datos...");
		this.matriculaRepository.insertar(matricula);
		System.out.println("Matricula realizada...");
	}

	@Override
	public void guardar(Matricula matricula) {
		System.out.println("Se esta realizando las actualizaciones...");
		this.matriculaRepository.actualizar(matricula);
		System.out.println("Cambios realizados de manera correcta....");
	}

	@Override
	public Matricula buscar(BigDecimal valor) {
		System.out.println("Se estan buscando la Matricula correspondientes...");
		System.out.println("Busqueda Finalizada...");
		return this.matriculaRepository.seleccionar(valor);
	}

	@Override
	public void eliminar(BigDecimal valor) {
		System.out.println("Estamos realizando la transaccion correspondiente...");
		this.matriculaRepository.eliminar(valor);
		System.out.println("Transaccion Finalizada");
	}

	@Override
	public void crearMatricula(String cedula, String placa, BigDecimal valor) {
		
		//1. Colocamos la cedula del propietario y la seleccionamos
		System.out.println("Estamos detectando el propietario correspondiente...");
		Propietario propietario = this.propietarioRepository.seleccionar(cedula);
		String cedulaPropietario = propietario.getCedula();
		System.out.println("Propietario encontrado..."+ propietario);
		
		//2. Colcoamos la placa del vehiculo y la seleccionamos
		System.out.println("Estamos detectando el vechiculo correspondiente...");
		Vehiculo vehiculo = this.vehiculoRepository.seleccionar(placa);
		String placaVehiculo = vehiculo.getPlaca();
		System.out.println("Vehiculo encontrado..."+ vehiculo);
		
		//3. Accedemos al proceso de la matricula
		System.out.println("Estamos realizando la transaccion correspondiente....");
		Matricula matricula = this.matriculaRepository.seleccionar(valor);
		BigDecimal valorMatricula = matricula.getValor();
		System.out.println("Valor de la Matricula: "+valorMatricula.round(MathContext.DECIMAL32));
		
		//4. Se realiza la transaccion de cobro
		BigDecimal cobroMatricula = this.cobro.calcular(valor);
		
		if(valor.compareTo(valorMatricula)< 2000) {
			
			//4.1 Realizamos la operacion extra para el descuento
			BigDecimal descuento = valorMatricula.multiply(new BigDecimal(0.07));
			BigDecimal valorDescuento = valorMatricula.subtract(descuento);
			matricula.setValor(valorDescuento);
			
			System.out.println("Descuento: "+matricula.getValor().round(MathContext.DECIMAL32));
			
			//4.2. Se accede y se debita el valor con su respectivo descuento
			BigDecimal valorDescuento2 = valorMatricula.subtract(cobroMatricula);
			matricula.setValor(valorDescuento2);
			BigDecimal valorCobro = valorDescuento.subtract(valorDescuento2);
			matricula.setValor(valorCobro);
			this.matriculaRepository.actualizar(matricula);
			
			
			//4.3. Creamos la matricula respectiva
			Matricula matriculaOficial = new Matricula();
			matriculaOficial = matricula;
			matriculaOficial.setCedula(propietario);
			matriculaOficial.setPlaca(vehiculo);
			matriculaOficial.setFechaMatricula(LocalDateTime.now());
			matriculaOficial.setValor(valorCobro.round(MathContext.DECIMAL32));
			this.matriculaRepository.insertar(matriculaOficial);
			System.out.println("Transaccion realizada correctamente..."+ matriculaOficial);
			System.out.println("Matricula a Cobrar: "+matriculaOficial.getValor().round(MathContext.DECIMAL32));
		}
		else {
			
			//4.1. Se accede y se debita el valor con su respectivo descuento
			
			matricula.setValor(cobroMatricula);
			this.matriculaRepository.actualizar(matricula);
			
			
			//4.2. Creamos la matricula respectiva
			Matricula matriculaOficial = new Matricula();
			matriculaOficial = matricula;
			matriculaOficial.setCedula(propietario);
			matriculaOficial.setPlaca(vehiculo);
			matriculaOficial.setFechaMatricula(LocalDateTime.now());
			matriculaOficial.setValor(cobroMatricula.round(MathContext.DECIMAL32));
			this.matriculaRepository.insertar(matriculaOficial);
			System.out.println("Transaccion realizada correctamente..."+ matriculaOficial);
			System.out.println("Matricula a Cobrar: "+matriculaOficial.getValor().round(MathContext.DECIMAL32));
		}
	}

}
