$(function () {
	
	//filtro del dropdown para filtrar alumnos o cursos
	$("#filtro").keyup(function(){
		let value = $(this).val().toUpperCase();
		
		$(".dropdown-menu > a").filter(function() {
			$(this).toggle($(this).text().toUpperCase().includes(value));
		});
	});
	
	
	//comprueba que las dos contraseñas que se insertan al registrarse coinciden
	$("#formRegistro").submit(function (e) {
    	
        let pw = $("#pw");
        let pw2 = $("#pw2");
        
        if (pw.val() != pw2.val()) {

        	pw.val("");
        	pw2.val("");
        	
            $("#errorPws").show();
            
            return false;
            
        } else {
        	$("#errorPws").hide();
        }
    });
	
	
	//esto esta casi copiado y pegado de internet
	//declaras por que pagina quieres empezar y el numero de elementos por pagina y va ocultando
	//los tr dependiendo de la posicion
	$('.paginable').each(function() {
	    var currentPage = 0;
	    var numPerPage = 2;
	    var $table = $(this);
	    $table.bind('repaginate', function() {
	        $table.find('tbody tr:not(.cabecera)').hide().slice(currentPage * numPerPage, (currentPage + 1) * numPerPage).show();
	    });
	    $table.trigger('repaginate');
	    var numRows = $table.find('tbody tr:not(.cabecera)').length;
	    var numPages = Math.ceil(numRows / numPerPage);
	    var $pager = $('<div class="pager"></div>');
	    for (var page = 0; page < numPages; page++) {
	        $('<span class="page-number"></span>').text(page + 1).bind('click', {
	            newPage: page
	        }, function(event) {
	            currentPage = event.data['newPage'];
	            $table.trigger('repaginate');
	            $(this).addClass('active').siblings().removeClass('active');
	        }).appendTo($pager).addClass('clickable');
	    }
	    $pager.insertAfter($table).find('span.page-number:first').addClass('active');
	});
});