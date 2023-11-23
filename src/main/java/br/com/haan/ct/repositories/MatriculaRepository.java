package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.DescricaoModalidadeQuantidadeAluno;
import br.com.haan.ct.entities.Matricula;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula,Long >{
    
    @Query(value = "SELECT modalidade.descricao as descricaoModalidade, COUNT(matricula.id) as quantidadeAluno  FROM matricula, modalidade, turma where   matricula.turma_id = turma.id   and turma.modalidade_id = modalidade.id   GROUP BY  modalidade.descricao", nativeQuery = true)
    public Iterable<DescricaoModalidadeQuantidadeAluno> numeroMatriculasPorModalidade();
    
}
