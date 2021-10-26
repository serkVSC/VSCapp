package vitoriasc;

import java.io.Serializable;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class Bilhete implements Serializable{
    int IdJogo = -1;
    int IdSocio = -1;
    float PrecoPago = -1;

    public Bilhete() {
    }
    
    public Bilhete(int idjogo, int idsocio, float precopago) {
        this.IdJogo = idjogo;
        this.IdSocio = idsocio;
        this.PrecoPago = precopago;
    }

    public int getIdJogo() {
        return IdJogo;
    }

    public void setIdJogo(int IdJogo) {
        this.IdJogo = IdJogo;
    }

    public int getIdSocio() {
        return IdSocio;
    }

    public void setIdSocio(int IdSocio) {
        this.IdSocio = IdSocio;
    }

    public float getPrecoPago() {
        return PrecoPago;
    }

    public void setPrecoPago(float PrecoPago) {
        this.PrecoPago = PrecoPago;
    }

    @Override
    public String toString() {
        return "Bilhete{" + "IdJogo=" + IdJogo + ", IdSocio=" + IdSocio + ", PrecoPago=" + PrecoPago + '}';
    }
    
}
