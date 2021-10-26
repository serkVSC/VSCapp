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
import javafx.stage.Stage;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class MenuGestorController implements Initializable {

    @FXML
    private Label menugestor;
    @FXML
    private Label voltar;
    @FXML
    private Label msgerro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msgerro.setVisible(false);
    }    

    @FXML
    private void handleVisualizarSocioButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/ProcurarSocio.fxml"));
        Scene cenavisualizarsocio = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenavisualizarsocio);
        stage.show();
    }
    
    @FXML
    private void handleControlarModalidadesButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/Modalidades.fxml"));
        Scene cenamodalidades = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenamodalidades);
        stage.show();
    }
    
    @FXML
    private void handleInserirJogoButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/InserirJogo.fxml"));
        Scene cenainserirjogo = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenainserirjogo);
        stage.show();
    }
    
    @FXML
    private void handleVisualizarInformacaoButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/Listar.fxml"));
        Scene cenavisualizarinformacoes = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenavisualizarinformacoes);
        stage.show();
    }
    
    @FXML
    private void handleValidarComprasButton(ActionEvent event) throws IOException {
        if(!Repositorio.getInstance().getGestorfiles().getBilhetes().isEmpty()){
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/ValidarCompras.fxml"));
            Scene cenavalidarcompras = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenavalidarcompras);
            stage.show();
        }else{
            msgerro.setVisible(true);
        }
    }

    @FXML
    private void handleAlterarJogosButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/AlterarJogos.fxml"));
        Scene cenaalterarjogos = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenaalterarjogos);
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
