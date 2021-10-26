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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class AlterarJogosController implements Initializable {

    @FXML
    private TextField procurarjogo;
    @FXML
    private Separator s1;
    @FXML
    private Label resultadoE;
    @FXML
    private Label resultadoA;
    @FXML
    private Button cima1;
    @FXML
    private Button baixo1;
    @FXML
    private Button baixo2;
    @FXML
    private Button cima2;
    @FXML
    private Label adversarios;
    @FXML
    private Label msgerro;
    @FXML
    private ImageView imgadv;
    @FXML
    private ImageView imgsporting;
    @FXML
    private ImageView imgrioave;
    @FXML
    private ImageView imgbenfica;
    @FXML
    private ImageView imgboavista;
    @FXML
    private ImageView imgporto;
    
    private int resultado1;
    private int resultado2;
    private int jogo = -1;
    @FXML
    private Button alterar;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /* Colova invisiveis e valores defaults em todos os campos para quando abrir a janela
         * Começar tudo de novo */
        s1.setStyle("-fx-background-color: transparent");
        msgerro.setVisible(false);
        resultadoE.setText("0");
        resultadoA.setText("0");
        adversarios.setText("Adversário");
        resultado1 = 0;
        resultado2 = 0;
        imgadv.setVisible(true);
        imgsporting.setVisible(false);
        imgrioave.setVisible(false);
        imgbenfica.setVisible(false);
        imgboavista.setVisible(false);
        imgporto.setVisible(false);
        
        // disable aos botoes
        cima1.setDisable(true);
        baixo1.setDisable(true);
        cima2.setDisable(true);
        baixo2.setDisable(true);
        alterar.setDisable(true);
    }    

    @FXML
    private void handlePesquisarSociosButton(ActionEvent event) {
        int erro = 0;
        resultado1 = 0;
        resultado2 = 0;
        
        imgadv.setVisible(true);
        imgsporting.setVisible(false);
        imgrioave.setVisible(false);
        imgbenfica.setVisible(false);
        imgboavista.setVisible(false);
        imgporto.setVisible(false);
        
        
        //verifica se o texfield esta vazio, caso sim devolve erro
        if(procurarjogo.getText().trim().isEmpty()){
            erro = 64; System.out.println("[ERRO] No pesquisar Jogo. > Code: " + erro);
            s1.setStyle("-fx-background-color: #f04a4a");      
            msgerro.setVisible(true);
        // se nao tiver passa o campo para inteiro
        }else{
            jogo = Integer.parseInt(procurarjogo.getText());
            // depois verifica que o valor inserido está no dominio incorreto, se sim devolve erro
            if(jogo < 0 || jogo >= Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos()){
                erro = 65; System.out.println("[ERRO] No pesquisar Jogo. > Code: " + erro);
                s1.setStyle("-fx-background-color: #f04a4a");      
                msgerro.setVisible(true);
            }
        }
        
        /*
         caso não existirem erro, com o valor do jogo que obteu
        define todos os campos de acordo com esse jogo */
        
        if(erro == 0){
            msgerro.setVisible(false);
            s1.setStyle("-fx-background-color: transparent");
            //obtem adversario e coloca na label
            adversarios.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(jogo).getAdversarios());
            //verifica se o adversario (em maiusculas) corresponde a algum case do switch
            //se sim coloca o logotipo do clube visivel e torna o logotipo default invisivel
            switch(Repositorio.getInstance().getGestorfiles().obterJogo(jogo).getAdversarios().toUpperCase()){
                case "PORTO":
                case "FCPORTO":
                case "FC PORTO": imgadv.setVisible(false); imgporto.setVisible(true); break;
                case "BENFICA":
                case "SLBENFICA":
                case "SL BENFICA": imgadv.setVisible(false); imgbenfica.setVisible(true); break;
                case "SPORTING":
                case "SPORTINGCP":
                case "SPORTING CP": imgadv.setVisible(false); imgsporting.setVisible(true); break;
                case "RIOAVE":
                case "RIO AVE":
                case "RIOAVE FC":
                case "RIOAVEFC":
                case "RIO AVE FC": imgadv.setVisible(false); imgrioave.setVisible(true); break;
                case "BOAVISTA":
                case "BOAVISTAFC":
                case "BOAVISTA FC": imgadv.setVisible(false); imgboavista.setVisible(true); break;
                default: imgadv.setVisible(true);
            }
            //habilita os botoes de aumentar e diminuir o score
            cima1.setDisable(false);
            baixo1.setDisable(false);
            cima2.setDisable(false);
            baixo2.setDisable(false);
            alterar.setDisable(false);
        }
    }
    
    //aumenta um valor na label da Equipa VSC ao pressionar o botao
    @FXML
    private void handleAumentar1Button(ActionEvent event) throws IOException {
        if(resultado1 < 15)
            resultado1++;
        resultadoE.setText("" + resultado1);
    }
    
    //diminui um valor na label da Equipa VSC ao pressionar o botao 
    @FXML
    private void handleDiminuir1Button(ActionEvent event) throws IOException {
        if(resultado1 > 0)
            resultado1--;
        resultadoE.setText("" + resultado1);
    }
    
    //aumenta um valor na label da Equipa Adversaria ao pressionar o botao
    @FXML
    private void handleAumentar2Button(ActionEvent event) throws IOException {
        if(resultado2 < 15)
            resultado2++;
        resultadoA.setText("" + resultado2);
    }
    
    //diminui um valor na label da Equipa Adversaria ao pressionar o botao
    @FXML
    private void handleDiminuir2Button(ActionEvent event) throws IOException {
        if(resultado2 > 0)
            resultado2--;
        resultadoA.setText("" + resultado2);
    }

    /*
    Ao pressionar este botao ele obtoe o valor que esta nas labels
    e altera o reultado de ambas as equipas no jogo correspondente.
    Depois guarda as alterações nos ficheiros
    */
    @FXML
    private void handleAlterarButton(ActionEvent event) throws IOException {
        Repositorio.getInstance().getGestorfiles().obterJogo(jogo).setResultadoE(resultado1);
        Repositorio.getInstance().getGestorfiles().obterJogo(jogo).setResultadoA(resultado2);
        System.out.println("[INFO] Resultado do jogo atualizado");
        Repositorio.getInstance().getGestorfiles().guardarDadosJogos();
        
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
        Scene cenalogin = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenalogin);
        stage.show();
    }

    //volta ao menu anterior
    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
        Scene cenagestor = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenagestor);
        stage.show();
    }    
}
