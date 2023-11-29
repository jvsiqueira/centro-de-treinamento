package br.com.haan.ct.repositories;

import br.com.haan.ct.entities.FluxoFinanceiro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FluxoFinanceiroRepository extends CrudRepository<FluxoFinanceiro,Long> {
    @Query(value="SELECT ((SELECT SUM(valor) FROM fluxoFinanceiro WHERE tipoFluxo = 1) - (SELECT SUM(valor) FROM fluxoFinanceiro WHERE tipoFluxo = 0)) AS valorTotal From fluxoFinanceiro where MONTH(dataPagamento) = :mes limit 1;", nativeQuery = true)
    public double lucroPorMes(@Param("mes") int mes);
}
