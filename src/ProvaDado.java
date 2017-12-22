/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Simone.Pontalti
 */
public class ProvaDado extends Application {
    
    static int contatore=10;
    int base = 500;
    int altezza= 400;
    
    
    static HBox hb2;
    
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("RESET");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("STAMPA");
        
        ToggleButton tb = new ToggleButton();
        tb.setText("SPOSTAMENTO");
        
        Label lbl1 = new Label();
        lbl1.setText("CONTATORE   : "+contatore);
        
        
       //=============================================================
          
         // Dado d1 = new Dado();
         // Dado d2 = new Dado();
          //Dado d3 = new Dado();
          
        GestoreEvento1 g1 = new GestoreEvento1();
        
        //=============================================================
        HBox hb1 = new HBox(10); 
        hb1.setPrefHeight(10);
        hb1.setStyle("-fx-background-color: lightblue ;-fx-border-color: black;");
        hb1.getChildren().addAll(btn1,btn2,tb,lbl1);
        
        hb2 = new HBox(10);
        hb2.setPadding(new Insets(50, 10, 50, 10));
        hb2.setPrefHeight(400); //
        hb2.setAlignment(Pos.CENTER);
        hb2.setStyle("-fx-background-color: lightgreen ;-fx-border-color: red;");
  //      hb2.getChildren().addAll(d1,d2,d3); 
        
        
        
        hb2.addEventHandler(MouseEvent.MOUSE_PRESSED, g1);
        
        VBox vb1 = new VBox(10);
        vb1.getChildren().addAll(hb2,hb1);
        
        Scene scene = new Scene(vb1, 600, 200);
        
        primaryStage.setTitle("Gioco dadi");
        primaryStage.setScene(scene);
        primaryStage.setHeight(altezza);
        primaryStage.setWidth(base);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
