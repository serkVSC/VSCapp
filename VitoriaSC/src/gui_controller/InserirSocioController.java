package gui_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
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
import javafx.scene.control.*;
import javafx.stage.Stage;
import vitoriasc.Repositorio;
import vitoriasc.Tipos;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class InserirSocioController implements Initializable {
    private final ObservableList<String> sexolist = FXCollections.observableArrayList("M", "F");
    private final ObservableList<String> categorialist = FXCollections.observableArrayList("AFONSINHO", "CONQUISTADOR", "HONORARIO");
    @FXML
    private TextField nomeinserido;
    @FXML
    private Separator s1; 
    @FXML
    private TextField telinserido;
    @FXML
    private Separator s2;  
    @FXML
    private TextField moradainserida;
    @FXML
    private Separator s3;
    @FXML
    private PasswordField pwinserida;
    @FXML
    private Separator s4; 
    @FXML
    private PasswordField pwrinserida;
    @FXML
    private Separator s5; 
    @FXML
    private TextField diainserido;
    @FXML
    private Separator s6;
    @FXML
    private TextField mesinserido;
    @FXML
    private Separator s7;
    @FXML
    private TextField anoinserido;
    @FXML
    private Separator s8;
    @FXML
    private ComboBox sexoinserido;
    @FXML
    private Separator s9;
    @FXML
    private ComboBox categoriainserida;
    @FXML
    private Separator s10;
    
    @FXML
    private Label errortext;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errortext.setVisible(false);
        s1.setStyle("-fx-background-color: transparent");
        s2.setStyle("-fx-background-color: transparent");
        s3.setStyle("-fx-background-color: transparent");
        s4.setStyle("-fx-background-color: transparent");
        s5.setStyle("-fx-background-color: transparent");
        s6.setStyle("-fx-background-color: transparent");
        s7.setStyle("-fx-background-color: transparent");
        s8.setStyle("-fx-background-color: transparent");
        s9.setStyle("-fx-background-color: transparent");
        s10.setStyle("-fx-background-color: transparent");
        sexoinserido.setValue("Sexo");
        sexoinserido.setItems(sexolist);
        categoriainserida.setValue("Categoria Pretendida *");
        categoriainserida.setItems(categorialist);
    } 
    

    
    @FXML
    private void handleRegistarButton(ActionEvent event) throws IOException {
        int erro = 0;       
        int tel = -1;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        
        String sexo = (String) sexoinserido.getValue();
        Tipos.Categoria categoria = Tipos.Categoria.AFONSINHO;
        String cat = "AFONSINHO";
        cat = (String) categoriainserida.getValue();
        
        int quotatual = 2017; // Cada sócio criado tem a quota 2017 por defeito
 
        if(nomeinserido.getText().trim().isEmpty()){
            erro = 1; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
            s1.setStyle("-fx-background-color: #f04a4a");
        }if(telinserido.getText().trim().isEmpty()){
            erro = 2; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);   
            s2.setStyle("-fx-background-color: #f04a4a");
        }else{
            tel = Integer.parseInt(telinserido.getText());
            if(tel < 0){
                erro = 3; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);   
                s2.setStyle("-fx-background-color: #f04a4a");             
            }
        }if(moradainserida.getText().trim().isEmpty()){
            erro = 49; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
            s3.setStyle("-fx-background-color: #f04a4a"); 
        }if(pwinserida.getText().trim().isEmpty() || pwrinserida.getText().isEmpty()){
            erro = 50; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
            s4.setStyle("-fx-background-color: #f04a4a"); 
            s5.setStyle("-fx-background-color: #f04a4a"); 
        }else{
            if(!pwinserida.getText().equals(pwrinserida.getText())){ 
                erro = 51; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);  
                s4.setStyle("-fx-background-color: #f04a4a");
                s5.setStyle("-fx-background-color: #f04a4a");
            }
        }if(diainserido.getText().trim().isEmpty()){
            erro = 4; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
            s6.setStyle("-fx-background-color: #f04a4a");           
        }else{
            dia = Integer.parseInt(diainserido.getText());
            if(dia < 0 || dia > 31){
                erro = 5; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
                s6.setStyle("-fx-background-color: #f04a4a");                
            }
        }if(mesinserido.getText().trim().isEmpty()){
            erro = 5; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
            s7.setStyle("-fx-background-color: #f04a4a");           
        }else{
            mes = Integer.parseInt(mesinserido.getText());
            if(mes < 0 || mes > 12){
                erro = 6; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
                s7.setStyle("-fx-background-color: #f04a4a");                
            }
        }if(anoinserido.getText().trim().isEmpty()){
            erro = 7; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
            s8.setStyle("-fx-background-color: #f04a4a");           
        }else{
            ano = Integer.parseInt(anoinserido.getText());
            if(ano < 1900){
                erro = 8; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
                s8.setStyle("-fx-background-color: #f04a4a");                
            }
        }if(!sexo.equals("M") && !sexo.equals("F")){
            erro = 60; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);
            s9.setStyle("-fx-background-color: #f04a4a");            
        }
        if(cat.equals("AFONSINHO")){
            categoria = Tipos.Categoria.AFONSINHO;
        }else if(cat.equals("CONQUISTADOR")){
            categoria = Tipos.Categoria.CONQUISTADOR;
        }else if(cat.equals("HONORARIO")){
            categoria = Tipos.Categoria.HONORARIO;
        }
        
        if(erro == 0){
            if(Repositorio.getInstance().getSociosfiles().adicionarSocio(nomeinserido.getText(),dia,mes,ano,sexo,tel,moradainserida.getText(),categoria,pwinserida.getText(),quotatual) == 1){
                System.out.println("[INFO] Sócio adcionado.");
                Repositorio.getInstance().getSociosfiles().guardarDadosSocios();
                Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/Login.fxml"));
                Scene cenalogin = new Scene(ecra2Parent);

                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(cenalogin);
                stage.show();      
            }else{
                erro = 9; System.out.println("[ERRO] No adcionar socio. > Code: " + erro);    
            }
        }else{
            errortext.setVisible(true);
        }
    }

    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/Login.fxml"));
        Scene cenalogin = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenalogin);
        stage.show();
    }
    
}
