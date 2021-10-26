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
import vitoriasc.Jogo;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class ListarJogosController implements Initializable {

    @FXML
    private Label voltar;
    @FXML
    private Label listarjogos;
    @FXML
    private TableView<Jogo> tablejogos;
    @FXML
    private TableColumn<Jogo, String> modalidade;
    @FXML
    private TableColumn<Jogo, String> adversario;
    @FXML
    private TableColumn<Jogo, String> dia;
    @FXML
    private TableColumn<Jogo, String> mes;
    @FXML
    private TableColumn<Jogo, String> ano;
    @FXML
    private TableColumn<Jogo, String> scoreCasa;
    @FXML
    private TableColumn<Jogo, String> scoreFora;
    @FXML
    private TableColumn<Jogo, String> Preco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modalidade.setCellValueFactory(new PropertyValueFactory<>("id_modalidade"));
        adversario.setCellValueFactory(new PropertyValueFactory<>("adversarios"));
        dia.setCellValueFactory(new PropertyValueFactory<>("Diajogo"));
        mes.setCellValueFactory(new PropertyValueFactory<>("Mesjogo"));
        ano.setCellValueFactory(new PropertyValueFactory<>("Anojogo"));
        scoreCasa.setCellValueFactory(new PropertyValueFactory<>("ResultadoE"));
        scoreFora.setCellValueFactory(new PropertyValueFactory<>("ResultadoA"));
        Preco.setCellValueFactory(new PropertyValueFactory<>("PrecoBilhete"));
        tablejogos.getItems().setAll(Repositorio.getInstance().getGestorfiles().getJogos());
    }    

    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        if(LoginController.getWhois()==0){
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/Listar.fxml"));
        Scene cenalistar = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenalistar);
        stage.show();
        }else{
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/HistoricoJogos.fxml"));
        Scene cenajogos = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenajogos);
        stage.show();
        }
        
    }  
    
}
