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

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class ListarController implements Initializable {

    @FXML
    private Label visualizarinformacoes;
    @FXML
    private Label voltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSociosButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/ListarSocios.fxml"));
        Scene cenavisualizarsocio = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenavisualizarsocio);
        stage.show();
    }

    @FXML
    private void handleModalidadesButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/ListarModalidades.fxml"));
        Scene cenamodalidades = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenamodalidades);
        stage.show();
    }
    
    @FXML
    private void handleJogosButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/HistoricoJogos.fxml"));
        Scene cenavisualizarjogo = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenavisualizarjogo);
        stage.show();
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
