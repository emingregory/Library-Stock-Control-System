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

/*
*@resource loading.gif
*/

/**
 *
 * @author nishanbakunts
 */

public class Database {
    
    
     static boolean error = false;
     static Statement s;
     static Connection conn;
     static String connectionURL;
     static String connectionURL2;
     static String driver;
     static String dbName;
     
     static String dropDVD = "drop TABLE DVDtable";
     static String dropBooks = "drop TABLE BookTable";
     static String dropAudio = "drop TABLE AudioTable";
     static String dropGames = "drop TABLE GameTable";
     static String dropMags = "drop TABLE MagTable";
     static String dropJigsaw = "drop TABLE JigsawTable";
     static String dropMain = "drop TABLE MainTable";
    
     static String createDVDTable;
     static String createBookTable;
     static String createAudioTable;
     static String createMagTable;
     static String createJigTable;
     static String createGameTable;
     static String createMainTable;
     
     
    public static void shut() throws FileNotFoundException, IOException, SQLException
            
    {
        connectionURL = "jdbc:derby:" + dbName + "; drop=true";
        connectionURL2 = "jdbc:derby: ;shutdown=true";
        
        DriverManager.getConnection(connectionURL2);
    }
     
     
 public static void connect() throws FileNotFoundException, IOException, SQLException
              
