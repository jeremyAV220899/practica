package com.idat.microservicioIO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.microservicioIO.modelo.Profesor;
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

}
