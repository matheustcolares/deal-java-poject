package dio.deal.java.project.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dio.deal.java.project.model.Contato;
import dio.deal.java.project.model.Grupo;
import dio.deal.java.project.repository.ContatoRepository;
import dio.deal.java.project.repository.GrupoRepository;
import dio.deal.java.project.service.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService {
	
	private final GrupoRepository grupoRepository;
	
	private final ContatoRepository contatoRepository;
	
	public GrupoServiceImpl(GrupoRepository grupoRepository, ContatoRepository contatoRepository) {
		this.grupoRepository = grupoRepository;
		this.contatoRepository = contatoRepository;
	}

	@Override
	public Grupo findById(Long id) {
		return grupoRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Grupo create(Grupo grupo) {
		return grupoRepository.save(grupo);
	}

	@Override
	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		grupoRepository.deleteById(id);
		
	}

	@Override
	public void addContactToGroup(Long contact_id, Long group_id) {
		Contato contato = contatoRepository.findById(contact_id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));
		Grupo grupo = grupoRepository.findById(group_id).orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
		
		contato.getGrupos().add(grupo);
		grupo.addContato(contato);
		
		grupoRepository.save(grupo);
		//contatoRepository.save(contato);
		
	}

}
