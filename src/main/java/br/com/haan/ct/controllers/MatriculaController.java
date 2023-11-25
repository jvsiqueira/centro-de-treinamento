package br.com.haan.ct.controllers;

import br.com.haan.ct.dto.DescricaoModalidadeQuantidadeAluno;
import br.com.haan.ct.entities.Matricula;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.MatriculaService;
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
public class MatriculaController {
    
    
    @Autowired
    private MatriculaService matriculaService;
    
    @GetMapping("/matricula")
    public Iterable<Matricula> listar(){
        return matriculaService.listar();
    }

    @GetMapping("/numeroMatriculasPorModalidade")
    public Iterable<DescricaoModalidadeQuantidadeAluno> numeroMatriculasPorModalidade(){
        return matriculaService.numeroMatriculasPorModalidade();
    }

    @PostMapping("/matricula")
    public ResponseEntity<?> salvar (@RequestBody Matricula matricula){
        return matriculaService.salvar(matricula,"Salvar");
    }
    
    @PutMapping("/matricula/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Matricula matricula){
        return matriculaService.salvar(matricula,"Atualizar");
    }
    
    @DeleteMapping("/matricula/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return matriculaService.remover(id);
    }
}
