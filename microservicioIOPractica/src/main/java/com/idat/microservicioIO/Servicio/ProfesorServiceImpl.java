package com.idat.microservicioIO.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.microservicioIO.Repository.ProfesorRepository;
import com.idat.microservicioIO.modelo.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public List<Profesor> listarProfesor() {
		// TODO Auto-generated method stub
		return  repository.findAll();
	}
	
	@Override
	public Profesor ProfesorById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public void editarProfesor(Profesor p) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(p);
	}
	
	@Override
	public void eliminarProfesor(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
	
	@Override
	public void guardarProfesor(Profesor p) {
		Profesor profesor = new Profesor();
		profesor.setIdProfesor(p.getIdProfesor());
		profesor.setNombreProfesor(p.getNombreProfesor());
		profesor.setApellidoProfesor(p.getApellidoProfesor());
		repository.save(profesor);
	}
}
