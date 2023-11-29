package br.com.haan.ct.services;

import br.com.haan.ct.dto.DoencaMaisComum;
import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.entities.Doenca;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.AlunoRepository;
import br.com.haan.ct.repositories.DoencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DoencaService {

    @Autowired
    private DoencaRepository doencaRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Doenca> listar() {
        return doencaRepository.findAll();
    }

    public ResponseEntity<?> salvar(Doenca doenca, String acao) {
        if (doenca.getDescricao().equals("")) {
            respostaModelo.setMensagem("Hey boyzim, tu esqueceu a descricao.");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("Salvar")) {
                return new ResponseEntity<Doenca>(doencaRepository.save(doenca), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Doenca>(doencaRepository.save(doenca), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        doencaRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
    public Iterable<DoencaMaisComum> nomeDoencaMaisComum(){
        return doencaRepository.nomeDoencaMaiscomum();
    }
}
