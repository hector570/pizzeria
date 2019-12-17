package com.pizzeria.serviciosImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pizzeria.modelo.PizzaVO;
import com.pizzeria.repositorio.PizzaRepository;
import com.pizzeria.repositorio.UsuarioRepository;
import com.pizzeria.servicios.ServicioPizza;

@Service
public class ServicioPizzaImpl implements ServicioPizza  {
	
	@Autowired
	PizzaRepository pr;
	
	@Autowired
	UsuarioRepository usuarioRepository;


	@Override
	public <S extends PizzaVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public <S extends PizzaVO> Optional<S> findOne(Example<S> example) {
		return pr.findOne(example);
	}

	@Override
	public Page<PizzaVO> findAll(Pageable pageable) {
		return pr.findAll(pageable);
	}

	@Override
	public List<PizzaVO> findAll() {
		return pr.findAll();
	}

	@Override
	public List<PizzaVO> findAll(Sort sort) {
		return pr.findAll(sort);
	}

	@Override
	public Optional<PizzaVO> findById(Integer id) {
		return pr.findById(id);
	}

	@Override
	public List<PizzaVO> findAllById(Iterable<Integer> ids) {
		return pr.findAllById(ids);
	}

	@Override
	public <S extends PizzaVO> List<S> saveAll(Iterable<S> entities) {
		return pr.saveAll(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return pr.existsById(id);
	}

	@Override
	public void flush() {
		pr.flush();
	}

	@Override
	public <S extends PizzaVO> S saveAndFlush(S entity) {
		return pr.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<PizzaVO> entities) {
		pr.deleteInBatch(entities);
	}

	@Override
	public <S extends PizzaVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return pr.findAll(example, pageable);
	}

	@Override
	public long count() {
		return pr.count();
	}

	@Override
	public void deleteAllInBatch() {
		pr.deleteAllInBatch();
	}

	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public PizzaVO getOne(Integer id) {
		return pr.getOne(id);
	}

	@Override
	public void delete(PizzaVO entity) {
		pr.delete(entity);
	}

	@Override
	public <S extends PizzaVO> long count(Example<S> example) {
		return pr.count(example);
	}

	@Override
	public void deleteAll(Iterable<? extends PizzaVO> entities) {
		pr.deleteAll(entities);
	}

	@Override
	public <S extends PizzaVO> List<S> findAll(Example<S> example) {
		return pr.findAll(example);
	}

	@Override
	public <S extends PizzaVO> boolean exists(Example<S> example) {
		return pr.exists(example);
	}

	@Override
	public void deleteAll() {
		pr.deleteAll();
	}

	@Override
	public <S extends PizzaVO> List<S> findAll(Example<S> example, Sort sort) {
		return pr.findAll(example, sort);
	}

	@Override
	public PizzaVO getById(int idProducto) {
		return pr.findById(idProducto);
	}

	
	
}
