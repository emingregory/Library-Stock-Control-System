
package stock.search;

import javafx.application.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.cell.*;  
import java.lang.System;
import java.sql.*;
import java.sql.DriverManager;
import java.io.*;
import javafx.scene.effect.*;
import java.util.ArrayList;
import javafx.scene.image.*;
import static stock.search.DisplayShelf.Shelf.clip;
import javafx.scene.shape.Rectangle;
import java.io.PrintStream;
import java.io.BufferedWriter;
//import javafx.scene.control.DatePicker;
/* 
 * @resource suffolkLogo.jpg
 * @resource icon.png
 * /

/**
 *
 * @author Nishan Bakunts
 */

public class StockSearch extends Application {
    
    
    static Label lblCount = new Label();
    static Label lblCount2 = new Label();
    static Image logo = new Image(StockSearch.class.getResource("suffolkLogo.jpg").toExternalForm(),false);
    static Image icon = new Image(StockSearch.class.getResource("icon.png").toExternalForm(),false);        
            
    
    static ImageView logoView = new ImageView(logo);
    
    static VBox box = new VBox();
    
    
    static Stage stage;
    static int width;
    static int height;
    static Scene scene;
   
    
     // create all the border, pane, etc. variables necessary for the screen
        
        final static BorderPane border = new BorderPane();
        final static BorderPane border2 = new BorderPane();
        static HBox hBox = new HBox();
        static HBox hBox2 = new HBox();
        static VBox menuHolder = new VBox();
        static VBox mainMenu = new VBox();
        static HBox logoHolder = new HBox();
        final static VBox DVDMenu = new VBox();
        final static VBox bookMenu = new VBox();
        static HBox catalogBox = new HBox();
        static HBox enrolmentBox = new HBox();
        
        final static HBox centerMenu = new HBox();
        final static HBox center = new HBox();
        static ComboBox<String> searchBy = new ComboBox<String>();
        static ComboBox<String> searchBy2 = new ComboBox<String>();
        
        static ComboBox<String> searchType = new ComboBox<String>();
        static ArrayList<Label> menuItems = new ArrayList<Label>();
        static ArrayList<Label> addMenuItems = new ArrayList<Label>();
        
        Pane pane = new Pane();
        Pane pane2 = new Pane();
        final static TextField search = new TextField();
        static Button srchBtn = new Button();
        static Button srchBtn2 = new Button();
        static Menu home = new Menu();
        static Menu home2 = new Menu();
        
        
        static final TableView<Main> Maintable = new TableView<Main>();
        static final TableView<Book> Booktable = new TableView<Book>();
        static final TableView<Audio> Audiotable = new TableView<Audio>();
        static final TableView<DVD> DVDtable = new TableView<DVD>();
        static final TableView<Mags> Magstable = new TableView<Mags>();
        static final TableView<Games> Gamestable = new TableView<Games>();
        static final TableView<Jigsaw> Jigsawtable = new TableView<Jigsaw>();
        
    
        
        //  All the menubars necessary for the first scene
        
        MenuBar menuBar = new MenuBar();
        MenuBar menuBar2 = new MenuBar();
        MenuBar menuBar3 = new MenuBar();
        MenuBar menuBar4 = new MenuBar();
        
        
        
        // Create the buttons for ficiotn and non-fiction books
        
        
        Button bookItem = new Button("\n");
        Button Adv = new Button("Adventure");
        Button FantBooks = new Button("Fantasy");
        Button SciFiBooks = new Button("SciFi");
        Button Horror = new Button("Horror");
        Button Crime = new Button("Crime");
        Button Thriller= new Button("Thriller");
        Button Historical = new Button("Historical");
        Button fiction = new Button("All Fiction");
        Button non_fiction = new Button("All Non Fiction");
        Button dict = new Button("Dictionaries");
        Button phil = new Button("Philosophy");
        Button rel = new Button("Religion");
        Button socSci = new Button("Social Sciences");
        Button lan = new Button("Langauge");
        Button natSci = new Button("Natural Sciences");
        Button tech = new Button("Technology");
        Button art = new Button("Arts");
        Button lit = new Button("Literature");
        Button biog = new Button("Biographies");
        Button geo = new Button("Geography");
        Button wHist = new Button("World History");
        Button hist = new Button("History");
        
        ArrayList<Button> bookItems = new ArrayList<Button>();
        ArrayList<Button> dvdItems = new ArrayList<Button>();
        
        Button DvdMenu = new Button("\n\n");
        Button DvdMenu1 = new Button("Action");
        Button DvdMenu2 = new Button("Adventure ");
        Button DvdMenu3 = new Button("Animation");
        Button DvdMenu4 = new Button("Comedy");
        Button DvdMenu5 = new Button("Documentaries");
        Button DvdMenu6 = new Button("Drama");
        Button DvdMenu7 = new Button("Faith");
        Button DvdMenu8 = new Button("Fantasy");
        Button DvdMenu9 = new Button("Fishing");
        Button DvdMenu10 = new Button("Horror");
        Button DvdMenu11 = new Button("Martial Arts");
        Button DvdMenu12 = new Button("Sci-Fi");
        Button DvdMenu13 = new Button("Thriller");
        Button DvdMenu14 = new Button("True Life");
        Button DvdMenu15 = new Button("Poetry");
        
    @Override
    public void start(final Stage primaryStage) throws FileNotFoundException, IOException, SQLException {
        
       // Add all the book menu items to the book menu list 
       
       bookItems.add(Adv);
       bookItems.add(FantBooks);
       bookItems.add(SciFiBooks);
       bookItems.add(Horror);
       bookItems.add(Crime);
       bookItems.add(Thriller);
       bookItems.add(Historical);
       bookItems.add(fiction);
       bookItems.add(non_fiction);
       bookItems.add(dict);
       bookItems.add(phil);
       bookItems.add(rel);
       bookItems.add(socSci);
       bookItems.add(lan);
       bookItems.add(natSci);
       bookItems.add(tech);
       bookItems.add(art);
       bookItems.add(lit);
       bookItems.add( biog);
       bookItems.add(geo);
       bookItems.add(wHist);
       bookItems.add(hist);
       
       center.setAlignment(Pos.CENTER);
       center.setPrefSize(200,200);
       //centerMenu.setMaxSize(300, 600);
       centerMenu.setPrefSize(100,300);
       
       // Add all the DVD menu items to the dvd menu list
       
       dvdItems.add(DvdMenu1);
       dvdItems.add(DvdMenu2);
       dvdItems.add(DvdMenu3);
       dvdItems.add(DvdMenu4);
       dvdItems.add(DvdMenu5);
       dvdItems.add(DvdMenu6);
       dvdItems.add(DvdMenu7);
       dvdItems.add(DvdMenu8);
       dvdItems.add(DvdMenu9);
       dvdItems.add(DvdMenu10);
       dvdItems.add(DvdMenu11);
       dvdItems.add(DvdMenu12);
       dvdItems.add(DvdMenu13);
       dvdItems.add(DvdMenu14);
       dvdItems.add(DvdMenu15);
       
       
       
       // Set the stage
        stage = primaryStage;
        
        
        // create a toolkit to get the screen size
         
        
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        height = d.height;
        width = d.width;
        
        
        
        
        // Create the main table and load the data into it
        
                
        TableColumn<Main, String> mainTitle = new TableColumn<Main, String>("Title");
        mainTitle.setMinWidth(450);
        mainTitle.setCellValueFactory(new PropertyValueFactory<Main, String>("Title"));
        
        
        
        TableColumn<Main, String> mainAuthor = new TableColumn<Main, String>("Author");
        mainAuthor.setCellValueFactory(new PropertyValueFactory<Main, String>("Author"));
        mainAuthor.setMaxWidth(250);
        mainAuthor.setMinWidth(125);
        
        TableColumn<Main, String> mainGenre = new TableColumn<Main, String>("Genre");
        mainGenre.setCellValueFactory(new PropertyValueFactory<Main, String>("Genre"));
        mainGenre.setMinWidth(125);
                
        
        TableColumn<Main, String> mainMedia = new TableColumn<Main, String>("Media");
        mainMedia.setMinWidth(75);
        mainMedia.setCellValueFactory(new PropertyValueFactory<Main, String>("Media"));
        
        
        
        TableColumn<Main,Integer> mainNumber = new TableColumn<Main, Integer>("Number");
        mainNumber.setCellValueFactory(new PropertyValueFactory<Main,Integer>("Number"));
                
        mainNumber.setMinWidth(125);
        mainNumber.setText("Catalogue Number");
        
        TableColumn<Main,Integer> mainCat = new TableColumn<Main, Integer>("Cat");
        mainCat.setCellValueFactory(new PropertyValueFactory<Main,Integer>("Cat"));
                
        mainCat.setMinWidth(75);
        mainCat.setText("Class");
        
        Maintable.getColumns().addAll( mainCat, mainMedia, mainTitle, mainAuthor, mainGenre, mainNumber);

        
       
        Maintable.setMinWidth(width - 105);
        Maintable.setMaxWidth(width - 105);
        Maintable.setMaxHeight(height  - 118);
       
        //Maintable.autosize();
       
        
        
        
        // Create the Book table and load the data into it
        
        
        
        
        Booktable.setMinWidth(width - 105);
        Booktable.setMaxWidth(width - 105);
        Booktable.setMaxHeight(height  - 118);
        
        
        
        
        TableColumn<Book, String> bookCat = new TableColumn<Book, String>("Cat");
        bookCat.setMinWidth(150);
        bookCat.setCellValueFactory(new PropertyValueFactory<Book, String>("Cat"));
        bookCat.setText("Class");
        
        TableColumn<Book, String> bookTitle = new TableColumn<Book, String>("Title");
        bookTitle.setMinWidth(450);
        bookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("Title"));
        
        
        
        TableColumn<Book, String> bookAuthor = new TableColumn<Book, String>("Author");
        bookAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
        bookAuthor.setMinWidth(250);
        
        TableColumn<Book, String> bookGenre = new TableColumn<Book, String>("Genre");
        bookGenre.setCellValueFactory(new PropertyValueFactory<Book, String>("Genre"));
        bookGenre.setMinWidth(75);
        TableColumn<Book, String> bookRemarks = new TableColumn<Book, String>("Remarks");
        bookRemarks.setCellValueFactory(new PropertyValueFactory<Book, String>("Remarks"));
        bookRemarks.setMinWidth(85);
        TableColumn<Book,Integer> bookNumber = new TableColumn<Book, Integer>("Number");
        bookNumber.setCellValueFactory(new PropertyValueFactory<Book,Integer>("Number"));
                
        bookNumber.setMinWidth(120);
        bookNumber.setText("Catalogue Number");
        Booktable.getColumns().addAll(bookCat, bookTitle, bookAuthor, bookGenre,  bookRemarks,  bookNumber);
        
        
        
        
        
        // Create the Audio table and load the data into it
        
        
        
        
        
        Audiotable.setMinWidth(width - 105);
        Audiotable.setMaxWidth(width - 105);
        Audiotable.setMaxHeight(height  - 118);
        
        
        
        
        TableColumn<Audio, String> audioCat = new TableColumn<Audio, String>("Cat");
        audioCat.setMinWidth(150);
        audioCat.setCellValueFactory(new PropertyValueFactory<Audio, String>("Cat"));
        audioCat.setText("Class");
        
        TableColumn<Audio, String> audioTitle = new TableColumn<Audio, String>("Title");
        audioTitle.setMinWidth(400);
        audioTitle.setCellValueFactory(new PropertyValueFactory<Audio, String>("Title"));
        
        
        
