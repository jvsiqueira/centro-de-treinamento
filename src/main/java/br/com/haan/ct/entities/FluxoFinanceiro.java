package br.com.haan.ct.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
public class FluxoFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mensalidade_id;
    private LocalDate dataInserido;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private Double valor;
    @Getter @Setter
    private boolean tipoFluxo;
}
