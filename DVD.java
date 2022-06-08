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
/**
 *
 * @author nishanbakunts
 */
public class DVD {
    
    static int counter;
    private String title;
    private String genre;
    private String remarks;
    private int Number;
    private int cat_Number;
    
    
   static ObservableList<DVD> data;
    
      public static ObservableList<DVD> loadData(ResultSet movie) throws SQLException
   {
        data = FXCollections.observableArrayList();
        counter = 0;
       
          while(movie.next())
          {
              
              data.addAll(new DVD( movie.getString(1),movie.getString(2), movie.getString(3), Integer.parseInt(movie.getString(4))));
              counter++; 
          }
          //System.out.println(counter);
          movie.close();
          return data;
         }
       
        
    
    
    
    public DVD()
    {
        this.title = "";
        this.genre = "";
        this.remarks = "";
        this.Number = 0;
        this.cat_Number = 0;
    }
    
    
    public DVD(String title, String genre, String remarks, int Number)
    {
        this.title = title;
        this.genre = genre;
        this.remarks = remarks;
        this.Number = Number;
       // this.cat_Number = cat_Number;
    }
    
    
    public DVD(String title)
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
           
       File f = new File("C:\\Program Files\\Library\\Database\\dvds.txt");  
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
