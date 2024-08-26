package dio.deal.java.project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_group")
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "grupos")
	private List<Contato> contact_list;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contato> getContact_list() {
		return contact_list;
	}

	public void setContact_list(List<Contato> contact_list) {
		this.contact_list = contact_list;
	}
	public void addContato(Contato contato) {
	    this.contact_list.add(contato);
	    contato.getGrupos().add(this);
	}
	
}
