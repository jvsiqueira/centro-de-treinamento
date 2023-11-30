package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.MelhoresModalidades;
import br.com.haan.ct.entities.Pagamento;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PagamentoRepository extends CrudRepository<Pagamento,Long >{
    @Query(value = """
        select SUM(pag.valor) as valorPago, modd.descricao as descricaoModalidade 
        from pagamento as pag INNER JOIN matricula as mat on pag.matricula_id = mat.id 
        INNER JOIN turma as turm on mat.turma_id = turm.id 
        INNER JOIN modalidade as modd on turm.modalidade_id = modd.id 
        GROUP BY modd.id
        ORDER BY valorPago desc 
        LIMIT 10
            """, nativeQuery = true)
            public Iterable<MelhoresModalidades> melhoresModalidades();
}
