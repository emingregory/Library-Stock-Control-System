/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.search;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import static stock.search.StockSearch.stage;
import javafx.scene.control.*;
import java.util.Timer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 *
 * @author Bakunts2115
 */

public class Admin {
    
    
    
    public void setAdminAccount()
            
    {
        Statement s;
        String createAdminTable;
        String passString = "hello";
        int pass = 1117544247;
        
        s = Database.get_Statement();
        ResultSet results;
        
        createAdminTable = "CREATE TABLE AdminTable "
            
            + "(Name VARCHAR(100), "
            + "Password INT "
            + ")";
        
        try
        {
            
           results = s.executeQuery("SELECT * FROM AdminTable");
           
           results.deleteRow();
           results.absolute(pass);
           results.absolute(1);
           results.close();
           //pass = 1117544247;
           //s.executeUpdate(createAdminTable);
           s.execute("INSERT INTO AdminTable "
                   + "VALUES (Administrator, " + pass + ")");
           s.close();
        }
        
        
        
        
         catch(Throwable te)
    
    {
       System.out.println(te);
            
    }
    }
    
    
    
}
