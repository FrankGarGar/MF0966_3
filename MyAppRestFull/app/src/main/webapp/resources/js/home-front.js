$(document).ready(function(e){
	$(".fa-heart").click(function(e){
		if($(this).hasClass("far")){
			$(this).removeClass("far tb").addClass("fas tr");
			
		}else{
			$(this).removeClass("fas tr").addClass("far tb");
		}
		
	});
	$(".ican").change(function(e){
		'use strict';
		var cantidad = $(this).val();
		var precio = parseFloat($(this).data("price").replace(",",".")).toFixed(2);
		var total = parseFloat(parseFloat(precio).toFixed(2)*cantidad).toFixed(2);
		$(".total-price").html(total);
	});
	
});
function validate() {
	console.log("s");
    var res = confirm("¿Está seguro que desea eliminar este libro de su carrito?")
    if(res){
    	return true;
    }else{
    	return false;
    }

}