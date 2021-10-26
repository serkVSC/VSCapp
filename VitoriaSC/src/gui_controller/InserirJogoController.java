package gui_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class InserirJogoController implements Initializable {


    @FXML
    private TextField modalidadeinserida;
    @FXML
    private Separator s1;
    @FXML
    private TextField eadversariainserida;
    @FXML
    private Separator s2;
    @FXML
    private TextField diainserido;
    @FXML
    private Separator s3;
    @FXML
    private TextField mesinserido;
    @FXML
    private Separator s4;
    @FXML
    private TextField anoinserido;
    @FXML
    private Separator s5;
    @FXML
    private TextField precoinserido;
    @FXML
    private Separator s6;
    @FXML
    private Label errortxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errortxt.setVisible(false);
        s1.setStyle("-fx-background-color: transparent");
        s2.setStyle("-fx-background-color: transparent");
        s3.setStyle("-fx-background-color: transparent");
        s4.setStyle("-fx-background-color: transparent");
        s5.setStyle("-fx-background-color: transparent");
        s6.setStyle("-fx-background-color: transparent");
    }

    
    @FXML
    private void handleInserirButton(ActionEvent event) throws IOException {
        int erro = 0;
        int id_modalidadeinserido = -1;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        float preco = -1;
        
        if(modalidadeinserida.getText().trim().isEmpty()){
            erro = 36; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
            s1.setStyle("-fx-background-color: #f04a4a");
        }else{
            id_modalidadeinserido = Integer.parseInt(modalidadeinserida.getText());
            if(id_modalidadeinserido < 0 || id_modalidadeinserido > Repositorio.getInstance().getGestorfiles().obterQuantidadeModalidades()){
                erro = 37; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
                s1.setStyle("-fx-background-color: #f04a4a");                
            }
        }if(diainserido.getText().trim().isEmpty()){
            erro = 38; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
            s3.setStyle("-fx-background-color: #f04a4a");
        }else{
            dia = Integer.parseInt(diainserido.getText());
            if(dia < 0 || dia > 31){
                erro = 39; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
                s3.setStyle("-fx-background-color: #f04a4a");
            }
        }if(mesinserido.getText().trim().isEmpty()){
            erro = 40; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
            s4.setStyle("-fx-background-color: #f04a4a");
        }else{
            mes = Integer.parseInt(mesinserido.getText());
            if(mes < 0 || mes > 12){
                erro = 41; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
                s4.setStyle("-fx-background-color: #f04a4a");
            }
        }if(anoinserido.getText().trim().isEmpty()){
            erro = 42; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
            s5.setStyle("-fx-background-color: #f04a4a");
        }else{
            ano = Integer.parseInt(anoinserido.getText());
            if(ano < 1900){
                erro = 43; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
                s5.setStyle("-fx-background-color: #f04a4a");
            }
        }if(eadversariainserida.getText().trim().isEmpty()){
            erro = 44; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
            s2.setStyle("-fx-background-color: #f04a4a");           
        }if(precoinserido.getText().trim().isEmpty()){
            erro = 45; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
            s6.setStyle("-fx-background-color: #f04a4a");
        }else{
            preco = Float.valueOf(precoinserido.getText());
            if(preco < 0){
                erro = 46; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);
                s6.setStyle("-fx-background-color: #f04a4a");
            }
        }
        

        if(erro == 0){
            if(Repositorio.getInstance().getGestorfiles().adicionarJogo(id_modalidadeinserido,dia,mes,ano,eadversariainserida.getText(),-1,-1,preco) == 1){
                System.out.println("[INFO] Jogo adcionado.");
                Repositorio.getInstance().getGestorfiles().guardarDadosJogos();
                Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
                Scene cenagestor = new Scene(ecra2Parent);

                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(cenagestor);
                stage.show();      
            }else{
                erro = 47; System.out.println("[ERRO] No adcionar jogo. > Code: " + erro);    
            }
        }else{
            errortxt.setVisible(true);
        }              
    }  
    
    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
        Scene cenalogin = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenalogin);
        stage.show();
    }      
}
