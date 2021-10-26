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
public class ProcurarSocioController implements Initializable {

    @FXML
    private TextField procurarsocio;
    @FXML
    private Label numsocio;
    @FXML
    private Label nomesocio;
    @FXML
    private Label telemovel;
    @FXML
    private Label morada;
    @FXML
    private Label dia;
    @FXML
    private Label mes;
    @FXML
    private Label ano;
    @FXML
    private Label sexo;
    @FXML
    private Label categoria;
    @FXML
    private Label quotaatual;
    @FXML
    private Label msgerro;
    @FXML
    private Separator s1;
    @FXML
    private Label b1;
    @FXML
    private Label b2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numsocio.setVisible(false);
        nomesocio.setVisible(false);
        telemovel.setVisible(false);
        morada.setVisible(false);
        dia.setVisible(false);
        mes.setVisible(false);
        ano.setVisible(false);
        sexo.setVisible(false);
        categoria.setVisible(false);
        quotaatual.setVisible(false);
        msgerro.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);
        s1.setStyle("-fx-background-color: transparent"); 
        
    }    
   
    @FXML
    private void handlePesquisarSociosButton(ActionEvent event) throws IOException {
        int erro = 0;
        int socioinserido = 0;
        
        if(procurarsocio.getText().trim().isEmpty()){
           erro = 60; System.out.println("[ERRO] No procurar sócio. > Code: " + erro);
           msgerro.setVisible(true);
           s1.setStyle("-fx-background-color: #f04a4a");             
        }else{
            socioinserido = Integer.parseInt(procurarsocio.getText());
            if(socioinserido < 1 || socioinserido > Repositorio.getInstance().getSociosfiles().obterQuantidadeSocios()){
                erro = 61; System.out.println("[ERRO] No procurar sócio. > Code: " + erro);
                msgerro.setVisible(true);
                s1.setStyle("-fx-background-color: #f04a4a");     
            }else{
                msgerro.setVisible(false);
                s1.setStyle("-fx-background-color: transparent"); 
                numsocio.setVisible(true);
                numsocio.setText("Nº " + socioinserido);
                nomesocio.setVisible(true);
                nomesocio.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getNome().toUpperCase());
                telemovel.setVisible(true);
                telemovel.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getTelemovel());
                morada.setVisible(true);
                morada.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getMorada());
                dia.setVisible(true);
                dia.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getDia());
                b1.setVisible(true);
                mes.setVisible(true);
                mes.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getMes());
                b2.setVisible(true);
                ano.setVisible(true);
                ano.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getAno());
                sexo.setVisible(true);
                sexo.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getSexo());
                categoria.setVisible(true);
                categoria.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getCategoria());
                quotaatual.setVisible(true);
                quotaatual.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(socioinserido).getQuotaAtual());
            }
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
