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
import vitoriasc.Repositorio;
import vitoriasc.Socio;
import vitoriasc.Tipos;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class ListarSociosController implements Initializable {

    @FXML
    private Label voltar;
    @FXML
    private Label listarsocios;
    @FXML
    private TableView<Socio> tablesocios;
    @FXML
    private TableColumn<Socio, String> num;
    @FXML
    private TableColumn<Socio, String> nome;
    @FXML
    private TableColumn<Socio, String> quota;
    @FXML
    private TableColumn<Socio, String> datanasc;
    @FXML
    private TableColumn<Socio, String> sexo;
    @FXML
    private TableColumn<Socio, Tipos.Categoria> categoria;
    @FXML
    private TableColumn<Socio, String> password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        num.setCellValueFactory(new PropertyValueFactory<>("NumeroSocio"));
        nome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        quota.setCellValueFactory(new PropertyValueFactory<>("QuotaAtual"));
        datanasc.setCellValueFactory(new PropertyValueFactory<>("Ano"));
        sexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        categoria.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        tablesocios.getItems().setAll(Repositorio.getInstance().getSociosfiles().getSocios());
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
