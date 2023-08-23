package br.com.haan.ct.services;

import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.entities.Modalidade;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.AlunoRepository;
import br.com.haan.ct.repositories.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ModalidadeService {

    @Autowired
    private ModalidadeRepository modalidadeRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Modalidade> listar() {
        return modalidadeRepository.findAll();
    }

    public ResponseEntity<?> salvar(Modalidade modalidade, String acao) {
        if (modalidade.getDescricao().equals("")) {
            respostaModelo.setMensagem("Hey boyzim, tu esqueceu a descricao.");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("Salvar")) {
                return new ResponseEntity<Modalidade>(modalidadeRepository.save(modalidade), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Modalidade>(modalidadeRepository.save(modalidade), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        modalidadeRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
