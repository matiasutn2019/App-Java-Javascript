// Call the dataTables jQuery plugin
$(document).ready(function() {
	cargarUsuarios();
  	$('#usuarios').DataTable();
  	actualizarUsuario();
});

function actualizarUsuario() {
	document.getElementById('txt-usuario').outerHTML = localStorage.email;
}

async function cargarUsuarios() {
	const request = await fetch('api/usuarios', {
   		method: 'GET',
    	headers: {
      		'Accept': 'application/json',
      		'Content-Type': 'application/json',
   	  		'Authorization': localStorage.token
    	}
 	});
  	const usuarios = await request.json();
  	
  	let listadoHtml = '';  	
  	
  	for(usuario of usuarios) {
  		let botonEliminar = '<a href="#" onclick = "eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
  		let usuarioHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
  			+ usuario.email + '</td><td>' + botonEliminar + '</td></tr>';
  		listadoHtml += usuarioHtml;
  	}
 	
 	document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}
 	
async function eliminarUsuario(id) { 
	if(!confirm('¿Desea eliminar el usuario?')) {
		return;
	}	
	const request = await fetch('api/usuarios/' + id, {
		method: 'DELETE',
   		headers: {
      		'Accept': 'application/json',
   	  		'Content-Type': 'application/json',
   	  		'Authorization': localStorage.token
   		}
	}); 	
	location.reload();//actualiza la página para q se elimine el usuario de la table
}
