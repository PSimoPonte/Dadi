/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transition;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Simone.Pontalti
 */
public class NewFXMain extends Application {
    
    Rectangle rect;
    static TranslateTransition transizione;
    
    @Override
    public void start(Stage primaryStage) {
      
        
        rect = new Rectangle(50, 50);
        transizione = new TranslateTransition(new Duration(2000),rect);
        move(1);
        
        
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: green ;-fx-border-color: black;");
        root.getChildren().add(rect);
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Ciao Pino !");
                transizione.play();
                
            }
        });
        
        VBox vb = new VBox(10);
        vb.getChildren().addAll(btn,root);
        
        Scene scene = new Scene(vb, 300, 250);
        
        primaryStage.setTitle("Translate Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    public static void move(int x){
        
        
        transizione.setFromX(50);
        transizione.setToX(350);
        transizione.setCycleCount(1);
        transizione.setAutoReverse(true);
    }
}
