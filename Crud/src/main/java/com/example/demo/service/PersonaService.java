package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Datos;
import com.example.demo.Model.Pais;
import com.example.demo.dao.PersonaResponse;
import com.example.demo.dto.DatosDto;
import com.example.demo.exceptions.DatosNoEncontradosException;
import com.example.demo.exceptions.ResponseEntityExceptions;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.repo.PersonaRepo;
import com.example.demo.rest.PersonaREST;

@Service
@Component
public class PersonaService{
	@Autowired
	private PersonaRepo repo;

	public PersonaResponse create(Datos persona){
	PersonaResponse nuevap = null;
	try {
		if(persona.getNombre() == null || persona.getNombre().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR NOMBRE NO PEDE QUEDAR VACIO");
		}
		if(persona.getApellido() == null || persona.getApellido().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR APELLIDO NO PEDE QUEDAR VACIO");
		}
		if(persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO");
		}
		if(persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO VACIO");
		}
		if(persona.getPais().getNombre() == null || persona.getPais().getNombre().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR NOMBRE DEL PAIS NO PEDE QUEDAR VACIO");
		}
		if(persona.getPais().getCodigo() == null || persona.getPais().getCodigo().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR CODIGO DEL PAIS NO PEDE QUEDAR VACIO");
		}
		Datos resp = repo.save(persona);
		nuevap = new PersonaResponse();
		nuevap.setId(resp.getId());
		nuevap.setNombre(resp.getNombre());
		nuevap.setApellido(resp.getApellido());
		nuevap.setTelefono(resp.getTelefono());
		nuevap.setNombrePais(resp.getPais().getNombre());
		nuevap.setCodigoPais(resp.getPais().getCodigo());
	}catch (DatosNoEncontradosException exc ) {
		throw exc;
	}catch (Exception e) {
		e.printStackTrace();
		throw new DatosNoEncontradosException("409", "Error en el servicio ingresar datos");
	}
			return nuevap;
	}
	
	public PersonaResponse create(DatosDto dto){
	PersonaResponse nuevap = null;
	try {
		if(dto.getNombre() == null || dto.getNombre().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR NOMBRE NO PEDE QUEDAR VACIO");
		}
		if(dto.getApellido() == null || dto.getApellido().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR APELLIDO NO PEDE QUEDAR VACIO");
		}
		if(dto.getTelefono() == null || dto.getTelefono().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO");
		}
		if(dto.getTelefono() == null || dto.getTelefono().isEmpty()) {
			throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO VACIO");
		}
		if(dto.getIdPais() == null || dto.getIdPais().equals(0)) {
			throw new DatosNoEncontradosException("400","ERROR NOMBRE DEL PAIS NO PEDE QUEDAR VACIO");
		}
		Datos nuevos = new Datos();
		Pais paisnew = new Pais();
		
		nuevos.setNombre(dto.getNombre());
		nuevos.setApellido(dto.getApellido());
		nuevos.setTelefono(dto.getTelefono());
		paisnew.setId(dto.getIdPais());
		nuevos.setPais(paisnew);
		
		Datos resp = repo.save(nuevos);
		nuevap = new PersonaResponse();
		nuevap.setId(resp.getId());
		nuevap.setNombre(resp.getNombre());
		nuevap.setApellido(resp.getApellido());
		nuevap.setTelefono(resp.getTelefono());
		nuevap.setNombrePais(resp.getPais().getNombre());
		nuevap.setCodigoPais(resp.getPais().getCodigo());
	}catch (DatosNoEncontradosException exc ) {
		throw exc;
	}catch (Exception e) {
		e.printStackTrace();
		throw new DatosNoEncontradosException("409", "Error en el servicio ingresar datos");
	}
			return nuevap;
	}
		
	public  List<Datos> getAllPersonas(){
		List<Datos> listar = null;
		try {
			listar = repo.getAllPersonas();
			
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio optener npersonas");
		}
		return listar;
	}
		
	public void delete (Integer id) {
		try {
			if(id <= 0 || id.equals(null)) {
			throw new DatosNoEncontradosException("ERROR EL ID NO EXISTE");
		}
			repo.delete(id);
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio eliminar");
	}
	}
	
	public Optional<Datos> findById(Integer id) {
		Optional<Datos> listp = null;
		try {
			if(id <= 0 || id.equals(null)) {
				throw new DatosNoEncontradosException("400","ERROR debe ingresar numeros positivos");
			}
			listp = repo.findById(id);
		}
		catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio buscar por ID");
		}
		return listp;
	}
	
	public void edit(Datos persona) {
		try {
			if(persona.getNombre() == null || persona.getNombre().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR NOMBRE NO PEDE QUEDAR VACIO");
			}
			if(persona.getApellido() == null || persona.getApellido().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR APELLIDO NO PEDE QUEDAR VACIO");
			}
			if(persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO");
			}
			if(persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR TELEFONO NO PEDE QUEDAR VACIO VACIO");
			}
			if(persona.getPais().getNombre() == null || persona.getPais().getNombre().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR NOMBRE DEL PAIS NO PEDE QUEDAR VACIO");
			}
			if(persona.getPais().getCodigo() == null || persona.getPais().getCodigo().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR CODIGO DEL PAIS NO PEDE QUEDAR VACIO");
			}
			repo.save(persona);
		}
		catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio editar");
	}
}
	
	public void edit(DatosDto dto) {
		repo.findById(dto.getId());
		try {
			if(dto.getId() <= 0 || dto.getId() == null) {
				throw new DatosNoEncontradosException("400","ID NO VALIDO ");
			}
			if(dto.getNombre() != null || dto.getNombre().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR NOMBRE ESTA VACIO");
			}
			if(dto.getApellido() != null || dto.getApellido().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR APELLIDO ESTA VACIO");
			}
			if(dto.getTelefono() != null || dto.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR TELEFONO ESTA VACIO");
			}
			if(dto.getTelefono() != null || dto.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException("400","ERROR TELEFONO ESTA VACIO");
			}
			if(dto.getIdPais() != null || dto.getIdPais().equals(0)) {
				throw new DatosNoEncontradosException("400","ERROR NOMBRE DEL PAIS NO ESTA VACIO");
			}
			Datos editados = new Datos();
			Pais paisnew = new Pais();
			editados.setId(dto.getId());
			editados.setNombre(dto.getNombre());
			editados.setApellido(dto.getApellido());
			editados.setTelefono(dto.getTelefono());
			paisnew.setId(dto.getIdPais());
			editados.setPais(paisnew);
			
			repo.save(editados);
		}
		catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException("409", "Error en el servicio editar");
	}
}
}
