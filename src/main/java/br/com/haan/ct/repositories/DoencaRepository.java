package br.com.haan.ct.repositories;

import br.com.haan.ct.dto.DoencaMaisComum;
import br.com.haan.ct.entities.Doenca;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DoencaRepository extends CrudRepository<Doenca,Long >{
    @Query("SELECT doenca.descricao, COUNT(*) AS Comum FROM doenca JOIN alunodoenca ON alunodoenca.doenca_id = doenca.id GROUP BY doenca.id ORDER BY Comum DESC LIMIT 1")

    public Iterable<DoencaMaisComum> nomeDoencaMaiscomum();
}

