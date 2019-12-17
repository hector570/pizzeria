package com.pizzeria.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pizzeria.modelo.PizzaVO;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaVO, Integer> {

	PizzaVO findById(int id);
}
