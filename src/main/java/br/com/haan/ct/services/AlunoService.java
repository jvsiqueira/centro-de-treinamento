package br.com.haan.ct.services;

import br.com.haan.ct.entities.Aluno;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

     // aula do dia 10/08
    @Autowired
    private RespostaModelo respostaModelo;
    
    public Iterable<Aluno> listar() {
        return alunoRepository.findAll();
    }

   

    public ResponseEntity<?> salvar(Aluno aluno, String acao) {
        if (aluno.getNome().equals("")) {
            respostaModelo.setMensagem("Hey boyzim, tu esqueceu o nome.");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else if (aluno.getTelefone().equals("")) {
            respostaModelo.setMensagem("Hey boyzim, tu esqueceu o telefone.");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("Salvar")) {
                return new ResponseEntity<Aluno>(alunoRepository.save(aluno), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Aluno>(alunoRepository.save(aluno), HttpStatus.OK);
            }
        }
    }
    
    public ResponseEntity<RespostaModelo> remover (Long id){
        alunoRepository.deleteById(id);
        respostaModelo.setMensagem("O aluno foi removido com sucesso.");
         return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
}
