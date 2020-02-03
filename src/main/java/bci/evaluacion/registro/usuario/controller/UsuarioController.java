package bci.evaluacion.registro.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bci.evaluacion.registro.usuario.model.entity.Usuario;
import bci.evaluacion.registro.usuario.service.IUsuarioService;
import bci.evaluacion.registro.usuario.util.ExceptionUtil;

@RestController
@RequestMapping("/bci/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/registra")
    public ResponseEntity<?> registraUsuario(@RequestBody Usuario usuario) throws Exception {
        try {
        	usuarioService.RegistraUsuario(usuario);
        	return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
        	System.out.println ("Error:" + e.getMessage());
        	return new ResponseEntity<>(ExceptionUtil.getResponse(e, null),
                    ExceptionUtil.getExcepcion(e, null).getHttpStatus());
        }
    }
	
	@GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() throws Exception {
		  List<Usuario> listUsuarios;
        try {
        	listUsuarios = usuarioService.findAllUsuario();
        	return new ResponseEntity<>(listUsuarios, HttpStatus.OK);
        } catch (Exception e) {
        	return new ResponseEntity<>(ExceptionUtil.getResponse(e, null),
                    ExceptionUtil.getExcepcion(e, null).getHttpStatus());
        }
    }
}
