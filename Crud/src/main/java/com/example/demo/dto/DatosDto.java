package com.example.demo.dto;

import java.io.Serializable;

public class DatosDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String telefono;
	private Integer idPais;
	private Integer idBanco;
	private Integer idPersona;
	private String tipo_tarjeta;
	private String monto;
	
	public Integer getIdBanco() {
		return idBanco;
	}
	
	public DatosDto() {
		super();
	}

	public DatosDto(Integer id, String nombre, String apellido, String telefono, Integer idPais, Integer idBanco,
			Integer idPersona, String tipo_tarjeta, String monto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.idPais = idPais;
		this.idBanco = idBanco;
		this.idPersona = idPersona;
		this.tipo_tarjeta = tipo_tarjeta;
		this.monto = monto;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getTipo_tarjeta() {
		return tipo_tarjeta;
	}

	public void setTipo_tarjeta(String tipo_tarjeta) {
		this.tipo_tarjeta = tipo_tarjeta;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	} 
}
