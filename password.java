
package stock.search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
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
import javafx.scene.control.PasswordField;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.sql.*;



public class password {
    
    static Stage stage;
    static boolean btnYesClick;
    static PasswordField basePass;
    
    
    
    public static boolean show(String title, String user, String pass, String textOK)
    {
        
        btnYesClick = false;
        
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setWidth(400);
        
        Label usernameText = new Label();
        usernameText.setTextFill(Color.NAVY);
        usernameText.setStyle("-fx-font-weight: bold");
        usernameText.setText(user);
        usernameText.setAlignment(Pos.CENTER);
        
        Label lbl = new Label();
        lbl.setTextFill(Color.NAVY);
        lbl.setStyle("-fx-font-weight: bold");
        lbl.setText(pass);
        lbl.setAlignment(Pos.CENTER);
        
       Button btnYes = new Button();
       btnYes.setText(textOK);
       
       TextField username = new TextField();
       username.setMaxWidth(200);
       
       basePass = new PasswordField();
       basePass.setAlignment(Pos.CENTER);
       basePass.setMaxWidth(200);
      
       
       
       btnYes.setOnAction(new EventHandler <ActionEvent>()
       {
           @Override public void handle(ActionEvent e) 
           {
              int savedPass = 0; 
              Statement s;
              ResultSet results;
              int result = 0;
              JFileChooser fc;
              s = Database.get_Statement();
                
             // Database.get_Statement().
              
                try
        {
            
           results = s.executeQuery("SELECT * FROM AdminTable");
           savedPass = Integer.parseInt(results.getString(2));
           
        }
                catch (SQLException se)
                {
                    
                }
                
               int code = basePass.getText().hashCode();
               
               if (code == savedPass )
               {
                   try 
                      {
                          stage.close();
                          
                          StockSearch.stage.setIconified(true);
                          fc = new JFileChooser();
                          result = fc.showOpenDialog(new JFrame());
                          fc.setVisible(true);
                          
                          if (result == 0)
                          {
                          try
                          {
                            
                            Database.UpdateData(fc.getSelectedFile());  
                          }
                          catch (SQLException se)
                          {
                              
                          }
                          
                      }
                      } 
                      catch (FileNotFoundException f)
                      {
                          
                      }
                        
                      catch (IOException f)
                      {
                          
                      }
                   
                        btnYesClick = true;
                    }
           
               else if (result == 1)
               {
                  stage.close(); 
               }
                  
               
               else 
               {
                  stage.close(); 
                  show("Wrong password!", "Enter username:", "\n Wrong Password, Enter the Admin Password:", "OK");
               }
               
               
               
           }
       });
        
        
       basePass.setOnAction(new EventHandler <ActionEvent>()
       {
           
           
         @Override public void handle(ActionEvent e) 
           {
              int savedPass = 0; 
              Statement s;
              ResultSet results = null;
              int result = 0;
              JFileChooser fc;
              s = Database.get_Statement();
                
             // Database.get_Statement().
              
                try
           {
            results = s.executeQuery("SELECT * FROM AdminTable");
        
            while (results.next())
            {
                
           
           
           savedPass = Integer.parseInt(results.getString(2));
           System.out.println(results.getString(1));
        
             }
            
            }
                catch (SQLException se)
                {
                    System.out.println(se);
                }
                
               int code = basePass.getText().hashCode();
               System.out.println(code);
               System.out.println(savedPass);
               
               if (code == savedPass)
               {
                   try 
                      {
                          stage.close();
                          
                          StockSearch.stage.setIconified(true);
                          fc = new JFileChooser();
                          result = fc.showOpenDialog(new JFrame());
                          fc.setVisible(true);
                          
                          if (result == 0)
                          {
                          try
                          {
                            
                            Database.UpdateData(fc.getSelectedFile());  
                          }
                          catch (SQLException se)
                          {
                              
                          }
                          
                      }
                      } 
                      catch (FileNotFoundException f)
                      {
                          
                      }
                        
                      catch (IOException f)
                      {
                          
                      }
                   
                        btnYesClick = true;
                    }
           
               else if (result == 1)
               {
                  stage.close(); 
               }
                  
               
               else 
               {
                  stage.close(); 
                  show("Wrong password!", "Enter username:", "\n Wrong Password, Enter the Admin Password:", "OK");
               }
               
               
               
           }
       });
        
       
       
       
       
       
       
       HBox pane = new HBox(20);
       pane.setPadding(new Insets(10));
       
       HBox.setMargin(btnYes, new Insets(20,100,20,10));
       btnYes.setTranslateX(150);
       pane.getChildren().addAll(btnYes);
       
       
       VBox root = new VBox();
       root.setPadding(new Insets(5));
       root.getChildren().addAll(usernameText, username,  lbl,  basePass,  pane);
       root.setAlignment(Pos.CENTER);
       
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.showAndWait();
       return btnYesClick;
       
    }
    
    
}
