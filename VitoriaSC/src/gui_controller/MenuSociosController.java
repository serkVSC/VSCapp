package gui_controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vitoriasc.*;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class MenuSociosController implements Initializable {
    
    @FXML
    private Label numero;
    @FXML
    private Label nomesocio;

    @FXML
    private Label categoriainserida;
    @FXML
    private Label descontocategoria;
    
    @FXML
    private ImageView imgerrado;
    @FXML
    private Label esclamacaoerrado;    
    @FXML
    private Label ematraso;
    
    @FXML
    private ImageView imgcerto;
    @FXML
    private Label esclamacaocerto;
    @FXML
    private Label atualizadas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        
        nomesocio.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getNome().toUpperCase());
        numero.setText("" + LoginController.getWhois());
        if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria().equals(Tipos.Categoria.AFONSINHO)){
            categoriainserida.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria());
            descontocategoria.setText("-10%");
        }else if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria().equals(Tipos.Categoria.CONQUISTADOR)){
            categoriainserida.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria());
            descontocategoria.setText("-15%");
        }else if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria().equals(Tipos.Categoria.HONORARIO)){
            categoriainserida.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria());
            descontocategoria.setText("-25%");
        }else{
            categoriainserida.setText("Desconhecida");
            descontocategoria.setText("-0%");
        }
        
        if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getQuotaAtual() >=  year){
            imgerrado.setVisible(false);
            esclamacaoerrado.setVisible(false);
            ematraso.setVisible(false);
            imgcerto.setVisible(true);
            esclamacaocerto.setVisible(true);
            atualizadas.setVisible(true);
        }else{
            imgerrado.setVisible(true);
            esclamacaoerrado.setVisible(true);
            ematraso.setVisible(true);
            imgcerto.setVisible(false);
            esclamacaocerto.setVisible(false);
            atualizadas.setVisible(false);
        }
    }    
    
    @FXML
    private void handlePagarQuotasButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/PagarQuotas.fxml"));
        Scene cenapagarquotas = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenapagarquotas);
        stage.show();
    }
    
    @FXML
    private void handleReservarBilhetesButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/ReservarBilhetes.fxml"));
        Scene cenareservarbilhetes = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenareservarbilhetes);
        stage.show();
    }
    
    @FXML
    private void handleHistoricoBilheteiraButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/HistoricoBilheteira.fxml"));
        Scene cenahistoricobilheteira = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenahistoricobilheteira);
        stage.show();
    }
    
    @FXML
    private void handleHistoricoJogosButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/HistoricoJogos.fxml"));
        Scene cenahistoricojogos = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenahistoricojogos);
        stage.show();
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
