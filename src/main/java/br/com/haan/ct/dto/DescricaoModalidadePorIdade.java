package br.com.haan.ct.dto;

import br.com.haan.ct.entities.Aluno;
import java.time.LocalDate;

public interface DescricaoModalidadePorIdade {
    public String getDescricaoModalidade();
    public void setDescricaoModalidade(String descricaoModalidade);
    public int getQuantidadeAluno();
    public void setQuantidadeAluno (int quantidadeAluno);
    public Aluno getAlunoDaGraduacao();
    public void setAlunoDaGraduacao (Aluno alunoDaGraduacao);
    public LocalDate getDataAluno();
    public void setDataAluno( LocalDate dataAluno);
}
