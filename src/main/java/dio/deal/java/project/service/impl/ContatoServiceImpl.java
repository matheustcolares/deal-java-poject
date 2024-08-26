package dio.deal.java.project.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import dio.deal.java.project.model.Contato;
import dio.deal.java.project.repository.ContatoRepository;
import dio.deal.java.project.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService{

	private final ContatoRepository contatoRepository;
	
	public ContatoServiceImpl(ContatoRepository contatoRepostitory) {
		this.contatoRepository = contatoRepostitory;
	}
	
	@Override
	public Contato findById(Long id) {
		// TODO Auto-generated method stub
		return contatoRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Contato create(Contato contato) {
		// TODO Auto-generated method stub
		return contatoRepository.save(contato);
	}

	@Override
	public List<Contato> findAll() {
		// TODO Auto-generated method stub
		return contatoRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		contatoRepository.deleteById(id);
	}
	

}