      {
          
    
    // Create  SQL statement  and connection variables
    driver = "org.apache.derby.jdbc.EmbeddedDriver"; 
        
       
    dbName = "library";
    
    connectionURL = "jdbc:derby:" + dbName + "; create=true";
    
    
    try 
    {
        Class.forName(driver);
        
        
    }catch(java.lang.ClassNotFoundException e)
    {
        System.out.println(e);
        
        
        
    }
    
    conn = DriverManager.getConnection(connectionURL);
    s = conn.createStatement();
    
    
    
    
        
    }  
               
   
 public static Statement get_Statement()
 {
     return s;
 }

 
 
 
 
 
    public static void UpdateData(File f) throws FileNotFoundException, IOException, SQLException
 {
        
       Update up = new Update("Updating The Database, Please Wait...");
       
       
       
     
       // Create an empty array list
        
        ArrayList movieList = new ArrayList();
        ArrayList bookList = new ArrayList();
        ArrayList audioList = new ArrayList();
        ArrayList gameList = new ArrayList();
        ArrayList magList = new ArrayList();
        ArrayList jigList = new ArrayList();
           
        // Assign a new file to read the data from
        
         
        
            BufferedReader in = new BufferedReader(new FileReader(f));
            
            String line = in.readLine();
       
        // Read a line from the database
        
        
        
        // While the end of the file is not reached, if the line contains the string "DVD"
        // Create and array of strings and split the read line/string 
       
       try {
         
           while (line != null)
            {
          
           
                               
                  
                   String list[] = line.split("\t");
                   
                   
                   if (list[4].substring(1, list[4].length() -1 ).equals("DVD"))
                   {
                       //System.out.println(list[4]);
                       for (String dvdWord : list)
                     {
                         if (dvdWord.contains("'"))
                         
                         dvdWord = dvdWord.replace("'", "");
                       // Add the stirng to the movie list
                         movieList.add(dvdWord);
                     }
                        
                   }
                   
            
            
            
            else if (list[4].substring(1, list[4].length() -1 ).equals("Hardback") || list[4].substring(1, list[4].length() -1 ).equals("Paperback"))
                
                
                {
                               
                 
                
                     for (String bookWord : list)
                     {
                         if (bookWord.contains("'"))
                         
                         bookWord = bookWord.replace("'", "");
                       // Add the stirng to the book list
                         bookList.add(bookWord);
                         
                         //System.out.println(counter++);
                    
                     }
              
                }
            
            
            else if (list[4].substring(1, list[4].length() -1 ).equals("Audio"))
               
                {
                               
                  // String audios[] = line.split("\t");
                
                     for (String audioWord : list)
                     {
                         if (audioWord.contains("'"))
                         
                         audioWord = audioWord.replace("'", "");
                         
                       // Add the stirng to the games list
                         audioList.add(audioWord);
                      
                     // System.out.println(counter++);
                         
                   
                     }
                
                }
           
             else if (list[4].substring(1, list[4].length() -1 ).equals("Game"))
               
                {
                               
                   //String games[] = line.split("\t");
                
                     for (String gameWord : list)
                      
                     {
                         if (gameWord.contains("'"))
                         
                         gameWord = gameWord.replace("'", "");
                         
                       // Add the stirng to the games list
                          gameList.add(gameWord);
                          //counter++;
                      
                     // System.out.println(counter++);
                   
                     }
              
                }
            
            if (list[4].substring(1, list[4].length() -1 ).equals("Magazine"))
               {
                               
                   //String mag[] = line.split("\t");
                
                   
                     for (String magWord : list)
                      
                     {
                           if (magWord.contains("'"))
                         
                             magWord = magWord.replace("'", "");
                      
                            // Add the stirng to the magazine list
                             magList.add(magWord);
                      
                            //System.out.println(counter++);
                   
                     }
           
                }
            
       
            if (list[4].substring(1, list[4].length() -1 ).equals("Jigsaw"))
               {
                               
                  // String jig[] = line.split("\t");
                
                     for (String jigWord : list)
                      
                     {
                           if (jigWord.contains("'"))
                         
                             jigWord = jigWord.replace("'", "");
                      
                            // Add the stirng to the magazine list
                             jigList.add(jigWord);
                      
                            //System.out.println(counter++);
                   
                     }
           
                }
            
            
            
         // Reassign the variable
            
         line = in.readLine();
         
            }
        }  
   
       // Catch any input/output errors and print these on the console
       catch (IOException e)
       {
           System.out.println("This is an error " + e);
       }
       
       
       
       // Close the file and call write DVDs method
       in.close();
      // System.out.println(counter); 
       
        File dir = new File("C:\\Program Files\\library\\Database\\");
        
       
       
      
       
       if (! movieList.isEmpty())
       {
           write_DVDs(movieList); 
       }
      
       if (! bookList.isEmpty())
       {
           write_Books(bookList); 
       }
       
       if (! audioList.isEmpty())
       {
           write_Audio(audioList); 
       }
       
       if (! gameList.isEmpty())
       {
           write_Games(gameList); 
       }
       
       if (! magList.isEmpty())
       {
           write_Mags(magList); 
       }
       
       
       if (! jigList.isEmpty())
       {
           write_Jigsaw(jigList);
       }
       
       
       
            
       
       
       try {
      
      
              
       
       createDVDTable = "CREATE TABLE DVDTable "
               
            + "(ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Title VARCHAR(200), "
            + "Class VARCHAR(50), "
            + "Genre VARCHAR(25) NOT NULL, "
            + "Media VARCHAR(50), " 
            + "Remarks VARCHAR(75), "
            + "Cat_Number INT"
            
            + ")"; 
       
       
         createBookTable = "CREATE TABLE BookTable "
               
            + "(ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Class VARCHAR(50) NOT NULL, "
            + "Title VARCHAR(300) NOT NULL, "
            + "Author VARCHAR(400), "
            + "Remarks VARCHAR(300), " 
            + "Media VARCHAR(50), "      
            + "Genre VARCHAR(300), "    
            + "Cat_Number INT "
            + ")";
       
        
        createAudioTable = "CREATE TABLE AudioTable "
               
            + "(ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Class VARCHAR(50) NOT NULL, "
            + "Title VARCHAR(300) NOT NULL, "
            + "Author VARCHAR(400), "
            + "Remarks VARCHAR(300), "
            + "Media VARCHAR(50), " 
            + "Genre VARCHAR(300), "    
            + "Cat_Number INT "
            + ")";
        
        
        
        createMagTable = "CREATE TABLE MagTable "
               
            + "(ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Title VARCHAR(200), "
            + "Class VARCHAR(50), "
            + "Genre VARCHAR(25) NOT NULL, "
            + "Media VARCHAR(50), " 
            + "Remarks VARCHAR(75), "
            + "Cat_Number INT"
            
            + ")"; 
        
        
        createJigTable = "CREATE TABLE JigsawTable "
               
            + "(ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Title VARCHAR(200), "
            + "Class VARCHAR(50), "
            + "Genre VARCHAR(25) NOT NULL, "
            + "Media VARCHAR(50), " 
            + "Remarks VARCHAR(75), "
            
            + "Cat_Number INT"
            
            + ")"; 
        
        
        
       createGameTable = "CREATE TABLE GameTable "
               
            + "(ID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Title VARCHAR(200), "
            + "Class VARCHAR(50), "
            + "Genre VARCHAR(25) NOT NULL, "
            + "Media VARCHAR(50), " 
            + "Director VARCHAR(25), "    
            + "Remarks VARCHAR(75), "
            + "Cat_Number INT"
            
            + ")"; 
        
      
         
       createMainTable = "CREATE TABLE MainTable "
               
            + "(MainID INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "BookId INT, "
            + "DVDId INT , "
            + "AudioId INT , "
            + "GameId INT , "    
            + "MagId INT , "
            + "JigId INT , "
            + "Test INT , "
               
            + "CONSTRAINT book FOREIGN KEY (BookId)"
            + "REFERENCES Booktable (ID),"
               
            + "CONSTRAINT dvd FOREIGN KEY (DVDId)"
            + "REFERENCES DVDtable (ID),"
            
            + "CONSTRAINT audio FOREIGN KEY (AudioId)"
            + "REFERENCES Audiotable (ID),"   
            
            + "CONSTRAINT game FOREIGN KEY (GameId)"
            + "REFERENCES Gametable (ID),"
               
            + "CONSTRAINT mag FOREIGN KEY (MagId)"
            + "REFERENCES Magtable (ID),"   
             
            + "CONSTRAINT jig FOREIGN KEY (JigID)"
            + "REFERENCES Jigsawtable (ID)"   
            + ")"; 
       
      
              
    
    try 
        {
       s.execute(dropMain);
       s.execute(dropDVD);
       s.execute(dropBooks);
       s.execute(dropAudio);
       s.execute(dropGames);
       s.execute(dropMags);
       s.execute(dropJigsaw);  
       
       
        s.execute(createAudioTable);
        s.execute(createDVDTable);
        s.execute(createBookTable);
        s.execute(createMagTable);
        s.execute(createJigTable);
        s.execute(createGameTable);
        s.execute(createMainTable);
           
   
       
            DVD.update(s);
            Book.update(s);
            Audio.update(s);
            Games.update(s);
            Mags.update(s);
            Jigsaw.update(s); 
       
        // s.execute("insert into MainTable (Test) values( 7873)");  
                        
        }
       catch (FileNotFoundException e)
       {
         System.out.println(e);
       } 
        
      
      
             
     
   
       
    }catch(Throwable e)
    
    {
          
       
        
        System.out.println("This is an error "  + e);
        error = true;
       
       
       if (error)
        {   
           try 
       
           {
               
     /*  s.execute(dropMain);  
       s.execute(dropDVD);
       s.execute(dropBooks);
       s.execute(dropAudio);
       s.execute(dropGames);
       s.execute(dropMags);
       s.execute(dropJigsaw);  */
      
       s.execute(createMainTable);        
       s.execute(createAudioTable);
       s.execute(createDVDTable);
       s.execute(createBookTable);
       s.execute(createMagTable);
       s.execute(createJigTable);
       s.execute(createGameTable);
       
           
            
            
            DVD.update(s);
            Book.update(s);
            Audio.update(s);
            Games.update(s);
            Mags.update(s);
            Jigsaw.update(s);
            
            error = false;
        
         }
            catch (FileNotFoundException fe)
       {
         System.out.println(e);
       } 
        
      
      
           //ConfirmationBox.stage.close();
     
     
   
       
    catch(Throwable te)
    
    {
            
            
    }
        }
 }  
       
      
       File [] files = dir.listFiles();
       
       for (File file : files)
       {
           file.delete();
       }
      
      up.close();
     
      StockSearch.stage.setIconified(false); 
      StockSearch.stage.show();
  
 }

  
    
    
public static void write_DVDs(ArrayList movieList) throws FileNotFoundException, IOException
 {
       
            
       
     
        int counter = 0;
        // get the first, second and fourth items from the list and assign the variables to
        // Number, title and genre
        String number = movieList.get(0).toString();
        CharSequence no = number.subSequence(1, number.length() -1);
        int  cat_No = Integer.parseInt(no.toString()); 
        String genre = movieList.get(1).toString();
        String title = movieList.get(3).toString();
        String media = movieList.get(4).toString();
        
        
       // Create the DVDs file and assign it to the printwriter
        File DVDs = new File("C:\\Program Files\\library\\Database\\dvds.txt");
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(DVDs, true)));
  
     
       
      // While the movie list is not empty print the DVD details to the database script
      // The remove the first eight elements from the list and assign the variables the
      // next DVD details 
       
       
       while (! movieList.isEmpty())
           
      {
            // Create a new file named DVDs and output the title, genre and catalogue number
                       
         
           out.println("insert into DVDTable (Class, Title,   Genre, Media, Remarks, Cat_Number) "
               + "values(" + "'', '" + title.subSequence(1, title.length() - 1) + "', " + "'" + genre.subSequence(1, genre.length() - 1)  + "', " + "'" + media.subSequence(1, media.length() - 1)  + "', " + "'', " + cat_No + ")");                 
            
           
           
           
           // begin at 0 and reomove the elemets from the list 8 times
           
           for (int i = 0; i < 10; i++)
                        {
                           movieList.remove(0);
                       
                        }
          // if the movie list is empty then break the loop
           if (movieList.isEmpty())
   {
       break;
   }
      
      // Else reassign the variables to the number, title and genre of the movie list items 1,2,4
      else
               
        //System.out.println(cat_No +  " " + title + " " + genre); 
        
        number = movieList.get(0).toString();
        no = number.subSequence(1, number.length() -1); 
        cat_No = Integer.parseInt(no.toString()); 
        genre = movieList.get(1).toString();
        title = movieList.get(3).toString(); 
        media = movieList.get(4).toString();
        //System.out.println(counter++);      
       
    
 }  // Flush the buffer to free memory and close the file
       out.flush(); 
       out.close(); 
 
 }             
    


