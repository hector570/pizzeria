package com.pizzeria.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pizzeria.modelo.PizzaVO;

public interface ServicioPizza {


	<S extends PizzaVO> S save(S entity);


    public PizzaVO getById(int idProducto);

    
	<S extends PizzaVO> Optional<S> findOne(Example<S> example);


	Page<PizzaVO> findAll(Pageable pageable);

	List<PizzaVO> findAll();

	List<PizzaVO> findAll(Sort sort);

	Optional<PizzaVO> findById(Integer id);

	List<PizzaVO> findAllById(Iterable<Integer> ids);

	<S extends PizzaVO> List<S> saveAll(Iterable<S> entities);

	boolean existsById(Integer id);

	void flush();

	<S extends PizzaVO> S saveAndFlush(S entity);

	void deleteInBatch(Iterable<PizzaVO> entities);

	<S extends PizzaVO> Page<S> findAll(Example<S> example, Pageable pageable);

	long count();

	void deleteAllInBatch();

	void deleteById(Integer id);

	PizzaVO getOne(Integer id);

	void delete(PizzaVO entity);

	<S extends PizzaVO> long count(Example<S> example);

	void deleteAll(Iterable<? extends PizzaVO> entities);

	<S extends PizzaVO> List<S> findAll(Example<S> example);

	<S extends PizzaVO> boolean exists(Example<S> example);

	void deleteAll();

	<S extends PizzaVO> List<S> findAll(Example<S> example, Sort sort);
	

}