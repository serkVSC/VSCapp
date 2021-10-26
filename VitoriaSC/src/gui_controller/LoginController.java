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
import javafx.scene.control.*;
import javafx.stage.Stage;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class LoginController implements Initializable {

    @FXML
    private TextField numsocioinserido;
    @FXML
    private PasswordField passwordinserida;
    @FXML
    private Label errortext;
    
    private static int whois;

    public static int getWhois() {
        return whois;
    }

    public static void setWhois(int whois) {
        LoginController.whois = whois;
    }
    
    
    /**
     * Initializes the controller class.
     * @param url   
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errortext.setVisible(false);
    }    

    @FXML
    public void handleRegistarButton(ActionEvent event) throws IOException {
        
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/InserirSocio.fxml"));
        Scene cenainserir = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenainserir);
        stage.show();
    }
    
    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        whois = Integer.parseInt(numsocioinserido.getText());
        String passwdwhois = passwordinserida.getText();
        
        if(whois > 0 && whois < Repositorio.getInstance().getSociosfiles().obterQuantidadeSocios() && Repositorio.getInstance().getSociosfiles().obterPassword(whois).equals(passwdwhois) && !numsocioinserido.getText().trim().isBlank()){
            System.out.println("[INFO] Menu do sócio carregado! Sócio: " + whois);
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuSocios.fxml"));
            Scene cena = new Scene(ecra2Parent);
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cena);
            stage.show();
        }else if(whois == 0 && Repositorio.getInstance().getSociosfiles().obterSocio(whois).getPassword().equals(passwdwhois)&& !passwordinserida.getText().trim().isBlank()){
            System.out.println("[INFO] Menu do gestor carregado! Utilizador: " + whois);
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
            Scene cena = new Scene(ecra2Parent);
            
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cena);
            stage.show();
        }else{
            System.out.println("[ERRO] Existem campos incorretos > Code: 22");
            errortext.setVisible(true);
        }
    }
    
}
