package com.example.demo.repository.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Datos;
import com.example.demo.dto.DatosDto;
import com.example.demo.exceptions.DatosNoEncontradosException;
import com.example.demo.repository.PersonaRepository;

@Component
public class PersonaRepo {
	@Autowired
	private PersonaRepository personaResporitory;
	
	public Datos save(Datos datosnuevo) {
		Datos guardar = null;
		try {
			guardar = personaResporitory.save(datosnuevo);
		}catch (Exception e) {
			throw new DatosNoEncontradosException("409", " ERROR AL GUARDAR ");
		}
		return guardar;
	}
	
	public Optional<Datos> findById(Integer id){
		Optional<Datos> listid = null;
		try {
			listid = personaResporitory.findById(id);
		}catch (Exception e) {
			throw new DatosNoEncontradosException("409", "ERROR AL EXTRAR DATOS POR ID ");
		}
		return listid;
	}
	
	public List<Datos> getAllPersonas(){
		List<Datos> listar = null;
		try {
			listar = personaResporitory.findAll();
		}catch (Exception e) {
			throw new DatosNoEncontradosException("409", " ERROR AL LISTAR ");
		}
		return listar;
	}
	
	public void delete (Integer id) {
		try {
			personaResporitory.deleteById(id);
		}catch (Exception e) {
			throw new DatosNoEncontradosException("409", " ERROR AL ELIMINAR ");
		}
	}
	
	public void edit(Datos persona) {
		try {
			personaResporitory.save(persona);
		}catch (Exception e) {
			throw new DatosNoEncontradosException("409", " ERROR AL ELIMINAR ");
		}
	}


}
