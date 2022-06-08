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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.io.FileReader;
import java.util.ArrayList;


/**
 *
 * @author Bakunts2115
 */
public class Main {
    
    



/**
 *
 * @author Nishan Bakunts
 */





    // Assign the variables
    
    private String title;
    private String genre;
    private String author;
    private String Number;
    private String media; 
    private String cat;
    
    
    static ObservableList<Main> data;
    static ObservableList<Main> data2;
    static ArrayList<String> itemList; 
    static ArrayList<String> itemList2 ;
    
    static int counter = 0;
    
      /**
     *
     * @param main
     * @return
     * @throws SQLException
     */
    public static ObservableList<Main> loadData(ResultSet main) throws SQLException
   {
        // Assign the variables
        data = FXCollections.observableArrayList();
        
        itemList = new ArrayList<String>();
        itemList2 = new ArrayList<String>();
        int i1 = 0;
        int i2 = 1;
        int i3 = 2;
        int i4 = 3;
        int i5 = 4;
        
        // While resultset has newxt item 
          while(main.next())
              
              
          {
           // data.addAll(new Main(main.getString(1), main.getString(2), main.getString(3), main.getString(4), main.getString(5)));
             
              // Add the first five elemements of the resultset to the list
              
              itemList.add(main.getString(1).toString());
              itemList.add(main.getString(2).toString());
              itemList.add(main.getString(3).toString());
              itemList.add(main.getString(4).toString());
              itemList.add(main.getString(5).toString());
              itemList.add(main.getString(6).toString());
              
             
           // counter++; 
            
           
          }
          // Assign the variables to the element variables
            int el1 = 0;
            int el2 = 1;
            int el3 = 2;
            int el4 = 3;
            int el5 = 4;
            int el6 = 5;
            
            // Call the process Doubles method
            processDoubles(itemList);
           
            // Assign the variable no to the processed list2's size divided by five to get the correct size of five chunks
            int no = itemList2.size() / 6;
            
            // Go into a loop untill the list's 5 chunk size is reached
            for (int i = 0; i < no; i++)
              
            {
                // Add items one to five to the observable list to display in a table
              data.addAll(new Main(itemList2.get(el1).toString(), itemList2.get(el2).toString(), itemList2.get(el3).toString(), itemList2.get(el4).toString(), itemList2.get(el5).toString(), itemList2.get(el6).toString()));
                                  
             
              // Add one to the counter
              counter++; 
              
             // Add 5 to all elements for the next run
             el1 = el1 + 6;
             el2 = el2 + 6;
             el3 = el3 + 6;
             el4 = el4 + 6;
             el5 = el5 + 6;
             el6 = el6 + 6;
            }
                 
           
           
           // When loop is finished return the observable list
            return data;
         }
    
      
   
      
      
       /**
     *
     */
    public Main()
    {
        this.title = "";
        this.genre = "";
        this.author = "";
        this.cat = "";
        this.Number = "";
        this.media = "";
    }
      
      
      
    /**
     *
     * @param List
     * @return
     */
    public static ArrayList<String> processDoubles(ArrayList<String> List)  
    {
        // Assign the variables
        int el1 = 5;
        
        // No equals size of the list divided by 6
        int no = List.size() / 6;
                
        // while i is less than list's size divided by 6
        for(int i = 0; i < no ; i++)
        {
            
      
           // if second list contains the 5 element of the first list
           if (itemList2.contains(List.get(el1)))
        {
           
            // Move to the next 5th element
            el1 = el1 + 6;
           
            
        } 
          
        // if second list doesn't contain the 5 element of the first list   
       
           if (!itemList2.contains(List.get(el1)))
          {
              // Add the 5 elements preceeding that elemens 
                         itemList2.add(List.get(el1-5));
                         itemList2.add(List.get(el1-4));
                         itemList2.add(List.get(el1-3));
                         itemList2.add(List.get(el1-2));
                         itemList2.add(List.get(el1-1));
                         itemList2.add(List.get(el1));
                         
                         
                      
                     }        
                        
                         
        
        
        
        }
            
  
        
        
     return itemList2;
        
    }
       
       
      
      
    
     /**
     *
     * @param cat
     * @param media
     * @param title
     * @param author
     * @param genre
     * @param Number
     */
    public  Main(String cat, String media, String title, String author, String genre, String Number)
    {
        
        this.cat = cat;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.Number = Number;
        this.media = media;
    }
    
    
     
     public String getCat()
    {
        return this.cat;
    }
    
        
    
    
   public void setCat(String cat)
    {
        this.cat = cat;
    }
     
   
     public String getMedia()
    {
        return this.media;
    }
    
        
    
    
   public void setMedia(String cat)
    {
        this.media = media;
    }
   
   
       
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
     public String getAuthor()
    {
        return this.author;
    }
    
    
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    
    
    
   
    
    
     
    
     public String getNumber()
    {
        return this.Number;
    }
    
    
    public void setNumber(String Number)
    {
        this.Number = Number;
    }
    
    
  /*    public String getRemarks()
    {
        return this.remarks;
    }
    
    
    public void setRemarks(String remraks)
    {
        this.remarks = remarks;
    }
  */
       
    
    public static void update(Statement s) throws FileNotFoundException, IOException
       {
           
       File f = new File("C:\\Library\\Database\\mains.txt");  
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
