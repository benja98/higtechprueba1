package com.example.demo.dto;

import java.io.Serializable;

public class DatosDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idDatos;
	private String nombre;
	private String apellido;
	private String telefono;
	private Integer idPais;
	
	private Integer idBanco;
	private String tipoTarjeta;
	private String saldo;
	private Integer idPersona;
	
	
	public DatosDto(Integer idDatos, String nombre, String apellido, String telefono, Integer idPais, Integer idBanco,
			String tipoTarjeta, String saldo, Integer idPersona) {
		super();
		this.idDatos = idDatos;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.idPais = idPais;
		this.idBanco = idBanco;
		this.tipoTarjeta = tipoTarjeta;
		this.saldo = saldo;
		this.idPersona = idPersona;
	}


	public DatosDto() {
		super();
	}


	public Integer getIdDatos() {
		return idDatos;
	}


	public void setIdDatos(Integer idDatos) {
		this.idDatos = idDatos;
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


	public Integer getIdBanco() {
		return idBanco;
	}


	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}


	public String getTipoTarjeta() {
		return tipoTarjeta;
	}


	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}


	public String getSaldo() {
		return saldo;
	}


	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}


	public Integer getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
