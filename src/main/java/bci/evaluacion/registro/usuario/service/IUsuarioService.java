package bci.evaluacion.registro.usuario.service;

import java.util.List;

import bci.evaluacion.registro.usuario.model.entity.Telefono;
import bci.evaluacion.registro.usuario.model.entity.Usuario;

public interface IUsuarioService {
	
	public void RegistraUsuario(Usuario usuario) throws Exception;
	public Usuario findOneUsuario(Long id);
	public List<Usuario> findAllUsuario();
	public void saveUsuario(Usuario usuario);
	public void saveTelefono(Telefono telefono);
}
