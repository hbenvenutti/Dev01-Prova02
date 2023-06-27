package br.ifrs.edu.restinga.main;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.ifrs.edu.restinga.PersistenciaSpringApplication;
import br.ifrs.edu.restinga.domain.model.Cozinha;
import br.ifrs.edu.restinga.jpa.CadastroCozinha;

public class AtulizarCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(PersistenciaSpringApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = 
				applicationContext.getBean(CadastroCozinha.class);
		
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setId(1L);
		cozinha1.setNome("Australiana");

		cadastroCozinha.salvar(cozinha1);
		
		
	}		
}
