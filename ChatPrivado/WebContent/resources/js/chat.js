$(document).ready(function(){
	//SI quitan el atributo disabled del boton de envio se vuelve a añadir
	var objDiv =  $("#chat");
    objDiv.scrollTop = objDiv.scrollHeight;
	setInterval(function(e){
		if($("#send-pm #mensaje").val()==""){
			$("#send-pm button[type='submit']").attr("disabled","disabled");
		}
	},1000);
	$("#send-pm #mensaje").on('keydown keypress change', function(e) {
		var attr = $("#send-pm button[type='submit']").attr('disabled');
		var val = $(this).val();
		var codigo = event.which || event.keyCode;
		if(codigo===13 && val.length>=1){
			$("#send-pm button[type='submit']").click();
		}else{
			
			if(codigo===8 && val.length===1){
				$("#send-pm button[type='submit']").attr("disabled","disabled");
			}else if(codigo!=8 && val.length===0){
				$("#send-pm button[type='submit']").removeAttr("disabled");
			}else{
				if(val!=""){
					if (typeof attr !== typeof undefined && attr !== false){
						$("#send-pm button[type='submit']").removeAttr("disabled");
					}
				}else{
					$("#send-pm button[type='submit']").attr("disabled","disabled");
				}
			}
		}
	});
	$("#send-pm").submit(function(e){
		e.preventDefault();
		msj=$("#send-pm #mensaje").val();
		if(msj!=""){
			$.post("autenticado/chat",{msj:msj},function(e){
				
			}).done(function(data2) {
				if(data2==="1"){
					//aplicar recarga de mensajes
					$( "#all-mj" ).load( "autenticado/chat",{recarga:1}, function() {
						  
					});
					$("#send-pm")[0].reset();
				}else{
					console.log(data2);
				}
				
			}).fail(function() {
			    
			});
		}
		
	});
});