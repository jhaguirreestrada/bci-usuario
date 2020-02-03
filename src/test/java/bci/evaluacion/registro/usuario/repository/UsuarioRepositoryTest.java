package bci.evaluacion.registro.usuario.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import bci.evaluacion.registro.usuario.model.entity.Usuario;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Test
    public void saveUsuario() {
		Date fecha = new Date();
		Usuario usuario = new Usuario("Test 1", "test@prueba.cl", "Hunter3", null, fecha, fecha, fecha, 1);
		entityManager.persistAndFlush(usuario);
        assertThat(usuario.getId()).isNotNull();
	}
}
