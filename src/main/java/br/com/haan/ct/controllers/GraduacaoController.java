package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Graduacao;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.GraduacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GraduacaoController {
    
    
    @Autowired
    private GraduacaoService graduacaoService;
    
    @GetMapping("/graduacao")
    public Iterable<Graduacao> listar(){
        return graduacaoService.listar();
    }
    
    @PostMapping("/graduacao")
    public ResponseEntity<?> salvar (@RequestBody Graduacao graduacao){
        return graduacaoService.salvar(graduacao,"Salvar");
    }
    
    @PutMapping("/graduacao/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Graduacao graduacao){
        return graduacaoService.salvar(graduacao,"Atualizar");
    }
    
    @DeleteMapping("/graduacao/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return graduacaoService.remover(id);
    }
}
