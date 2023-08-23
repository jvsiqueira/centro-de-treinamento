package br.com.haan.ct.repositories;

import br.com.haan.ct.entities.AlunoDoenca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoDoencaRepository extends  CrudRepository<AlunoDoenca, Long>{
    
}
