package br.com.haan.ct.controllers;

import br.com.haan.ct.entities.Pagamento;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.services.PagamentoService;
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
public class PagamentoController {
    
    
    @Autowired
    private PagamentoService pagamentoService;
    
    @GetMapping("/pagamento")
    public Iterable<Pagamento> listar(){
        return pagamentoService.listar();
    }
    
    @PostMapping("/pagamento")
    public ResponseEntity<?> salvar (@RequestBody Pagamento pagamento){
        return pagamentoService.salvar(pagamento,"Salvar");
    }
    
    @PutMapping("/pagamento/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Pagamento pagamento){
        return pagamentoService.salvar(pagamento,"Atualizar");
    }
    
    @DeleteMapping("/pagamento/{id}")
    public ResponseEntity<RespostaModelo> deletar (@PathVariable Long id){
        return pagamentoService.remover(id);
    }
}
