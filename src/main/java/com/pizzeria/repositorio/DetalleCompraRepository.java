package com.pizzeria.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzeria.modelo.DetalleCompraVO;
@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompraVO, Integer> {
}
