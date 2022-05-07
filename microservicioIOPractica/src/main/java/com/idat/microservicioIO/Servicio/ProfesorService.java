package com.idat.microservicioIO.Servicio;

import java.util.List;

import com.idat.microservicioIO.modelo.Profesor;

public interface ProfesorService {

	public List<Profesor> listarProfesor();
	public Profesor ProfesorById(Integer id);
	public void editarProfesor(Profesor p);
	public void eliminarProfesor(Integer id);
	public void guardarProfesor(Profesor p);

}
