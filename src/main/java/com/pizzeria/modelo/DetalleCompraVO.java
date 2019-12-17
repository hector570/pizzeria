package com.pizzeria.modelo;


import javax.persistence.*;

@Entity
@Table(name = "detalle")
public class DetalleCompraVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int cantidad;
    private int precio;
    private int total;
    private String idsesion;
    private String sabor;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}


	
	public DetalleCompraVO() {
		super();
	}

	public DetalleCompraVO(int cantidad, int precio, int total, String idsession,String sabor) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.total = total;
		this.idsesion=idsession;
		this.sabor=sabor;
	}

	public String getIdsesion() {
		return idsesion;
	}

	public void setIdsesion(String idsesion) {
		this.idsesion = idsesion;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

   
}