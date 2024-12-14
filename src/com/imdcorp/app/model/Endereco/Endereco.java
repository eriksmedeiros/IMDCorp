package src.com.imdcorp.app.model.Endereco;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco(String rua, Integer numero, String bairro, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }
}