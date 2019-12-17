package com.pizzeria.servicios;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.pizzeria.modelo.ReservaVO;

public interface ServiceReserva {
    
    Page<ReservaVO> findAll(Pageable pageable);

    <S extends ReservaVO> S save(S entity);

	ReservaVO findBySession(String idsesion);
    
}
