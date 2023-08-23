package br.com.haan.ct.services;

import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.entities.AlunoDoenca;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.AlunoRepository;
import br.com.haan.ct.repositories.AlunoDoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlunoDoencaService {

    @Autowired
    private AlunoDoencaRepository alunoDoencaRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<AlunoDoenca> listar() {
        return alunoDoencaRepository.findAll();
    }

    public ResponseEntity<?> salvar(AlunoDoenca alunoDoenca, String acao) {
        if (acao.equals("Salvar")) {
            return new ResponseEntity<AlunoDoenca>(alunoDoencaRepository.save(alunoDoenca), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<AlunoDoenca>(alunoDoencaRepository.save(alunoDoenca), HttpStatus.OK);
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        alunoDoencaRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
