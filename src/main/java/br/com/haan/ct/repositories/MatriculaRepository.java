package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.DescricaoModalidadeQuantidadeAluno;
import br.com.haan.ct.entities.Matricula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula,Long >{
    
    @Query( value = "SELECT mod.descricao as descricaoModalidade, COUNT(mat.id) as quantidadeAluno FROM matricula mat INNER JOIN turma tur ON mat.turma_id = tur.id INNER JOIN modalidade mod ON tur.modalidade_id = mod.id GROUP BY mat.modalidade_id, mod.descricao", nativeQuery = true)
    public Iterable<DescricaoModalidadeQuantidadeAluno> numeroMatriculasPorModalidade();

    @Query(value = "SELECT graduacao.nivel, COUNT(matricula.id) AS matriculas_ativas, modalidade.descricao as descricaoModalidade FROM graduacao INNER JOIN matricula ON graduacao.aluno_id = matricula.aluno_id inner join modalidade on modalidade.id = graduacao.modalidade_id inner join turma on turma.modalidade_id = modalidade.id where matricula.situacao = 'ativa' GROUP BY graduacao.nivel , modalidade.id", nativeQuery = true)
    public Iterable<DescricaoModalidadeQuantidadeAluno> numeroMatriculasPorGraduacao();
}