        TableColumn<Audio, String> audioAuthor = new TableColumn<Audio, String>("Author");
        audioAuthor.setCellValueFactory(new PropertyValueFactory<Audio, String>("Author"));
        audioAuthor.setMinWidth(250);
        
        TableColumn<Audio, String> audioGenre = new TableColumn<Audio, String>("Genre");
        audioGenre.setCellValueFactory(new PropertyValueFactory<Audio, String>("Genre"));
        
        TableColumn<Audio, String> audioRemarks = new TableColumn<Audio, String>("Remarks");
        audioRemarks.setCellValueFactory(new PropertyValueFactory<Audio, String>("Remarks"));
        audioRemarks.setMinWidth(150);
        TableColumn<Audio,Integer> audioNumber = new TableColumn<Audio, Integer>("Number");
        audioNumber.setCellValueFactory(new PropertyValueFactory<Audio,Integer>("Number"));
                
        audioNumber.setMinWidth(125);
        audioNumber.setText("Catalogue Number");
        Audiotable.getColumns().addAll(audioCat, audioTitle, audioAuthor, audioGenre,  audioRemarks,  audioNumber);
        

        
        
        
        
        
        
        
    
       // Create the DVD table and load the data into it
        
        
        
        
        
        DVDtable.setMinWidth(width - 100);
        DVDtable.setMaxWidth(width - 105);
        DVDtable.setMaxHeight(height  - 118);
        
        
        
        TableColumn<DVD, String> colTitle = new TableColumn<DVD, String>("Title");
        colTitle.setMinWidth(450);
        colTitle.setCellValueFactory(new PropertyValueFactory<DVD, String>("Title"));
        
        
        
        TableColumn<DVD, Integer> colYear = new TableColumn<DVD, Integer>("Remarks");
        colYear.setCellValueFactory(new PropertyValueFactory<DVD, Integer>("Remarks"));
        
        
        TableColumn<DVD, String> colGenre = new TableColumn<DVD, String>("Genre");
        colGenre.setCellValueFactory(new PropertyValueFactory<DVD, String>("Genre"));
        colGenre.setMinWidth(150);
        
        
        TableColumn<DVD,Integer> colNumber = new TableColumn<DVD, Integer>("Number");
        colNumber.setCellValueFactory(new PropertyValueFactory<DVD,Integer>("Number"));
                
        colNumber.setMinWidth(150);
        colNumber.setText("Catalogue Number");
        DVDtable.getColumns().addAll(colTitle, colGenre, colNumber );
        
        
       
        
        
        // Create the Games table and load the data into it
        
        
        
        
        
        Gamestable.setMinWidth(width - 105);
        Gamestable.setMaxWidth(width - 105);
        Gamestable.setMaxHeight(height  - 118);
        
        
        
        TableColumn<Games, String> gameTitle = new TableColumn<Games, String>("Title");
        gameTitle.setMinWidth(450);
        gameTitle.setCellValueFactory(new PropertyValueFactory<Games, String>("Title"));
        
        
        
        TableColumn<Games, Integer> gameYear = new TableColumn<Games, Integer>("Remarks");
        gameYear.setCellValueFactory(new PropertyValueFactory<Games, Integer>("Remarks"));
        
        
        TableColumn<Games, String> gameGenre = new TableColumn<Games, String>("Genre");
        gameGenre.setCellValueFactory(new PropertyValueFactory<Games, String>("Genre"));
        
        
        
        TableColumn<Games,Integer> gameNumber = new TableColumn<Games, Integer>("Number");
        gameNumber.setCellValueFactory(new PropertyValueFactory<Games,Integer>("Number"));
                
        gameNumber.setMinWidth(125);
        gameNumber.setText("Catalogue Number");
        Gamestable.getColumns().addAll(gameTitle, gameGenre, gameNumber );

        
        
        
        // Create the Mags table and load the data into it
        
        
        Magstable.setMinWidth(width - 105);
        Magstable.setMaxWidth(width - 105);
        Magstable.setMaxHeight(height  - 118);
        
        
        
        
        
        
        TableColumn<Mags, String> magTitle = new TableColumn<Mags, String>("Title");
        magTitle.setMinWidth(450);
        magTitle.setCellValueFactory(new PropertyValueFactory<Mags, String>("Title"));
        
        
        
        TableColumn<Mags, Integer> magYear = new TableColumn<Mags, Integer>("Remarks");
        magYear.setCellValueFactory(new PropertyValueFactory<Mags, Integer>("Remarks"));
        
        
        TableColumn<Mags, String> magGenre = new TableColumn<Mags, String>("Genre");
        magGenre.setCellValueFactory(new PropertyValueFactory<Mags, String>("Genre"));
        
        
        
        TableColumn<Mags,Integer> magNumber = new TableColumn<Mags, Integer>("Number");
        magNumber.setCellValueFactory(new PropertyValueFactory<Mags,Integer>("Number"));
                
        magNumber.setMinWidth(125);
        magNumber.setText("Catalogue Number");
        Magstable.getColumns().addAll(magTitle, magGenre, magNumber );

        

        // Create the Jigsaw table and load the data into it
        
        
        
        
        Jigsawtable.setMinWidth(width - 105);
        Jigsawtable.setMaxWidth(width - 105);
        Jigsawtable.setMaxHeight(height  - 118);
        
        
        
        
        TableColumn<Jigsaw, String> jigTitle = new TableColumn<Jigsaw, String>("Title");
        jigTitle.setMinWidth(450);
        jigTitle.setCellValueFactory(new PropertyValueFactory<Jigsaw, String>("Title"));
        
        
        
        TableColumn<Jigsaw, Integer> jigYear = new TableColumn<Jigsaw, Integer>("Remarks");
        jigYear.setCellValueFactory(new PropertyValueFactory<Jigsaw, Integer>("Remarks"));
        
        
        TableColumn<Jigsaw, String> jigGenre = new TableColumn<Jigsaw, String>("Genre");
        jigGenre.setCellValueFactory(new PropertyValueFactory<Jigsaw, String>("Genre"));
        
        
        
        TableColumn<Jigsaw,Integer> jigNumber = new TableColumn<Jigsaw, Integer>("Number");
        jigNumber.setCellValueFactory(new PropertyValueFactory<Jigsaw,Integer>("Number"));
                
        jigNumber.setMinWidth(125);
        jigNumber.setText("Catalogue Number");
        Jigsawtable.getColumns().addAll(jigTitle, jigGenre, jigNumber );

        
        
        
       
        
        
        
        
        
       
        search.setMinWidth(250);
        
        Glow glow = new Glow();
        glow.setLevel(2.0);
        
        
        // Create catalog screen's bottom enu items 
        
        
        final Button addItems = new Button("Add Media");
        final Button editItem = new Button("Edit");
        final Button exportItems = new Button("Export");
        final Button itemViews = new Button("Views");
        final Button removeItem = new Button("Remove");
        final Button recycleItem = new Button("Recycle");
        
        // Create usera screen's bottom enu items 
        
        final Button addUsers = new Button("Add Users");
        final Button recycleUser = new Button("Recycle");
        final Button removeUser = new Button("Remove");
        final Button exportUsers = new Button("Export");
        final Button editUser = new Button("Edit");
        final Button userViews = new Button("Views");
        
        
        
        addUsers.setStyle("-fx-background-color: black; -fx-font-size: 13");
        recycleUser.setStyle("-fx-background-color: black; -fx-font-size: 13");
        removeUser.setStyle("-fx-background-color: black; -fx-font-size: 13");
        exportUsers.setStyle("-fx-background-color: black; -fx-font-size: 13");
        editUser.setStyle("-fx-background-color: black; -fx-font-size: 13");        
        userViews.setStyle("-fx-background-color: black; -fx-font-size: 13");       
                
        addItems.setStyle("-fx-background-color: black; -fx-font-size: 13");
        editItem.setStyle("-fx-background-color: black; -fx-font-size: 13");
        exportItems.setStyle("-fx-background-color: black; -fx-font-size: 13");
        itemViews.setStyle("-fx-background-color: black; -fx-font-size: 13");        
        removeItem.setStyle("-fx-background-color: black; -fx-font-size: 13");        
        recycleItem.setStyle("-fx-background-color: black; -fx-font-size: 13");        
                
                
        addUsers.setTextFill(Color.AQUA);
        addUsers.setEffect(glow);
        recycleUser.setTextFill(Color.AQUA);
        recycleUser.setEffect(glow);
        removeUser.setTextFill(Color.AQUA);
        removeUser.setEffect(glow);
        exportUsers.setTextFill(Color.AQUA);
        exportUsers.setEffect(glow);
        editUser.setTextFill(Color.AQUA); 
        editUser.setEffect(glow);
        userViews.setTextFill(Color.AQUA);
        
        
        
        addItems.setTextFill(Color.AQUA);
        addItems.setEffect(glow);
        
        
        editItem.setTextFill(Color.AQUA);
        editItem.setEffect(glow);
        exportItems.setTextFill(Color.AQUA);
        exportItems.setEffect(glow);
        itemViews.setTextFill(Color.AQUA);
        itemViews.setEffect(glow);
        removeItem.setTextFill(Color.AQUA); 
        removeItem.setEffect(glow);
        recycleItem.setTextFill(Color.AQUA);
        recycleItem.setEffect(glow);
        // create the variables for left menu and set their text and style 
        
        
        final Label dvd = new Label("DVDs");
        final Label books = new Label("Books");
        final Label audio = new Label("Audio CDs");
        final Label games = new Label("Games");
        final Label jigsaw = new Label("Jigsaws");
        final Label mag = new Label("Magazines");
        final Label library = new Label("Library");
        
    
        
        
        library.setStyle("-fx-background-color: black; -fx-font-size: 13");
        dvd.setStyle("-fx-background-color: black; -fx-font-size: 13");
        audio.setStyle("-fx-background-color: black; -fx-font-size: 13");
        games.setStyle("-fx-background-color: black; -fx-font-size: 13");
        books.setStyle("-fx-background-color: black; -fx-font-size: 13");
        jigsaw.setStyle("-fx-background-color: black; -fx-font-size: 13");
        mag.setStyle("-fx-background-color: black; -fx-font-size: 13");
        library.setStyle("-fx-background-color: black; -fx-font-size: 13");
        
        
        
       
        library.setTextFill(Color.AQUA);
        dvd.setTextFill(Color.AQUA);
        audio.setTextFill(Color.AQUA);
        games.setTextFill(Color.AQUA);
        books.setTextFill(Color.AQUA);
        jigsaw.setTextFill(Color.AQUA);
        mag.setTextFill(Color.AQUA);
        
        
        
        
        dvd.setEffect(glow);
        audio.setEffect(glow);
        jigsaw.setEffect(glow);
        books.setEffect(glow);
        games.setEffect(glow);
        mag.setEffect(glow);
        library.setEffect(glow);
        
        
        // add all the menu items for the menu of the initial screen and set style
        logoHolder.getChildren().add(logoView);
        menuItems.add(library);
        menuItems.add(audio);
        menuItems.add(books);
        menuItems.add(dvd);
        menuItems.add(games);
        menuItems.add(jigsaw);
        menuItems.add(mag);
        
            
        //addMenuItems.add(addUsers);
        //addMenuItems.add(addItems);   
        
        menuHolder.getChildren().addAll(menuItems); 
        
        menuHolder.setAlignment(Pos.CENTER);
        menuHolder.setSpacing(20);
        
       
        enrolmentBox.getChildren().add(addUsers);
        catalogBox.getChildren().addAll(addItems, editItem, exportItems, itemViews, removeItem, recycleItem);
        catalogBox.setStyle("-fx-background-color: black");
        catalogBox.setSpacing(15);
        catalogBox.setMinHeight(30);
        catalogBox.setAlignment(Pos.CENTER);
        mainMenu.setSpacing(35);
        mainMenu.setStyle("-fx-background-color: black");
        
