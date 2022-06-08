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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 *
 * @author nishanbakunts
 */
public class Progress extends Application {
    
    static Stage stage = new Stage();
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Loading Data");
        stage.setWidth(275);
        stage.setHeight(175);
        stage.setResizable(false);
        
       ProgressBar pb = new ProgressBar();
       
      
       pb.setScaleX(2);
       pb.setScaleY(2);
       Label text = new Label();
       
       text.setText("Loading, please wait...");
       HBox pane = new HBox(30);
       pane.setPadding(new Insets(10));
      
       
       pane.getChildren().addAll(pb);
       
       
       VBox root = new VBox();
       root.setSpacing(15);
       root.getChildren().addAll(pane, text);
       
       pb.setTranslateX(70);
       pb.setTranslateY(10);
       text.setTranslateY(10);
       text.setTextFill(Color.AQUA);
      
       root.setStyle("-fx-background-color: black");
       root.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(root);
       
       stage.setScene(scene);
       stage.initStyle(StageStyle.UTILITY);
       stage.show();
       
       
       stage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
        
        @Override 
        public void handle(WindowEvent e)
          {
                       
            stage.close();
            
          }
        
        });
        
    }
    
   public static void finish()
   {
       stage.close();
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
