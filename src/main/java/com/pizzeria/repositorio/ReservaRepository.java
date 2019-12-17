package com.pizzeria.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pizzeria.modelo.ReservaVO;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaVO, Integer> {

	@Query("select a from ReservaVO a where a.idsesion = ?1")
	ReservaVO findBySession(String  idsesion);

}
