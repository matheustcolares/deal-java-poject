package dio.deal.java.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.deal.java.project.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
