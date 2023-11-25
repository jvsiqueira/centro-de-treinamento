package br.com.haan.ct.repositories;

import br.com.haan.ct.entities.FluxoFinanceiro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FluxoFinanceiroRepository extends CrudRepository<FluxoFinanceiro,Long> {
}
