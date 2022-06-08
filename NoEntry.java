/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.search;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.effect.*;


/**
 *
 * @author Bakunts2115
 */
public class NoEntry extends Application {
    
  
    
    @Override
    public void start(final Stage stage) {
        
        
        Glow glow = new Glow();
        
        stage.initModality(Modality.APPLICATION_MODAL);
        
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setResizable(false);
        
        Button ok = new Button("Proceed");
        Button exit = new Button("Exit");
        Label message = new Label("Please scan/enter the number of the item you are adding "
                + "\nto the catalogue. Also scan the ISBN or the barcode of the "
                + "\nitem and click proceed.");
        
        
        Label catNoLbl = new Label("Catalogue Number: ");
        Label isbnLbl = new Label("ISBN Number: ");
        TextField catNo = new TextField();
        catNo.setMaxWidth(175);
        TextField isbn = new TextField();
        isbn.setMaxWidth(175);
        catNoLbl.setTextFill(Color.YELLOW);
        catNoLbl.setEffect(glow);
        
        isbnLbl.setTextFill(Color.YELLOW);
        isbnLbl.setEffect(glow);
        
        message.setTextFill(Color.YELLOW);
        message.setEffect(glow);
        
       HBox pane = new HBox(30);
       pane.setPadding(new Insets(10));
      
       
       pane.getChildren().addAll(ok, exit);
       pane.setTranslateX(120);
       pane.setTranslateY(80);
       VBox root = new VBox();
       root.setSpacing(15);
       
       root.getChildren().addAll(message, catNoLbl, isbnLbl, catNo, isbn, pane);
       catNoLbl.setTranslateY(65);
       catNoLbl.setTranslateX(-90);
       isbnLbl.setTranslateY(70);
       isbnLbl.setTranslateX(-100);
       catNo.setTranslateX(50);
       isbn.setTranslateX(50);
       
       
       //catNoLbl.setStyle("-fx");
       root.setStyle("-fx-background-color: navy");
       ok.setStyle("-fx-background-color: aqua");
       exit.setStyle("-fx-background-color: aqua");
       root.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(root);
       
       stage.setScene(scene);
       stage.initStyle(StageStyle.UNDECORATED);
       stage.show();
        
        ok.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });
        
       
        
        
        
        
        
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
