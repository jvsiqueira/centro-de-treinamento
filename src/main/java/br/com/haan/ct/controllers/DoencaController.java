package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.entities.Doenca;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.AlunoService;
import br.com.haan.ct.services.DoencaService;
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
public class DoencaController {
    
    
    @Autowired
    private DoencaService doencaService;
    
    @GetMapping("/doencas")
    public Iterable<Doenca> listar(){
        return doencaService.listar();
    }
    
    @PostMapping("/doencas")
    public ResponseEntity<?> salvar (@RequestBody Doenca doenca){
        return doencaService.salvar(doenca,"Salvar");
    }
    
    @PutMapping("/doencas/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Doenca doenca){
        return doencaService.salvar(doenca,"Atualizar");
    }
    
    @DeleteMapping("/doencas/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return doencaService.remover(id);
    }
}
