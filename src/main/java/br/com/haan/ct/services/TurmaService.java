package br.com.haan.ct.services;

import br.com.haan.ct.entities.Turma;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Turma> listar() {
        return turmaRepository.findAll();
    }

    public ResponseEntity<?> salvar(Turma turma, String acao) {
        if (acao.equals("Salvar")) {
            return new ResponseEntity<Turma>(turmaRepository.save(turma), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Turma>(turmaRepository.save(turma), HttpStatus.OK);
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        turmaRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
