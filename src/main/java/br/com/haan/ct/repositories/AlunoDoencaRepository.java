package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.DescricaoDoencaQuantidadeModalidade;
import br.com.haan.ct.entities.AlunoDoenca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoDoencaRepository extends  CrudRepository<AlunoDoenca, Long>{

    @Query( "SELECT m.descricao AS modalidade,COUNT(d.id) AS quantidade_doencas FROM modalidade m LEFT JOIN turma t ON m.id = t.modalidade_id LEFT JOIN graduacao g ON t.id = g.modalidade_id LEFT JOIN aluno a ON g.aluno_id = a.id LEFT JOIN alunodoenca ad ON a.id = ad.aluno_id LEFT JOIN doenca d ON ad.doenca_id = d.id GROUP BY m.descricao;" )
    
    
    public  Iterable <DescricaoDoencaQuantidadeModalidade> numeroDoencaPorModalidade();
    
}
