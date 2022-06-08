/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.search;

/**
 *
 * @author nishan bakunts
 * 
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.io.FileReader;


public class Audio {
    
    static int counter;
    private String title;
    private String genre;
    private String author;
    private String Number;
    private String remarks; 
    private String cat;
    
    
    static ObservableList<Audio> data;
    
      public static ObservableList<Audio> loadData(ResultSet audio) throws SQLException
   {
        data = FXCollections.observableArrayList();
        counter = 0;
       
          while(audio.next())
          {
              
              data.addAll(new Audio(audio.getString(1),audio.getString(2), audio.getString(3), audio.getString(4), audio.getString(5), audio.getString(6)));
              counter++; 
          }
          
          audio.close();
          return data;
         }
    
      
       public Audio()
    {
        this.title = "";
        this.genre = "";
        this.author = "";
        this.cat = "";
        this.Number = "";
        this.remarks = "";
    }
      
      
      
      
      
    
     public Audio(String cat, String title,  String author, String remarks, String genre, String Number)
    {
        
        this.cat = cat;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.remarks = remarks;
        this.Number = Number;
       
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
    
    
    
    
    public String getAuthor()
    {
        return this.author;
    }
    
    
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    
     public String getCat()
    {
        return this.cat;
    }
    
    
    
    
    
   public void setCat(String cat)
    {
        this.cat = cat;
    }
     
    
     public String getNumber()
    {
        return this.Number;
    }
    
    
    public void setNumber(String Number)
    {
        this.Number = Number;
    }
    
    
      public String getRemarks()
    {
        return this.remarks;
    }
    
    
    public void setRemarks(String remraks)
    {
        this.remarks = remarks;
    }
  
       
    
    public static void update(Statement s) throws FileNotFoundException, IOException
       {
           
       File f = new File("C:\\Program Files\\Library\\Database\\audio.txt");  
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
