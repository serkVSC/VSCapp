package gui_controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vitoriasc.Repositorio;
import vitoriasc.Tipos;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class ReservarBilhetesController implements Initializable {

    @FXML
    private TextField codigoinserido;
    @FXML 
    private Separator s1;
    @FXML 
    private Label equipas;
    @FXML 
    private Label datajogo;
    @FXML 
    private Label precobilhete;
    @FXML 
    private Label desconto;
    @FXML 
    private Label total;
    @FXML 
    private Label estadio;
    @FXML 
    private Rectangle border;
    @FXML 
    private ImageView b1;
    @FXML 
    private ImageView b2;
    
    @FXML 
    private Label quotas;
    
    @FXML 
    private Label errotext;
    @FXML 
    private ImageView imgerro;
    @FXML 
    private Rectangle bordererro;
    
    @FXML 
    private Button reservar;
    @FXML 
    private Label erroreservar;
    
    private int codigo = -1;
    private float subtotal = -1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        equipas.setVisible(false);
        datajogo.setVisible(false);
        estadio.setVisible(false);
        border.setVisible(false);
        precobilhete.setVisible(false);
        total.setVisible(false);
        desconto.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        quotas.setVisible(false);
        reservar.setVisible(false);
        erroreservar.setVisible(false);
        s1.setStyle("-fx-background-color: transparent"); 
        
        if(Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos() <= 0){
            errotext.setVisible(true);
            errotext.setText("NÃO HÁ JOGOS DISPONIVEIS!");
            imgerro.setVisible(true);
            bordererro.setVisible(true);      
        }else{
            errotext.setVisible(true);
            errotext.setText("NENHUM JOGO SELECIONADO!");
            imgerro.setVisible(true);
            bordererro.setVisible(true);  
        }
    }    
    
    @FXML
    private void handlePesquisarJogoButton(ActionEvent event) throws IOException {
        int erro = 0;
        String mes = "";
        subtotal = -1;
        float descontos = 0;
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);       
        
        if(codigoinserido.getText().trim().isEmpty()){
            erro = 56; System.out.println("[ERRO] No procurar jogo. > Code: " + erro);
            s1.setStyle("-fx-background-color: #f04a4a"); 
        }else{
            codigo =  Integer.parseInt(codigoinserido.getText());
            if(codigo < 0 || codigo >= Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos()){
                erro = 57; System.out.println("[ERRO] No procurar jogo. > Code: " + erro);
                s1.setStyle("-fx-background-color: #f04a4a");             
            }
        }
        
        if(erro == 0){
            errotext.setVisible(false);
            imgerro.setVisible(false);
            bordererro.setVisible(false);
            equipas.setText("VITÓRIASC  x  " + Repositorio.getInstance().getGestorfiles().obterJogo(codigo).getAdversarios());
            switch(Repositorio.getInstance().getGestorfiles().obterJogo(codigo).getMesjogo()){
                case 1: mes = "JAN";break;
                case 2: mes = "FEV";break;
                case 3: mes = "MAR";break;
                case 4: mes = "ABR";break;
                case 5: mes = "MAI";break;
                case 6: mes = "JUN";break;
                case 7: mes = "JUL";break;
                case 8: mes = "AGO";break;
                case 9: mes = "SET";break;
                case 10: mes = "OUT";break;
                case 11: mes = "NOV";break;
                case 12: mes = "DEZ";break;
                default: mes = "MM";
            }
        
        datajogo.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(codigo).getDiajogo() + " DE " +  mes + " DE " +  Repositorio.getInstance().getGestorfiles().obterJogo(codigo).getAnojogo());
        precobilhete.setText("Bilhete: " + Repositorio.getInstance().getGestorfiles().obterJogo(codigo).getPrecoBilhete() + " €");
        if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getQuotaAtual() >= year){
            if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria().equals(Tipos.Categoria.AFONSINHO)){
                desconto.setText("-10%");
                descontos = (float) 0.10;
            }else if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria().equals(Tipos.Categoria.CONQUISTADOR)){
                desconto.setText("-15%");
                descontos = (float) 0.15;
            }else if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria().equals(Tipos.Categoria.HONORARIO)){
                desconto.setText("-25%");
                descontos = (float) 0.24;
            }else{
                desconto.setText("-0%");
                descontos = 0;
            }
            quotas.setVisible(false);
            desconto.setVisible(true);
        }else{
            quotas.setVisible(true);
        }
        
        subtotal = Repositorio.getInstance().getGestorfiles().obterJogo(codigo).getPrecoBilhete() - (Repositorio.getInstance().getGestorfiles().obterJogo(codigo).getPrecoBilhete() * descontos);
        total.setText("Total: " + subtotal + " €");
        equipas.setVisible(true);
        datajogo.setVisible(true);
        estadio.setVisible(true);
        border.setVisible(true);
        precobilhete.setVisible(true);
        total.setVisible(true);
        b1.setVisible(true);
        b2.setVisible(true); 
        reservar.setVisible(true);
        }
    }
    
    @FXML
    private void handleReservarBilheteButton(ActionEvent event) throws IOException {
        int erro = 0; 
        if(codigoinserido.getText().trim().isEmpty()){
            erro = 58; System.out.println("[ERRO] No procurar jogo. > Code: " + erro);
            s1.setStyle("-fx-background-color: #f04a4a"); 
        }else{
            if(codigo < 0 || codigo >= Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos()){
                erro = 59; System.out.println("[ERRO] No procurar jogo. > Code: " + erro);
                s1.setStyle("-fx-background-color: #f04a4a");             
            }
        }
        
        if(erro == 0){
        System.out.println("[INFO] Bilhete reservado - Na queueu. > Code: ");    
        Repositorio.getInstance().getGestorfiles().adicionarBilhete(codigo, LoginController.getWhois(), subtotal);
        Repositorio.getInstance().getGestorfiles().guardarDadosBilhetes();
        Repositorio.getInstance().getGestorfiles().listarBilhetes();
        
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuSocios.fxml"));
        Scene cenasocios = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenasocios);
        stage.show();
        
        }else{
            erroreservar.setVisible(true);
            erro = 60; System.out.println("[ERRO] No reservar bilhete. > Code: " + erro);
        }
    }
    
    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuSocios.fxml"));
        Scene cenasocios = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenasocios);
        stage.show();
    }
}
