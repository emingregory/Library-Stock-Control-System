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



public class Mags {
    
  

/**
 *
 * @author nishan bakunts
 */
    
    static int counter;
    private String title;
    private String genre;
    private String remarks;
    private String Number;
    private int cat_Number;
    
    
   static ObservableList<Mags> data;
    
      public static ObservableList<Mags> loadData(ResultSet mag) throws SQLException
   {
        data = FXCollections.observableArrayList();
        counter = 0;
       
          while(mag.next())
          {
              
              data.addAll(new Mags( mag.getString(1),mag.getString(2), mag.getString(3), mag.getString(4)));
              counter++; 
          }
          //System.out.println(counter);
          mag.close();
          return data;
         }
       
        
    
    
    
    public Mags()
    {
        this.title = "";
        this.genre = "";
        this.remarks = "";
        this.Number = "";
        this.cat_Number = 0;
    }
    
    
    public Mags(String title, String genre, String remarks, String Number)
    {
        this.title = title;
        this.genre = genre;
        this.remarks = remarks;
        this.Number = Number;
       // this.cat_Number = cat_Number;
    }
    
    
    public Mags(String title)
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
    
    
    
     public String getNumber()
    {
        return this.Number;
    }
    
    
    public void setNumber(String Number)
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
           
       File f = new File("C:\\Program Files\\Library\\Database\\mags.txt");  
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

    
    
    
    
