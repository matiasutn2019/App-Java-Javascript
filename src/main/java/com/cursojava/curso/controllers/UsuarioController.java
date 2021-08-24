package com.cursojava.curso.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
	public Usuario getUsuario(@PathVariable Long id) {
		Usuario usuario = new Usuario();
		return usuario;
	}
	
	@RequestMapping(value = "api/usuarios")
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();		
		return usuarioDao.getUsuarios();
	}
	
	@RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		usuarioDao.eliminar(id);		
	}
}
