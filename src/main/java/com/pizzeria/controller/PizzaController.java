 package com.pizzeria.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.pizzeria.servicios.ServiceCompra;
import com.pizzeria.servicios.ServicioPizza;
import com.pizzeria.utils.PageUtils;
import com.pizzeria.utils.Rutas;
import com.pizzeria.utils.Utils;

@Controller
@RequestMapping("/pedidos")
public class PizzaController {
	
	@Autowired
	ServicioPizza servicioPizza;
	
	@Autowired
	ServiceCompra servicioCompra;
	
	
	@RequestMapping
	public String lista(Model model, @RequestParam(required = false) String error,
			@RequestParam(required = false) Integer pagPiz, @RequestParam(required = false) Integer pagDes,HttpSession sesion) {
		
		//si la pagina es null cargamos la primera
		if (pagPiz == null) pagPiz = 1;
		
		//(desde que pagina, tamaño por pagina, criterio de busqueda)
		//(el primer parametro hay que poner menos 1 para que coja el numero de pagina bien)
		Page<PizzaVO> page = servicioPizza.findAll(PageRequest.of(pagPiz - 1, Utils.PAGESIZE, Sort.by("sabor")));
		
		//obtenemos el numero de paginas en las que se puede dividir la lista
        model.addAttribute("pageNumbers", PageUtils.getNumPaginas(page));
		model.addAttribute("lista", page);
		model.addAttribute("error", error);
		
		
		//si la pagina es null cargamos la primera
		if (pagDes == null) pagDes = 1;
		Page<DetalleCompraVO> page2 = servicioCompra.findAll(PageRequest.of(pagDes - 1, Utils.PAGESIZE));
		
		//obtenemos una lista con todos el carrito
		List<DetalleCompraVO> lCarrito =  servicioCompra.listAll();
		for (int i =0;i<lCarrito.size();i++)
		{
			if(lCarrito.get(i).getIdsesion()!= sesion.getId())
			{
				lCarrito.remove(i);
			}
		}
		model.addAttribute("carrito", page2);
		
		return Rutas.CARPETA_PIZZAS + "listaPizza";
	}
	
	@RequestMapping("/add")
	public String eliminaAlumno(@RequestParam int pizza, Model model,HttpSession sesion,@RequestParam(required = false) Integer pagina
			,@RequestParam(required = false) Integer pagPiz, @RequestParam(required = false) Integer pagDes) {
		String resultado;
		
		PizzaVO p = servicioPizza.getById(pizza);
		
		DetalleCompraVO det = new DetalleCompraVO(1, p.getPrecio(), p.getPrecio(),  sesion.getId(), p.getSabor());
		
		servicioCompra.save(det);
		
		
		
		//obtenemos una lista con todos el carrito
		List<DetalleCompraVO> lCarrito =  servicioCompra.listAll();
		for (int i =0;i<lCarrito.size();i++)
		{
			if(lCarrito.get(i).getIdsesion()== sesion.getId() && lCarrito.get(i).getSabor()==p.getSabor())
			{
				lCarrito.get(i).setCantidad(lCarrito.get(i).getCantidad());
			}
			else {
				DetalleCompraVO dete = new DetalleCompraVO(0, p.getPrecio(), p.getPrecio(),  sesion.getId(), p.getSabor());
				
				servicioCompra.save(dete);
			}
		}
		
		//si la pagina es null cargamos la primera
				if (pagPiz == null) pagPiz = 1;
				
				//(desde que pagina, tamaño por pagina, criterio de busqueda)
				//(el primer parametro hay que poner menos 1 para que coja el numero de pagina bien)
				Page<PizzaVO> page = servicioPizza.findAll(PageRequest.of(pagPiz - 1, Utils.PAGESIZE, Sort.by("sabor")));
				
				//obtenemos el numero de paginas en las que se puede dividir la lista
		        model.addAttribute("pageNumbers", PageUtils.getNumPaginas(page));
				model.addAttribute("lista", page);
				
				
				//si la pagina es null cargamos la primera
				if (pagDes == null) pagDes = 1;
				Page<DetalleCompraVO> page2 = servicioCompra.findAll(PageRequest.of(pagDes - 1, Utils.PAGESIZE));
				
				//obtenemos una lista con todos el carrito
				List<DetalleCompraVO> lCarritos =  servicioCompra.listAll();
				for (int i =0;i<lCarritos.size();i++)
				{
					if(lCarritos.get(i).getIdsesion()!= sesion.getId())
					{
						lCarritos.remove(i);
					}
				}
				model.addAttribute("carrito", page2);
		
		return Rutas.CARPETA_PIZZAS + "listaPizza";
	}
	@RequestMapping("/pedido")
	public String aceptado(Model modelo)
	{
		return Rutas.CARPETA_PIZZAS +"pedido";
	}
}
