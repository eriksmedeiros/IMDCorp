package src.com.imdcorp.app.model.Professor;

import src.com.imdcorp.app.model.Endereco.Endereco;
import src.com.imdcorp.app.model.Funcionario.Funcionario;
import src.com.imdcorp.app.model.Pessoa.Pessoa;
import src.com.imdcorp.app.model.enums.Formacao;
import src.com.imdcorp.app.model.enums.Nivel;
import src.com.imdcorp.app.model.enums.Genero;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Professor extends Pessoa implements Funcionario, Serializable {
    private Nivel nivelProfessor;
    private Formacao formacaoProfessor;
    private List<String> disciplinas;

    public Professor(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Long matricula, Double salario, String departamento, Integer cargaHoraria, LocalDate dataIngresso, Nivel nivelProfessor, Formacao formacaoProfessor, List<String> disciplinas) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, salario, departamento, cargaHoraria, dataIngresso);
        this.nivelProfessor = nivelProfessor;
        this.formacaoProfessor = formacaoProfessor;
        this.disciplinas = disciplinas;
        this.setSalario(calcularSalario());
    }

    public Nivel getNivelProfessor() { return nivelProfessor; }
    public void setNivelProfessor(Nivel nivelProfessor) { this.nivelProfessor = nivelProfessor; }

    public Formacao getFormacaoProfessor() { return formacaoProfessor; }
    public void setFormacaoProfessor(Formacao formacaoProfessor) { this.formacaoProfessor = formacaoProfessor; }

    public List<String> getDisciplinas() { return disciplinas; }
    public void setDisciplinas(List<String> disciplinas) { this.disciplinas = disciplinas; }

    @Override
    public Double calcularSalario(){
        final double SALARIO_BASE = 4000.0;

        double nivel = 1;
        switch (nivelProfessor){
            case VIII: nivel *= 1.05;
            case VII: nivel *= 1.05;
            case VI: nivel *= 1.05;
            case V: nivel *= 1.05;
            case IV: nivel *= 1.05;
            case III: nivel *= 1.05;
            case II: nivel *= 1.05;
            case I: break;
        }

        double formacao = 1;
        switch (formacaoProfessor){
            case DOUTOR: formacao = 1.75; break;
            case MESTRE: formacao = 1.5; break;
            case ESPECIALISTA: formacao = 1.25; break;
        }

        double salarioFinal = SALARIO_BASE * nivel * formacao;
        return salarioFinal;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" +
                "Disciplinas: " + getDisciplinas() + "\n";
    }
}

