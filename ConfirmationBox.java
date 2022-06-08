
package stock.search;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.*;


public class ConfirmationBox {
    
    static Stage stage;
    static boolean btnYesClick;
    static Label lbl;
    
    
    public static boolean show(String title, String message, String textYes)
    {
        
        btnYesClick = false;
        
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setWidth(275);
        stage.setHeight(150);
        stage.setResizable(false);
        
        
        lbl = new Label();
        lbl.setText(message);
        lbl.setStyle("-fx-font-size: 15pt");
        lbl.setStyle("-fx-font-weight: bolder");
       Button btnYes = new Button();
       btnYes.setText(textYes);
       
       btnYes.setOnAction(new EventHandler <ActionEvent>()
       {
           @Override public void handle(ActionEvent e) 
           {
               stage.close();
               btnYesClick = true;
               
           }
       });
        
        
      
       
       
       HBox pane = new HBox(30);
       
       pane.setPadding(new Insets(10));
       HBox.setMargin(btnYes, new Insets(20,10,50,10));
       
       pane.getChildren().addAll(btnYes);
       
       
       VBox root = new VBox();
       root.getChildren().addAll(lbl,pane);
       lbl.setTranslateY(25);
       lbl.setTranslateX(3);
       lbl.setTextFill(Color.NAVY);
       btnYes.setTranslateX(100);
       btnYes.setTranslateY(40);
      
       
       root.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.showAndWait();
       return btnYesClick;
       
    }
    
    
}