        enrolmentBox.setSpacing(15);
        enrolmentBox.setMinHeight(25);
        enrolmentBox.setAlignment(Pos.CENTER);
        enrolmentBox.setStyle("-fx-background-color: black");
        
        
        
        
        // create the top menus of the initial screen and set the styles
        
        Menu menu = new Menu();
        
        menu.setText("_DATABASE");
        menu.setStyle("-fx-font-weight: bold");
        home.setText("_NAVIGATE");
        home.setStyle("-fx-font-weight: bold");
        
        
        
        Menu menu2 = new Menu("                                                                                                                                                                                                                                                ");
        menu2.setDisable(true);
        Menu menu3 = new Menu("                                                                                                                                                                                                                                                ");
        menu3.setDisable(true);
        
        
        
        
        
        
        
        
        bookItem.setStyle("-fx-background-color: black");
        bookItem.setDisable(true);
        Adv.setStyle("-fx-background-color: black");
        FantBooks.setStyle("-fx-background-color: black");
        SciFiBooks.setStyle("-fx-background-color: black");
        Horror.setStyle("-fx-background-color: black");  
        Crime.setStyle("-fx-background-color: black");
        Thriller.setStyle("-fx-background-color: black");  
        Historical.setStyle("-fx-background-color: black");
        fiction.setStyle("-fx-background-color: black");
        non_fiction.setStyle("-fx-background-color: black");
        
        dict.setStyle("-fx-background-color: black"); 
        phil.setStyle("-fx-background-color: black"); 
        rel.setStyle("-fx-background-color: black");
        socSci.setStyle("-fx-background-color: black");
        lan.setStyle("-fx-background-color: black"); 
        natSci.setStyle("-fx-background-color: black"); 
        tech.setStyle("-fx-background-color: black");
        art.setStyle("-fx-background-color: black"); 
        lit.setStyle("-fx-background-color: black");
        biog.setStyle("-fx-background-color: black");
        geo.setStyle("-fx-background-color: black");
        wHist.setStyle("-fx-background-color: black"); 
        hist.setStyle("-fx-background-color: black");
        
        
        
       
        
        fiction.setTextFill(Color.AQUA);
        Adv.setTextFill(Color.AQUA);
        FantBooks.setTextFill(Color.AQUA);
        SciFiBooks.setTextFill(Color.AQUA);
        Horror.setTextFill(Color.AQUA);
        Crime.setTextFill(Color.AQUA);
        Thriller.setTextFill(Color.AQUA);
        Historical.setTextFill(Color.AQUA);
        non_fiction.setTextFill(Color.AQUA);
        
        
        dict.setTextFill(Color.AQUA); 
        phil.setTextFill(Color.AQUA); 
        rel.setTextFill(Color.AQUA);
        socSci.setTextFill(Color.AQUA); 
        lan.setTextFill(Color.AQUA); 
        natSci.setTextFill(Color.AQUA); 
        tech.setTextFill(Color.AQUA);
        art.setTextFill(Color.AQUA); 
        lit.setTextFill(Color.AQUA); 
        biog.setTextFill(Color.AQUA); 
        geo.setTextFill(Color.AQUA);
        wHist.setTextFill(Color.AQUA); 
        hist.setTextFill(Color.AQUA); 
        
        
        
        
        
        // Add the buttons to the book menu 
        
        bookMenu.getChildren().addAll(bookItem,  fiction, Adv, Crime, FantBooks, Historical, Horror, SciFiBooks, Thriller, 
                non_fiction, art, biog, dict, geo, hist, lan, lit, natSci, phil, rel,  socSci, wHist );
        bookMenu.setStyle("-fx-background-color: black"); 
        bookMenu.setSpacing(10);
         
         
        // create the buttons for DVD menu and set their text and styles
        
       
        
        
        Menu DvdMenu16 = new Menu("               ");
        Menu DvdMenu17 = new Menu("");
        
        DvdMenu.setStyle("-fx-background-color: black");
        DvdMenu1.setStyle("-fx-background-color: black");
        DvdMenu2.setStyle("-fx-background-color: black");
        DvdMenu3.setStyle("-fx-background-color: black");
        DvdMenu4.setStyle("-fx-background-color: black");
        DvdMenu5.setStyle("-fx-background-color: black");
        DvdMenu6.setStyle("-fx-background-color: black");
        DvdMenu7.setStyle("-fx-background-color: black");
        DvdMenu8.setStyle("-fx-background-color: black");
        DvdMenu9.setStyle("-fx-background-color: black");
        DvdMenu10.setStyle("-fx-background-color: black");
        DvdMenu11.setStyle("-fx-background-color: black");
        DvdMenu12.setStyle("-fx-background-color: black");
        DvdMenu13.setStyle("-fx-background-color: black");
        DvdMenu14.setStyle("-fx-background-color: black");
        DvdMenu15.setStyle("-fx-background-color: black");
        
        
        // This menu creates two carraige returns within the DVD menu bar and is disabled so that it cannot be clicked
        DvdMenu.setDisable(true);
        
        
        DvdMenu1.setTextFill(Color.AQUA);
        DvdMenu2.setTextFill(Color.AQUA);
        DvdMenu3.setTextFill(Color.AQUA);
        DvdMenu4.setTextFill(Color.AQUA);
        DvdMenu5.setTextFill(Color.AQUA);
        DvdMenu6.setTextFill(Color.AQUA);
        DvdMenu7.setTextFill(Color.AQUA);
        DvdMenu8.setTextFill(Color.AQUA);
        DvdMenu9.setTextFill(Color.AQUA);
        DvdMenu10.setTextFill(Color.AQUA);
        DvdMenu11.setTextFill(Color.AQUA);
        DvdMenu12.setTextFill(Color.AQUA);
        DvdMenu13.setTextFill(Color.AQUA);
        DvdMenu14.setTextFill(Color.AQUA);
        DvdMenu15.setTextFill(Color.AQUA);
        
        // Add exit itme to the menu
        
       
        Menu admin = new Menu("_Administer");
        MenuItem update = new MenuItem("_Update");
        MenuItem resetAcc = new MenuItem("_Reset Admin Account");
        MenuItem exit = new MenuItem("_Exit");
        MenuItem print = new MenuItem("_Print");
        final MenuItem minimise = new MenuItem("_Minimise");
        admin.getItems().addAll(update, resetAcc);
        menu.getItems().addAll(admin, minimise, print, exit);
        
        
        
        // Add main menu item to the navigate menu
        
        MenuItem main = new MenuItem("_Main Menu");
        home.getItems().add(main);
        
        // List of search by items to be chosen when searching
        
        searchBy.setPromptText("Search By");
        searchBy.getItems().addAll("Title", "Class", "Author", "Genre");
        searchBy.setMinWidth(100);
       
        
        // List of search type to be chosen from
        
        
        searchType.setPromptText("Search Options");
        searchType.getItems().addAll("Search Entire Database", "Search Audio Books", "Search Books", "Search DVDs", "Search Jigsaws", "Search Magazines");
        searchType.setMinWidth(100);
        
        
        
        
        
       
        
        
        // Add all the menus for the first scene
        
        menuBar.getMenus().addAll(menu, home);
        menuBar.setStyle("-fx-background-color: black");
        menuBar2.getMenus().add(menu2);
        menuBar2.setStyle("-fx-background-color: black");
        menuBar3.getMenus().add(menu3);
        menuBar3.setStyle("-fx-background-color: black");
        
        menuBar4.getMenus().add(DvdMenu16);
        menuBar4.setStyle("-fx-background-color: black");
        menuBar4.setMaxHeight(height);
        
        
        
        
        
        srchBtn.setText("SEARCH");
        srchBtn.setTextFill(Color.RED);
        
        hBox.getChildren().addAll(searchType, searchBy, search, srchBtn, lblCount2);
       
        
        
        Menu secndMenu = new Menu("_DATABASE");
        secndMenu.setStyle("-fx-font-weight: bold");
        home2.setText("_NAVIGATE");
        home2.setStyle("-fx-font-weight: bold");
        
       
        MenuItem exit2 = new MenuItem("_Exit");
        MenuItem menuHome = new MenuItem("_Main Menu");
        home2.getItems().add(menuHome);
        secndMenu.getItems().addAll(exit2);
        Menu secndMenu2 = new Menu("                                                                                                                                                                                                                                                ");
        secndMenu2.setDisable(true);
        
        
        MenuBar ScndMenuBar = new MenuBar();
        MenuBar ScndMenuBar2 = new MenuBar();
        MenuBar ScndMenuBar3 = new MenuBar();
        MenuBar ScndMenuBar4 = new MenuBar();
        
        
        ScndMenuBar.getMenus().addAll(secndMenu, home2);
        ScndMenuBar.setStyle("-fx-background-color: black");
        ScndMenuBar2.getMenus().add(secndMenu2);
        ScndMenuBar2.setStyle("-fx-background-color: black");
        ScndMenuBar3.getMenus().add(DvdMenu17);
        ScndMenuBar3.setStyle("-fx-background-color: black");
        ScndMenuBar4.getMenus().add(DvdMenu16);
        ScndMenuBar4.setMaxHeight(height );
        
        
             
        
        
        
        // Create a list box name it Search by and add all the items necessary for the Search
        
        searchBy2.setPromptText("Search By");
        searchBy2.getItems().addAll("Title", "Class", "Author", "Genre");
        searchBy2.setMinWidth(100);
        
        
        // List of Search type to be chosen from
        
        
       
        
        
        
        
        
        // Set the text and the colour of the search button of the DVD screen
        srchBtn2.setText("SEARCH");
        srchBtn2.setTextFill(Color.RED);
        
        
        
       
        
      
        
        // Add all the menu buttons for the left DVD screen
        
        DVDMenu.getChildren().addAll(DvdMenu, DvdMenu1, DvdMenu2, DvdMenu3, DvdMenu4,DvdMenu5, DvdMenu6, DvdMenu7, DvdMenu8, DvdMenu9, DvdMenu10, DvdMenu11, DvdMenu12, DvdMenu13, DvdMenu14, DvdMenu15);
        DVDMenu.setSpacing(15);
        DVDMenu.setStyle("-fx-background-color: black");
    
        
       
     
       
       // Set the mennubar spacing and position them for both main menu and DVD screen 
        
        
        hBox.setSpacing(5);
        hBox.setTranslateX(165);
        hBox2.setSpacing(5);
        hBox2.setTranslateX(165);
        
        
        // Add the menubar and the horizontal box to the pane
        
        pane.getChildren().addAll(menuBar, hBox);
        
        // Add a black menubar to the top of the main screen 
        border.setTop(menuBar2);
        
       // Add the search by, search bar, etc to the top of the main screen
        border.getChildren().add(pane);
        
      
        
        // Creat the scene
         scene = new Scene(border, width, height);
        
        
        
        
        
        mainMenu.getChildren().clear();
          
        //mainMenu.getChildren().addAll(logoHolder, menuHolder);
        
        create_Stage();
        
        
        
        
        // If DVDs are selected, then remove the Author option from the Search By list
        // if Jigsaws/Magazines are selecte , then remove Author, Genre, Class from the Search By list
        
