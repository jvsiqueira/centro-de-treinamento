package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Turma;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.TurmaService;
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
public class TurmaController {
    
    
    @Autowired
    private TurmaService turmaService;
    
    @GetMapping("/turma")
    public Iterable<Turma> listar(){
        return turmaService.listar();
    }
    
    @PostMapping("/turma")
    public ResponseEntity<?> salvar (@RequestBody Turma turma){
        return turmaService.salvar(turma,"Salvar");
    }
    
    @PutMapping("/turma/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Turma turma){
        return turmaService.salvar(turma,"Atualizar");
    }
    
    @DeleteMapping("/turma/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return turmaService.remover(id);
    }
}
