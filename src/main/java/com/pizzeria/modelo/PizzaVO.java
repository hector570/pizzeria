package com.pizzeria.modelo;


import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Table(name = "pizza")
public class PizzaVO {

  @Id
  @Column(name = "idpizza", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, name = "sabor", length = 25)
  private String sabor;

  @Column(nullable = false, name = "precio", length = 25)
  private Integer precio;

  @Column(nullable = false, name = "tiempo", length = 25)
  private Integer tiempoPreparado;
  

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getSabor() {
	return sabor;
}

public void setSabor(String sabor) {
	this.sabor = sabor;
}

public Integer getPrecio() {
	return precio;
}

public void setPrecio(Integer precio) {
	this.precio = precio;
}

public Integer getTiempoPreparado() {
	return tiempoPreparado;
}

public void setTiempoPreparado(Integer tiempoPreparado) {
	this.tiempoPreparado = tiempoPreparado;
}


public PizzaVO(Integer id, String sabor, Integer precio, Integer tiempoPreparado) {
	super();
	this.id = id;
	this.sabor = sabor;
	this.precio = precio;
	this.tiempoPreparado = tiempoPreparado;
}

public PizzaVO(String sabor, Integer precio, Integer tiempoPreparado) {
	super();
	this.sabor = sabor;
	this.precio = precio;
	this.tiempoPreparado = tiempoPreparado;
}

public PizzaVO() {
}

public int getCantidad() {
	// TODO Auto-generated method stub
	return 0;
}

}
