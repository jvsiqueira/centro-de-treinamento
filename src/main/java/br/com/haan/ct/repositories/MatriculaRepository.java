package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.DescricaoModalidadeQuantidadeAluno;
import br.com.haan.ct.entities.Matricula;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula,Long >{
    
    @Query("SELECT mod.descricao as descricaoModalidade, COUNT(mat.id) as quantidadeAluno FROM matricula mat INNER JOIN turma tur ON mat.turma_id = tur.id INNER JOIN modalidade mod ON tur.modalidade_id = mod.id GROUP BY mat.modalidade_id, mod.descricao")
    public Iterable<DescricaoModalidadeQuantidadeAluno> numeroMatriculasPorModalidade();
    
}
