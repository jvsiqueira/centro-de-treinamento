package br.com.haan.ct.repositories;

import br.com.haan.ct.entities.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends  CrudRepository<Aluno, Long>{
    
}
