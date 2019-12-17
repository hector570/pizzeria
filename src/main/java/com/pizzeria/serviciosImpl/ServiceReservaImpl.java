package com.pizzeria.serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzeria.modelo.CompraVO;
import com.pizzeria.modelo.DetalleCompraVO;
import com.pizzeria.modelo.PizzaVO;
import com.pizzeria.modelo.ReservaVO;
import com.pizzeria.repositorio.CompraRepository;
import com.pizzeria.repositorio.DetalleCompraRepository;
import com.pizzeria.repositorio.ReservaRepository;
import com.pizzeria.servicios.ServiceCompra;
import com.pizzeria.servicios.ServiceReserva;
import com.pizzeria.servicios.ServicioPizza;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceReservaImpl implements ServiceReserva {

    @Autowired
    ReservaRepository rR;

	@Override
	public Page<ReservaVO> findAll(Pageable pageable) {
		
		return rR.findAll(pageable);
	}
	
	@Override
	public ReservaVO findBySession(String idsesion) {
		return rR.findBySession(idsesion);
	}

	@Override
	public <S extends ReservaVO> S save(S entity) {
		return rR.save(entity);
	}

   
}
