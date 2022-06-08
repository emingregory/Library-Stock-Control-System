/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.search;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.io.FileReader;



public class Games {
    
    
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author nishanbakunts
 */

    static int counter;
    private String title;
    private String genre;
    private String remarks;
    private int Number;
    private int cat_Number;
    
    
   static ObservableList<Games> data;
    
      public static ObservableList<Games> loadData(ResultSet game) throws SQLException
   {
        data = FXCollections.observableArrayList();
        counter = 0;
       
          while(game.next())
          {
              
              data.addAll(new Games( game.getString(1),game.getString(2), game.getString(3), Integer.parseInt(game.getString(4))));
              counter++; 
          }
          //System.out.println(counter);
          game.close();
          return data;
         }
       
        
    
    
    
    public Games()
    {
        this.title = "";
        this.genre = "";
        this.remarks = "";
        this.Number = 0;
        this.cat_Number = 0;
    }
    
    
    public Games(String title, String genre, String remarks, int Number)
    {
        this.title = title;
        this.genre = genre;
        this.remarks = remarks;
        this.Number = Number;
       // this.cat_Number = cat_Number;
    }
    
    
    public Games(String title)
    {
        this.title = title;
        
    }
    
    
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    
    
    
    public String getRemarks()
    {
        return this.remarks;
    }
    
    
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }
    
    
    
     public int getNumber()
    {
        return this.Number;
    }
    
    
    public void setNumber(int Number)
    {
        this.Number = Number;
    }
    
    
      public int getCatNumber()
    {
        return this.cat_Number;
    }
    
    
    public void setCatNumber(int Number)
    {
        this.cat_Number = Number;
    }
  
       

    
     public static void update(Statement s) throws FileNotFoundException, IOException
       {
           
       File f = new File("C:\\Program Files\\Library\\Database\\games.txt");  
       BufferedReader in = new BufferedReader(new FileReader(f));
       String line = in.readLine();
       
       while (line!= null)
       {
          try 
          {
              s.execute(line);
              
          }
          catch (SQLException e)
          {
             System.out.println(e); 
          }
           line = in.readLine();
       }
          in.close();
       }
       
   
    
}   

    
    
    
    
    
    
    
    
    
    
    

