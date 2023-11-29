package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.NomeAlunoEmDebito;
import br.com.haan.ct.entities.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends  CrudRepository<Aluno, Long>{
    
    @Query("SELECT aluno.nome FROM aluno JOIN matricula ON aluno.id = matricula.aluno_id JOIN pagamento ON matricula.id = pagamento.matricula_id WHERE (pagamento.ano < YEAR(CURDATE())) OR (pagamento.ano = YEAR(CURDATE()) AND pagamento.mes < MONTH(CURDATE()));")
    public Iterable<NomeAlunoEmDebito> numeroMatriculaAlunosEmDebito();
}
