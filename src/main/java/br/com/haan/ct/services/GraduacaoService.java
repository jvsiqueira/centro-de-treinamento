package br.com.haan.ct.services;

import br.com.haan.ct.entities.Graduacao;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.GraduacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GraduacaoService {

    @Autowired
    private GraduacaoRepository graduacaoRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Graduacao> listar() {
        return graduacaoRepository.findAll();
    }

    public ResponseEntity<?> salvar(Graduacao graduacao, String acao) {
        if (acao.equals("Salvar")) {
            return new ResponseEntity<Graduacao>(graduacaoRepository.save(graduacao), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Graduacao>(graduacaoRepository.save(graduacao), HttpStatus.OK);
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        graduacaoRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
