package com.pizzeria.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzeria.modelo.CompraVO;
@Repository
public interface CompraRepository extends JpaRepository<CompraVO, Integer> {

	CompraVO findById(int id);
}