public static void write_Games(ArrayList gameList) throws FileNotFoundException, IOException
 {
        int counter = 0;
        // get the first, second and fourth items from the list and assign the variables to
        // Number, title and genre
        String number = gameList.get(0).toString();
        CharSequence no = number.subSequence(1, number.length() -1);
        int  cat_No = Integer.parseInt(no.toString()); 
        String genre = gameList.get(1).toString();
        String title = gameList.get(3).toString();
        String media = gameList.get(4).toString();
        
       // Create the Games file and assign it to the printwriter
        File Games = new File("C:\\Program Files\\library\\Database\\games.txt");
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Games, true)));
  
     
       
      // While the movie list is not empty print the game details to the database script
      // The remove the first eight elements from the list and assign the variables the
      // next game details 
       
       
       while (! gameList.isEmpty())
           
      {
            // Create a new file named games and output the title, genre and catalogue number
                       
         
           out.println("insert into GameTable (Class, Title,  Genre, Media, Remarks, Cat_Number) "
               + "values(" + "'', '" + title.subSequence(1, title.length() - 1) + "', " + "'" + genre.subSequence(1, genre.length() - 1)  + "', " + "'" + media.subSequence(1, media.length() - 1)  + "', " + "'', " + cat_No + ")");                 
            //counter++;
           
           // begin at 0 and reomove the elemets from the list 8 times
           
           for (int i = 0; i < 10; i++)
                        {
                           gameList.remove(0);
                       
                        }
          // if the game list is empty then break the loop
           if (gameList.isEmpty())
   {
       break;
   }
      
      // Else reassign the variables to the number, title and genre of the movie list items 1,2,4
      else
               
                
        number = gameList.get(0).toString();
        no = number.subSequence(1, number.length() -1); 
        cat_No = Integer.parseInt(no.toString()); 
        genre = gameList.get(1).toString();
        title = gameList.get(3).toString();    
        media = gameList.get(4).toString();     
       
    
 }  // Flush the buffer to free memory and close the file
      // System.out.println(counter); 
       out.flush(); 
       out.close(); 
 
 }             