         searchBy.setOnMouseClicked(new EventHandler<MouseEvent>()
         {
                @Override
                    public void handle(MouseEvent e) 
                        
                        { 
                  if (searchType.getValue().equals("Search DVDs") )
     
   {
       
       searchBy.getItems().remove("Author");
       
       // Clear the contents of the menubar and add the updated contents
       
        hBox.getChildren().clear();
        hBox.getChildren().addAll(searchType, searchBy, search, srchBtn, lblCount2);
             
   }
                  
                  
      if( (!searchBy.getItems().contains("Class") || !searchBy.getItems().contains("Genre")) && searchType.getValue().equals("Search DVDs")) 
        { 
        searchBy.getItems().add("Class");
        searchBy.getItems().add("Genre");
       
       
        hBox.getChildren().clear();
        hBox.getChildren().addAll(searchType, searchBy, search, srchBtn, lblCount2);
        
        }             
                  
      
      else  if ( searchType.getValue().equals("Search Jigsaws")  )        
                 {
                      searchBy.getItems().remove("Author");
                      searchBy.getItems().remove("Class");
                      searchBy.getItems().remove("Genre");
                      
       // Clear the contents of the menubar and add the updated contents
       
        hBox.getChildren().clear();
        hBox.getChildren().addAll(searchType, searchBy, search, srchBtn, lblCount2);
                 
                 }
                  
                  
            
       else if ( searchType.getValue().equals("Search Magazines"))        
                 {
                      searchBy.getItems().remove("Author");
                      searchBy.getItems().remove("Class");
                      searchBy.getItems().remove("Genre");
       // Clear the contents of the menubar and add the updated contents
       
        hBox.getChildren().clear();
        hBox.getChildren().addAll(searchType, searchBy, search, srchBtn, lblCount2);
                 }
         
      
                
       if ( (!searchBy.getItems().contains("Author")) && (!searchBy.getItems().contains("Class")) && (!searchBy.getItems().contains("Genre")) && (searchType.getValue().equals("Search Entire Database") || searchType.getValue().equals("Search Books") || searchType.getValue().equals("Search Audio Books")) )
     
   {
       searchBy.getItems().add("Author");
       searchBy.getItems().add("Class");
       searchBy.getItems().add("Genre");
       
       
        hBox.getChildren().clear();
        hBox.getChildren().addAll(searchType, searchBy, search, srchBtn, lblCount2);
               
   }
   
       
       else  if(!searchBy.getItems().contains("Author")   && (searchType.getValue().equals("Search Entire Database") || searchType.getValue().equals("Search Books") || searchType.getValue().equals("Search Audio Books"))) 
        { 
        searchBy.getItems().add("Author");
        
       
       
        hBox.getChildren().clear();
        hBox.getChildren().addAll(searchType, searchBy, search, srchBtn, lblCount2);
        
        }
        
     
                  
    }
    
                
        });

         
         
        
       
        
       
        
      
        
        
        
        
        
        
        
        
                
       
        
      
        
        
        
        
        
        
        
        
                
       
    
    
    
    
    
    
    
    
    
    
