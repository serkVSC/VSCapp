package gui_controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class ValidarComprasController implements Initializable {

    @FXML
    private Label validada;
    @FXML
    private Label invalidada;
    @FXML
    private Label socio1;
    @FXML
    private Label atraso1;
    @FXML
    private Label dia1;
    @FXML
    private Label jogo1;
    @FXML
    private Label preco1;
    
    Calendar cal = Calendar.getInstance();
    private int day = cal.get(Calendar.DATE);
    private int month = cal.get(Calendar.MONTH) + 1;
    private int year = cal.get(Calendar.YEAR);    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validada.setVisible(false);
        invalidada.setVisible(false);
        atraso1.setVisible(false);
        dia1.setVisible(false); 
        if(!Repositorio.getInstance().getGestorfiles().getBilhetes().isEmpty()){
            socio1.setText("" + Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdSocio());
            if(Repositorio.getInstance().getSociosfiles().obterSocio(Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdSocio()).getQuotaAtual() >= year){
                dia1.setVisible(true);
            }else{
                atraso1.setVisible(true);
            }
            jogo1.setText("" + Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdJogo());
            preco1.setText("" +Repositorio.getInstance().getGestorfiles().getBilhetes().element().getPrecoPago() + " €");
        }
    }    
    
    
    @FXML
    private void hundleNoButton(ActionEvent event) throws IOException {
        Repositorio.getInstance().getGestorfiles().getBilhetes().poll();
        validada.setVisible(false);
        Repositorio.getInstance().getGestorfiles().guardarDadosBilhetes();
        
        atraso1.setVisible(false);
        dia1.setVisible(false);
        
        if(!Repositorio.getInstance().getGestorfiles().getBilhetes().isEmpty()){
        socio1.setText("" + Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdSocio());
            if(Repositorio.getInstance().getSociosfiles().obterSocio(Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdSocio()).getQuotaAtual() >= year){
                dia1.setVisible(true);
            }else{
                atraso1.setVisible(true);
            }
            jogo1.setText("" + Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdJogo());
            preco1.setText("" +Repositorio.getInstance().getGestorfiles().getBilhetes().element().getPrecoPago() + " €");
            invalidada.setVisible(true);
            System.out.println("[INFO] Compra invalidada. Reserva removida da Queue.");
        }else{
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
            Scene cenagestor = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenagestor);
            stage.show();
        }
    }
    
    @FXML
    private void hundleValidarButton(ActionEvent event) throws IOException {
        invalidada.setVisible(false);
        atraso1.setVisible(false);
        dia1.setVisible(false);
        
        Repositorio.getInstance().getSociosfiles().obterSocio(Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdSocio()).addBilhetesComprados(Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdJogo());
        Repositorio.getInstance().getGestorfiles().getBilhetes().poll();
        Repositorio.getInstance().getGestorfiles().guardarDadosBilhetes();
        Repositorio.getInstance().getSociosfiles().guardarDadosSocios();
        
        if(!Repositorio.getInstance().getGestorfiles().getBilhetes().isEmpty()){
            socio1.setText("" + Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdSocio());
            if(Repositorio.getInstance().getSociosfiles().obterSocio(Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdSocio()).getQuotaAtual() >= year){
                dia1.setVisible(true);
            }else{
                atraso1.setVisible(true);
            }
            validada.setVisible(true);
            System.out.println("[INFO] Compra validada. Reserva removida da Queue.");
            jogo1.setText("" + Repositorio.getInstance().getGestorfiles().getBilhetes().element().getIdJogo());
            preco1.setText("" +Repositorio.getInstance().getGestorfiles().getBilhetes().element().getPrecoPago() + " €");
        }else{
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
            Scene cenagestor = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenagestor);
            stage.show();
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
