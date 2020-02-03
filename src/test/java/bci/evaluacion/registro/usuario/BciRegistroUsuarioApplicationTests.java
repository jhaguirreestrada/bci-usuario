package bci.evaluacion.registro.usuario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import bci.evaluacion.registro.usuario.controller.UsuarioController;

@RunWith(SpringRunner.class)
@SpringBootTest
class BciRegistroUsuarioApplicationTests {
	
	@Autowired
	private UsuarioController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		
	}

}
