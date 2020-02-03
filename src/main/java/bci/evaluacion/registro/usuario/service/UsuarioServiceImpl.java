package bci.evaluacion.registro.usuario.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bci.evaluacion.registro.usuario.model.entity.Telefono;
import bci.evaluacion.registro.usuario.model.entity.Usuario;
import bci.evaluacion.registro.usuario.repository.ITelefonoRepository;
import bci.evaluacion.registro.usuario.repository.IUsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Autowired
	private ITelefonoRepository  telefonoRepository;
	
	@Override
	public void RegistraUsuario(Usuario usuario) throws Exception{
	
		//se realiza la validacion que exista correo
		if(!validaCorreo(usuario.getEmail())){
			
			//generacion de token en base al correo y nombre
			final Instant now = Instant.now();
			 
		    final String jwt = Jwts.builder()
		        .setSubject(usuario.getEmail())
		        .setIssuedAt(Date.from(now))
		        .setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
		        .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(usuario.getName()))
		        .compact();
			
			Date fecha = new Date();
			usuario.setCreated(fecha);
			usuario.setLastLogin(fecha);
			usuario.setModified(fecha);
			usuario.setToken(jwt);
			usuario.setIsActive(1);
			saveUsuario(usuario);
		} else {
			throw new Exception("Correo ya registrado");
		}
	}
	
	private boolean validaCorreo(String correo) {
		boolean resultado = false;
		List<Usuario> listUsuarios = findAllUsuario();
		
		for (Usuario usuario: listUsuarios) {
			if(usuario.getEmail().equals(correo)) {
				resultado = true;
				System.out.println ("Error Correo:");
				break;
			}
		}
		
		return resultado;
		
	}
	
	@Override
	@Transactional
	public Usuario findOneUsuario(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public List<Usuario> findAllUsuario() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public void saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void saveTelefono(Telefono telefono) {
		telefonoRepository.save(telefono);
	}
	
	
	
}
