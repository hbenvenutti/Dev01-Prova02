package br.ifrs.edu.restinga.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Cozinha;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class CadastroCozinha {
	//consulta cozinhas
	//método - Listar todas as instâncias cozinha que foram encontradas
	//retorno: list 
	//entrada: nada
	
	//responsável pela gerência de persistência no JPA
	//ou seja, responsável pela tradução java vs sql
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> listar(){
	//query criada - retornando uma lista tipada 
	TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
		
	//retorna lista das cozinhas
	return query.getResultList();	
		
	}
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	
	//esta classe busca um objeto no banco pelo id
	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	
	@Transactional
	public void remover(Cozinha cozinha) {
		//find 
		 cozinha = buscar(cozinha.getId());
		 manager.remove(cozinha);
	}
	
	

}
