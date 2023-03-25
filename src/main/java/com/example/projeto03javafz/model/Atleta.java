package com.example.projeto03javafz.model;

public class Atleta {

    private String dataNasc;
    private String CPF;
    private String nome;

    public Atleta() {
    }

    public Atleta(String dataNasc, String CPF, String nome) {
        this.dataNasc = dataNasc;
        this.CPF = CPF;
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
