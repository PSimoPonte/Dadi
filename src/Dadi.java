/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Simone.Pontalti
 * <p>
 * Questa classe rappresenta la <strong> finestra principale </strong> 
 * dove apparirà il campo verde e i tasti d'azione
 */
public class Dadi extends Application {
    
 //   Box xb = new Box();
    
    Button btn2,btn1;
    
    int base = 485;
    int altezza= 485;
    static int numTentativo=10;
    static Label lbl1;
    static HBox hb2;
    static CampoVerde cv;
    
    
    @Override
    public void start(Stage primaryStage) {
        btn1 = new Button();
        btn1.setText("RESET");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
               
                cv.numeroDadi=0;
                numTentativo=10;
                cv.reset();
                //lbl1.setText("===================");
                lbl1.setText("CONTATORE   : "+numTentativo);
                
            }
        });
        
        btn2 = new Button();
        btn2.setText("STAMPA");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hai cliccato sul bottone stampa!");
                
                String mess= cv.stampa();
                CampoVerde.showPopup(mess);
                
            }
        });
        
        ToggleButton tb = new ToggleButton();
        tb.setText("SPOSTAMENTO");
         tb.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
         
                
                if(tb.getText().equalsIgnoreCase("SPOSTAMENTO")){
                
                    tb.setText("DISSOLVIMENTO");
                }
                else if(tb.getText().equalsIgnoreCase("DISSOLVIMENTO")){
                
                    tb.setText("SPOSTAMENTO");
                }
            }
        });
        
         lbl1 = new Label();
        lbl1.setText("CONTATORE   : "+numTentativo);
        
        
       //=============================================================
          
         // Dado d1 = new Dado();
         // Dado d2 = new Dado();
          //Dado d3 = new Dado();
          
    //    GestoreEvento1 g1 = new GestoreEvento1();
        
        //=============================================================
    HBox hb1 = new HBox(10); 
    hb1.setPrefHeight(10);
    hb1.setStyle("-fx-background-color: lightblue ;-fx-border-color: black;");
    hb1.getChildren().addAll(btn1,btn2,tb,lbl1);


      // CREIAMO UN OGGETTO DEL TIPO CampoVerde che è un GridPane e lo aggiungo
      // all'HBOX
        
      // istanzio una zona verde dove vengono aggiunti i dadi
      
       cv = new CampoVerde();
        
       
        
        
   // QUESTO EVENTO NON SERVE PIù, POICHè L'EVENTO SARà SUL GRIDPANE     
   //      hb2.addEventHandler(MouseEvent.MOUSE_PRESSED, g1);
        
        VBox vb1 = new VBox(10);
        vb1.getChildren().addAll(cv,hb1);
        
        Scene scene = new Scene(vb1, 600, 200);
        
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, keyEventHandler);
        
        primaryStage.setTitle("Gioco dadi");
        primaryStage.setScene(scene);
        primaryStage.setHeight(altezza);
        primaryStage.setWidth(base);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest((new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent arg0){
            
                Platform.exit();
            }
            }));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public static void controllaVincita(){
    
     //andare a visitare il gridpane del campo verde per trovare i dadi. 
     //Per ogni dado trovato devo accedere alla proprietà num.Punti del dado
     //faremo così il controllo se i numeri sono 3 / 4 e 5
    }
    
    //#########################################################################
  //#######           EVENTO PER IL CLICK DA TASTIERA!!!     #################
  //##########################################################################
  EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>(){
    
       public void handle(final KeyEvent e){

        //KeyCode st = e.getCode();

      // System.out.println(e.getSource()+ " => " + e.getTarget());
         switch(e.getCode()){

             case S: System.out.println("Hai cliccato su S, quindi SU STAMPA!");
             btn2.fireEvent(new ActionEvent());
             break;

             case R: System.out.println("Hai cliccato su R, quindi SU RESET!");
             btn1.fireEvent(new ActionEvent());
             break;


         }
      }
        
  };
 //###########################################################################
 //############################################################################
 //############################################################################  

    
}
