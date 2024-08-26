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

import dio.deal.java.project.model.Grupo;
import dio.deal.java.project.service.impl.GrupoServiceImpl;

@RestController
@RequestMapping(value = "/grupo")
public class GrupoController {

	@Autowired
	GrupoServiceImpl service;
	
	@PostMapping
	public ResponseEntity<Grupo> save(@RequestBody Grupo grupo){
		return new ResponseEntity<Grupo>(service.create(grupo),HttpStatus.OK);
	}
	
	@PostMapping(value = "/{grupoId}/contato/{contatoId}")
	public ResponseEntity<String>addContactToGroup(@PathVariable Long grupoId,@PathVariable Long contatoId){
		service.addContactToGroup(contatoId,grupoId);
		return new ResponseEntity<String>("Contato adicionado ao Grupo",HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Grupo>> getAll(){
		return new ResponseEntity<List<Grupo>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Grupo> getGroup(@PathVariable Long id){
		return new ResponseEntity<Grupo>(service.findById(id),HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			service.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao deletar",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Grupo Deletado",HttpStatus.OK);
		
	}
}
