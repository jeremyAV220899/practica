package com.idat.microservicioIO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.microservicioIO.Servicio.ProfesorService;
import com.idat.microservicioIO.modelo.Profesor;


@Controller
@RequestMapping("/profesor/v1")
public class ProfesorControler {
	
	@Autowired
	private ProfesorService service;
	
	@GetMapping(path = "/listar")
	public @ResponseBody List<Profesor> listar(){
		return service.listarProfesor();
	}
	
	@PostMapping(path = "/guardar")
	public @ResponseBody ResponseEntity<Profesor> guardar(Profesor p){
		service.guardarProfesor(p);
		return new ResponseEntity<Profesor>(HttpStatus.CREATED);
	}
	@DeleteMapping(path = "/eliminar/{id}")
	public @ResponseBody ResponseEntity<Profesor>  eliminar(Integer id){
		Profesor profesor = service.ProfesorById(id);
		if(profesor !=null) {
			service.eliminarProfesor(id);
			return new ResponseEntity<Profesor>(HttpStatus.OK);
		}
		return  new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
	}
    @PutMapping(path = "/editar")
    public @ResponseBody  ResponseEntity<Profesor> editar (Profesor p){
    	Profesor profesor = service.ProfesorById(p.getIdProfesor());
    	if(profesor !=null) {
    		service.editarProfesor(profesor);
    		return new ResponseEntity<Profesor>(HttpStatus.OK);
    	}
    	return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
    }
}
