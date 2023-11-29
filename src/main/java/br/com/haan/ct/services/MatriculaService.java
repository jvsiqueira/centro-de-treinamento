package br.com.haan.ct.services;

import br.com.haan.ct.dto.DescricaoModalidadeQuantidadeAluno;
import br.com.haan.ct.entities.Matricula;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    public ResponseEntity<?> salvar(Matricula matricula, String acao) {
        if (acao.equals("Salvar")) {
            return new ResponseEntity<Matricula>(matriculaRepository.save(matricula), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Matricula>(matriculaRepository.save(matricula), HttpStatus.OK);
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        matriculaRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
    
    public Iterable<DescricaoModalidadeQuantidadeAluno> numeroMatriculasPorModalidade(){
        return matriculaRepository.numeroMatriculasPorModalidade();
    }
    

    public Iterable<DescricaoModalidadeQuantidadeAluno> numerosMatriculasPorGraduacao(){
        return matriculaRepository.numeroMatriculasPorGraduacao();
    }
    
}
