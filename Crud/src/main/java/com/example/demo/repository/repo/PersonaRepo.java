package com.example.demo.repository.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Datos;
import com.example.demo.exceptions.DatosNoEncontradosException;
import com.example.demo.repository.PersonaRepository;

import commons.AppConstans;

@Component
public class PersonaRepo {
	@Autowired
	private Environment env;
	@Autowired
	private PersonaRepository personaResporitory;
	
	public Datos save(Datos datosnuevo) {
		Datos guardar = null;
		try {
			guardar = personaResporitory.save(datosnuevo);
		}catch (Exception e) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_REPOSAVE_MSG));
		}
		return guardar;
	}
	
	public Optional<Datos> findById(Integer id){
		Optional<Datos> listid = null;
		try {
			listid = personaResporitory.findById(id);
		}catch (Exception e) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_REPOLISTID_MSG));
		}
		return listid;
	}
	
	public List<Datos> getAllPersonas(){
		List<Datos> listar = null;
		try {
			listar = personaResporitory.findAll();
		}catch (Exception e) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_REPOLIST_MSG));
		}
		return listar;
	}
	
	public void delete (Integer id) {
		try {
			personaResporitory.deleteById(id);
		}catch (Exception e) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_REPODELETE_MSG));
		}
	}
	
	public void edit(Datos persona) {
		try {
			personaResporitory.save(persona);
		}catch (Exception e) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_REPOEDIT_MSG));
		}
	}


}