public static void write_Mags(ArrayList magList) throws FileNotFoundException, IOException
 {
        
        // get the first, second and fourth items from the list and assign the variables to
        // Number, title and genre
        String number = magList.get(0).toString();
        CharSequence no = number.subSequence(1, number.length() -1);
        int  cat_No = Integer.parseInt(no.toString()); 
        String genre = magList.get(1).toString();
        String title = magList.get(3).toString();
        String media = magList.get(4).toString();
        
       // Create the Mags file and assign it to the printwriter
        File Mags = new File("C:\\Program Files\\library\\Database\\mags.txt");
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Mags, true)));
  
     
       
      // While the mags list is not empty print the magazine details to the database script
      // The remove the first eight elements from the list and assign the variables the
      // next mags details 
       
       
       while (! magList.isEmpty())
           
      {
            // Create a new file named games and output the title, genre and catalogue number
                       
         
           out.println("insert into MagTable (Class, Title,  Genre, Media, Remarks, Cat_Number) "
               + "values(" + "'', ' " + title.subSequence(1, title.length() - 1) + "', " + "'" + genre.subSequence(1, genre.length() - 1)  + "', " + "'" + media.subSequence(1, media.length() - 1)  + "', " + "'', " + cat_No + ")");                 
            
           
           // begin at 0 and reomove the elemets from the list 8 times
           
           for (int i = 0; i < 10; i++)
                        {
                           magList.remove(0);
                       
                        }
          // if the game list is empty then break the loop
           if (magList.isEmpty())
   {
       break;
   }
      
      // Else reassign the variables to the number, title and genre of the movie list items 1,2,4
      else
               
                
        number = magList.get(0).toString();
        no = number.subSequence(1, number.length() -1); 
        cat_No = Integer.parseInt(no.toString()); 
        genre = magList.get(1).toString();
        title = magList.get(3).toString();    
        media = magList.get(4).toString();   
       
    
 }  // Flush the buffer to free memory and close the file
       out.flush(); 
       out.close(); 
 
 }             





