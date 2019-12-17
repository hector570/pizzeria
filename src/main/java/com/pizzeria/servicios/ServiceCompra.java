package com.pizzeria.servicios;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pizzeria.modelo.CompraVO;
import com.pizzeria.modelo.DetalleCompraVO;

public interface ServiceCompra {
	
	public List<DetalleCompraVO> listAll();

    public List<CompraVO> getAll();

    public CompraVO getById(int idCompra);

    public CompraVO save(CompraVO compra);
    
    Page<DetalleCompraVO> findAll(Pageable pageable);

    <S extends DetalleCompraVO> S save(S entity);
    
}
