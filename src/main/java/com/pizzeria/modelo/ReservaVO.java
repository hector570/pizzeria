package com.pizzeria.modelo;


import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "reserva")
public class ReservaVO {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(nullable = false, name = "idsesion",length=100000)
  private String idsesion;

  @Column(nullable = false, name = "fecha", length = 25)
  private LocalDate fecha;

  @Column(nullable = false, name = "hora", length = 25)
  private LocalTime hora;

  @Column(nullable = false, name = "comensales", length = 25)
  private Integer comensales;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public LocalDate getFecha() {
	return fecha;
}

public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}

public LocalTime getHora() {
	return hora;
}

public void setHora(LocalTime hora) {
	this.hora = hora;
}

public Integer getComensales() {
	return comensales;
}

public void setComensales(Integer comensales) {
	this.comensales = comensales;
}

public String getIdsesion() {
	return idsesion;
}

public void setIdsesion(String idsesion) {
	this.idsesion = idsesion;
}

public ReservaVO() {
	super();
}

public ReservaVO(Integer id, String idsesion, LocalDate fecha, LocalTime hora, Integer comensales) {
	super();
	this.id = id;
	this.idsesion = idsesion;
	this.fecha = fecha;
	this.hora = hora;
	this.comensales = comensales;
}

public ReservaVO(String idsesion, LocalDate fecha, LocalTime hora, Integer comensales) {
	super();
	this.idsesion = idsesion;
	this.fecha = fecha;
	this.hora = hora;
	this.comensales = comensales;
}


  


}
