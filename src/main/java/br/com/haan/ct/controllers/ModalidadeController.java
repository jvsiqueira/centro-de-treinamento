package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.entities.Modalidade;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.AlunoService;
import br.com.haan.ct.services.ModalidadeService;
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
public class ModalidadeController {
    
    
    @Autowired
    private ModalidadeService modalidadeService;
    
    @GetMapping("/modalidades")
    public Iterable<Modalidade> listar(){
        return modalidadeService.listar();
    }
    
    @PostMapping("/modalidades")
    public ResponseEntity<?> salvar (@RequestBody Modalidade modalidade){
        return modalidadeService.salvar(modalidade,"Salvar");
    }
    
    @PutMapping("/modalidades/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Modalidade modalidade){
        return modalidadeService.salvar(modalidade,"Atualizar");
    }
    
    @DeleteMapping("/modalidades/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return modalidadeService.remover(id);
    }
}
