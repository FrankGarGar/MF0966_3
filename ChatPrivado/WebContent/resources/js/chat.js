$(document).ready(function(){
	var userlog = $("#bienvenida").attr("user");
	var cant=$("#all-mj .mm").length;
	var activo = true;
	var usertochat=0;
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
			//Al presionar enter deberia enviarse el mensaje
			//$("#send-pm button[type='submit']").click();
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
		var msj=$("#send-pm #mensaje").val();
		cant = $("#all-mj .mm").length;
		
		if(msj!=""){
			if(activo){
				$.post("autenticado/chat",{msj:msj,cant:cant})
				.done(function(data2) {
					if(data2!="2"){
						$("#send-pm")[0].reset();
						var mensajes = JSON.parse(data2);
						var name,clase;
						$.each(mensajes, function(idx, msj) {
							
							if(msj.usuario.username===userlog){
								clase="message2";
								name= " Tu";
							}else{
								clase="message";
								name= " " + msj.usuario.username;
							}
							$("#all-mj").append('<p class="' + clase + ' mm"><span class="info"><span class="fecha">'+ msj.fecha +'</span><span class="username">'+ name +'</span></span>' + msj.mensaje + '</p>');
						});
					}
				}).fail(function() {});
			}else{
				$.post("autenticado/chat",{msj:msj,cant:cant,userchat:usertochat})
				.done(function(data2) {
					if(data2!="2"){
						$("#send-pm")[0].reset();
						var mensajes = JSON.parse(data2);
						var name,clase;
						$.each(mensajes, function(idx, msj) {
							
							if(msj.usuario.username===userlog){
								clase="message2";
								name= " Tu";
							}else{
								clase="message";
								name= " " + msj.usuario.username;
							}
							$("#all-mj").append('<p class="' + clase + ' mm"><span class="info"><span class="fecha">'+ msj.fecha +'</span><span class="username">'+ name +'</span></span>' + msj.mensaje + '</p>');
						});
					}
				}).fail(function() {});
			}
		}
		
		
	});
	window.setInterval(function(){
		if(activo){
			cant = $("#all-mj .mm").length;
			console.log(cant);
			$.post("autenticado/chat",{cant:cant,recarga:true})
			.done(function(data2) {
				if(data2!="2"){
					var mensajes = JSON.parse(data2);
					var name,clase;
					$.each(mensajes, function(idx, msj) {
						
						if(msj.usuario.username===userlog){
							clase="message2";
							name= " Tu";
						}else{
							clase="message";
							name= " " + msj.usuario.username;
						}
						$("#all-mj").append('<p class="' + clase + ' mm"><span class="info"><span class="fecha">'+ msj.fecha +'</span><span class="username">'+ name +'</span></span>' + msj.mensaje + '</p>');
					});
					
					
				}else{
					console.log(data2);
				}
				
			}).fail(function() {
			    
			});
		}
	}, 10000);
	$(".li-user").click(function(){
		var nombre = $(this).find(".username").html();
		activo=false;
		if(usertochat!=$(this).data("user")){
			usertochat= $(this).data("user");
			$.post("autenticado/chat",{recarga:true,userchat:usertochat})
			.done(function(data2) {
				if(data2==="[]"){
					$("#all-mj").empty();
					$("#all-mj").append("<h2>Chat vacio. Escrible un mensaje a "+ nombre + "</h2>");
				}else{
					
					$("#send-pm")[0].reset();
					$("#all-mj").empty();
					var mensajes = JSON.parse(data2);
					var name,clase;
					$.each(mensajes, function(idx, msj) {	
						if(msj.usuario.username===userlog){
							clase="message2";
							name= " Tu";
						}else{
							clase="message";
							name= " " + msj.usuario.username;
						}
						
						$("#all-mj").append('<p class="' + clase + ' mm"><span class="info"><span class="fecha">'+ msj.fecha +'</span><span class="username">'+ name +'</span></span>' + msj.mensaje + '</p>');
					});
				}
			}).fail(function() {
			});
		}
	});
	$(".li-all-users").click(function(){
		activo=true;
		if(usertochat!=$(this).data("user")){
			usertochat= $(this).data("user");
			$.post("autenticado/chat",{recarga:true,cant:0})
			.done(function(data2) {
				if(data2!="2"){
					$("#send-pm")[0].reset();
					$("#all-mj").empty();
					var mensajes = JSON.parse(data2);
					var name,clase;
					$.each(mensajes, function(idx, msj) {
						
						if(msj.usuario.username===userlog){
							clase="message2";
							name= " Tu";
						}else{
							clase="message";
							name= " " + msj.usuario.username;
						}
						$("#all-mj").append('<p class="' + clase + ' mm"><span class="info"><span class="fecha">'+ msj.fecha +'</span><span class="username">'+ name +'</span></span>' + msj.mensaje + '</p>');
					});
				}
			}).fail(function() {});
		}
		
		
		
	});
	
});