package src.com.imdcorp.app.model.TecnicoADM;

import src.com.imdcorp.app.model.Endereco.Endereco;
import src.com.imdcorp.app.model.Funcionario.Funcionario;
import src.com.imdcorp.app.model.Pessoa.Pessoa;
import src.com.imdcorp.app.model.enums.Formacao;
import src.com.imdcorp.app.model.enums.Nivel;
import src.com.imdcorp.app.model.enums.Genero;

import java.io.Serializable;
import java.time.LocalDate;

public class TecnicoADM extends Pessoa implements Funcionario, Serializable {
    private Nivel nivelTecnico;
    private Formacao formacaoTecnico;
    private Boolean insalubridade;
    private Boolean funcaoGratificada;

    public TecnicoADM(String nome, String cpf, LocalDate dataNascimento, Genero genero, Endereco endereco, Long matricula, Double salario, String departamento, Integer cargaHoraria, LocalDate dataIngresso, Nivel nivelTecnico, Formacao formacaoTecnico, Boolean insalubridade, Boolean funcaoGratificada) {
        super(nome, cpf, dataNascimento, genero, endereco, matricula, salario, departamento, cargaHoraria, dataIngresso);
        this.nivelTecnico = nivelTecnico;
        this.formacaoTecnico = formacaoTecnico;
        this.insalubridade = insalubridade;
        this.funcaoGratificada = funcaoGratificada;
        this.setSalario(calcularSalario());
    }

    public Nivel getNivelTecnico() {
        return nivelTecnico;
    }

    public void setNivelTecnico(Nivel nivelTecnico) {
        this.nivelTecnico = nivelTecnico;
    }

    public Formacao getFormacaoTecnico() {
        return formacaoTecnico;
    }

    public void setFormacaoTecnico(Formacao formacaoTecnico) {
        this.formacaoTecnico = formacaoTecnico;
    }

    public Boolean getInsalubridade() {
        return insalubridade;
    }

    public void setInsalubridade(Boolean insalubridade) {
        this.insalubridade = insalubridade;
    }

    public Boolean getFuncaoGratificada() {
        return funcaoGratificada;
    }

    public void setFuncaoGratificada(Boolean funcaoGratificada) {
        this.funcaoGratificada = funcaoGratificada;
    }

    @Override
    public String toString() {
        return "Nome: " + "\n" +
                "Função: " + "\n";
    }

    @Override
    public Double calcularSalario() {

        final double SALARIO_BASE = 2500.0;

        double nivel = 1;
        switch (nivelTecnico){
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
        switch (formacaoTecnico){
            case DOUTOR: formacao = 1.75; break;
            case MESTRE: formacao = 1.5; break;
            case ESPECIALISTA: formacao = 1.25; break;
        }

        double insalubridade = getInsalubridade() ? SALARIO_BASE * 0.5 : 0;
        double funcaoGratificada = getFuncaoGratificada() ? SALARIO_BASE * 0.5 : 0;

        double salarioFinal = SALARIO_BASE * nivel * formacao + insalubridade + funcaoGratificada;
        return salarioFinal;
    }
}