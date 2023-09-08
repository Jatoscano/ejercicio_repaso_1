package com.example.demo.uce.edu.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("pesado")
public class CobroPesadoServiceImpl implements CobroService{

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		
		BigDecimal valorPesado = valor.multiply(new BigDecimal(0.15));
		return  valor.subtract(valorPesado);
	}

}
