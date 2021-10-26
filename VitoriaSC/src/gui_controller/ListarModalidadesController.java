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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import vitoriasc.Modalidade;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class ListarModalidadesController implements Initializable {

    @FXML
    private Label voltar;
    @FXML
    private Label listarmodalidades;
    @FXML
    private TableView<Modalidade> tablemodalidades;
    @FXML
    private TableColumn<Modalidade, String> codigo;
    @FXML
    private TableColumn<Modalidade, String> modalidade;
    @FXML
    private TableColumn<Modalidade, String> equipa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codigo.setCellValueFactory(new PropertyValueFactory<>("cod_modalidade"));
        modalidade.setCellValueFactory(new PropertyValueFactory<>("nome"));
        equipa.setCellValueFactory(new PropertyValueFactory<>("nomeequipa"));
        tablemodalidades.getItems().setAll(Repositorio.getInstance().getGestorfiles().getModalidades());
    }    

    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/Listar.fxml"));
        Scene cenalogin = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenalogin);
        stage.show();
    }  
    
}
