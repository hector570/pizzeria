package com.pizzeria.modelo;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "compras")
public class CompraVO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date fecha;
    private Double total;

    @ManyToOne
    private UsuarioVO cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public UsuarioVO getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioVO cliente) {
        this.cliente = cliente;
    }

}