/*
 * Instituto Politécnico de Viana do Castelo 
 * Engenharia de Redes e Sistemas de Computadores
 * 2º Ano
 * Trabalho Prático P2
 * 
 */

// Codigo erro atual: 65 - o proximo tem de ser o atual + 1

package vitoriasc;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.css.SizeUnits.MM;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author João Diogo Nº 24831
 * @author Mariana Barreto Nº 23746
 */
public class vitoriasc extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    private static void timer(int i, ActionListener actListner) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        //Carregar os dados dos ficheiros
        Repositorio.getInstance().getSociosfiles().carregaDadosSocios();
        //Repositorio.getInstance().getSociosfiles().listarSocios();
        Repositorio.getInstance().getGestorfiles().carregaDadosModalidades();
        //Repositorio.getInstance().getGestorfiles().listarModalidade();
        Repositorio.getInstance().getGestorfiles().carregaDadosJogos();
        //Repositorio.getInstance().getGestorfiles().listarJogos();
        Repositorio.getInstance().getGestorfiles().carregaDadosBilhetes();
        //Repositorio.getInstance().getGestorfiles().listarBilhetes();
        
        // carrega ficheiro FXML
        Parent root = FXMLLoader.load(getClass().getResource("/gui_fxml/Inicial.fxml"));
        // define o nome a apresentar na janela
        stage.setTitle("Vitória SC");
        // modifica o icon
        stage.getIcons().add(new Image("/images/logo-1vitoriasc.png"));
        // imepede a redimensão
        stage.setResizable(false);
        // colocar a Scene no Stage
        stage.setScene(new Scene(root));
        // apresentar / atualizar o Stage
        stage.show();
        
        //Timer para ficar 3 segundos na página inicial
        
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/mm/yyyy");
        
        formatador.format( data );
        
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
    
        pause.setOnFinished(new EventHandler<ActionEvent>(){
        
            public void handle(ActionEvent t){
                
                //mudar de cena para o login
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/gui_fxml/Login.fxml"));
                    // define o nome a apresentar na janela
                    stage.setTitle("Vitória SC");
                    // imepede a redimensão
                    stage.setResizable(false);
                    // colocar a Scene no Stage
                    stage.setScene(new Scene(root));
                    // apresentar / atualizar o Stage
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(vitoriasc.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
     pause.play();
    }
}
