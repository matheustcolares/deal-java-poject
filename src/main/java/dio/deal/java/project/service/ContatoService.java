package dio.deal.java.project.service;

import java.util.List;

import dio.deal.java.project.model.Contato;

public interface ContatoService {
	Contato findById(Long id);
	
	Contato create(Contato contato);
	
	List<Contato> findAll();
	
	void delete(Long id);
}
