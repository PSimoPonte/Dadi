
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * <p>
 * Questa classe rappresenta la finestra che darà vita al campo verde.
 */

/**
 *
 * @author Simone.Pontalti
 */
public class CampoVerde extends GridPane {
    
    int nCol= 6;
    int nRow= 5;
    static int numeroDadi=0;
    static Stage mainWindow=null; 
    
    
    public CampoVerde (){
    
         this.setGridLinesVisible(false);
         this.setStyle("-fx-background-color: green ;-fx-border-color: black;");
//#############################################################################
//#############################################################################
/////// COSTRUZIONE DELLLA GRIGLIA 3x3 CELLE  //////////
//#############################################################################
/**
 * Questo insieme di for consente di crare la griglia del gridpane. Ogni cella
 * al suo interno avrà uno stackpane
 */
        for(int i=0;i<nRow;i++) 
        {
            for(int j = 0;j<nCol;j++)
            {
              StackPane sp = new StackPane();
                this.add(sp, j, i);   // inserisce prima tutta una riga e 
                                        //successivamente le righe dopo
            }
        }
        for (int i = 0; i < nRow; i++) {
           this.getRowConstraints().add(new RowConstraints(80, 
                    Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, 
                    Priority.ALWAYS, VPos.CENTER, true));
        }
        for (int i = 0; i < nCol; i++) {
            this.getColumnConstraints().add(new ColumnConstraints(80, 
                    Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, 
                    Priority.ALWAYS, HPos.CENTER, true));
        }
 
//
//############################################################################## 
//##Evento applicato al GridPane che reagisce al click di una cella del Grid#### 
//##############################################################################  
//############################################################################## 
//############################################################################## 

 this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
   public void handle (MouseEvent event) {

    try{

              System.out.println("Hai cliccato in una cella del GridPane!");
              Node source = (Node)event.getTarget() ;
              Integer colIndex = GridPane.getColumnIndex(source);
              Integer rowIndex = GridPane.getRowIndex(source);
              System.out.println("Hai cliccato sulla cella :  indice colonna: "
                + colIndex.intValue()+" -- indice riga: "+ rowIndex.intValue());
              StackPane sp = (StackPane) source; //cast da tipo nodo 
                                                    //a tipo stackpane

              if(numeroDadi<3){

                  Dado d1 = new Dado(); //
                  sp.getChildren().add(d1);
                  numeroDadi ++;

              }else{
                //  System.out.println("Raggiunto il numero massimo di dadi");
                  showPopup("Raggiunto il numero massimo di dadi");
              }   
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
   }
      
  });
//############################################################################## 
//############################################################################## 
//##############################################################################    
    }
 /**
  * Questo metodo mi consente di creare una finestra dove farò apparire
  * un determinato messaggio al suo interno
  * @param message 
  */   
          public static void showPopup(String message) { 
          
                Label label = new Label(message);
                label.setAlignment(Pos.CENTER);
                label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
                Scene sc = new Scene(label, 500, 200);
                Stage stage = new Stage();
                stage.setScene(sc);
                stage.setX(200);
                stage.setY(100);
                stage.setTitle("Finestra Popup");
             //   stage.initModality(Modality.WINDOW_MODAL);
             //   stage.initOwner(mainWindow);
                stage.show();
          }
    
    //visito ogni cella del campo verde
    //recupero lo stackpane che per forza c'è in ogni cella
    //controllo se lo stackpane contiene un dado come figlio
    //nel caso lo contenesse accedo alla proprietà numero palline del dado
    //aggiungo il valore in un arraylist
    //una volta conclusa la visita delle celle del campoVerde controllo se 
        // nell'arraylist ci sono i 3 valori ricercati, (3,4,5)
        // nel caso positivo mostrerò un popup che dice "Hai vinto!"
          
        public void controllaVincita() {
            
            StackPane sp=null;
            Node nd=null;
            Node d = null;
            Dado qd = null;
            int n = 0;
            
            ArrayList<Integer> v = new ArrayList<Integer>(3);
            
            Integer a = new Integer(3);
            Integer b = new Integer(4);
            Integer c = new Integer(5);
            
    for(int i=0;i<nRow;i++){

        for(int j = 0;j<nCol;j++){

            try{
                nd = getNodeDellaCella(i,j);
                sp = (StackPane)nd;
                ObservableList<Node> childs = sp.getChildren();
                 System.out.println("Riga 161 : cella visitata :"+i+"-"+j+" "
                                        + " ==>  size "+ childs.size());
               if( childs.size() > 0 ){

                    d = childs.get(0);

                    if( d!= null){//controllo se lo stackpane contiene un figlio

                        qd = (Dado)d;
                        n = qd.numeroPalline;
                        System.out.println("Riga 171 "+n);
                        v.add(n); //aggiunge all'arraylist il numero di palline 
                                    //del dado trovato in quell'istante.
                    }
                }  
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    if (v.contains(a) && v.contains(b)&& v.contains(c)){

        showPopup("Hai vinto");
    }
}
/////////////////////////////////////////////////////////////////////////////// 
/////////////////////////////////////////////////////////////////////////////// 
/**
 * la funzione reset visita cella per cella il gridpane campoverde ed elimina i
 * probabili nodi al suo interno
 */
        public void reset() {
            
            StackPane sp=null;
            Node nd=null;
            Node d = null;
            Dado qd = null;
            int n = 0;
            
            ArrayList<Integer> v = new ArrayList<Integer>(3);
            
            Integer a = new Integer(3);
            Integer b = new Integer(4);
            Integer c = new Integer(5);
            
            for(int i=0;i<nRow;i++){
                
                for(int j = 0;j<nCol;j++){
              
                        try{
                            nd = getNodeDellaCella(i,j);
                            sp = (StackPane)nd;
                            sp.getChildren().clear();
                           
            

                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                }
                showPopup(" PROGRAMMA RESETTATO");
            }
  
        }
 /**
  * 
  * //metodo per stampare a console lo stato del gioco,
  * //il valore dei singoli dadi e il totale dei dadi  
  */       
      
public String stampa() {

    StackPane sp=null;
    Node nd=null;
    Node d = null;
    Dado qd = null;
    int n = 0;
    int somma=0;
    ArrayList<Integer> v = new ArrayList<Integer>(3);
    String message= null; 

            
    for(int i=0;i<nRow;i++){

        for(int j = 0;j<nCol;j++){

            try{
                nd = getNodeDellaCella(i,j);
                sp = (StackPane)nd;
                ObservableList<Node> childs = sp.getChildren();
               //  System.out.println("Riga 161 : cella visitata :"+i+"-"+j+" 
                //==>  size "+ childs.size());
               if( childs.size() > 0 ){

                    d = childs.get(0);
                    if( d!= null){//controllo se lo stackpane contiene un figlio

                        qd = (Dado)d;
                        n = qd.numeroPalline;
                        //System.out.println("Riga 171 "+n);
                        v.add(n); //aggiunge all'arraylist il numero di palline 
                                    //del dado trovato in quell'istante.
                    }
                }  
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
//Integer somma= v.get(0) + v.get(1) + v.get(3);
if(v.size()==3 ){
   somma= v.get(0).intValue() + v.get(1).intValue() + v.get(2).intValue();

    System.out.println("=============================\n");
    System.out.println("Il valore del primo dado e': "+v.get(0).intValue());
    System.out.println("Il valore del secondo dado  e': "+v.get(1).intValue());
    System.out.println("Il valore del terzo dado e': "+v.get(2).intValue());
    System.out.println("Il totale del punteggio e': "+somma);
    System.out.println("=============================\n");

///////////////////////////////////////////////////////////////////////////////

    message = "\nIl valore del primo dado e': "+v.get(0).intValue();
    message = message +"\nIl valore del secondo dado  e': "+v.get(1).intValue();
    message = message +"\nIl valore del terzo dado e': "+v.get(2).intValue();
    message = message +"\nIl totale del punteggio e': "+somma;
}else {

    System.out.println("Inserisci almeno 3 dadi!");
    message= "\nInserisci almeno 3 dadi!";
}
return message;
}
 //############################################################################      
/**
 * mi restituisce l'elemento alla posizione i-j del GridPane su cui è chiamata
 * @param i riga
 * @param j colonna
 * @return null
 */

public Node getNodeDellaCella(int i, int j){

      for (Node x: this.getChildren()){

          try{

            if((GridPane.getRowIndex(x)==i) && (GridPane.getColumnIndex(x)==j)){

                  return x;
              }
          }catch(Exception exp){

              System.out.println(exp.getMessage());
          }
      }

      return null;
  }
//############################################################################
//############################################################################         
}
