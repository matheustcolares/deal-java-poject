package dio.deal.java.project.service;

import java.util.List;

import dio.deal.java.project.model.Grupo;

public interface GrupoService {
	Grupo findById(Long id);
	
	Grupo create(Grupo gurpo);
	
	List<Grupo> findAll();
	
	void delete(Long id);
	
	void addContactToGroup(Long contact_id,Long group_id);
}
