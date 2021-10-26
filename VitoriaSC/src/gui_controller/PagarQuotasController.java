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
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vitoriasc.Repositorio;
import vitoriasc.Tipos;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class PagarQuotasController implements Initializable {

    @FXML
    private Label quotasocio;
    @FXML
    private Label quotatual;
    @FXML
    private Label quotaprevista;
    @FXML
    private Label previsao;
    @FXML
    private Label calculoquota;
    @FXML
    private Label subtotal;
    @FXML
    private Label total;
    @FXML
    private TextField nquotaspagar;
    @FXML
    private Label quotasematraso;
    @FXML
    private Label txterror;
    @FXML
    private Separator s1;
    @FXML
    private Label novacat;
    @FXML
    private Label txterror2;
    
    Calendar cal = Calendar.getInstance();
    private int day = cal.get(Calendar.DATE);
    private int month = cal.get(Calendar.MONTH) + 1;
    private int year = cal.get(Calendar.YEAR);
    private int flag = 0;
    private int numquotas = 0;
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flag = 0;
        txterror2.setVisible(false);
        novacat.setVisible(false);
        calculoquota.setVisible(false);
        subtotal.setVisible(false);
        txterror.setVisible(false);
        total.setText("0 €");
        s1.setStyle("-fx-background-color: transparent"); 
        
        quotaprevista.setVisible(false);
       
        previsao.setVisible(false);
        quotatual.setText("" + year);
        quotasocio.setText("" + Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getQuotaAtual());
        
        int calcularquotasatrasadas = 0; 
        calcularquotasatrasadas = year - Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getQuotaAtual();
        if(calcularquotasatrasadas < 0)
            calcularquotasatrasadas = 0;
        quotasematraso.setText("" + calcularquotasatrasadas);
    }   
    
    @FXML
    private void handleMelhorCategoriaButton(ActionEvent event) {
        if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria() == Tipos.Categoria.AFONSINHO || Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria() == Tipos.Categoria.CONQUISTADOR){
            flag = 1;
            total.setText("" + ((numquotas * Repositorio.getPrecoquotas())+20) + "€");
            novacat.setVisible(true);
        }else{
            flag = 0;
            txterror2.setVisible(true);
        }
    }
    
    @FXML
    private void hundleAtualizaTalao(KeyEvent event) throws IOException {
        if(nquotaspagar.getText().trim().isEmpty()){
            s1.setStyle("-fx-background-color: transparent"); 
            txterror.setVisible(false);
        }else{
            previsao.setVisible(true);
            txterror.setVisible(false);
            quotaprevista.setVisible(true);
            numquotas = Integer.parseInt(nquotaspagar.getText());
            if(numquotas >= 0 && numquotas < 15){
            previsao.setText("" + (Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getQuotaAtual() + numquotas)); 
            calculoquota.setText("" + numquotas + " x " + Repositorio.getPrecoquotas());
            calculoquota.setVisible(true);
            subtotal.setText("" + (numquotas * Repositorio.getPrecoquotas()) + "€");
            subtotal.setVisible(true);
            if(flag == 0){
                total.setText("" + (numquotas * Repositorio.getPrecoquotas()) + " €");
            }else{
                total.setText("" + ((numquotas * Repositorio.getPrecoquotas())+20) + "€"); 
            }
            }else{
                txterror.setVisible(true);
                System.out.println("[ERRO] Não podem ser inseridos codigos negatios > Code: 30");
                s1.setStyle("-fx-background-color: #f04a4a");
            }
        }
    }
    
    @FXML
    private void handlePagarButton(ActionEvent event) throws IOException {
        int novaquota;
        int erro = 0;
        
        if(nquotaspagar.getText().isEmpty()){
            if(flag == 0){
                erro = 32;
                System.out.println("[ERRO] Erro ao comprar quota > Code: " + erro);
            }else{
                if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria() == Tipos.Categoria.AFONSINHO){
                    Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).setCategoria(Tipos.Categoria.CONQUISTADOR);
                }else if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria() == Tipos.Categoria.CONQUISTADOR){
                    Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).setCategoria(Tipos.Categoria.HONORARIO);
                }else{
                    erro = 65;
                    System.out.println("[ERRO] Erro ao comprar categoria > Code: " + erro);                
                }
                Repositorio.getInstance().getSociosfiles().guardarDadosSocios();
                System.out.println("[INFO] Categoria atualizada.");
            }
        }else{
            numquotas = Integer.parseInt(nquotaspagar.getText());
            if(numquotas < 0 || numquotas > 15){
                erro = 32;
                System.out.println("[ERRO] Erro ao comprar quota > Code: " + erro);
            }else{
                novaquota = (Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getQuotaAtual()) + numquotas;
                Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).setQuotaAtual(novaquota);
                Repositorio.getInstance().getSociosfiles().guardarDadosSocios();
                System.out.println("[INFO] Quota do socio " + LoginController.getWhois() + " atualizadas.");
                if(flag == 1){
                    if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria() == Tipos.Categoria.AFONSINHO){
                        Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).setCategoria(Tipos.Categoria.CONQUISTADOR);
                    }else if(Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getCategoria() == Tipos.Categoria.CONQUISTADOR){
                        Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).setCategoria(Tipos.Categoria.HONORARIO);
                    }else{
                        erro = 65;
                        System.out.println("[ERRO] Erro ao comprar categoria > Code: " + erro);                
                    }
                    Repositorio.getInstance().getSociosfiles().guardarDadosSocios();
                    System.out.println("[INFO] Categoria atualizada.");
                }
            }
        }
        
        if(erro == 0){
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuSocios.fxml"));
            Scene cenalogin = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenalogin);
            stage.show();
        }else{
            s1.setStyle("-fx-background-color: #f04a4a");
            txterror.setVisible(true);           
            System.out.println("[ERRO] Erro ao comprar quota > Code: 33" );
        }
    }
    
    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuSocios.fxml"));
        Scene cenalogin = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenalogin);
        stage.show();
    }    
}