public static void write_Jigsaw(ArrayList jigList) throws FileNotFoundException, IOException
 {
        
        // get the first, second and fourth items from the list and assign the variables to
        // Number, title and genre
        String number = jigList.get(0).toString();
        CharSequence no = number.subSequence(1, number.length() -1);
        int  cat_No = Integer.parseInt(no.toString()); 
        String genre = jigList.get(1).toString();
        String title = jigList.get(3).toString();
        String media = jigList.get(4).toString();
        
       // Create the Mags file and assign it to the printwriter
        File Jigsaw = new File("C:\\Program Files\\library\\Database\\jigsaw.txt");
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Jigsaw, true)));
  
     
       
      // While the mags list is not empty print the magazine details to the database script
      // The remove the first eight elements from the list and assign the variables the
      // next mags details 
       
       
       while (! jigList.isEmpty())
           
      {
            // Create a new file named games and output the title, genre and catalogue number
                       
         
           out.println("insert into JigsawTable (Class, Title, Genre, Media, Remarks, Cat_Number) "
               + "values(" + "'', ' " + title.subSequence(1, title.length() - 1) + "', " + "'" + genre.subSequence(1, genre.length() - 1)  + "', " + "'" + media.subSequence(1, media.length() - 1)  + "', "+ "'', " + cat_No + ")");                 
            
           
           // begin at 0 and reomove the elemets from the list 8 times
           
           for (int i = 0; i < 10; i++)
                        {
                           jigList.remove(0);
                       
                        }
          // if the game list is empty then break the loop
           if (jigList.isEmpty())
   {
       break;
   }
      
      // Else reassign the variables to the number, title and genre of the movie list items 1,2,4
      else
               
                
        number = jigList.get(0).toString();
        no = number.subSequence(1, number.length() -1); 
        cat_No = Integer.parseInt(no.toString()); 
        genre = jigList.get(1).toString();
        title = jigList.get(3).toString();  
        media = jigList.get(4).toString();
        //System.out.println(counter++);      
       
    
 }  // Flush the buffer to free memory and close the file
       out.flush(); 
       out.close(); 
 
 }             











