package curso.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Telefone;


@Repository
@Transactional
public interface TelefoneRepository extends CrudRepository <Telefone, Long>{
	
	//esse metodo retorna um telefone de acordo ao id da pessoa
	@Query("select t from Telefone t where t.pessoa.id = ?1")
	public List<Telefone> getTelefones(Long pessoaid);
}