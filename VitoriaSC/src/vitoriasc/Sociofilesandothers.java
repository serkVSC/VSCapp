package vitoriasc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class Sociofilesandothers implements Serializable{
    Socio[] socios; //declara socios como um array da class Socio
    
    public Sociofilesandothers() {
        this.socios = new Socio[100]; //Inicia socios com 100 posiçoes
    }

    public Socio[] getSocios() {
        return socios;
    }

    public void setSocios(Socio[] socios) {
        this.socios = socios;
    }
   
    public int adicionarSocio(String nome, int dia, int mes, int ano, String sexo, int telemovel, String morada, Tipos.Categoria categoria, String password, int quotatual){         
        // inserir socio numa posição vazia
        for(int x = 0; x < this.socios.length; x++){
            if(this.socios[x] == null){
                this.socios[x] = new Socio(x, nome, dia, mes, ano, sexo, telemovel, morada, categoria, password, quotatual); // add as seguintes informaçoes ao socios
                return 1;
            }
        }
        
        // se todas as posições do array estiverem preenchidas
        return -2;
    }
    
    public Socio obterSocio(int NumeroSocio){
        // itera sobre o array socios. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável socioTemp
        for(Socio socioTemp : this.socios){
            if(socioTemp != null){
                if(socioTemp.getNumeroSocio() == NumeroSocio)
                    return socioTemp; //devolve socio escolhido
            }
        }
        
        // se não existir socio com o número de socio escolhido, return null
       return null;
    }
    
    public String obterPassword(int NumeroSocio){
        // itera sobre o array socios. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável socioTemp
        for(Socio socioTemp : this.socios){
            if(socioTemp != null){
                if(socioTemp.getNumeroSocio() == NumeroSocio)
                    return socioTemp.getPassword(); //devolve a password
            }
        }
        
        // se não existir socio com o número de socio escolhido, return null
       return null;
    }
    

    public void listarSocios(){
        // itera sobre o array socios. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável socioTemp
        for(Socio socioTemp : this.socios){
            if(socioTemp != null){
                System.out.println("\t" + socioTemp); // lista na linha de comandos os socios
            }
        }
    }
    
    
    public int obterQuantidadeSocios(){
        int contador = 0;
        for(Socio socioTemp : this.socios){
            if(socioTemp != null){
                contador++;
            }
        }
        return contador; //devolve a quantidade de socios inseridos
    }
    
    
    
    // ----------- METODOS SERIALIZAR E DESSERIALIZAR
    public void guardarDadosSocios(){
        String nomeFicheiro = "dados_socios.dados";
        
        try{
            FileOutputStream ficheiroSaida = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream out = new ObjectOutputStream(ficheiroSaida);
            out.writeObject(this.socios);
            out.close();
            ficheiroSaida.close();
            System.out.println("[INFO] Dados dos sócios guardados.");
        } catch(IOException ex){
            System.out.println("[ERRO] Ocorreu um erro a guardar os dados. > Code: 10");
        }
        
    }
    
    public void carregaDadosSocios(){
        String nomeFicheiro = "dados_socios.dados";
        if(this.obterQuantidadeSocios() > 0){
            System.out.println("[ERRO] Dados já carregados ou sócios já inseridos no clube. > Code: 11");
            return;
        }
        try {
            FileInputStream ficheiro = new FileInputStream(nomeFicheiro);
            ObjectInputStream ois = new ObjectInputStream(ficheiro);
            this.socios = (Socio[]) ois.readObject();
            ois.close();
            ficheiro.close();
            System.out.println("[INFO] Dados dos sócios carregados.");
        } catch (FileNotFoundException ex) {
            System.out.println("[ERRO] O ficheiro indicado (sócios) não existe > Code: 12");
        } catch (IOException ex) {
            System.out.println("[ERRO] Ocorreu um erro a carregar os dados (sócios) > Code: 13");
        } catch (ClassNotFoundException ex) {
            System.out.println("[ERRO] Classe do objeto carregado não existe > Code: " + ex.getMessage());
        }
    }
    
}
