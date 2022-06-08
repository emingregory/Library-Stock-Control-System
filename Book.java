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
 * @author Nishan Bakunts
 */




public class Book {
    
    static int counter = 0;
    private String title;
    private String genre;
    private String author;
    private String Number;
    private String remarks; 
    private String cat;
    
    
    static ObservableList<Book> data;
    
      public static ObservableList<Book> loadData(ResultSet book) throws SQLException
   {
        data = FXCollections.observableArrayList();
        
       
          while(book.next())
          {
              //System.out.println(book.getString(2) + " " + book.getString(3)+ " " + book.getString(4)+ " " + book.getString(6)+ " " + book.getString(5));
              data.addAll(new Book(book.getString(1),book.getString(2), book.getString(3), book.getString(4), book.getString(5), book.getString(6)));
              counter++; 
          }
           
          //System.out.println(counter);
          book.close();
          return data;
         }
    
      
       public Book()
    {
        this.title = "";
        this.genre = "";
        this.author = "";
        this.cat = "";
        this.Number = "";
        this.remarks = "";
    }
      
      
      
      
      
    
     public Book(String cat, String title,  String author, String remarks, String genre, String Number)
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
           
       File f = new File("C:\\Program Files\\Library\\Database\\books.txt");  
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
