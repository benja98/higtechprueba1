package com.example.demo.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Datos;
import com.example.demo.dao.PersonaResponse;
import com.example.demo.dto.DatosDto;
import com.example.demo.exceptions.DatosNoEncontradosException;
import com.example.demo.exceptions.ResponseEntityExceptions;
import com.example.demo.service.PersonaService;

@RestController
@Service
@RequestMapping ("/api/persona")																	
public class PersonaREST{																			 
	@Autowired																	
	private PersonaService personaService;	
	@Autowired																					
	ResponseEntityExceptions responseExceptions;
	
	@PostMapping(value = "/datos")																					
	private ResponseEntity<?> guardar(@RequestBody Datos datos){
		PersonaResponse pservice  = null;
		ResponseEntity<?> response = null;																
		try {
			pservice = personaService.create(datos);
			response = responseExceptions.createOkResponse(pservice, "0", "ok");
		}catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409","error al ingresar datos");
		}
		 return response;
	}	
	
	@PostMapping(value = "/datos1")																					
	private ResponseEntity<?> guardar(@RequestBody DatosDto dto){
		PersonaResponse pservice  = null;
		ResponseEntity<?> response = null;																
		try {
			pservice = personaService.create(dto);
			response = responseExceptions.createOkResponse(pservice, "0", "ok");
		}catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409","error al ingresar datos");
		}
		 return response;
	}
	
	
	@GetMapping																										
	private ResponseEntity<List<PersonaResponse>> listarTodasLasPersona (){	
		
		List<Datos> temporal1 = personaService.getAllPersonas();	
		List<PersonaResponse> responseList = new ArrayList<>();
			for(Datos temporal : temporal1) 
			{
				PersonaResponse response = new PersonaResponse();
				response.setId(temporal.getId());
				response.setNombre(temporal.getNombre());
				response.setApellido(temporal.getApellido());
				response.setTelefono(temporal.getTelefono());
				response.setNombrePais(temporal.getPais().getNombre());
				response.setCodigoPais(temporal.getPais().getCodigo());
				responseList.add(response);
			}																							
		return ResponseEntity.ok(responseList);																																				
		}	
	
	@GetMapping (value = "/identificador")																	
	private ResponseEntity<Optional<Datos>> listarPersonasPorID (@RequestParam Integer id){
		ResponseEntity<Optional<Datos>> listarExcep = null;																
		try {
			listarExcep = responseExceptions.createOkResponse(null, "0", "ok");
		}catch (DatosNoEncontradosException e) {
			listarExcep = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			listarExcep = responseExceptions.createFailResponse(null, "409","error al buscar persona");
		}	
	return ResponseEntity.ok(personaService.findById(id));		
	}		
	
	@DeleteMapping(value = "/identificador1")																				
	private ResponseEntity<Void> eliminarPersona (@RequestParam Integer id){
		PersonaResponse pservice  = null;
		ResponseEntity<Void> response = null;	
	try {
		personaService.delete(id);
		responseExceptions.createOkResponse(pservice, "0", "ok");
	}catch (DatosNoEncontradosException e) {
		response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
	}catch (Exception e) {
		e.printStackTrace();
		response = responseExceptions.createFailResponse(null, "409","error al eliminar datos");
	}
	return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")																		
	private ResponseEntity<Void> edit(@RequestBody Datos datos){
		PersonaResponse pservice  = null;
		ResponseEntity<Void> response = null;																
		try {
			personaService.edit(datos);
			responseExceptions.createOkResponse(pservice, "0", "ok");
		}catch (DatosNoEncontradosException e) {
			response = responseExceptions.createFailResponse(null, e.getCod(), e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			response = responseExceptions.createFailResponse(null, "409","error al modificar datos");
		}
		 return response;															
	}
}