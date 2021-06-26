package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Banco;
import com.example.demo.Model.Datos;
import com.example.demo.Model.Pais;
import com.example.demo.dao.PersonaResponse;
import com.example.demo.dto.DatosDto;
import com.example.demo.exceptions.DatosNoEncontradosException;
import com.example.demo.repository.repo.PersonaRepo;

import commons.AppConstans;

@Service
@Component
public class PersonaService{
	@Autowired
	private RestTemplate clienteRest;
	@Autowired
	private Environment env;
	@Autowired
	private PersonaRepo repo;

	
	
	public PersonaResponse create(Datos persona){
	PersonaResponse nuevap = null;
	try {
		if(persona.getNombre() == null || persona.getNombre().isEmpty()) {		
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_NOMBRE_MSG));
		}
		if(persona.getApellido() == null || persona.getApellido().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_APELLIDO_MSG));
		}
		if(persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_TELEFONO_MSG));
		}
		if(persona.getPais().getNombre() == null || persona.getPais().getNombre().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_NOMBREPAIS_MSG));
		}
		if(persona.getPais().getCodigo() == null || persona.getPais().getCodigo().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_CODIGOPAIS_MSG));
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
		throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
												env.getProperty(AppConstans.ERROR_SERVICIOSAVE_MSG));
	}
			return nuevap;
	}
	
	public void edit(Datos persona) {
		try {
			if(persona.getNombre() == null || persona.getNombre().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_NOMBRE_MSG));
			}
			if(persona.getApellido() == null || persona.getApellido().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_APELLIDO_MSG));
			}
			if(persona.getTelefono() == null || persona.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_TELEFONO_MSG));
			}
			if(persona.getPais().getNombre() == null || persona.getPais().getNombre().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_NOMBREPAIS_MSG));
			}
			if(persona.getPais().getCodigo() == null || persona.getPais().getCodigo().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_CODIGOPAIS_MSG));
			}
			repo.save(persona);
		}
		catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_SERVICIOEDIT_MSG));
	}
}
	
	
	
	
	
	
	public PersonaResponse create(DatosDto dto){
	PersonaResponse nuevap = null;
	try {
		if(dto.getNombre() == null || dto.getNombre().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_NOMBRE_MSG));
		}
		if(dto.getApellido() == null || dto.getApellido().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_APELLIDO_MSG));
		}
		if(dto.getTelefono() == null || dto.getTelefono().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_TELEFONO_MSG));
		}
		if(dto.getIdPais() == null || dto.getIdPais().equals(0)) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_IDPAIS_MSG));
		}
		if(dto.getTipo_tarjeta() == null || dto.getTipo_tarjeta().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_TIPOTARG_MSG));
		}
		if(dto.getSaldo() == null || dto.getSaldo().isEmpty()) {
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
													env.getProperty(AppConstans.ERROR_SALDO_MSG));
		}
		
		//seteos a la clase Datos
		Datos d = new Datos();
		d.setId(dto.getIdDatos());
		d.setNombre(dto.getNombre());
		d.setApellido(dto.getApellido());
		d.setTelefono(dto.getTelefono());
		
		//mandando a llamar a mi clase pais para pasarle el objeto a mi clase Datos
		Pais p = new Pais();
		p.setId(dto.getIdPais());
		d.setPais(p);
		
		Datos resp = repo.save(d);
		
		//Integracion con el RestTeplate
		Banco b = new Banco();
		b.setId(dto.getIdBanco());
		b.setTipoTarjeta(dto.getTipo_tarjeta());
		b.setSaldo(dto.getSaldo());
		b.setIdpersona(d);
		
		
		
		clienteRest.postForEntity("http://localhost:8001/banco/agregar",b,Banco.class);
		 
	}catch (DatosNoEncontradosException exc ) {
		throw exc;
	}catch (Exception e) {
		e.printStackTrace();
		throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
												env.getProperty(AppConstans.ERROR_SERVICIOSAVE_MSG));
	}
			return nuevap;
	}
	
	
	public void edit(DatosDto dto) {
		try {
			if(dto.getNombre() == null || dto.getNombre().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_NOMBRE_MSG));
			}
			if(dto.getApellido() == null || dto.getApellido().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_APELLIDO_MSG));
			}
			if(dto.getTelefono() == null || dto.getTelefono().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_TELEFONO_MSG));
			}
			if(dto.getIdPais() == null || dto.getIdPais().equals(0)) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_IDPAIS_MSG));
			}
			if(dto.getTipo_tarjeta() == null || dto.getTipo_tarjeta().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_TIPOTARG_MSG));
			}
			if(dto.getSaldo() == null || dto.getSaldo().isEmpty()) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_SALDO_MSG));
			}
			
			//seteos a la clase Datos
			Datos d = new Datos();
			d.setId(dto.getIdDatos());
			d.setNombre(dto.getNombre());
			d.setApellido(dto.getApellido());
			d.setTelefono(dto.getTelefono());
			
			//mandando a llamar a mi clase pais para pasarle el objeto a mi clase Datos
			Pais p = new Pais();
			p.setId(dto.getIdPais());
			d.setPais(p);
			
			Datos resp = repo.save(d);
			
			//Integracion con el RestTeplate
			Banco b = new Banco();
			b.setId(dto.getIdBanco());
			b.setTipoTarjeta(dto.getTipo_tarjeta());
			b.setSaldo(dto.getSaldo());
			b.setIdpersona(d);
			
			String url = "http://localhost:2021/planillas/editar";
		    Map<String, Integer> param = new HashMap<>();
		    param.put("id", b.getId());
		    clienteRest.put(url, b, param);
		}
		catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_SERVICIOEDIT_MSG));
	}
}
		
	
	public  List<Datos> getAllPersonas(){
		List<Datos> listar = null;
		try {
			listar = repo.getAllPersonas();
			
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_SERVICIOLIST_MSG));
		}
		return listar;
	}
		
	public void delete (Integer id) {
		try {
			if(id <= 0 || id.equals(null)) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_IDNULL_MSG));
		}
			repo.delete(id);
		}catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_SERVICIODELETE_MSG));
	}
	}
	
	public Optional<Datos> findById(Integer id) {
		Optional<Datos> listp = null;
		try {
			if(id <= 0 || id.equals(null)) {
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
														env.getProperty(AppConstans.ERROR_NUMPOSITIVOS_MSG));
			}
			listp = repo.findById(id);
			if(listp == null ) {
				//TERMINAR 156
				throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_CAMPOVACIO_COD),
						env.getProperty(AppConstans.ERROR_NUMPOSITIVOS_MSG));
			}
		}
		catch (DatosNoEncontradosException exc ) {
			throw exc;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
													env.getProperty(AppConstans.ERROR_SERVICIOBISCARID_MSG));
		}
		return listp;
	}
	
	
	
//	public Datos edit(DatosDto dto) {
//		Optional<Datos> edit = repo.findById(dto.getIdDatos());
//		Datos editados = null;
//		try {
//			if(dto.getNombre() != null && !dto.getNombre().isEmpty()) {
//				edit.get().setNombre(dto.getNombre());
//			}
//			if(dto.getApellido() != null && !dto.getApellido().isEmpty()) {
//				edit.get().setApellido(dto.getApellido());
//			}
//			if(dto.getTelefono() != null && !dto.getTelefono().isEmpty()) {
//				edit.get().setTelefono(dto.getTelefono());
//			}
//			if(dto.getIdPais() != null && !dto.getIdPais().equals(0)) {
//				Pais nuevop = new Pais();
//				nuevop.setId(dto.getIdPais());
//				edit.get().setPais(nuevop);
//			}
//			editados = repo.save(edit.get());
//		}
//		catch (DatosNoEncontradosException exc ) {
//			throw exc;
//		}catch (Exception e){
//			e.printStackTrace();
//			throw new DatosNoEncontradosException(env.getProperty(AppConstans.ERROR_SERVICIOSAVE_COD),
//														env.getProperty(AppConstans.ERROR_SERVICIOEDIT_MSG));
//	}
//		return editados;
//}
}
