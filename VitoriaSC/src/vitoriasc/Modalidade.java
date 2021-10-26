package vitoriasc;

import java.io.Serializable;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */

public class Modalidade implements Serializable{
    private int cod_modalidade = 0;
    private String nome = "";
    private String nomeequipa = "";
        
    public Modalidade(int cod_modalidade, String nome, String nomeequipa){
        this.cod_modalidade = cod_modalidade;
        this.nome = nome;
        this.nomeequipa = nomeequipa;
    }

    public int getCod_modalidade() {
        return cod_modalidade;
    }

    public void setCod_modalidade(int cod_modalidade) {
        this.cod_modalidade = cod_modalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeequipa() {
        return nomeequipa;
    }

    public void setNomeequipa(String nomeequipa) {
        this.nomeequipa = nomeequipa;
    }

    @Override
    public String toString() {
        return "Modalidade{" + "cod_modalidade=" + cod_modalidade + ", nome=" + nome + ", nome_equipa=" + nomeequipa + '}';
    }
    
}
