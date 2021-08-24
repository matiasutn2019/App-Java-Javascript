package com.cursojava.curso.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Getter @Setter
	private Long id;
	
	@Column(name = "nombre")
	@Getter @Setter
	private String nombre;
	
	@Column(name = "apellido")
	@Getter @Setter
	private String apellido;
	
	@Column(name = "email")
	@Getter @Setter
	private String email;
	
	@Column(name = "telefono")
	@Getter @Setter
	private String telefono;
	
	@Column(name = "password")
	@Getter @Setter
	private String password;

}
