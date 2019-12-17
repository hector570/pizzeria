package com.pizzeria.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;

public class PageUtils {

	//devuelve una lista desde el 1 y hasta el numero total de paginas que tiene el objeto Page que se le pasa como paremtro
	//si por ejemplo tiene 5 paginas devolveria una lista de enteros [1,2,3,4,5]
	//si el objeto no tiene paginas devuelve una lista vacia
	public static <T> List<Integer> getNumPaginas(Page<T> page) {
				
		List<Integer> pageNumbers = new ArrayList<Integer>();
		
		int totalPages = page.getTotalPages();
        if (totalPages > 0) {
        	
        	//genera un array de numeros entre 1 y el numero de paginas
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
        }
        
        return pageNumbers;
	}
	
}
