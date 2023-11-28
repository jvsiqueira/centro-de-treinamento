package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.entities.AlunoDoenca;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.AlunoService;
import br.com.haan.ct.services.AlunoDoencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoDoencaController {
    
    
    @Autowired
    private AlunoDoencaService alunoDoencaService;

    @GetMapping("/numeroDoencaPorModalidade")
    public  Iterable < DescricaoDoencaQuantidadeModalidade > numeroDoencaPorModalidade (){
        return  alunoDoencaService.numeroDoencaPorModalidade();
    }
    
    @GetMapping("/alunoDoencas")
    public Iterable<AlunoDoenca> listar(){
        return alunoDoencaService.listar();
    }
    
    @PostMapping("/alunoDoencas")
    public ResponseEntity<?> salvar (@RequestBody AlunoDoenca alunoDoenca){
        return alunoDoencaService.salvar(alunoDoenca,"Salvar");
    }
    
    @PutMapping("/alunoDoencas/{id}")
    public ResponseEntity<?> atualizar (@RequestBody AlunoDoenca alunoDoenca){
        return alunoDoencaService.salvar(alunoDoenca,"Atualizar");
    }
    
    @DeleteMapping("/alunoDoencas/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return alunoDoencaService.remover(id);
    }
}
