package com.pizzeria.serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzeria.modelo.CompraVO;
import com.pizzeria.modelo.DetalleCompraVO;
import com.pizzeria.modelo.PizzaVO;
import com.pizzeria.repositorio.CompraRepository;
import com.pizzeria.repositorio.DetalleCompraRepository;
import com.pizzeria.servicios.ServiceCompra;
import com.pizzeria.servicios.ServicioPizza;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCompraImpl implements ServiceCompra {

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    DetalleCompraRepository detalleCompraRep;

    @Autowired
    ServicioPizza servicioPizza;

    @Override
    public List<CompraVO> getAll() {
        return compraRepository.findAll();
    }

    @Override
    public CompraVO getById(int idCompra) {
        return compraRepository.findById(idCompra);
    }

    @Override
    @Transactional(readOnly = false)
    public CompraVO save(CompraVO compra) {

        compra.setFecha(new Date());

        
        compraRepository.save(compra);

        
        return compra;
    }

	@Override
	public List<DetalleCompraVO> listAll() {
		return detalleCompraRep.findAll();
	}
	@Override
	public <S extends DetalleCompraVO> S save(S entity) {
		return detalleCompraRep.save(entity);
	}

	@Override
	public Page<DetalleCompraVO> findAll(Pageable pageable) {
		return detalleCompraRep.findAll(pageable);
	}
}
