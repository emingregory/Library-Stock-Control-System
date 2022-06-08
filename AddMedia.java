/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.search;

import com.sun.javafx.geom.Shape;
import java.awt.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.io.IOException;

/**
 *
 * @author Bakunts2115
 */
public class AddMedia extends Application {
    
    
    @Override
    public void start(Stage primaryStage)  {
        
        //Runtime.getRuntime().exec("shutdown /a");  
        
        VBox detailsOnLeft = new VBox();
        VBox detailsOnRight = new VBox();
        HBox detailsBox = new HBox();
        
        //Spinner test = new Spinner();
        
        Label titleLab = new Label("Title:");
        Label seriesLab = new Label("Series:");
        Label authorLab = new Label("Author:");
        Label ClassLab = new Label("Class:");
        Label isbnLab = new Label("ISBN:");
        Label mediaLab = new Label("Media:");
        Label keywordsLab = new Label("Keywords:");
        Label addedLab = new Label("Date Added:");
        Label locationLab = new Label("Location:");
        Label ownerLab = new Label("Owner:");
        Label missingLab = new Label("missing:");
        Label reasonLab = new Label("Reason:");
        
        TextField title = new TextField();
        title.setMinWidth(400);
        ComboBox series = new ComboBox();
        series.setMinWidth(400);
        ComboBox author = new ComboBox();
        author.setMinWidth(400);
        ComboBox Class = new ComboBox();
        TextField isbn = new TextField();
        ComboBox media = new ComboBox();
        ComboBox keywords = new ComboBox();
        
        TextField addedDate = new TextField();
        ComboBox location = new ComboBox();
        ComboBox owner = new ComboBox();
        TextField missingDate = new TextField();
        ComboBox reason = new ComboBox();
        
        Tab details = new Tab("Details");
        details.setClosable(false);
       
        
        Tab loans = new Tab("Loans");
        loans.setClosable(false);
        Tab notes = new Tab("Notes");
        notes.setClosable(false);
       
        Tab custom = new Tab("Custom Fields");
        custom.setClosable(false);
        
        TabPane allTabs = new TabPane();
        
        
        
        detailsOnLeft.getChildren().addAll(titleLab, title, seriesLab, series, authorLab, author, ClassLab, Class, isbnLab, isbn,  mediaLab, media,  keywordsLab, keywords);
        detailsOnLeft.setSpacing(5);
        detailsOnRight.getChildren().addAll(addedLab, addedDate, locationLab, location,  ownerLab, owner, missingLab, missingDate, reasonLab, reason);
        detailsOnRight.setSpacing(5);
        
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Add Media");
            }
        });
        
        
        detailsBox.getChildren().addAll(detailsOnLeft, detailsOnRight, btn);
        detailsBox.setSpacing(15);
        detailsBox.setMinWidth(800);
        detailsBox.setMinHeight(600);
        details.setContent(detailsBox);
        detailsBox.setTranslateX(5);
        detailsBox.setTranslateY(15);
        
        allTabs.getTabs().addAll(details,loans, notes,custom);
        
        
        Pane root = new Pane();
        root.getChildren().addAll(allTabs);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Add Media");
        primaryStage.setScene(scene);
        primaryStage.show();
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
