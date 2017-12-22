

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


/**
 *
 * @author Simone.Pontalti
 * <p>
 * Questa classe mi consente di creare il dado. Si tratta di un
 * gridpane in miniatura
 */
public class Dado extends GridPane {
    
    int nCol= 3;
    int nRow= 3;
    int numeroPalline = 0;
    
    public Dado(){
    
         this.setGridLinesVisible(false);
         this.setStyle("-fx-background-color: white ;-fx-border-color: black;");
//#############################################################################
//#############################################################################
/////// COSTRUZIONE DELLLA GRIGLIA 3x3 CELLE  //////////

        for(int i=0;i<nRow;i++) 
        {
            for(int j = 0;j<nCol;j++)
                
            {
        
            }
        }
    //   this.setHgap(30);
     //  this.setVgap(30);
       
  
        for (int i = 0; i < nRow; i++) {
           this.getRowConstraints().add(new RowConstraints(5, 
                    Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, 
                    Priority.ALWAYS, VPos.CENTER, true));
        }
        for (int i = 0; i < nCol; i++) {
            this.getColumnConstraints().add(new ColumnConstraints(5, 
                    Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, 
                    Priority.ALWAYS, HPos.CENTER, true));
  
        }

 this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
   public void handle (MouseEvent event) {


    System.out.println("Hai cliccato su un dado!!");

    if(Dadi.numTentativo > 0){

          CambiaPunti(); //funzione che rimuove le palline (cerchi) dal gridpane 
                            //del DADO
          int x=randInt(1,6);
          numeroPalline=x;
          System.out.println("n. palline: "+x);
          creaPallini(x); //funzione che crea un numero di pallini casuali
          Dadi.numTentativo--;
          System.out.println("NUMERO TENTATIVO :  "
                                    +Dadi.numTentativo);
          Dadi.lbl1.setText("contatore  :  "
                                    +Dadi.numTentativo);

          //CampoVerde cmp = new CampoVerde();
          Dadi.cv.controllaVincita();

    }else{

        System.out.println("GAME OVER");
         CampoVerde.showPopup("GAME OVER! Tentativi finiti!");
    }


}
      
      
});
        
        int x=randInt(1,6);
        System.out.println("n. palline: "+x);
        numeroPalline=x;
        creaPallini(x);
        
        
    }

    /**
     * funzione per generare un valore casuale tra 0 e 5
     * @param min il minimo
     * @param max il massimo
     * @return il valore specifico
     */
    public int randInt(int min,int max) { 
        return (min+ (int)(Math.random()* ((max-min)+1)));
    }

    /**
     * metodo che mi crea i pallini sul dado
     * @param num 
     */
    
    public void creaPallini (int num){
        
        
        if (num==1){
            Circle c1 = new Circle(6,6,6);
            c1.setFill(Color.BLACK);
            this.add(c1,1,1);
            
        
        }
        else if (num==2){
            Circle c1 = new Circle(6,6,6);
            c1.setFill(Color.BLACK);
            
            Circle c2 = new Circle(6,6,6);
            c2.setFill(Color.BLACK);
            
            this.add(c1,0,0);
            this.add(c2,2,2);
            
        
        } else if (num==3){
            Circle c1 = new Circle(6,6,6);
            c1.setFill(Color.BLACK);
            
            Circle c2 = new Circle(6,6,6);
            c2.setFill(Color.BLACK);
            
            Circle c3 = new Circle(6,6,6);
            c3.setFill(Color.BLACK);
            
            this.add(c1,0,0);
            this.add(c2,1,1);
            this.add(c3,2,2);
        
        }else if (num==4){
            Circle c1 = new Circle(6,6,6);
            c1.setFill(Color.BLACK);
            
            Circle c2 = new Circle(6,6,6);
            c2.setFill(Color.BLACK);
            
            Circle c3 = new Circle(6,6,6);
            c3.setFill(Color.BLACK);
            
            Circle c4 = new Circle(6,6,6);
            c4.setFill(Color.BLACK);
            
            this.add(c1,0,0);
            this.add(c2,2,0);
            this.add(c3,0,2);
            this.add(c4,2,2);
        
        }else if (num==5){
            Circle c1 = new Circle(6,6,6);
            c1.setFill(Color.BLACK);
            
            Circle c2 = new Circle(6,6,6);
            c2.setFill(Color.BLACK);
            
            Circle c3 = new Circle(6,6,6);
            c3.setFill(Color.BLACK);
            
            Circle c4 = new Circle(6,6,6);
            c4.setFill(Color.BLACK);
            
            Circle c5 = new Circle(6,6,6);
            c5.setFill(Color.BLACK);
            
            
            this.add(c1,0,0);
            this.add(c2,2,0);
            this.add(c3,0,2);
            this.add(c4,2,2);
            this.add(c5,1,1);
            
        }else if (num==6){
            Circle c1 = new Circle(6,6,6);
            c1.setFill(Color.BLACK);
            
            Circle c2 = new Circle(6,6,6);
            c2.setFill(Color.BLACK);
            
            Circle c3 = new Circle(6,6,6);
            c3.setFill(Color.BLACK);
            
            Circle c4 = new Circle(6,6,6);
            c4.setFill(Color.BLACK);
            
            Circle c5 = new Circle(6,6,6);
            c5.setFill(Color.BLACK);
            
            Circle c6 = new Circle(6,6,6);
            c6.setFill(Color.BLACK);
            
            this.add(c1,0,0);
            this.add(c2,1,0);
            this.add(c3,2,0);
            this.add(c4,0,2);
            this.add(c5,1,2);
            this.add(c6,2,2);
        }
    
    }
    
//#############################################################################
//###########################    N.B      #####################################  
//#############################################################################      
/**
 * funzione per recuperare i nodi (pallini) all'interno della griglia(dado)
 * @param i
 * @param j
 * @return 
 */ 
public Node getNodeDellaCella(int i, int j){

    for (Node x: this.getChildren()){

        try{

            if((GridPane.getRowIndex(x)==i)&& (GridPane.getColumnIndex(x)==j)){

                return x;
            }
        }catch(Exception exp){

            System.out.println(exp.getMessage());
        }
    }

    return null;
}
//#############################################################################  
//############################################################################# 
//#############################################################################  
public void CambiaPunti(){

    for (int i=0; i<3; i++){
        for(int j=0; j<3;j++)
        {
            Node  nd= getNodeDellaCella(i, j);
            if (nd != null){

                this.getChildren().remove(nd);
           }else{

             System.out.println("Nulla da cancellare,la cella è vuota.");

             }


        }
    }
} 
        
        
}

