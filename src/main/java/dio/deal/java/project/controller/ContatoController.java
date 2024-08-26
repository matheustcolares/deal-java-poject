package dio.deal.java.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.deal.java.project.model.Contato;
import dio.deal.java.project.service.impl.ContatoServiceImpl;

@RestController
@RequestMapping(value = "/contato")
public class ContatoController {
	
	@Autowired
	ContatoServiceImpl service;
	
	@PostMapping
	public ResponseEntity<Contato> save(@RequestBody Contato contato){
		
		return new ResponseEntity<Contato>(service.create(contato), HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<Contato>> getAllContact(){
		
		return new ResponseEntity<List<Contato>>(service.findAll(), HttpStatus.CREATED);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> getContact(@PathVariable Long id){
		
		return new ResponseEntity<Contato>(service.findById(id), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable Long id){
		try {
			service.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao deletar",HttpStatus.BAD_REQUEST);
		}
		return  new ResponseEntity<String>("Contato Deletado",HttpStatus.OK);
		
	}

}
