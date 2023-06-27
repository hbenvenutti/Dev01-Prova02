package br.ifrs.edu.restinga.main;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.ifrs.edu.restinga.PersistenciaSpringApplication;
import br.ifrs.edu.restinga.domain.model.Cozinha;
import br.ifrs.edu.restinga.jpa.CadastroCozinha;

public class BuscaCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(PersistenciaSpringApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CadastroCozinha cadastroCozinha = 
				applicationContext.getBean(CadastroCozinha.class);
		

		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Japonesa");
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Uruguaia");
		
		cadastroCozinha.salvar(cozinha1);
		cadastroCozinha.salvar(cozinha2);

		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}		
}