public static void write_Books(ArrayList bookList) throws FileNotFoundException, IOException
 {
        int counter = 0;
        // get the first, second and fourth items from the list and assign the variables to
        // Number, title and genre, acquisition and series
        String number = bookList.get(0).toString();
        CharSequence no = number.subSequence(1, number.length() -1);
        int  cat_No = Integer.parseInt(no.toString()); 
        String Class = bookList.get(1).toString();
        String author = bookList.get(2).toString();
        String title = bookList.get(3).toString();
        String media = bookList.get(4).toString();
        String remarks = bookList.get(8).toString();
        String genre = bookList.get(9).toString();
        
        
       // Create the books file and assign it to the printwriter
        File Books = new File("C:\\Program Files\\library\\Database\\books.txt");
                        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Books, true)));
  
                         
                      
                     
       
       
      // While the book list is not empty print the book details to the database script
      // The remove the first eight elements from the list and assign the variables the
      // next book details 
       
       
       while (! bookList.isEmpty())
           
      {
            // Create a new file named books and output the title, genre and catalogue number
            // by stripping of the double quotes of the strings
                       
         
           out.println("insert into BookTable (Class, Title, Author, Remarks, Media, Genre, Cat_Number) "
               + "values(" + "'" + Class.subSequence(1, Class.length() - 1) + "', '" + title.subSequence(1, title.length() - 1) + "', '"   + author.subSequence(1, author.length() - 1) + "', '" + genre.subSequence(1, genre.length() - 1) + "', '" + media.subSequence(1, media.length() - 1) +  "', " +  " '" + remarks.subSequence(1, remarks.length() - 1) +  "', " + cat_No  + ")");                 
           
           
          
           
           
           
           // System.out.println(bookList);     
           
           // begin at 0 and reomove the elemets from the list 8 times
           
           for (int i = 0; i < 10; i++)
                        {
                           bookList.remove(0);
                       
                        }
          // if the movie list is empty then break the loop
           if (bookList.isEmpty())
             {
                 break;
             }
      
      // Else reassign the variables to the number, title and genre of the movie list items 1,2,4
            else
               
               
        number = bookList.get(0).toString();
        no = number.subSequence(1, number.length() -1); 
        cat_No = Integer.parseInt(no.toString()); 
        Class = bookList.get(1).toString();
        author = bookList.get(2).toString();
        title = bookList.get(3).toString();
        remarks = bookList.get(8).toString();
        genre = bookList.get(9).toString();
        media = bookList.get(4).toString();
 }  // Flush the buffer to free memory and close the file
      //System.out.println(counter);
       out.flush(); 
       out.close(); 
 
 }   
        
        
     

public static void write_Audio(ArrayList audioList) throws FileNotFoundException, IOException
 {
        int counter = 0;
        // get the first, second and fourth items from the list and assign the variables to
        // Number, title acquisition and series
        String number = audioList.get(0).toString();
        CharSequence no = number.subSequence(1, number.length() -1);
        int  cat_No = Integer.parseInt(no.toString()); 
        String Class = audioList.get(1).toString();
        String author = audioList.get(2).toString();
        String title = audioList.get(3).toString();
        String media = audioList.get(4).toString();
        String remarks = audioList.get(8).toString();
        String genre = audioList.get(9).toString();
        
        
       // Create the books file and assign it to the printwriter
        
        File Audios = new File("C:\\Program Files\\library\\Database\\audio.txt");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(Audios, true)));
  
      
       
      // While the book list is not empty print the book details to the database script
      // The remove the first eight elements from the list and assign the variables the
      // next book details 
       
       
       while (! audioList.isEmpty())
           
      {
            // Create a new file named books and output the title, genre and catalogue number
            // by stripping of the double quotes of the strings
                       
         
           out.println("insert into AudioTable (Class, Title, Author, Remarks, Media, Genre, Cat_Number) "
               + "values(" + "'" + Class.subSequence(1, Class.length() - 1) + "', '" + title.subSequence(1, title.length() - 1) + "', '"   + author.subSequence(1, author.length() - 1) + "', '" + genre.subSequence(1, genre.length() - 1 )+ "', '" + media.subSequence(1, media.length() - 1) +  "', " + " '" + remarks.subSequence(1, remarks.length() - 1) +  "', " + cat_No  + ")");                 
             
           
           // begin at 0 and reomove the elemets from the list 8 times
           
           for (int i = 0; i < 10; i++)
                        {
                           audioList.remove(0);
                       
                        }
          // if the movie list is empty then break the loop
           if (audioList.isEmpty())
   {
       break;
   }
      
      // Else reassign the variables to the number, title and genre of the movie list items 1,2,4
      else
               
               
        number = audioList.get(0).toString();
        no = number.subSequence(1, number.length() -1);
        cat_No = Integer.parseInt(no.toString()); 
        Class = audioList.get(1).toString();
        author = audioList.get(2).toString();
        title = audioList.get(3).toString();
        remarks = audioList.get(8).toString();
        genre = audioList.get(9).toString();
        media = audioList.get(4).toString();
    
 }  // Flush the buffer to free memory and close the file
       
      out.flush(); 
       out.close(); }





}

