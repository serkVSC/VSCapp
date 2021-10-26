package vitoriasc;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class Socio implements Serializable{
    private int NumeroSocio = 0; // atribuido automaticamente
    private String Nome = "";
    private int Dia = -1;
    private int Mes = -1; // Data nascimento com dia mes ano
    private int Ano = -1;
    private String Sexo = "";
    private int Telemovel = 0;
    private String Morada = "";
    private Tipos.Categoria CategoriaSocio = Tipos.Categoria.AFONSINHO;
    private String Password = "";
    private int QuotaAtual = 0; // Quota atual do socio
    private Integer[] BilhetesComprados; // Declara Array que guarda o id dos bilhetes comprados de cada socio

    public Socio() {
        this.BilhetesComprados = new Integer[50]; // Inicia o array com 50 posições
    }
    
    public Socio(int numerosocio, String nome, int dia, int mes, int ano, String sexo, int telemovel, String morada, Tipos.Categoria categoria, String password, int quotaAtual){
            this.NumeroSocio = numerosocio;
            this.Nome = nome;
            this.Dia = dia;
            this.Mes = mes;
            this.Ano = ano;
            this.Sexo = sexo;
            this.Telemovel = telemovel;
            this.Morada = morada;
            this.CategoriaSocio = categoria;
            this.Password = password;
            this.QuotaAtual = quotaAtual;
            this.BilhetesComprados = new Integer[50];
    }

    public int getNumeroSocio() {
        return NumeroSocio;
    }

    public void setNumeroSocio(int NumeroSocio) {
        this.NumeroSocio = NumeroSocio;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public int getTelemovel() {
        return Telemovel;
    }

    public void setTelemovel(int Telemovel) {
        this.Telemovel = Telemovel;
    }

    public String getMorada() {
        return Morada;
    }

    public void setMorada(String Morada) {
        this.Morada = Morada;
    }

    public Tipos.Categoria getCategoria() {
        return CategoriaSocio;
    }

    public void setCategoria(Tipos.Categoria CategoriaSocio) {
        this.CategoriaSocio = CategoriaSocio;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getQuotaAtual() {
        return QuotaAtual;
    }

    public void setQuotaAtual(int QuotaAtual) {
        this.QuotaAtual = QuotaAtual;
    }

    public Integer[] getBilhetesComprados() {
        return BilhetesComprados;
    }

    public void setBilhetesComprados(Integer[] BilhetesComprados) {
        this.BilhetesComprados = BilhetesComprados;
    }

    @Override
    public String toString() {
        return "Socio{" + "NumeroSocio=" + NumeroSocio + ", Nome=" + Nome + ", Dia=" + Dia + ", Mes=" + Mes + ", Ano=" + Ano + ", Sexo=" + Sexo + ", Telemovel=" + Telemovel + ", Morada=" + Morada + ", CategoriaSocio=" + CategoriaSocio + ", Password=" + Password + ", QuotaAtual=" + QuotaAtual + ", BilhetesComprados=" + Arrays.toString(BilhetesComprados) + '}';
    } 

    public void addBilhetesComprados(int BilhetesComprados){
        for(int x = 0; x < this.BilhetesComprados.length; x++){ // BilhetesComprados.lenght = tamanho do array
            if(this.BilhetesComprados[x] == null){
                this.BilhetesComprados[x] = BilhetesComprados; // adciona bilhete comprado
                return;
            }
        }
    }
}