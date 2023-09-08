package com.example.demo.uce.edu.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service("liviano")
public class CobroLivianoServiceImpl implements CobroService{

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		
		BigDecimal valorLiviano = valor.multiply(new BigDecimal(0.1));
		return valor.subtract(valorLiviano);
	}

}
