package bci.evaluacion.registro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bci.evaluacion.registro.usuario.model.entity.Telefono;

/**
 * Clase de repositorio de Telefono.
 */
@Repository
public interface ITelefonoRepository extends JpaRepository<Telefono, Long> {
	
}