    Database.connect();
    
    
    
   
    
    
      // Get all the action movies from the database when the Action button is clicked  
        DvdMenu1.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu1.setEffect(bloom);
                DvdMenu1.setTextFill(Color.YELLOW);
                DvdMenu1.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Action'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
    
            }
        });
            
         // Get all the adventure movies from the database when the Adventure button is clicked  
        
        DvdMenu2.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu2.setEffect(bloom);
                DvdMenu2.setTextFill(Color.YELLOW);
                DvdMenu2.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Adventure'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        // Get all the animation from the database when the Animation button is clicked  
        
        DvdMenu3.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu3.setEffect(bloom);
                DvdMenu3.setTextFill(Color.YELLOW);
                DvdMenu3.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Animation'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        // Get all comedy movies from the database when the Comedy button is clicked  
        
        DvdMenu4.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu4.setEffect(bloom);
                DvdMenu4.setTextFill(Color.YELLOW);
                DvdMenu4.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Comedy'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        // Get all documentaries from the database when the Documentaries button is clicked
        
        DvdMenu5.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu5.setEffect(bloom);
                DvdMenu5.setTextFill(Color.YELLOW);
                DvdMenu5.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Documentary'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        // Get all Drama movies from the database when the Drama button is clicked
        
        DvdMenu6.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu6.setEffect(bloom);
                DvdMenu6.setTextFill(Color.YELLOW);
                DvdMenu6.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Drama'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        // Get all Faith movies from the database when the Faith button is clicked
        
        DvdMenu7.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu7.setEffect(bloom);
                DvdMenu7.setTextFill(Color.YELLOW);
                DvdMenu7.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Faith'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        // Get all Fantasy movies from the database when the Fantasy button is clicked
        
        DvdMenu8.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu8.setEffect(bloom);
                DvdMenu8.setTextFill(Color.YELLOW);
                DvdMenu8.setStyle("-fx-background-color: brown");
                
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Fantasy'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        // Get all Fishing movies from the database when the Fishing button is clicked
        
        DvdMenu9.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu9.setEffect(bloom);
                DvdMenu9.setTextFill(Color.YELLOW);
                DvdMenu9.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Fishing'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        // Get all Horror movies from the database when the Horror button is clicked
        
        DvdMenu10.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu10.setEffect(bloom);
                DvdMenu10.setTextFill(Color.YELLOW);
                DvdMenu10.setStyle("-fx-background-color: brown");
                
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Horror'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        // Get all Martail Arts movies from the database when the Martial Arts button is clicked
        
        DvdMenu11.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu11.setEffect(bloom);
                DvdMenu11.setTextFill(Color.YELLOW);
                DvdMenu11.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Martial Arts'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
         // Get all Sci-Fi Arts movies from the database when the Sci-Fi button is clicked
        
        DvdMenu12.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu12.setEffect(bloom);
                DvdMenu12.setTextFill(Color.YELLOW);
                DvdMenu12.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Sci-Fi'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
       // Get all Thriller Arts movies from the database when the Thriller button is clicked
        
        DvdMenu13.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu13.setEffect(bloom);
                DvdMenu13.setTextFill(Color.YELLOW);
                DvdMenu13.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Thriller'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
         
      
        // Get all True Life Arts movies from the database when the True Life button is clicked
        
        DvdMenu14.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu14.setEffect(bloom);
                DvdMenu14.setTextFill(Color.YELLOW);
                DvdMenu14.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'True Life'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                 
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        // Get all Poem DVDs from the database when the Poem DVDs button is clicked
        
        DvdMenu15.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                DVD.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                DvdMenu15.setEffect(bloom);
                DvdMenu15.setTextFill(Color.YELLOW);
                DvdMenu15.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable where Genre = 'Poem DVD'");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
      
        
        /* Set the second scene of the window to DVD menu and resize the window to fit the contents
           Get all the DVDs from the database and load these into the the table to display 
        */
        
        
        dvd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                
                DVD.counter = 0;
                // Add the center of the main screen
                
                lblCount2.setText("");
                border.setLeft(null);
                border.setRight(null);
                border.setLeft(DVDMenu);
                border.setCenter(null);
                centerMenu.getChildren().clear();
                centerMenu.getChildren().add(DVDtable);
                centerMenu.setTranslateY(1);
                centerMenu.autosize();
                
                border.setCenter(centerMenu);
                border.setLeft(DVDMenu);
                stage.setTitle("DVD Stock");
                
                
                try 
                
                { ResultSet movie = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDTable ");
                  
                  DVDtable.setItems(DVD.loadData(movie));
                  
                  lblCount2.setTextFill(Color.YELLOW);
                  lblCount2.setText("Total number of items: " + Integer.toString(DVD.counter));
                  lblCount2.setEffect(new Bloom());
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
            }
        });
        
        
        
        
        /* 
         get all the media from the database and load these into the main screen
          
         */
          
         library.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                border.setRight(null);
                border.setCenter(null); 
                
                 
                
                
                centerMenu.getChildren().clear();
                centerMenu.getChildren().add(Maintable);
                centerMenu.setTranslateY(1);
                //centerMenu.autosize();
                
                border.setCenter(centerMenu);
                mainMenu.getChildren().clear();
                mainMenu.getChildren().addAll(logoHolder, menuHolder);
                border.setLeft(StockSearch.mainMenu);
                border.setBottom(catalogBox);
                
                
                stage.setScene(StockSearch.scene);
               
                stage.setTitle("Entire Library Stock");
                
                // Start the progress bar for displaying info on loading all the data
                
                
                Update up = new Update("          Loading please wait...   ");
                
                up.setVisible(true);
                
                
                // Load all of the data from the database into the table
                try 
                
                { ResultSet all = Database.get_Statement().executeQuery("select Class, Media, Title,  Author, Genre, cat_Number from Audiotable "
                        + "UNION select Class, Media, Title, Author, Genre, cat_Number from BookTable "
                        + "UNION Select Class, Media, title, Remarks, genre, cat_number from DVDtable "
                        + "UNION Select Class, Media, Title, Remarks, Genre, cat_Number from Gametable "
                        + "UNION Select Class, Media, Title, Remarks, Genre, cat_Number from Magtable "
                        + "UNION Select Class, Media, Title, Remarks, Genre, cat_Number from Jigsawtable"
                        
                        );
                  
                  Main.counter = 0;
                  StockSearch.lblCount2.setTextFill(Color.YELLOW);
                  
                  
                  
              
                 
                  StockSearch.Maintable.setItems(Main.loadData(all));
                  up.close();
                  
                  StockSearch.lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                  StockSearch.lblCount2.setEffect(new Bloom());
                 
                  
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
                  
            
               
                
                
                
                
            }
            
         });
        
        /* 
           Get all the books from the database and load these into the the table to display 
        */
        
       
        books.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                
                Book.counter = 0;
                lblCount2.setText("");
                border.setLeft(bookMenu);
                centerMenu.getChildren().clear();
                centerMenu.setTranslateY(1);
                centerMenu.getChildren().add(Booktable);
                centerMenu.autosize();
                border.setCenter(centerMenu);
                stage.setTitle("Book Stock");
                
                
                try 
                
                { ResultSet book = Database.get_Statement().executeQuery("select Class, Title, Author, Genre, Remarks, cat_Number from BookTable ");
                  
                  Booktable.setItems(Book.loadData(book));
                  
                  
                  
                  lblCount2.setTextFill(Color.YELLOW);
                  lblCount2.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount2.setEffect(new Bloom());
                  
                 
                }
                
                catch (SQLException e)
                {
                    System.out.println("Error " + e);
                }   
        
            }
        });
        
        
        
        
        audio.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Audio.counter = 0;
                mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(StockSearch.logoHolder, menuHolder);                    
                                    
                border.setLeft(null);
                border.setLeft(null);
                border.setRight(null);
                border.setCenter(null);
                centerMenu.getChildren().clear();
                centerMenu.setTranslateY(1);
                centerMenu.autosize();
                border.setLeft(mainMenu);
                
                
                centerMenu.getChildren().add(Audiotable);
                centerMenu.setTranslateY(1);
                centerMenu.autosize();
                border.setCenter(centerMenu);
               
                StockSearch.stage.setTitle("Audio Stock");
                
                
                try 
                
                { ResultSet audio = Database.get_Statement().executeQuery("select Class, Title, Author, Genre, Remarks, cat_Number from AudioTable ");
                  
                  Audiotable.setItems(Audio.loadData(audio));
                  
                  lblCount2.setTextFill(Color.YELLOW);
                  lblCount2.setText("Total number of items: " + Integer.toString(Audio.counter));
                  lblCount2.setEffect(new Bloom());
                  
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
            }
        });
        
        
        
        
        
        games.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
               mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(logoHolder, menuHolder);
                
                Games.counter = 0;
                
                border.setRight(null);
                
                
                border.setCenter(null);
                centerMenu.getChildren().clear();
                centerMenu.getChildren().add(Gamestable);
                centerMenu.setTranslateY(1);
                centerMenu.autosize();
                border.setLeft(mainMenu);
                border.setCenter(centerMenu);
                
                
                stage.setTitle("Games Stock");
                
                
                try 
                
                { ResultSet game = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from GameTable ");
                  
                  Gamestable.setItems(Games.loadData(game));
                  
                  lblCount2.setTextFill(Color.YELLOW);
                  lblCount2.setText("Total number of items: " + Integer.toString(Games.counter));
                  lblCount2.setEffect(new Bloom());
                  
                  
                
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
            }
        });
        
        
        
          mag.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Mags.counter = 0;
                mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(logoHolder, menuHolder);
                border.setLeft(null);
                border.setRight(null);
                border.setCenter(null);
                centerMenu.getChildren().clear();
                centerMenu.getChildren().add(Magstable);
                border.setCenter(centerMenu);
                centerMenu.setTranslateY(1);
                centerMenu.autosize();
                border.setLeft(mainMenu);
                //border.setCenter(centerMenu);
                
                
                
                stage.setTitle("Magazine Stock");
                
                
                try 
                
                { ResultSet mag = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number  from Magtable ");
                 
                  Magstable.setItems(Mags.loadData(mag));
                  
                              
                  
                 
                  lblCount2.setTextFill(Color.YELLOW);
                  lblCount2.setText("Total number of items: " + Integer.toString(Mags.counter));
                  lblCount2.setEffect(new Bloom());
                  
                  
                  
                }
                catch (SQLException e)
                {
                          System.out.println(e);
                }   
        
            }
        });
        
        
        
        
        
        
      
        
        jigsaw.setOnMouseClicked(new EventHandler<MouseEvent>() {
        
            @Override
            public void handle(MouseEvent event) {
                
                mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(StockSearch.logoHolder, menuHolder);
                
                border.setLeft(null);
                border.setRight(null);
                border.setCenter(null);
                centerMenu.getChildren().clear();
                centerMenu.getChildren().add(Jigsawtable);
                centerMenu.setTranslateY(1);
                centerMenu.autosize();
                border.setLeft(mainMenu);
                border.setCenter(centerMenu);
                
                StockSearch.stage.setTitle("Jigsaw Stock");
                
                
                try 
                
                { ResultSet jigs = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from JigsawTable ");
                  
                  Jigsawtable.setItems(Jigsaw.loadData(jigs));
                  
                 
                  lblCount2.setTextFill(Color.YELLOW);
                  lblCount2.setText("Total number of items: " + Integer.toString(Jigsaw.counter));
                  lblCount2.setEffect(new Bloom());
                  
                  
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
            }
        });
        
        
       
        
        fiction.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                fiction.setEffect(bloom);
                fiction.setTextFill(Color.YELLOW);
                fiction.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Class = 'Fiction'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount2.setTextFill(Color.YELLOW);
                  lblCount2.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount2.setEffect(bloom);
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        Adv.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                Adv.setEffect(bloom);
                Adv.setTextFill(Color.YELLOW);
                Adv.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Genre = 'Adventure'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        
        Crime.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                Crime.setEffect(bloom);
                Crime.setTextFill(Color.YELLOW);
                Crime.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Genre = 'Crime'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        
        
        
       
        
        FantBooks.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                FantBooks.setEffect(bloom);
                FantBooks.setTextFill(Color.YELLOW);
                FantBooks.setStyle("-fx-background-color: brown");
                
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Genre = 'Fantasy'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        Historical.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                Historical.setEffect(bloom);
                Historical.setTextFill(Color.YELLOW);
                Historical.setStyle("-fx-background-color: brown");
                
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Genre = 'Historical'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        Horror.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                Horror.setEffect(bloom);
                Horror.setTextFill(Color.YELLOW);
                Horror.setStyle("-fx-background-color: brown");
                
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Genre = 'Horror'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        
        SciFiBooks.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                SciFiBooks.setEffect(bloom);
                SciFiBooks.setTextFill(Color.YELLOW);
                SciFiBooks.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Genre = 'Sci-Fi'");
                  
                  Booktable.setItems(Book.loadData(books));
                 
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
        
        Thriller.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                Thriller.setEffect(bloom);
                Thriller.setTextFill(Color.YELLOW);
                Thriller.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number   from BookTable where Genre = 'Thriller'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
       
              }
        });
        
        
     
        
        non_fiction.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                non_fiction.setEffect(bloom);
                non_fiction.setTextFill(Color.YELLOW);
                non_fiction.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '0' AND '999.999'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        art.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                art.setEffect(bloom);
                art.setTextFill(Color.YELLOW);
                art.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '700' AND '799'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        biog.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                biog.setEffect(bloom);
                biog.setTextFill(Color.YELLOW);
                biog.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '920' AND '921'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        dict.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                dict.setEffect(bloom);
                dict.setTextFill(Color.YELLOW);
                dict.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Genre = 'Dictionary'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        geo.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                geo.setEffect(bloom);
                geo.setTextFill(Color.YELLOW);
                geo.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '900' AND '919'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        
        
        hist.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                hist.setEffect(bloom);
                hist.setTextFill(Color.YELLOW);
                hist.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '940' AND '999'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        lan.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                 lan.setEffect(bloom);
                 lan.setTextFill(Color.YELLOW);
                 lan.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '400' AND '499'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        
        lit.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                 lit.setEffect(bloom);
                 lit.setTextFill(Color.YELLOW);
                 lit.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '800' AND '899'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        natSci.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                
              Book.counter = 0;  
              Bloom bloom = new Bloom();
              bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                natSci.setEffect(bloom);
                natSci.setTextFill(Color.YELLOW);
                natSci.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '500' AND '599'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        
         phil.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                phil.setEffect(bloom);
                phil.setTextFill(Color.YELLOW);
                phil.setStyle("-fx-background-color: brown");
                
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '100' AND '199'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        rel.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                
               for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                rel.setEffect(bloom);
                rel.setTextFill(Color.YELLOW);
                rel.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '200' AND '299'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
        socSci.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
               
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                socSci.setEffect(bloom);
                socSci.setTextFill(Color.YELLOW);
                socSci.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '300' AND '399'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        });
        
        
        
       tech.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
               
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                tech.setEffect(bloom);
                tech.setTextFill(Color.YELLOW);
                tech.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class BETWEEN '600' AND '699'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        }); 
        
       
       
       
       wHist.setOnAction(new EventHandler<ActionEvent>() {
            
            
            @Override
            public void handle(ActionEvent event) {
                
                Book.counter = 0;
                Bloom bloom = new Bloom();
                bloom.setThreshold(0.3);
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                wHist.setEffect(bloom);
                wHist.setTextFill(Color.YELLOW);
                wHist.setStyle("-fx-background-color: brown");
                try 
                
                { ResultSet books = Database.get_Statement().executeQuery("SELECT CLASS, TITLE, AUTHOR, REMARKS, GENRE,  CAT_NUMBER   FROM BookTable WHERE Class = '909'");
                  
                  Booktable.setItems(Book.loadData(books));
                  
                  lblCount.setTextFill(Color.YELLOW);
                  lblCount.setText("Total number of items: " + Integer.toString(Book.counter));
                  lblCount.setEffect(bloom);
                }
                catch (SQLException e)
                {
                   System.out.println(e);
                }   
       
              }
        }); 
       

       
       
       
       
       
       
       
       
        
        // Create a link to the home page from the second screen 
        
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                
                
                
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                
                stage.setScene(scene); 
                
                centerMenu.getChildren().clear();
              
                border.setCenter(DisplayShelf.root);
                StockSearch.mainMenu.getChildren().clear();
                border.setBottom(null);
               
                border.setRight(null);
                border.setLeft(null);
                stage.setTitle("Library Stock Search");
                lblCount2.setTextFill(Color.YELLOW);
                lblCount2.setText("");
                lblCount2.setEffect(new Bloom());
                
            }
        });
        
        
        
        
           // Create a link to the home page from the DVD screen 
        
        home2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                 
                lblCount.setText("");
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                
                
                
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                
                stage.setScene(scene); 
                stage.setFullScreen(true);
                stage.setFullScreen(false);
                centerMenu.getChildren().clear();
              
                border.setCenter(DisplayShelf.root);
                border.setLeft(null);
                border.setRight(logoHolder);
                lblCount2.setTextFill(Color.YELLOW);
                lblCount2.setText("");
                lblCount2.setEffect(new Bloom());
               
                stage.setTitle("Library Stock Search");
                
                
            }
        });
        
        
        
        
      
        
        
        
        //  Create a minimise menu item for the Database menu
        
         minimise.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                
                stage.setIconified(true);
                
                
                
                stage.setTitle("Library Stock Search");
                
                
            }
        });
        
        
        
        
        
        
        
        
        
        
        menuHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                lblCount.setText("");
                for  (int i = 0; i < bookItems.size(); i++)
                {
                    
                    bookItems.get(i).setTextFill(Color.AQUA);
                    bookItems.get(i).setStyle("-fx-background-color: black");
                }
                
                
                
                for  (int i = 0; i < dvdItems.size(); i++)
                {
                    
                    dvdItems.get(i).setTextFill(Color.AQUA);
                    dvdItems.get(i).setStyle("-fx-background-color: black");
                    
                }
                
                stage.setScene(scene); 
                stage.setFullScreen(true);
                stage.setFullScreen(false);
                centerMenu.getChildren().clear();
              
                border.setCenter(DisplayShelf.root);
                border.setLeft(null);
                border.setRight(logoHolder);
               
                stage.setTitle("Library Stock Search");
                
                
            }
        });
        
        
        
        
        
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            
            
            public void handle(ActionEvent event)  {
                boolean gotSql = false;
                boolean confirm = Confirm.show("Confirm Exit", "Are you sure?", "Yes", "No");
            
            if (confirm) 
            {
                try 
                {
                    Database.shut();
                     
                
                
                }
            catch (FileNotFoundException fe) 
            
            {
               System.out.println(fe) ;
            }
            
            catch (IOException ie)
            {
               System.out.println(ie) ; 
            }
            
            catch (SQLException se)  
            {
                if (se.getSQLState().equals("XJ015"))
                {
                   gotSql = true; 
                }
               if (!gotSql)
               {
                   System.out.println("database did not shutdown normally.") ;
               }
               else
               {
                  System.out.println("database shutdown normally."); 
                  System.exit(0);
               }
            }
            
            }      
            }
        
        });
     
        
        exit2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean gotSql = false;
                boolean confirm = Confirm.show("Confirm Exit", "Are you sure?", "Yes", "No");
            
            if (confirm) 
            {
                try 
                {
                    Database.shut();
                     
                
                
                }
            catch (FileNotFoundException fe) 
            
            {
               System.out.println(fe);
            }
            
            catch (IOException ie)
            {
               System.out.println(ie) ; 
            }
            
            catch (SQLException se)  
            {
                if (se.getSQLState().equals("XJ015"))
                {
                   gotSql = true; 
                }
               if (!gotSql)
               {
                   System.out.println("database did not shutdown normally.") ;
               }
               else
               {
                  System.out.println("database shutdown normally."); 
                  System.exit(0);
               }
            }
            
            }      
            }
        
        });
        
        
       stage.setOnCloseRequest(new EventHandler<WindowEvent>()
        {
        
            
        @Override public void handle(WindowEvent e)
          {
            e.consume();
            boolean gotSql = false;
            boolean confirm = Confirm.show("Confirm Exit", "Are you sure?", "Yes", "No");
            
           if (confirm) 
            {
                try 
                {
                    Database.shut();
               
                }
            catch (FileNotFoundException fe) 
            
            {
               System.out.println(fe) ;
            }
            
            catch (IOException ie)
            {
               System.out.println(ie) ; 
            }
            
            catch (SQLException se)  
            {
                if (se.getSQLState().equals("XJ015"))
                {
                   gotSql = true; 
                }
               if (!gotSql)
               {
                   System.out.println("database did not shutdown normally.") ;
               }
               else
               {
                  System.out.println("database shutdown normally."); 
                  System.exit(0);
               }
            }
            
                
               
            }      
            }
        
        });
    
       
       
        

              
              
              
         
  
       
 
  

    
    
    search.setOnAction(new EventHandler<ActionEvent>() {
        
      
        
        
        
        
        @Override
            public void handle(ActionEvent event)
            {
                
          mainMenu.getChildren().clear();
          
          mainMenu.getChildren().addAll(logoHolder, menuHolder);   
           
              
          // Set the variables
        ResultSet results = null;
        
        
        String contents = "";
        int len = 0;
        
        CharSequence contents2;
        
        // Set the variables
                lblCount.setText("");
                Main.counter = 0;
                // get the user entry
                contents = search.getText();
                contents = contents.toLowerCase();
                contents2 = contents.subSequence(0, contents.length());
                len = contents.length();
                search.setText("");
                
                
                
                
                   
                 
                
               
                  // If search by combo is not selected 
                   if (searchBy.getValue() == null || searchType.getValue() == null) 
                   
               {
                   try
                   {
                       
                   
                   // Display a dialog box to remind the user to choose the search by option
                   Confirm.show("Search by", "Choose an option from the Search By \n"
                           + "           and Search Options lists ", "Ok", "Cancel");
                   
               } 
                  catch (NullPointerException ne)
                  
                  {
                      
                  
                   searchType.setValue(searchType.getValue());
                   searchBy.setValue(searchBy.getValue()); 
                  }    
              }   
                  
                
                if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Title") )
               
                {
                    
                    
                        
                try 
                { 
                    
                  results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.title) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.title) like '%" + contents2 + "') OR (LOWER(Audiotable.title) like  '" + contents2 + "%') OR (LOWER(Audiotable.title) like  '_" + contents2 + "%') OR (LOWER(Audiotable.title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select  Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.title) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.title) like '%" + contents2 + "') OR (LOWER(Audiotable.title) like  '" + contents2 + "%') OR (LOWER(Audiotable.title) like  '_" + contents2 + "%') OR (LOWER(Audiotable.title) = '" + contents2 + "')" 
                         
                          
                          );
                          
                          
                          
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }    
                
                else 
                  if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Class") )
               
                {
                    try     
                
                { 
                    
                 results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.class) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.class) like '%" + contents2 + "') OR (LOWER(Audiotable.class) like  '" + contents2 + "%') OR (LOWER(Audiotable.class) like  '_" + contents2 + "%') OR (LOWER(Audiotable.class) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select  Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.class) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.class) like '%" + contents2 + "') OR (LOWER(Audiotable.class) like  '" + contents2 + "%') OR (LOWER(Audiotable.class) like  '_" + contents2 + "%') OR (LOWER(Audiotable.class) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
                }
           
                 else if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Author") )
               
                    {
                        try 
                    {

                 results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Author) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Author) like '%" + contents2 + "') OR (LOWER(Audiotable.Author) like  '" + contents2 + "%') OR (LOWER(Audiotable.Author) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Author) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select  Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          +"WHERE (SUBSTR(LOWER(Audiotable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Author) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Author) like '%" + contents2 + "') OR (LOWER(Audiotable.Author) like  '" + contents2 + "%') OR (LOWER(Audiotable.Author) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Author) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
              
                    } 
                 
                 else if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Genre") )
               
                                       {
                                try 
                                   {

                        results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Genre) like '%" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '" + contents2 + "%') OR (LOWER(Audiotable.Genre) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Genre) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Genre) like '%" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '" + contents2 + "%') OR (LOWER(Audiotable.Genre) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Genre) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
                
                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Title") )
               
                         {
                            try 
                         {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Title) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Title) like '%" + contents2 + "') OR (LOWER(Booktable.Title) like  '" + contents2 + "%') OR (LOWER(Booktable.Title) like  '_" + contents2 + "%') OR (LOWER(Booktable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Title) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Title) like '%" + contents2 + "') OR (LOWER(Booktable.Title) like  '" + contents2 + "%') OR (LOWER(Booktable.Title) like  '_" + contents2 + "%') OR (LOWER(Booktable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
                

                 
                 
                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Class") )
               
                             {
                            try 
                                 {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Class) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Class) like '%" + contents2 + "') OR (LOWER(Booktable.Class) like  '" + contents2 + "%') OR (LOWER(Booktable.Class) like  '_" + contents2 + "%') OR (LOWER(Booktable.Class) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Class) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Class) like '%" + contents2 + "') OR (LOWER(Booktable.Class) like  '" + contents2 + "%') OR (LOWER(Booktable.Class) like  '_" + contents2 + "%') OR (LOWER(Booktable.Class) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
              

                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Author") )
               
                          {
                                try 
                        {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Author) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Author) like '%" + contents2 + "') OR (LOWER(Booktable.Author) like  '" + contents2 + "%') OR (LOWER(Booktable.Author) like  '_" + contents2 + "%') OR (LOWER(Booktable.Author) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Author) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Author) like '%" + contents2 + "') OR (LOWER(Booktable.Author) like  '" + contents2 + "%') OR (LOWER(Booktable.Author) like  '_" + contents2 + "%') OR (LOWER(Booktable.Author) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
                

                 
                 
                 
                 
                 
                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Genre") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Genre) like '%" + contents2 + "') OR (LOWER(Booktable.Genre) like  '" + contents2 + "%') OR (LOWER(Booktable.Genre) like  '_" + contents2 + "%') OR (LOWER(Booktable.Genre) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Genre) like '%" + contents2 + "') OR (LOWER(Booktable.Genre) like  '" + contents2 + "%') OR (LOWER(Booktable.Genre) like  '_" + contents2 + "%') OR (LOWER(Booktable.Genre) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
                 
             }
                 
                 
                  
                 
                 else if (searchType.getValue().equals("Search DVDs") &&  searchBy.getValue().equals("Title") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Title) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Title) like '%" + contents2 + "') OR (LOWER(DVDtable.Title) like  '" + contents2 + "%') OR (LOWER(DVDtable.Title) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Title) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Title) like '%" + contents2 + "') OR (LOWER(DVDtable.Title) like  '" + contents2 + "%') OR (LOWER(DVDtable.Title) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 

           
            }  
                

                 else if (searchType.getValue().equals("Search DVDs") &&  searchBy.getValue().equals("Class") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Class) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Class) like '%" + contents2 + "') OR (LOWER(DVDtable.Class) like  '" + contents2 + "%') OR (LOWER(DVDtable.Class) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Class) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Class) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Class) like '%" + contents2 + "') OR (LOWER(DVDtable.Class) like  '" + contents2 + "%') OR (LOWER(DVDtable.Class) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Class) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
               }
            
                
                
                 else if (searchType.getValue().equals("Search DVDs") &&  searchBy.getValue().equals("Genre") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Genre) like '%" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '" + contents2 + "%') OR (LOWER(DVDtable.Genre) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Genre) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          + "WHERE (SUBSTR(LOWER(DVDtable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Genre) like '%" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '" + contents2 + "%') OR (LOWER(DVDtable.Genre) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Genre) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
            
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
            }
                               
                
                
          else if (searchType.getValue().equals("Search Jigsaws") &&  searchBy.getValue().equals("Title") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Jigsawtable.Class, Jigsawtable.Media, Jigsawtable.title,"
                          + "Jigsawtable.Remarks, Jigsawtable.genre, Jigsawtable.cat_number "
                          + "from Jigsawtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Jigsawtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '%" + contents2 + "%')  OR (LOWER(Jigsawtable.Title) like '%" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '" + contents2 + "%') OR (LOWER(Jigsawtable.Title) like  '_" + contents2 + "%') OR (LOWER(Jigsawtable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Jigsawtable.Class, Jigsawtable.Media, Jigsawtable.title,"
                          + "Jigsawtable.Remarks, Jigsawtable.genre, Jigsawtable.cat_number "
                          + "from Jigsawtable "
                          
                         +"WHERE (SUBSTR(LOWER(Jigsawtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '%" + contents2 + "%')  OR (LOWER(Jigsawtable.Title) like '%" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '" + contents2 + "%') OR (LOWER(Jigsawtable.Title) like  '_" + contents2 + "%') OR (LOWER(Jigsawtable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 

           
            }
      
             
                else if (searchType.getValue().equals("Search Magazines") &&  searchBy.getValue().equals("Title") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select MagTable.Class, MagTable.Media, MagTable.title,"
                          + "MagTable.Remarks, MagTable.genre, MagTable.cat_number "
                          + "from MagTable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(MagTable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(MagTable.Title) like  '%" + contents2 + "%')  OR (LOWER(MagTable.Title) like '%" + contents2 + "') OR (LOWER(MagTable.Title) like  '" + contents2 + "%') OR (LOWER(MagTable.Title) like  '_" + contents2 + "%') OR (LOWER(MagTable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select MagTable.Class, MagTable.Media, MagTable.title,"
                          + "MagTable.Remarks, MagTable.genre, MagTable.cat_number "
                          + "from MagTable "
                          
                         +"WHERE (SUBSTR(LOWER(MagTable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(MagTable.Title) like  '%" + contents2 + "%')  OR (LOWER(MagTable.Title) like '%" + contents2 + "') OR (LOWER(MagTable.Title) like  '" + contents2 + "%') OR (LOWER(MagTable.Title) like  '_" + contents2 + "%') OR (LOWER(MagTable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 

           
            }

               
                
                
               
               
                              
                if (searchType.getValue().equals("Search Entire Database") && searchBy.getValue().equals("Title") )
               
                
                
                {
                  
                    try     
                
                { 
                   
                          results =  Database.get_Statement().executeQuery(
                                  
                         
                               
                          "Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.title), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.title) like '" + contents2 + "%'" 
                        
                        
                          
                          + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.title), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.title) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.title) like '" + contents2 + "%'" 


                         
                          + " UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE SUBSTR(LOWER(D.title), 1, " +  len + ") = '" + contents2 +"'"
                          
                          

			  + "UNION ALL Select D.class,  D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.title) like '" + contents2 + "%'" 




                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE  SUBSTR(LOWER(G.title), 1, " +  len + ") = '" + contents2 +"'"
                          
                                                 
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.title) like  '%" + contents2 + "%'"                      
                         
                          
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.title) like '" + contents2 + "%'"


                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE SUBSTR(LOWER(M.title), 1, " +  len + ") = '" + contents2 +"'"
                          
                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.title) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select M.class, M.Media,  M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.title) like '" + contents2 + "%'"



                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE SUBSTR(LOWER(J.title), 1, " +  len + ") = '" + contents2 +"'"
                                               
                          
                       
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like '" + contents2 + "%'"


                          );
                
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
               
               
               
               
          }        
            
                
             else if (searchBy.getValue().equals("Class") && searchType.getValue().equals("Search Entire Database"))
                { 
                     
                    
                    try     
                
                {       results =  Database.get_Statement().executeQuery(
                    
                          "Select B.class, B.Media, B.Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.Class), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Class) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Class) like '" + contents2 + "%'" 
                        
                         
                                                  
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.Class), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Class) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Class) like '" + contents2 + "%'" 


                         
                          + " UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE SUBSTR(LOWER(D.Class), 1, " +  len + ") = '" + contents2 +"'"
                          
                          

			  + "UNION ALL Select D.class,  D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Class) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Class) like '" + contents2 + "%'" 




                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE  SUBSTR(LOWER(G.Class), 1, " +  len + ") = '" + contents2 +"'"
                          
                                                 
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Class) like  '%" + contents2 + "%'"                      
                         
                          
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Class) like '" + contents2 + "%'"


                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE SUBSTR(LOWER(M.Class), 1, " +  len + ") = '" + contents2 +"'"
                          
                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Class) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select M.class, M.Media,  M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Class) like '" + contents2 + "%'"



                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE SUBSTR(LOWER(J.Class), 1, " +  len + ") = '" + contents2 +"'"
                                               
                          
                       
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Class) like '" + contents2 + "%'"


                          );
                
                    } 

                    
                 
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
               
              
               
               
          }      
               
                  
            else if (searchBy.getValue().equals("Author") && searchType.getValue().equals("Search Entire Database") )
                { 
                     
                    
                    try     
                
                { results =  Database.get_Statement().executeQuery(
                    
                          "Select B.class, B.Media, B.Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.Author), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Author) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Author) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Author) like '" + contents2 + "%'" 
                        
                         
                                                  
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.Author), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Author) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Author) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Author) like '" + contents2 + "%'" 


                       

                        );
                             } 

                    
                 
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
       
           }
              
               else if (searchBy.getValue().equals("Genre") && searchType.getValue().equals("Search Entire Database") )
                {
               
                try
          
                   {

                    results =  Database.get_Statement().executeQuery(
                    
                          "Select B.class, B.Media, B.Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.Genre), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Genre) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Genre) like '" + contents2 + "%'" 
                        
                         
                                                  
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.Genre), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Genre) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Genre) like '" + contents2 + "%'" 


                         
                          + " UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE SUBSTR(LOWER(D.Genre), 1, " +  len + ") = '" + contents2 +"'"
                          
                          

			  + "UNION ALL Select D.class,  D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Genre) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Genre) like '" + contents2 + "%'" 




                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE  SUBSTR(LOWER(G.Genre), 1, " +  len + ") = '" + contents2 +"'"
                          
                                                 
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Genre) like  '%" + contents2 + "%'"                      
                         
                          
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Genre) like '" + contents2 + "%'"


                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE SUBSTR(LOWER(M.Genre), 1, " +  len + ") = '" + contents2 +"'"
                          
                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Genre) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select M.class, M.Media,  M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Genre) like '" + contents2 + "%'"



                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE SUBSTR(LOWER(J.Genre), 1, " +  len + ") = '" + contents2 +"'"
                                               
                          
                       
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Genre) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Genre) like '" + contents2 + "%'"

                    );
                            
                                
               }
                    
                 
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                  
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
               
       }
      
               
          else if (Main.counter == 0) 
                 {
                     ConfirmationBox.show("No Results found", "Your search returned no matches", "Ok");
                     
                 }  
           }  
              
              });
           //searchBy.setValue(null);
           //searchType.setValue(null);   
                    
             
          
       
        
              
        
        
    srchBtn.setOnAction(new EventHandler<ActionEvent>() {
        
      
        
        
        
        
        @Override
            public void handle(ActionEvent event)
            {
                
          mainMenu.getChildren().clear();
          
          mainMenu.getChildren().addAll(logoHolder, menuHolder);   
           
              
          // Set the variables
        ResultSet results = null;
        
        
        String contents = "";
        int len = 0;
        
        CharSequence contents2;
        
        // Set the variables
                lblCount.setText("");
                Main.counter = 0;
                // get the user entry
                contents = search.getText();
                contents = contents.toLowerCase();
                contents2 = contents.subSequence(0, contents.length());
                len = contents.length();
                search.setText("");
                
                
                
                
                   
                 
                
                // If the search by combo is not selected and user input is Update
                  if (searchBy.getValue() == null && searchType.getValue() == null && contents.equals("update"))
                    
                {   // Display the Password dialog box
                    password.show("Authentication Required!", "\nEnter username", "\n Enter the Password.", "OK");
               
                }
                  // Else if search by combo is not selected 
                  else  if (searchBy.getValue() == null || searchType.getValue() == null) 
                   
               {
                   try
                   {
                       
                   
                   // Display a dialog box to remind the user to choose the search by option
                   Confirm.show("Search by", "Choose an option from the Search By \n"
                           + "           and Search Options lists ", "Ok", "Cancel");
                   
               } 
                  catch (NullPointerException ne)
                  
                  {
                      
                  
                   searchType.setValue(searchType.getValue());
                   searchBy.setValue(searchBy.getValue()); 
                  }    
              }   
                  
                
                if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Title") )
               
                {
                    
                    
                        
                try 
                { 
                    
                  results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.title) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.title) like '%" + contents2 + "') OR (LOWER(Audiotable.title) like  '" + contents2 + "%') OR (LOWER(Audiotable.title) like  '_" + contents2 + "%') OR (LOWER(Audiotable.title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select  Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.title) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.title) like '%" + contents2 + "') OR (LOWER(Audiotable.title) like  '" + contents2 + "%') OR (LOWER(Audiotable.title) like  '_" + contents2 + "%') OR (LOWER(Audiotable.title) = '" + contents2 + "')" 
                         
                          
                          );
                          
                          
                          
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }    
                
                else 
                  if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Class") )
               
                {
                    try     
                
                { 
                    
                 results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.class) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.class) like '%" + contents2 + "') OR (LOWER(Audiotable.class) like  '" + contents2 + "%') OR (LOWER(Audiotable.class) like  '_" + contents2 + "%') OR (LOWER(Audiotable.class) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select  Audiotable.class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.class) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.class) like '%" + contents2 + "') OR (LOWER(Audiotable.class) like  '" + contents2 + "%') OR (LOWER(Audiotable.class) like  '_" + contents2 + "%') OR (LOWER(Audiotable.class) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
                }
           
                 else if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Author") )
               
                    {
                        try 
                    {

                 results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Author) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Author) like '%" + contents2 + "') OR (LOWER(Audiotable.Author) like  '" + contents2 + "%') OR (LOWER(Audiotable.Author) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Author) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select  Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          +"WHERE (SUBSTR(LOWER(Audiotable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Author) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Author) like '%" + contents2 + "') OR (LOWER(Audiotable.Author) like  '" + contents2 + "%') OR (LOWER(Audiotable.Author) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Author) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
              
                    } 
                 
                 else if (searchType.getValue().equals("Search Audio Books") && searchBy.getValue().equals("Genre") )
               
                                       {
                                try 
                                   {

                        results =  Database.get_Statement().executeQuery(""
                          + "Select Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Genre) like '%" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '" + contents2 + "%') OR (LOWER(Audiotable.Genre) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Genre) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Audiotable.Class, Audiotable.Media, Audiotable.title,"
                          + "Audiotable.Author, Audiotable.genre, Audiotable.cat_number "
                          + "from Audiotable "
                          
                         +"WHERE (SUBSTR(LOWER(Audiotable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Audiotable.Genre) like '%" + contents2 + "') OR (LOWER(Audiotable.Genre) like  '" + contents2 + "%') OR (LOWER(Audiotable.Genre) like  '_" + contents2 + "%') OR (LOWER(Audiotable.Genre) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
                
                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Title") )
               
                         {
                            try 
                         {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Title) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Title) like '%" + contents2 + "') OR (LOWER(Booktable.Title) like  '" + contents2 + "%') OR (LOWER(Booktable.Title) like  '_" + contents2 + "%') OR (LOWER(Booktable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Title) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Title) like '%" + contents2 + "') OR (LOWER(Booktable.Title) like  '" + contents2 + "%') OR (LOWER(Booktable.Title) like  '_" + contents2 + "%') OR (LOWER(Booktable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
                

                 
                 
                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Class") )
               
                             {
                            try 
                                 {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Class) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Class) like '%" + contents2 + "') OR (LOWER(Booktable.Class) like  '" + contents2 + "%') OR (LOWER(Booktable.Class) like  '_" + contents2 + "%') OR (LOWER(Booktable.Class) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Class) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Class) like '%" + contents2 + "') OR (LOWER(Booktable.Class) like  '" + contents2 + "%') OR (LOWER(Booktable.Class) like  '_" + contents2 + "%') OR (LOWER(Booktable.Class) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
              

                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Author") )
               
                          {
                                try 
                        {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Author) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Author) like '%" + contents2 + "') OR (LOWER(Booktable.Author) like  '" + contents2 + "%') OR (LOWER(Booktable.Author) like  '_" + contents2 + "%') OR (LOWER(Booktable.Author) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.Genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Author), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Author) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Author) like '%" + contents2 + "') OR (LOWER(Booktable.Author) like  '" + contents2 + "%') OR (LOWER(Booktable.Author) like  '_" + contents2 + "%') OR (LOWER(Booktable.Author) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
           
            }  
                

                 
                 
                 
                 
                 
                 else if (searchType.getValue().equals("Search Books") && searchBy.getValue().equals("Genre") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.genre, Booktable.cat_number "
                          + "from Booktable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Genre) like '%" + contents2 + "') OR (LOWER(Booktable.Genre) like  '" + contents2 + "%') OR (LOWER(Booktable.Genre) like  '_" + contents2 + "%') OR (LOWER(Booktable.Genre) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Booktable.Class, Booktable.Media, Booktable.title,"
                          + "Booktable.Author, Booktable.genre, Booktable.cat_number "
                          + "from Booktable "
                          
                         +"WHERE (SUBSTR(LOWER(Booktable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Booktable.Genre) like  '%" + contents2 + "%')  OR (LOWER(Booktable.Genre) like '%" + contents2 + "') OR (LOWER(Booktable.Genre) like  '" + contents2 + "%') OR (LOWER(Booktable.Genre) like  '_" + contents2 + "%') OR (LOWER(Booktable.Genre) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
                 
             }
                 
                 
                  
                 
                 else if (searchType.getValue().equals("Search DVDs") &&  searchBy.getValue().equals("Title") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Title) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Title) like '%" + contents2 + "') OR (LOWER(DVDtable.Title) like  '" + contents2 + "%') OR (LOWER(DVDtable.Title) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Title) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Title) like '%" + contents2 + "') OR (LOWER(DVDtable.Title) like  '" + contents2 + "%') OR (LOWER(DVDtable.Title) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 

           
            }  
                

                 else if (searchType.getValue().equals("Search DVDs") &&  searchBy.getValue().equals("Class") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Class) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Class) like '%" + contents2 + "') OR (LOWER(DVDtable.Class) like  '" + contents2 + "%') OR (LOWER(DVDtable.Class) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Class) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Class), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Class) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Class) like '%" + contents2 + "') OR (LOWER(DVDtable.Class) like  '" + contents2 + "%') OR (LOWER(DVDtable.Class) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Class) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
               }
            
                
                
                 else if (searchType.getValue().equals("Search DVDs") &&  searchBy.getValue().equals("Genre") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(DVDtable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Genre) like '%" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '" + contents2 + "%') OR (LOWER(DVDtable.Genre) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Genre) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select DVDtable.Class, DVDtable.Media, DVDtable.title,"
                          + "DVDtable.Remarks, DVDtable.genre, DVDtable.cat_number "
                          + "from DVDtable "
                          
                          + "WHERE (SUBSTR(LOWER(DVDtable.Genre), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '%" + contents2 + "%')  OR (LOWER(DVDtable.Genre) like '%" + contents2 + "') OR (LOWER(DVDtable.Genre) like  '" + contents2 + "%') OR (LOWER(DVDtable.Genre) like  '_" + contents2 + "%') OR (LOWER(DVDtable.Genre) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
            
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 
            }
                               
                
                
          else if (searchType.getValue().equals("Search Jigsaws") &&  searchBy.getValue().equals("Title") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select Jigsawtable.Class, Jigsawtable.Media, Jigsawtable.title,"
                          + "Jigsawtable.Remarks, Jigsawtable.genre, Jigsawtable.cat_number "
                          + "from Jigsawtable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(Jigsawtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '%" + contents2 + "%')  OR (LOWER(Jigsawtable.Title) like '%" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '" + contents2 + "%') OR (LOWER(Jigsawtable.Title) like  '_" + contents2 + "%') OR (LOWER(Jigsawtable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select Jigsawtable.Class, Jigsawtable.Media, Jigsawtable.title,"
                          + "Jigsawtable.Remarks, Jigsawtable.genre, Jigsawtable.cat_number "
                          + "from Jigsawtable "
                          
                         +"WHERE (SUBSTR(LOWER(Jigsawtable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '%" + contents2 + "%')  OR (LOWER(Jigsawtable.Title) like '%" + contents2 + "') OR (LOWER(Jigsawtable.Title) like  '" + contents2 + "%') OR (LOWER(Jigsawtable.Title) like  '_" + contents2 + "%') OR (LOWER(Jigsawtable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 

           
            }
      
             
                else if (searchType.getValue().equals("Search Magazines") &&  searchBy.getValue().equals("Title") )
               
                        {
                             try 
                          {

                            results =  Database.get_Statement().executeQuery(""
                          + "Select MagTable.Class, MagTable.Media, MagTable.title,"
                          + "MagTable.Remarks, MagTable.genre, MagTable.cat_number "
                          + "from MagTable "
                          
                          
                         +"WHERE (SUBSTR(LOWER(MagTable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(MagTable.Title) like  '%" + contents2 + "%')  OR (LOWER(MagTable.Title) like '%" + contents2 + "') OR (LOWER(MagTable.Title) like  '" + contents2 + "%') OR (LOWER(MagTable.Title) like  '_" + contents2 + "%') OR (LOWER(MagTable.Title) = '" + contents2 + "')" 
                      
                          
                          +" UNION ALL "
                          + "Select MagTable.Class, MagTable.Media, MagTable.title,"
                          + "MagTable.Remarks, MagTable.genre, MagTable.cat_number "
                          + "from MagTable "
                          
                         +"WHERE (SUBSTR(LOWER(MagTable.Title), 1, " +  len + ") = '" + contents2 + "') OR (LOWER(MagTable.Title) like  '%" + contents2 + "%')  OR (LOWER(MagTable.Title) like '%" + contents2 + "') OR (LOWER(MagTable.Title) like  '" + contents2 + "%') OR (LOWER(MagTable.Title) like  '_" + contents2 + "%') OR (LOWER(MagTable.Title) = '" + contents2 + "')" 
                          );
                      
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }   
                    

                
                
                
                
                 try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
                 

           
            }

               
                
                
               
               
                              
                if (searchType.getValue().equals("Search Entire Database") && searchBy.getValue().equals("Title") )
               
                
                
                {
                  
                    try     
                
                { 
                   
                          results =  Database.get_Statement().executeQuery(
                                  
                         
                               
                          "Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.title), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B.title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.title) like '" + contents2 + "%'" 
                        
                        
                          
                          + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.title), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.title) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.title) like '" + contents2 + "%'" 


                         
                          + " UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE SUBSTR(LOWER(D.title), 1, " +  len + ") = '" + contents2 +"'"
                          
                          

			  + "UNION ALL Select D.class,  D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.title) like '" + contents2 + "%'" 




                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE  SUBSTR(LOWER(G.title), 1, " +  len + ") = '" + contents2 +"'"
                          
                                                 
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.title) like  '%" + contents2 + "%'"                      
                         
                          
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.title) like '" + contents2 + "%'"


                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE SUBSTR(LOWER(M.title), 1, " +  len + ") = '" + contents2 +"'"
                          
                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.title) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select M.class, M.Media,  M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.title) like '" + contents2 + "%'"



                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE SUBSTR(LOWER(J.title), 1, " +  len + ") = '" + contents2 +"'"
                                               
                          
                       
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like '" + contents2 + "%'"


                          );
                
                    }
               
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                  
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
               
               
               
               
          }        
            
                
             else if (searchBy.getValue().equals("Class") && searchType.getValue().equals("Search Entire Database"))
                { 
                     
                    
                    try     
                
                {       results =  Database.get_Statement().executeQuery(
                    
                          "Select B.class, B.Media, B.Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.Class), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Class) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Class) like '" + contents2 + "%'" 
                        
                         
                                                  
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.Class), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Class) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Class) like '" + contents2 + "%'" 


                         
                          + " UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE SUBSTR(LOWER(D.Class), 1, " +  len + ") = '" + contents2 +"'"
                          
                          

			  + "UNION ALL Select D.class,  D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Class) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Class) like '" + contents2 + "%'" 




                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE  SUBSTR(LOWER(G.Class), 1, " +  len + ") = '" + contents2 +"'"
                          
                                                 
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Class) like  '%" + contents2 + "%'"                      
                         
                          
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Class) like '" + contents2 + "%'"


                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE SUBSTR(LOWER(M.Class), 1, " +  len + ") = '" + contents2 +"'"
                          
                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Class) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select M.class, M.Media,  M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Class) like '" + contents2 + "%'"



                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE SUBSTR(LOWER(J.Class), 1, " +  len + ") = '" + contents2 +"'"
                                               
                          
                       
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.title) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Class) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Class) like '" + contents2 + "%'"


                          );
                
                    } 

                    
                 
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
               
              
               
               
          }      
               
                  
            else if (searchBy.getValue().equals("Author") && searchType.getValue().equals("Search Entire Database") )
                { 
                     
                    
                    try     
                
                { results =  Database.get_Statement().executeQuery(
                    
                          "Select B.class, B.Media, B.Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.Author), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Author) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Author) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Author) like '" + contents2 + "%'" 
                        
                         
                                                  
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.Author), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Author) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Author) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Author) like '" + contents2 + "%'" 


                       

                        );
                             } 

                    
                 
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                    
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
       
           }
              
               else if (searchBy.getValue().equals("Genre") && searchType.getValue().equals("Search Entire Database") )
                {
               
                try
          
                   {

                    results =  Database.get_Statement().executeQuery(
                    
                          "Select B.class, B.Media, B.Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE SUBSTR(LOWER(B.Genre), 1, " +  len + ") = '" + contents2 +"'"
                       
                                                   
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Genre) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select B.class, B.Media, B. Title,"
                          + " B.Author, B.genre, B.cat_number "
                          + " from Booktable B "
                          + "WHERE LOWER(B.Genre) like '" + contents2 + "%'" 
                        
                         
                                                  
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE SUBSTR(LOWER(A.Genre), 1, " +  len + ") = '" + contents2 + "'"                      
                          

			  + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Genre) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select A.class, A.Media, A.Title,"
                          + " A.Author, A.genre, A.cat_number "
                          + " from Audiotable A "
                          + "WHERE LOWER(A.Genre) like '" + contents2 + "%'" 


                         
                          + " UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE SUBSTR(LOWER(D.Genre), 1, " +  len + ") = '" + contents2 +"'"
                          
                          

			  + "UNION ALL Select D.class,  D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Genre) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select D.class, D.Media, D.title,"
                          + " D.Remarks, D.genre, D.cat_number "
                          + " from DVDtable D "
                          + "WHERE LOWER(D.Genre) like '" + contents2 + "%'" 




                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE  SUBSTR(LOWER(G.Genre), 1, " +  len + ") = '" + contents2 +"'"
                          
                                                 
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Genre) like  '%" + contents2 + "%'"                      
                         
                          
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select G.class, G.Media, G.title,"
                          + " G.Remarks, G.genre, G.cat_number "
                          + " from Gametable G "
                          + "WHERE LOWER(G.Genre) like '" + contents2 + "%'"


                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE SUBSTR(LOWER(M.Genre), 1, " +  len + ") = '" + contents2 +"'"
                          
                          
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Genre) like  '%" + contents2 + "%'"                      
                          
                          
                          + "UNION ALL Select M.class, M.Media,  M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select M.class, M.Media, M.title,"
                          + " M.Remarks, M.genre, M.cat_number "
                          + " from Magtable M "
                          + "WHERE LOWER(M.Genre) like '" + contents2 + "%'"



                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE SUBSTR(LOWER(J.Genre), 1, " +  len + ") = '" + contents2 +"'"
                                               
                          
                       
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Genre) like  '%" + contents2 + "%'"                      
                          
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Genre) like '%" + contents2 + "'" 
                        
                         
                          + "UNION ALL Select J.class, J.Media, J.title,"
                          + " J.Remarks, J.genre, J.cat_number "
                          + " from Jigsawtable J "
                          + "WHERE LOWER(J.Genre) like '" + contents2 + "%'"

                    );
                            
                                
               }
                    
                 
                    
                 catch (SQLException e)
                {
                    System.out.println("Error 1" + e);
                }  
                    
              
                  
               try {
               
                 while (results.next()) 
                {
                    
                
                 Maintable.setItems(Main.loadData(results));
                 lblCount2.setTextFill(Color.YELLOW);
                 lblCount2.setText("Total number of items: " + Integer.toString(Main.counter));
                 lblCount2.setEffect(new Bloom());
                 border.setLeft(mainMenu);
                 border.setRight(null);
                 border.setCenter(null); 
                 centerMenu.getChildren().clear();
                 centerMenu.getChildren().add(Maintable);
                 centerMenu.setTranslateY(1);
                 border.setCenter(centerMenu); 
                 
                 
                } 
                  
               }   catch (SQLException e)
                {
                    System.out.println("Error 2" + e);
                } 
               
       }
      
               
          else if (Main.counter == 0) 
                 {
                     ConfirmationBox.show("No Results found", "Your search returned no matches", "Ok");
                     
                 }  
           }  
              
              });
           
    
    
    resetAcc.setOnAction(new EventHandler<ActionEvent>() {
     
        @Override
            public void handle(ActionEvent event)
            {
             
                Admin admin = new Admin();
                admin.setAdminAccount();
                
            }
        
    });
            
    
    
    update.setOnAction(new EventHandler<ActionEvent>() {
     
        @Override
            public void handle(ActionEvent event)
            {
            
            
             
                   // Display the Password dialog box
                    password.show("Authentication Required!", "\nEnter Username", "\nEnter Password", "OK");
               
            }   
            });
    
      
            
   print.setOnAction(new EventHandler<ActionEvent>() {
     
        @Override
            public void handle(ActionEvent event)
            {
              Print p = new Print();
              p.start();
 
            }
   });
     
    
    
    
    
    
    
    addItems.setOnAction(new EventHandler<ActionEvent>() {
     
        @Override
            public void handle(ActionEvent event)
            {
              Stage numStage = new Stage();
              Stage addMediaStage = new Stage();
              NoEntry numberEntry = new NoEntry();
              AddMedia addMedia = new AddMedia();
              addMedia.start(addMediaStage);
              numberEntry.start(numStage);
              
              
            }
   });    
        
        
  }    
    
    public static void create_Stage()
       {
           
           
        //hBox.getChildren().addAll(home, searchBy, search, srchBtn);   
        stage.setTitle("Library Stock Search");
        stage.setScene(scene);
        
        //stage.initStyle(StageStyle.UTILITY);
       // stage.initStyle(StageStyle.UNDECORATED);
        
        
        //stage.setResizable(false);
        
        stage.setWidth(800);
        stage.setHeight(600);
        
        //border.setRight(logoHolder);
        
        stage.getIcons().add(icon);
        
        
         // stage.setMaximized(true);
          stage.show();  
        
        
        
        DisplayShelf.init();
        
       
        
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
