package br.com.haan.ct.services;

import br.com.haan.ct.entities.FluxoFinanceiro;
import br.com.haan.ct.modelo.RespostaModelo;
import br.com.haan.ct.repositories.FluxoFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FluxoFinanceiroService {

    @Autowired
    private RespostaModelo respostaModelo;
    @Autowired
    private FluxoFinanceiroRepository fluxoFinanceiroRepository;
    public Iterable<FluxoFinanceiro> listar() {
        return fluxoFinanceiroRepository.findAll();
    }

    public ResponseEntity<?> salvar(FluxoFinanceiro fluxo, String acao) {
        if (validarCampos(fluxo)) {
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("Salvar")) {
                return new ResponseEntity<FluxoFinanceiro>(fluxoFinanceiroRepository.save(fluxo), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<FluxoFinanceiro>(fluxoFinanceiroRepository.save(fluxo), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(Long id) {
        fluxoFinanceiroRepository.deleteById(id);
        respostaModelo.setMensagem("o fluxo foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }

    private boolean validarCampos(FluxoFinanceiro fluxo){
        if (fluxo.getMensalidade_id() == null) {
            respostaModelo.setMensagem("id da mensalidade está ausente.");
            return true;
        }
        else if (fluxo.getDataInserido() == null) {
            respostaModelo.setMensagem("data de inserção ausente.");
            return true;
        }
        else if (fluxo.getDataVencimento() == null) {
            respostaModelo.setMensagem("data de vencimento ausente.");
            return true;
        }
        else if (fluxo.getDataPagamento() == null) {
            respostaModelo.setMensagem("data de pagamento ausente.");
            return true;
        }
        else if (fluxo.getValor() == null) {
            respostaModelo.setMensagem("valor invalido.");
            return true;
        }
        else{
            return false;
        }
    }
    
    public double lucroPorMes(int mes) {
        return fluxoFinanceiroRepository.lucroPorMes(mes);
    }
}
