package vitoriasc;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */

public class Jogo implements Serializable {
    private int cod_jogo = 0;
    private int id_modalidade = -1;
    private int Diajogo = 0;
    private int Mesjogo = 0;
    private int Anojogo = 0;
    private String adversarios = "";
    private int ResultadoE = -1;
    private int ResultadoA = -1;
    private float PrecoBilhete = 0;
    
    public Jogo(int cod_jogo, int id_modalidade, int diajogo, int mesjogo, int anojogo, String adversarios, int resultadoE, int resultadoA, float PrecoBilhete){
        this.cod_jogo = cod_jogo;
        this.id_modalidade = id_modalidade;
        this.Diajogo = diajogo;
        this.Mesjogo = mesjogo;
        this.Anojogo = anojogo;
        this.adversarios = adversarios;
        this.ResultadoE = resultadoE;
        this.ResultadoA = resultadoA; 
        this.PrecoBilhete = PrecoBilhete;
    }

    public int getCod_jogo() {
        return cod_jogo;
    }

    public void setCod_jogo(int cod_jogo) {
        this.cod_jogo = cod_jogo;
    }

    public int getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(int id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public int getDiajogo() {
        return Diajogo;
    }

    public void setDiajogo(int Diajogo) {
        this.Diajogo = Diajogo;
    }

    public int getMesjogo() {
        return Mesjogo;
    }

    public void setMesjogo(int Mesjogo) {
        this.Mesjogo = Mesjogo;
    }

    public int getAnojogo() {
        return Anojogo;
    }

    public void setAnojogo(int Anojogo) {
        this.Anojogo = Anojogo;
    }

    public String getAdversarios() {
        return adversarios;
    }

    public void setAdversarios(String adversarios) {
        this.adversarios = adversarios;
    }

    public int getResultadoE() {
        return ResultadoE;
    }

    public void setResultadoE(int ResultadoE) {
        this.ResultadoE = ResultadoE;
    }

    public int getResultadoA() {
        return ResultadoA;
    }

    public void setResultadoA(int ResultadoA) {
        this.ResultadoA = ResultadoA;
    }

    public float getPrecoBilhete() {
        return PrecoBilhete;
    }

    public void setPrecoBilhete(float PrecoBilhete) {
        this.PrecoBilhete = PrecoBilhete;
    }
    

    @Override
    public String toString() {
        return "Jogo{" + "cod_jogo=" + cod_jogo + ", id_modalidade=" + id_modalidade + ", Diajogo=" + Diajogo + ", Mesjogo=" + Mesjogo + ", Anojogo=" + Anojogo + ", adversarios=" + adversarios + ", ResultadoE=" + ResultadoE + ", ResultadoA=" + ResultadoA + ", PrecoBilhete=" + PrecoBilhete + '}';
    }

}
