 package com.pizzeria.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizzeria.modelo.DetalleCompraVO;
import com.pizzeria.modelo.PizzaVO;
import com.pizzeria.modelo.ReservaVO;
import com.pizzeria.servicios.ServiceCompra;
import com.pizzeria.servicios.ServiceReserva;
import com.pizzeria.servicios.ServicioPizza;
import com.pizzeria.utils.PageUtils;
import com.pizzeria.utils.Rutas;
import com.pizzeria.utils.Utils;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired
	ServicioPizza servicioPizza;
	
	@Autowired
	ServiceReserva sR;
	
	
	@RequestMapping
	public String lista(Model model, @RequestParam(required = false) String error,HttpSession sesion,@RequestParam(required = false) Integer pagina) {
		String cadena =sesion.getId();
		String sSubCadena = cadena.substring(0,10);
		if(sR.findBySession(sSubCadena)!=null) {
			model.addAttribute("reserva", sR.findBySession(sesion.getId()));
			
			//si la pagina es null cargamos la primera
			if (pagina == null) pagina = 1;
			
			//(desde que pagina, tamaño por pagina, criterio de busqueda)
			//(el primer parametro hay que poner menos 1 para que coja el numero de pagina bien)
			Page<ReservaVO> page = sR.findAll(PageRequest.of(pagina - 1, Utils.PAGESIZE, Sort.by("fecha")));
			
			//obtenemos el numero de paginas en las que se puede dividir la lista
	        model.addAttribute("pageNumberss", PageUtils.getNumPaginas(page));
			model.addAttribute("listaa", page);
			
			return Rutas.CARPETA_RESERVAS + "muestraReserva";
		}
		else {
			ReservaVO reserva = new ReservaVO();
			model.addAttribute("reserva", reserva);
			return Rutas.CARPETA_RESERVAS + "reserva";
		}
	}
	
	@RequestMapping("/add")
	public String verReserva(@RequestParam String fecha,@RequestParam LocalTime hora,@RequestParam int comensales, Model model,HttpSession sesion) {
		String cadena =sesion.getId();
		String sSubCadena = cadena.substring(0,10);
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fech = LocalDate.parse(fecha);
		ReservaVO r = new ReservaVO(sSubCadena, fech, hora, comensales);
		
		sR.save(r);
		
		return Rutas.CARPETA_RESERVAS + "muestraReserva";
	}
	
}
