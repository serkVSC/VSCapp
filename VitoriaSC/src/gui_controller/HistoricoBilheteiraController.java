package gui_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import vitoriasc.Bilhete;
import vitoriasc.Jogo;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class HistoricoBilheteiraController implements Initializable {

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
     * Define todas as colunas da tabela e os seus valores
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
        
        // Adciona à tabela todos os jogos em que o socio tenha tido o bilhete aprovado
        Integer[] array = new Integer[50];
        array = Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getBilhetesComprados();
        
        for(int i = 0; i < Repositorio.getInstance().getSociosfiles().obterSocio(LoginController.getWhois()).getBilhetesComprados().length; i++){
            if(array[i] == null){
            }else{
                tablejogos.getItems().add(Repositorio.getInstance().getGestorfiles().obterJogo(array[i]));
            }
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
