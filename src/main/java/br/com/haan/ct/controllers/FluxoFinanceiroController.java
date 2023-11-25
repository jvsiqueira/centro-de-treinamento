package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.FluxoFinanceiro;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.FluxoFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class FluxoFinanceiroController {
    @Autowired
    private FluxoFinanceiroService fluxoFinanceiroService;

    @GetMapping("/financeiro")
    public Iterable<FluxoFinanceiro> listar(){
        return fluxoFinanceiroService.listar();
    }

    @PostMapping("/financeiro")
    public ResponseEntity<?> salvar (@RequestBody FluxoFinanceiro fluxo){
        return fluxoFinanceiroService.salvar(fluxo,"Salvar");
    }

    @PutMapping("/financeiro")
    public ResponseEntity<?> atualizar (@RequestBody FluxoFinanceiro fluxo){
        return fluxoFinanceiroService.salvar(fluxo,"Atualizar");
    }

    @DeleteMapping("/financeiro/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return fluxoFinanceiroService.remover(id);
    }
}
