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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class ModalidadesController implements Initializable {

    @FXML
    private Label modalidades;
    @FXML
    private Label voltar;
    @FXML
    private TextField modalidadeinserida;
    @FXML
    private Separator s1;
    @FXML
    private TextField equipainserida;
    @FXML
    private Separator s2;
    @FXML
    private TextField codigomodinserido;
    @FXML
    private Separator s3;
    @FXML
    private Label errortxt;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        s1.setStyle("-fx-background-color: transparent");
        s2.setStyle("-fx-background-color: transparent");
        s3.setStyle("-fx-background-color: transparent");       
        errortxt.setText("(Existem erros nos campos assinalados)");
        errortxt.setVisible(false);
    }    

    @FXML
    private void handleAdicionarModalidadeButton(ActionEvent event) throws IOException {
        int erro = 0;
        if(modalidadeinserida.getText().trim().isEmpty()){
            erro = 24; System.out.println("[ERRO] No adcionar modalidade. > Code: " + erro);
            s1.setStyle("-fx-background-color: #f04a4a");
        }if(equipainserida.getText().trim().isEmpty()){
            erro = 25; System.out.println("[ERRO] No adcionar modalidade. > Code: " + erro);
            s2.setStyle("-fx-background-color: #f04a4a");
        }
        
        if(erro == 0){
            if(Repositorio.getInstance().getGestorfiles().adicionarModalidade(modalidadeinserida.getText(), equipainserida.getText()) == 1){
                System.out.println("[INFO] Modalidade adcionada.");
                Repositorio.getInstance().getGestorfiles().guardarDadosModalidades();
            }else{
                erro = 26; System.out.println("[ERRO] No adcionar modalidade. > Code: " + erro);   
            }
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
            Scene cenagestor = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenagestor);
            stage.show();
        }else{
            errortxt.setVisible(true);
        }
    }

    @FXML
    private void handleRemoverModalidadeButton(ActionEvent event) throws IOException {
        int erro = 0;
        int codremover = -1;
        if(codigomodinserido.getText().trim().isEmpty()){
            erro = 27; System.out.println("[ERRO] No remover modalidade. > Code: " + erro);
            s3.setStyle("-fx-background-color: #f04a4a");
        }else{
            codremover = Integer.parseInt(codigomodinserido.getText());
            if(codremover < 0 || codremover >= Repositorio.getInstance().getGestorfiles().obterQuantidadeModalidades()){
                erro = 28; System.out.println("[ERRO] No remover modalidade. > Code: " + erro);
                s3.setStyle("-fx-background-color: #f04a4a");
            }
        }
        
        if(erro == 0){
            Repositorio.getInstance().getGestorfiles().removerModalidade(codremover);
            System.out.println("[INFO] Modalidade removida.");
            Repositorio.getInstance().getGestorfiles().guardarDadosModalidades();
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
            Scene cenagestor = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenagestor);
            stage.show();
        }else{
            System.out.println("[ERRO] No remover modalidade. > Code: 35");
            errortxt.setVisible(true);
        }
    }
    
    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
        Scene cenagestor = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenagestor);
        stage.show();
    }  
}
