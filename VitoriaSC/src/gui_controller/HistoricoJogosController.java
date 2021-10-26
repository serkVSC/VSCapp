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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vitoriasc.Repositorio;

/**
 * FXML Controller class
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class HistoricoJogosController implements Initializable {

    @FXML
    private Label resultado;
    @FXML
    private Label horario;
    @FXML
    private ImageView imgboavista;
    @FXML
    private ImageView imgporto;
    @FXML
    private ImageView imgsporting;
    @FXML
    private ImageView imgbenfica;
    @FXML
    private ImageView imgrioave;
    @FXML
    private ImageView imgadv;
    @FXML
    private Label resultado1;
    @FXML
    private Label horario1;
    @FXML
    private ImageView imgboavista1;
    @FXML
    private ImageView imgporto1;
    @FXML
    private ImageView imgsporting1;
    @FXML
    private ImageView imgbenfica1;
    @FXML
    private ImageView imgrioave1;
    @FXML
    private ImageView imgadv1;
    @FXML
    private Label resultado2;
    @FXML
    private Label horario2;
    @FXML
    private ImageView imgboavista2;
    @FXML
    private ImageView imgporto2;
    @FXML
    private ImageView imgsporting2;
    @FXML
    private ImageView imgbenfica2;
    @FXML
    private ImageView imgrioave2;
    @FXML
    private ImageView imgadv2;
    @FXML
    private Rectangle ret;
    @FXML
    private Rectangle ret1;
    @FXML
    private Rectangle ret2;
    @FXML
    private ImageView vsc;
    @FXML
    private ImageView vsc1;
    @FXML
    private ImageView vsc2;
    @FXML
    private Button vermais;

 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        imgboavista.setVisible(false);
        imgporto.setVisible(false);
        imgsporting.setVisible(false);
        imgbenfica.setVisible(false);
        imgrioave.setVisible(false);
        imgadv.setVisible(true);
        imgboavista1.setVisible(false);
        imgporto1.setVisible(false);
        imgsporting1.setVisible(false);
        imgbenfica1.setVisible(false);
        imgrioave1.setVisible(false);
        imgadv1.setVisible(true);
        imgboavista2.setVisible(false);
        imgporto2.setVisible(false);
        imgsporting2.setVisible(false);
        imgbenfica2.setVisible(false);
        imgrioave2.setVisible(false);
        imgadv2.setVisible(true);
        vermais.setDisable(true);
        
        int jogo = Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos() - 1;
        int jogo1 = (jogo - 1);
        int jogo2 = (jogo - 2);
        String mes = "";
        String mes1 = "";
        String mes2 = "";
        
        if((Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos() ) >= 1){
            
            resultado.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(jogo).getResultadoE() + " : " + Repositorio.getInstance().getGestorfiles().obterJogo(jogo).getResultadoA());
            switch(Repositorio.getInstance().getGestorfiles().obterJogo(jogo).getMesjogo()){
                case 1: mes = "JAN";break;
                case 2: mes = "FEV";break;
                case 3: mes = "MAR";break;
                case 4: mes = "ABR";break;
                case 5: mes = "MAI";break;
                case 6: mes = "JUN";break;
                case 7: mes = "JUL";break;
                case 8: mes = "AGO";break;
                case 9: mes = "SET";break;
                case 10: mes = "OUT";break;
                case 11: mes = "NOV";break;
                case 12: mes = "DEZ";break;
                default: mes = "MM";
            }
            horario.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(jogo).getDiajogo() + " DE " + mes + " DE " + Repositorio.getInstance().getGestorfiles().obterJogo(jogo).getAnojogo());
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
        
        }else{
            imgboavista.setVisible(false);
            imgporto.setVisible(false);
            imgsporting.setVisible(false);
            imgbenfica.setVisible(false);
            imgrioave.setVisible(false);
            imgadv.setVisible(false);
            horario.setVisible(false);
            resultado.setVisible(false);
            vsc.setVisible(false);
            ret.setVisible(false);
            
            imgboavista1.setVisible(false);
            imgporto1.setVisible(false);
            imgsporting1.setVisible(false);
            imgbenfica1.setVisible(false);
            imgrioave1.setVisible(false);
            imgadv1.setVisible(false);
            horario1.setVisible(false);
            resultado1.setVisible(false);
            vsc1.setVisible(false);
            ret1.setVisible(false);
            
            imgboavista2.setVisible(false);
            imgporto2.setVisible(false);
            imgsporting2.setVisible(false);
            imgbenfica2.setVisible(false);
            imgrioave2.setVisible(false);
            imgadv2.setVisible(false);
            horario2.setVisible(false);
            resultado2.setVisible(false);
            vsc2.setVisible(false);
            ret2.setVisible(false);
        }
        
        if((Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos() ) >= 2){
            
            resultado1.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(jogo1).getResultadoE() + " : " + Repositorio.getInstance().getGestorfiles().obterJogo(jogo1).getResultadoA());
            switch(Repositorio.getInstance().getGestorfiles().obterJogo(jogo1).getMesjogo()){
                case 1: mes1 = "JAN";break;
                case 2: mes1 = "FEV";break;
                case 3: mes1 = "MAR";break;
                case 4: mes1 = "ABR";break;
                case 5: mes1 = "MAI";break;
                case 6: mes1 = "JUN";break;
                case 7: mes1 = "JUL";break;
                case 8: mes1 = "AGO";break;
                case 9: mes1 = "SET";break;
                case 10: mes1 = "OUT";break;
                case 11: mes1 = "NOV";break;
                case 12: mes1 = "DEZ";break;
                default: mes1 = "MM";
            }
            horario1.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(jogo1).getDiajogo() + " DE " + mes1 + " DE " + Repositorio.getInstance().getGestorfiles().obterJogo(jogo1).getAnojogo());
            switch(Repositorio.getInstance().getGestorfiles().obterJogo(jogo1).getAdversarios().toUpperCase()){
                case "PORTO":
                case "FCPORTO":
                case "FC PORTO": imgadv1.setVisible(false); imgporto1.setVisible(true); break;
                case "BENFICA":
                case "SLBENFICA":
                case "SL BENFICA": imgadv1.setVisible(false); imgbenfica1.setVisible(true); break;
                case "SPORTING":
                case "SPORTINGCP":
                case "SPORTING CP": imgadv1.setVisible(false); imgsporting1.setVisible(true); break;
                case "RIOAVE":
                case "RIO AVE":
                case "RIOAVE FC":
                case "RIOAVEFC":
                case "RIO AVE FC": imgadv1.setVisible(false); imgrioave1.setVisible(true); break;
                case "BOAVISTA":
                case "BOAVISTAFC":
                case "BOAVISTA FC": imgadv1.setVisible(false); imgboavista1.setVisible(true); break;
                default: imgadv1.setVisible(true);
            }
            
        }else{
            imgboavista1.setVisible(false);
            imgporto1.setVisible(false);
            imgsporting1.setVisible(false);
            imgbenfica1.setVisible(false);
            imgrioave1.setVisible(false);
            imgadv1.setVisible(false);
            horario1.setVisible(false);
            resultado1.setVisible(false);
            vsc1.setVisible(false);
            ret1.setVisible(false);
            
            imgboavista2.setVisible(false);
            imgporto2.setVisible(false);
            imgsporting2.setVisible(false);
            imgbenfica2.setVisible(false);
            imgrioave2.setVisible(false);
            imgadv2.setVisible(false);
            horario2.setVisible(false);
            resultado2.setVisible(false);
            vsc2.setVisible(false);
            ret2.setVisible(false);
        }
        
        if((Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos() ) >= 3){
            resultado2.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(jogo2).getResultadoE() + " : " + Repositorio.getInstance().getGestorfiles().obterJogo(jogo2).getResultadoA());
            switch(Repositorio.getInstance().getGestorfiles().obterJogo(jogo2).getMesjogo()){
                case 1: mes2 = "JAN";break;
                case 2: mes2 = "FEV";break;
                case 3: mes2 = "MAR";break;
                case 4: mes2 = "ABR";break;
                case 5: mes2 = "MAI";break;
                case 6: mes2 = "JUN";break;
                case 7: mes2 = "JUL";break;
                case 8: mes2 = "AGO";break;
                case 9: mes2 = "SET";break;
                case 10: mes2 = "OUT";break;
                case 11: mes2 = "NOV";break;
                case 12: mes2 = "DEZ";break;
                default: mes2 = "MM";
            }
            horario2.setText("" + Repositorio.getInstance().getGestorfiles().obterJogo(jogo2).getDiajogo() + " DE " + mes2 + " DE " + Repositorio.getInstance().getGestorfiles().obterJogo(jogo2).getAnojogo());
            switch(Repositorio.getInstance().getGestorfiles().obterJogo(jogo2).getAdversarios().toUpperCase()){
                case "PORTO":
                case "FCPORTO":
                case "FC PORTO": imgadv2.setVisible(false); imgporto2.setVisible(true); break;
                case "BENFICA":
                case "SLBENFICA":
                case "SL BENFICA": imgadv2.setVisible(false); imgbenfica2.setVisible(true); break;
                case "SPORTING":
                case "SPORTINGCP":
                case "SPORTING CP": imgadv2.setVisible(false); imgsporting2.setVisible(true); break;
                case "RIOAVE":
                case "RIO AVE":
                case "RIOAVE FC":
                case "RIOAVEFC":
                case "RIO AVE FC": imgadv2.setVisible(false); imgrioave2.setVisible(true); break;
                case "BOAVISTA":
                case "BOAVISTAFC":
                case "BOAVISTA FC": imgadv2.setVisible(false); imgboavista2.setVisible(true); break;
                default: imgadv2.setVisible(true);
            }
        }else{
            imgboavista2.setVisible(false);
            imgporto2.setVisible(false);
            imgsporting2.setVisible(false);
            imgbenfica2.setVisible(false);
            imgrioave2.setVisible(false);
            imgadv2.setVisible(false);
            horario2.setVisible(false);
            resultado2.setVisible(false);
            vsc2.setVisible(false);
            ret2.setVisible(false);
        }
        if((Repositorio.getInstance().getGestorfiles().obterQuantidadeJogos()) >= 4){
            vermais.setDisable(false);
        }
    }


    @FXML
    private void handleMoreButton(ActionEvent event) throws IOException {
        Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/ListarJogos.fxml"));
        Scene cenavisualizarsocio = new Scene(ecra2Parent);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(cenavisualizarsocio);
        stage.show();
    }

    @FXML
    private void handleVoltarButton(ActionEvent event) throws IOException{
        if(LoginController.getWhois() == 0){
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuGestor.fxml"));
            Scene cenagestor = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenagestor);
            stage.show();
        }else{
            Parent ecra2Parent = FXMLLoader.load(getClass().getResource("/gui_fxml/MenuSocios.fxml"));
            Scene cenasocios = new Scene(ecra2Parent);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(cenasocios);
            stage.show();           
        }
    }
}