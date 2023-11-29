package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.DescricaoModalidadePorIdade;
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

    
    @Query(value = """
                   SELECT
                     modalidade.descricao AS descricaoModalidade,
                     COUNT(matricula.id) AS quantidadeAluno,
                     CASE
                       WHEN TIMESTAMPDIFF(YEAR, aluno.dataNascimento, CURDATE()) BETWEEN 0 AND 10 THEN '0-10 anos'
                       WHEN TIMESTAMPDIFF(YEAR, aluno.dataNascimento, CURDATE()) BETWEEN 11 AND 20 THEN '11-20 anos'
                       WHEN TIMESTAMPDIFF(YEAR, aluno.dataNascimento, CURDATE()) BETWEEN 21 AND 30 THEN '21-30 anos'
                       WHEN TIMESTAMPDIFF(YEAR, aluno.dataNascimento, CURDATE()) BETWEEN 31 AND 40 THEN '31-40 anos'
                       ELSE 'Acima de 40 anos'
                     END AS faixaEtaria
                   FROM
                     modalidade
                     INNER JOIN matricula ON modalidade.id = matricula.modalidade_id
                     INNER JOIN graduacao ON matricula.id = graduacao.matricula_id
                     INNER JOIN aluno ON graduacao.aluno_id = aluno.id
                   WHERE
                     matricula.ativa = 1 -- filtra apenas as matr\u00edculas ativas
                   GROUP BY
                     modalidade.descricao,
                     faixaEtaria
                   ORDER BY
                     modalidade.descricao,
                     faixaEtaria""", nativeQuery = true)
    public Iterable<DescricaoModalidadePorIdade> descricaoModalidadePorIdade();
}
