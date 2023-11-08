package br.com.haan.ct.services;

import br.com.haan.ct.entities.Pagamento;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Pagamento> listar() {
        return pagamentoRepository.findAll();
    }

    public ResponseEntity<?> salvar(Pagamento pagamento, String acao) {
        if (acao.equals("Salvar")) {
            return new ResponseEntity<Pagamento>(pagamentoRepository.save(pagamento), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Pagamento>(pagamentoRepository.save(pagamento), HttpStatus.OK);
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        pagamentoRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
