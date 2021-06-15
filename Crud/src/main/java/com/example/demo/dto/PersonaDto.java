package com.example.demo.dto;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Model.Datos;
import com.example.demo.Model.Pais;
import com.example.demo.dao.PersonaResponse;
import com.example.demo.exceptions.DatosNoEncontradosException;
import com.example.demo.repository.repo.PersonaRepo;

public class PersonaDto  {

	@Autowired
	private PersonaRepo repo;

	public Datos create(DatosDto datosdto){
		Datos nuevap = null;
		try {
			if(datosdto.getNombre() == null || datosdto.getNombre().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR NOMBRE NO PEDE QUEDAR VACIO");
			}
			if(datosdto.getApellido() == null || datosdto.getApellido().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR APELLIDO NO PEDE QUEDAR VACIO");
			}
			if(datosdto.getTelefono() == null || datosdto.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO");
			}
			if(datosdto.getTelefono() == null || datosdto.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO VACIO");
			}
			if(datosdto.getNombrePais() == null || datosdto.getNombrePais().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR NOMBRE DEL PAIS NO PEDE QUEDAR VACIO");
			}
			if(datosdto.getNombrePais() == null || datosdto.getNombrePais().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR CODIGO DEL PAIS NO PEDE QUEDAR VACIO");
			}
			DatosDto resp = repo.save(datosdto);
			nuevap = new DatosDto();
			nuevap.setId(resp.getId());
			nuevap.setNombre(resp.getNombre());
			nuevap.setApellido(resp.getApellido());
			nuevap.setTelefono(resp.getTelefono());
			nuevap.setNombrePais(resp.getNombrePais());
			nuevap.setCodigoPais(resp.getCodigoPais());
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio ingresar datos");
		}
				return nuevap;
		}
}
