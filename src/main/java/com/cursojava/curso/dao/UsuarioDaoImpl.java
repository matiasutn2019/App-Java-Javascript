package com.cursojava.curso.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.models.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> getUsuarios() {
		String query = "FROM Usuario";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public void eliminar(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
	}

}
