package vitoriasc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class Gestorfilesandothers implements Serializable {
     Modalidade[] modalidades;
     Jogo[] jogos;
     Queue<Bilhete> bilhetes;
    
     
    /**********************************************
     * Inicializa tanto um array de modalidades
     * como um array de jogos
     * e a queue de bilhetes
     **********************************************/
    public Gestorfilesandothers() {
        this.modalidades = new Modalidade[100];
        this.jogos = new Jogo[100];
        this.bilhetes = new LinkedList<>();
    }
    
    /**********************************************
     * Getter Setter
     * Funcao Adcionar e Remover
     * Funçao obtermodalidade obterorganizado e listar
     * Função obterquantidade
     * Ficheiros de guardar e nao guardar
     **********************************************/
    public Modalidade[] getModalidades() {
        return modalidades;
    }

    public void setModalidades(Modalidade[] modalidades) {
        this.modalidades = modalidades;
    }
    
    public int adicionarModalidade(String nomeinserido,String nomeequipainserido){
        // inserir modalidade numa posição vazia
        for(int x = 0; x < this.modalidades.length; x++){
            if(this.modalidades[x] == null){
                this.modalidades[x] = new Modalidade(x,nomeinserido,nomeequipainserido);
                return 1;
            }
        }
        
        // se todas as posições do array estiverem preenchidas
        return -2;
    }
    
   public void removerModalidade(int cod_modalidade){
        while(true){
            for(int x = 0; x < modalidades.length; x++){
                if(modalidades[x] != null){
                    if(modalidades[x].getCod_modalidade() == cod_modalidade){
                        modalidades[x] = null;
                        return;
                    }
                }
            }
        }  
    }
    
    public Modalidade obterModalidade(int cod_modalidade){
        // itera sobre o array Modalidades. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável modalidadeTemp
        for(Modalidade modalidadeTemp : this.modalidades){
            if(modalidadeTemp != null){
                if(modalidadeTemp.getCod_modalidade() == cod_modalidade)
                    return modalidadeTemp;
            }
        }
        
        // se não existir modalidade com o código de modalidade escolhido, return null
       return null;
    }
    
    public void listarModalidade(){
        // itera sobre o array modalidade. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável modalidadeTemp
        for(Modalidade modalidadeTemp : this.modalidades){
            if(modalidadeTemp != null){
                System.out.println("\t" + modalidadeTemp);
            }
        }
    }
    
    public int obterQuantidadeModalidades(){
        int contador = 0;
        for(Modalidade modalidadeTemp : this.modalidades){
            if(modalidadeTemp != null){
                contador++;
            }
        }
        return contador;
    }
    
      // ----------- METODOS SERIALIZAR E DESSERIALIZAR
    public void guardarDadosModalidades(){
        String nomeFicheiro = "dados_modalidades.dados";
        
        try{
            FileOutputStream ficheiroSaida = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream out = new ObjectOutputStream(ficheiroSaida);
            out.writeObject(this.modalidades);
            out.close();
            ficheiroSaida.close();
            System.out.println("[INFO] Dados das modalidades guardados.");
        } catch(IOException ex){
            System.out.println("[ERRO] Ocorreu um erro a guardar os dados das modalidades > Code: 14");
        }
        
    }
    
    public void carregaDadosModalidades(){
        String nomeFicheiro = "dados_modalidades.dados";
        if(this.obterQuantidadeModalidades() > 0){
            System.out.println("[ERRO] Dados já carregados ou modalidades já inseridas. > Code: 15");
            return;
        }
        try {
            FileInputStream ficheiro = new FileInputStream(nomeFicheiro);
            ObjectInputStream ois = new ObjectInputStream(ficheiro);
            this.modalidades = (Modalidade[]) ois.readObject();
            ois.close();
            ficheiro.close();
            System.out.println("[INFO] Dados das modalidades carregados.");
        } catch (FileNotFoundException ex) {
            System.out.println("[ERRO] O ficheiro indicado (modalidades) não existe. > Code: 16");
        } catch (IOException ex) {
            System.out.println("[ERRO] Ocorreu um erro a carregar os dados (modalidades) > Code: 17");
        } catch (ClassNotFoundException ex) {
            System.out.println("[ERRO] Classe do objeto carregado não existe > Code: " + ex.getMessage());
        }
    }
    
    /**********************************************
     * JOGOS
     * Getter Setter
     * Adcionar 
     * Funçao obterjogo obterjogoorganizado e listar
     * Função obterquantidade
     * Ficheiros de guardar e nao guardar
     **********************************************/
    public Jogo[] getJogos() {
        return jogos;
    }

    public void setJogos(Jogo[] jogos) {
        this.jogos = jogos;
    }
   
    public int adicionarJogo(int id_modalidadeinserido,int dia_jogoinserido,int mes_jogoinserido,int ano_jogoinserido,String adversarioinserido,int resultadoEinserido,int resultadoAinserido,float precobilheteinserido){             
        
        // inserir jogo numa posição vazia
        for(int x = 0; x < this.jogos.length; x++){
            if(this.jogos[x] == null){
                this.jogos[x] = new Jogo(x,id_modalidadeinserido,dia_jogoinserido,mes_jogoinserido,ano_jogoinserido,adversarioinserido,resultadoEinserido,resultadoAinserido,precobilheteinserido);
                return 1;
            }
        }
        
        // se todas as posições do array estiverem preenchidas
        return -2;
    }
    
    public Jogo obterJogo(int cod_jogo){
        // itera sobre o array jogos. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável jogoTemp
        for(Jogo jogoTemp : this.jogos){
            if(jogoTemp != null){
                if(jogoTemp.getCod_jogo() == cod_jogo)
                    return jogoTemp;
            }
        }
        
        // se não existir jogo com o código de jogo escolhido, return null
       return null;
    }
    
    public void listarJogos(){
        // itera sobre o array jogos. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável jogoTemp
        for(Jogo jogoTemp : this.jogos){
            if(jogoTemp != null){
                System.out.println("\t" + jogoTemp);
            }
        }
    }    
    
    public int obterQuantidadeJogos(){
        int contador = 0;
        for(Jogo jogoTemp : this.jogos){
            if(jogoTemp != null){
                contador++;
            }
        }
        return contador;
    }
    
  // ----------- METODOS SERIALIZAR E DESSERIALIZAR
    public void guardarDadosJogos(){
        String nomeFicheiro = "dados_jogos.dados";
        
        try{
            FileOutputStream ficheiroSaida = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream out = new ObjectOutputStream(ficheiroSaida);
            out.writeObject(this.jogos);
            out.close();
            ficheiroSaida.close();
            System.out.println("[INFO] Dados dos jogos guardados.");
        } catch(IOException ex){
            System.out.println("[ERRO] Ocorreu um erro a guardar os dados dos jogos. > Code: 18");
        }
        
    }
    
    public void carregaDadosJogos(){
        String nomeFicheiro = "dados_jogos.dados";
        if(this.obterQuantidadeJogos() > 0){
            System.out.println("[ERRO] Dados já carregados ou jogos já inseridos. > Code: 19");
            return;
        }
        try {
            FileInputStream ficheiro = new FileInputStream(nomeFicheiro);
            ObjectInputStream ois = new ObjectInputStream(ficheiro);
            this.jogos= (Jogo[]) ois.readObject();
            ois.close();
            ficheiro.close();
            System.out.println("[INFO] Dados dos jogos carregados. ");
        } catch (FileNotFoundException ex) {
            System.out.println("[ERRO] O ficheiro indicado (jogos) não existe! > Code: 20");
        } catch (IOException ex) {
            System.out.println("[ERRO] Ocorreu um erro a carregar os dados (jogos) > Code: 21" );
        } catch (ClassNotFoundException ex) {
            System.out.println("[ERRO] Classe do objeto carregado não existe > Code: " + ex.getMessage());
        }
    }

    

    /**********************************************
     * Bilhetes
     * Getter Setter
     * Adcionar 
     * Funçao obterjogo obterjogoorganizado e listar
     * Função obterquantidade
     * Ficheiros de guardar e nao guardar
     **********************************************/
    
    public Queue<Bilhete> getBilhetes(){                 
        return bilhetes;
    }
    
    public void setBilhetes(Queue<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public int adicionarBilhete(int idjogo, int idsocios, float precopago) {
        // inserir jogo numa posição vazia
        for(int x = 0; x < this.jogos.length; x++){
            if(this.jogos[x] == null){
                bilhetes.offer(new Bilhete(idjogo, idsocios, precopago));
                return 1;
            }
        }
         return -2;
    }
    
    public void removerBilhete(){
        bilhetes.remove();
    }
        
        
    public void listarBilhetes(){
        // itera sobre o array jogos. Para cada elemento do array ou a cada iteração do array, coloca o próximo elemento do array na variável jogoTemp
        for(Bilhete bilheteTemp : this.bilhetes){
            if(bilheteTemp != null){
                System.out.println("\t" + bilheteTemp);
            }
        }
    }    
    
    public int obterQuantidadeBilhetes(){
        int contador = 0;
        for(Bilhete bilheteTemp : this.bilhetes){
            if(bilheteTemp != null){
                contador++;
            }
        }
        return contador;
    }
    
  // ----------- METODOS SERIALIZAR E DESSERIALIZAR
    public void guardarDadosBilhetes(){
        String nomeFicheiro = "dados_bilhetes.dados";
        
        try{
            FileOutputStream ficheiroSaida = new FileOutputStream(nomeFicheiro);
            ObjectOutputStream out = new ObjectOutputStream(ficheiroSaida);
            out.writeObject(this.bilhetes);
            out.close();
            ficheiroSaida.close(); 
            System.out.println("[INFO] Dados dos bilhetes guardados.");
        } catch(IOException ex){
            System.out.println("[ERRO] Ocorreu um erro a guardar os dados dos bilhetes. > Code: 52");
        }
        
    }
    
    public void carregaDadosBilhetes(){
        String nomeFicheiro = "dados_bilhetes.dados";
        if(this.obterQuantidadeBilhetes() > 0){
            System.out.println("[ERRO] Dados já carregados ou bilhetes já inseridos. > Code: 53");
            return;
        }
        try {
            FileInputStream ficheiro = new FileInputStream(nomeFicheiro);
            ObjectInputStream ois = new ObjectInputStream(ficheiro);
            this.bilhetes = (Queue<Bilhete>) ois.readObject();
            ois.close();
            ficheiro.close();
            System.out.println("[INFO] Dados dos bilhetes carregados. ");
        } catch (FileNotFoundException ex) {
            System.out.println("[ERRO] O ficheiro indicado (bilhetes) não existe! > Code: 54");
        } catch (IOException ex) {
            System.out.println("[ERRO] Ocorreu um erro a carregar os dados (bilhetes) > Code: 55" );
        } catch (ClassNotFoundException ex) {
            System.out.println("[ERRO] Classe do objeto carregado não existe > Code: " + ex.getMessage());
        }
    }
}


