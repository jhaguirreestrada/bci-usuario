package bci.evaluacion.registro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bci.evaluacion.registro.usuario.model.entity.Usuario;

/**
 * Clase de repositorio de Usuario.
 */
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
