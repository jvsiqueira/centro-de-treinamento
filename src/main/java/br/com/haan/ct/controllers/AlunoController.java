package br.com.haan.ct.controllers;

import br.com.haan.ct.dto.NomeAlunoEmDebito;
import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.AlunoService;
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
public class AlunoController {
       
    @Autowired
    private AlunoService alunoService;
    
    @GetMapping("/alunos")
    public Iterable<Aluno> buchadaDeBodeDoMercadoPublico(){
        return alunoService.listar();
    }
    
    @PostMapping("/alunos")
    public ResponseEntity<?> salvar (@RequestBody Aluno aluno){
        return alunoService.salvar(aluno,"Salvar");
    }
    
    @PutMapping("/alunos")
    public ResponseEntity<?> atualizar (@RequestBody Aluno aluno){
        return alunoService.salvar(aluno,"Atualizar");
    }
    
    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return alunoService.remover(id);
    }
    
    @GetMapping("/numeroMatriculaAlunosEmDebito")
    public Iterable<NomeAlunoEmDebito> numeroMatriculaAlunosEmDebito(){
        return alunoService.numeroMatriculaAlunosEmDebito();
    }

}
