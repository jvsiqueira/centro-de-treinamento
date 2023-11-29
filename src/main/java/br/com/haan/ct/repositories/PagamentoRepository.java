package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.MensalidadePagas;
import br.com.haan.ct.dto.NomeAlunoEmDebito;
import br.com.haan.ct.entities.Pagamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

    @Query("SELECT aluno.nome, matricula.id, pagamento.valor  FROM aluno LEFT JOIN pagamento, matricula ON aluno.id = pagamento.id WHERE aluno.situacaomatricula = 'ativo'")
    public Iterable<MensalidadePagas> mensalidadePagasMensalidadeNaoPagas();
}
