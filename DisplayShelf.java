/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import static stock.search.StockSearch.width;
import static stock.search.StockSearch.height;
import javafx.scene.layout.VBox;
import static stock.search.StockSearch.border2;
import javafx.scene.effect.*;
import javafx.scene.effect.SepiaTone;
import javafx.scene.paint.Color;
import static stock.search.StockSearch.border;
import static stock.search.StockSearch.mainMenu;
import static stock.search.StockSearch.stage;
import javafx.scene.control.ProgressBar;
//import javafx.scene.layout.Border;
import javafx.stage.Stage;


/**
 *
 * @author Nishan Bakunts
 */
  
    


/**
 * A display shelf of images using the PerspectiveTransform effect.
 *
 * @see javafx.scene.effect.PerspectiveTransform
 * @see javafx.scene.effect.Reflection
 * @see javafx.scene.control.ScrollBar
 * @see javafx.scene.input.MouseEvent
 * @see javafx.scene.input.KeyEvent
 * @resource lib1.jpg
 * @resource lib2.jpg
 * @resource lib3.jpg
 * @resource lib4.jpg
 * @resource lib5.jpg
 * @resource lib6.jpg
 * @resource lib7.jpg
 * @resource lib8.jpg
 
 */
public class DisplayShelf {
    
    
    static Shelf displayShelf;
    static Group root;
    public static double width = StockSearch.width;
    public static double height = StockSearch.height;
    
    static PerspectiveImage item2;
    static PerspectiveImage library;
    static PerspectiveImage audio;
    static PerspectiveImage books;
    static PerspectiveImage dvd;
    static PerspectiveImage games;
    static PerspectiveImage jig;
    static PerspectiveImage mags;
    static PerspectiveImage users;
    static Stage progressStage;
    
    
    public static void init() {
         root = new Group();
         
         
        
        Image[] images = new Image[8];
        for (int i = 0; i < 8; i++) {
            images[i] = new Image(DisplayShelf.class.getResource("lib"+(i+1)+".jpg").toExternalForm(),false);
        }
        // create display shelf
        Image img = images[0];
        
        displayShelf = new Shelf(images);
        displayShelf.setPrefSize(width / 2, height / 2);
        root.getChildren().add(displayShelf);
        StockSearch.border.setCenter(root); 
        //StockSearch.border.setLeft(StockSearch.mainMenu);
        
       
    }   

    /**
     * A ui control which displays a browseable display shelf of images
     */
    public static class Shelf extends Region {
        
        private static final Duration DURATION = Duration.millis(500);
        private static final Interpolator INTERPOLATOR = Interpolator.EASE_BOTH;
        private static final double SPACING = 50;
        private static final double LEFT_OFFSET = -110;
        private static final double RIGHT_OFFSET = 110;
        private static final double SCALE_SMALL = 0.7;
        public static  PerspectiveImage[] items;
        public static Group centered = new Group();
        public static Group left = new Group();
        public static Group center = new Group();
        public static Group right = new Group();
        public static int centerIndex = 0;
        private ScrollBar scrollBar = new ScrollBar();
        public static Timeline timeline;
        public static boolean localChange = false;
        public static Rectangle clip = new Rectangle();

        public Shelf(final Image[] images) {
            
            // set clip
            setClip(clip);
            
            // style scroll bar color
            scrollBar.setStyle("-fx-base: black; ");
            // create items
            items = new PerspectiveImage[images.length];
            
            for (int i=0; i<images.length; i++) {
                final PerspectiveImage item =
                items[i] = new PerspectiveImage(images[i]);
                final double index = i;
                item2 = item;
                
                
               
                
                
                
              
                  item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        
                                                
                                              
                       
               
             Glow glow = new Glow();
             glow.setLevel(0.2);
               
            // center.setEffect(glow);
               
               
             localChange = true;
             scrollBar.setValue(index);
             localChange = false;
               
               
              
             shiftToCenter(item); 
                        
                        
                        
                    }
                }); 
              
                library = items[0];
                users = items[1];
                audio = items[2];
                books = items[3];
                dvd = items[4];
                games = items[5];
                mags = items[6];
                jig = items[7];
                
            }
            
            // setup scroll bar
            scrollBar.setMax(items.length-1);
            scrollBar.setVisibleAmount(1);
            scrollBar.setUnitIncrement(1);
            scrollBar.setBlockIncrement(1);
            scrollBar.valueProperty().addListener(new InvalidationListener() {
                public void invalidated(Observable ov) {
                    if(!localChange)
                        shiftToCenter(items[(int)scrollBar.getValue()]);
                }
            });
            
            center.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                
            
            if (center.getChildren().get(0) == library)            
            {  
                
                
               
               //border.setLeft(null);
                
                border.setRight(null);
                border.setCenter(null); 
                
                
               
                StockSearch.centerMenu.getChildren().clear();
                StockSearch.centerMenu.getChildren().add(StockSearch.Maintable);
                
                StockSearch.centerMenu.setTranslateY(1);
               
                
                
               
                
                
                border.setCenter(StockSearch.centerMenu);
                
                mainMenu.getChildren().addAll(StockSearch.logoHolder, StockSearch.menuHolder);
                border.setLeft(StockSearch.mainMenu);
                border.setBottom(StockSearch.catalogBox);
                StockSearch.catalogBox.setMinHeight(30);
                
                
                StockSearch.stage.setScene(StockSearch.scene);
                
                StockSearch.stage.setTitle("Entire Library Stock");
                
               
                
                
                
                
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
                        
                        
                        
             else if (center.getChildren().get(0) == audio)
                                {
                mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(StockSearch.logoHolder, StockSearch.menuHolder);                    
                                    
                border.setLeft(null);
                border.setLeft(null);
                border.setRight(null);
                border.setCenter(null);
                StockSearch.centerMenu.getChildren().clear();
                StockSearch.centerMenu.autosize();
                border.setLeft(mainMenu);
                
                
                StockSearch.centerMenu.getChildren().add(StockSearch.Audiotable);
                StockSearch.centerMenu.setTranslateY(1);
                StockSearch.centerMenu.autosize();
                border.setCenter(StockSearch.centerMenu);
                border.setBottom(StockSearch.catalogBox);
                StockSearch.stage.setTitle("Audio Stock");
                
                
                try 
                
                { ResultSet audio = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre,  cat_Number from AudioTable ");
                  
                  Audio.counter = 0;
                  StockSearch.Audiotable.setItems(Audio.loadData(audio));
                  StockSearch.lblCount2.setTextFill(Color.YELLOW);
                  StockSearch.lblCount2.setText("Total number of items: " + Integer.toString(Audio.counter));
                  StockSearch.lblCount2.setEffect(new Bloom());
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
              
            }
            else if (center.getChildren().get(0) == books)            
            {    
                StockSearch.border.setLeft(null);
                StockSearch.border.setRight(null);
                StockSearch.border.setLeft(StockSearch.bookMenu);
                StockSearch.border.setCenter(null);
                StockSearch.centerMenu.getChildren().clear();
                StockSearch.centerMenu.getChildren().add(StockSearch.Booktable);
                StockSearch.centerMenu.setTranslateY(1);
                StockSearch.centerMenu.autosize();
                border.setBottom(StockSearch.catalogBox);
                border.setCenter(StockSearch.centerMenu);
               
                Book.counter = 0;
                StockSearch.lblCount.setText("");
                border.setLeft(StockSearch.bookMenu);
                
                
                StockSearch.centerMenu.autosize();
                StockSearch.stage.setTitle("Book Stock");
                
                try 
                
                { ResultSet book = Database.get_Statement().executeQuery("select Class, Title, Author, Remarks, Genre, cat_Number from BookTable ");
                  
                 
                  StockSearch.Booktable.setItems(Book.loadData(book));
                  StockSearch.lblCount2.setTextFill(Color.YELLOW);
                  StockSearch.lblCount2.setText("Total number of items: " + Integer.toString(Book.counter));
                  StockSearch.lblCount2.setEffect(new Bloom());
                  
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
              
            }           
                        
             else if (center.getChildren().get(0) == dvd)            
            {     
                DVD.counter = 0;
                StockSearch.border.setLeft(null);
                StockSearch.border.setRight(null);
                StockSearch.border.setLeft(StockSearch.DVDMenu);
                StockSearch.border.setCenter(null);
                StockSearch.centerMenu.getChildren().clear();
                StockSearch.centerMenu.getChildren().add(StockSearch.DVDtable);
                StockSearch.centerMenu.setTranslateY(1);
                StockSearch.centerMenu.autosize();
                
                border.setCenter(StockSearch.centerMenu);
                border.setLeft(StockSearch.DVDMenu);
                border.setBottom(StockSearch.catalogBox);
                StockSearch.stage.setTitle("DVD Stock");
                
                
                try 
                
                { ResultSet dvds = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from DVDtable ");
                  
                  
                  StockSearch.DVDtable.setItems(DVD.loadData(dvds));
                  
                  StockSearch.lblCount2.setTextFill(Color.YELLOW);
                  StockSearch.lblCount2.setText("Total number of items: " + Integer.toString(DVD.counter));
                  StockSearch.lblCount2.setEffect(new Bloom());
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
              
            }                   
                        
            else if (center.getChildren().get(0) == games)            
            {     
                
                mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(StockSearch.logoHolder, StockSearch.menuHolder);
                
                Games.counter = 0;
                
                border.setRight(null);
                
                
                border.setCenter(null);
                StockSearch.centerMenu.getChildren().clear();
                StockSearch.centerMenu.getChildren().add(StockSearch.Gamestable);
                StockSearch.centerMenu.setTranslateY(1);
                StockSearch.centerMenu.autosize();
                border.setLeft(mainMenu);
                border.setCenter(StockSearch.centerMenu);
                border.setBottom(StockSearch.catalogBox);
                
                StockSearch.stage.setTitle("Games Stock");
                
                
                try 
                
                { ResultSet game = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number from Gametable ");
                  
                  
                  //stage.setFullScreen(true);
                  
                  StockSearch.Gamestable.setItems(Games.loadData(game));
                  
                  
                  
                  //stage.setFullScreen(false);
                 
                  
                  StockSearch.lblCount2.setTextFill(Color.YELLOW);
                  StockSearch.lblCount2.setText("Total number of items: " + Integer.toString(Games.counter));
                  StockSearch.lblCount2.setEffect(new Bloom());
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
              
            }              
                        
           
                        
            else if (center.getChildren().get(0) == jig)            
            {    
                mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(StockSearch.logoHolder, StockSearch.menuHolder);
                
                StockSearch.border.setLeft(null);
                StockSearch.border.setRight(null);
                StockSearch.border.setCenter(null);
                StockSearch.centerMenu.getChildren().clear();
                StockSearch.centerMenu.getChildren().add(StockSearch.Jigsawtable);
                StockSearch.centerMenu.setTranslateY(1);
                StockSearch.centerMenu.autosize();
                border.setLeft(mainMenu);
                border.setCenter(StockSearch.centerMenu);
                border.setBottom(StockSearch.catalogBox);
                StockSearch.stage.setTitle("Jigsaw Stock");
                
                
                try 
                
                { ResultSet jigsaw = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number  from Jigsawtable ");
                  
                  Jigsaw.counter = 0;
                  StockSearch.Jigsawtable.setItems(Jigsaw.loadData(jigsaw));
                  
                  StockSearch.lblCount2.setTextFill(Color.YELLOW);
                  StockSearch.lblCount2.setText("Total number of items: " + Integer.toString(Jigsaw.counter));
                  StockSearch.lblCount2.setEffect(new Bloom());
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
              
            }     
                        
                        
            else if (center.getChildren().get(0) == mags)            
            {     
                mainMenu.getChildren().clear();
          
                mainMenu.getChildren().addAll(StockSearch.logoHolder, StockSearch.menuHolder);
                border.setLeft(null);
                border.setRight(null);
                border.setCenter(null);
                StockSearch.centerMenu.getChildren().clear();
                StockSearch.centerMenu.setTranslateY(1);
                StockSearch.centerMenu.autosize();
                border.setLeft(mainMenu);
                border.setCenter(StockSearch.centerMenu);
                border.setBottom(StockSearch.catalogBox);
                
                
                StockSearch.stage.setTitle("Magazine Stock");
                
                
                try 
                
                { ResultSet mag = Database.get_Statement().executeQuery("select title, genre, remarks, cat_Number  from Magtable ");
                  
                  Mags.counter = 0;
                  StockSearch.Magstable.setItems(Mags.loadData(mag));
                  StockSearch.centerMenu.getChildren().add(StockSearch.Magstable);
                  border.setCenter(StockSearch.centerMenu);
                  StockSearch.lblCount2.setTextFill(Color.YELLOW);
                  StockSearch.lblCount2.setText("Total number of items: " + Integer.toString(Mags.counter));
                  StockSearch.lblCount2.setEffect(new Bloom());
                }
                catch (SQLException e)
                {
                    System.out.println(e);
                }   
        
              
            }              
            }                
                    
                });
            
               
            
           
            // create content
            centered.getChildren().addAll(left, right, center);
            getChildren().addAll(centered, scrollBar);
            // listen for keyboard events
            setFocusTraversable(true);
            setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent ke) {
                    if (ke.getCode() == KeyCode.LEFT) {
                        shift(1);
                        localChange = true;
                        localChange = false;
                    } else if (ke.getCode() == KeyCode.RIGHT) {
                        shift(-1);
                        localChange = true;
                        localChange = false;
                    }
                }
            });
            // update
            update();
        }

        @Override protected void layoutChildren() {
            // update clip to our size
            clip.setWidth(getWidth());
            clip.setHeight(getHeight());
            // keep centered centered
            centered.setLayoutY((getHeight() - PerspectiveImage.HEIGHT) / 2);
            centered.setLayoutX((getWidth() - PerspectiveImage.WIDTH) / 2);
            // position scroll bar at bottom
            scrollBar.setLayoutX(10);
            scrollBar.setLayoutY(getHeight()-25);
            scrollBar.resize(getWidth()-20,15);
            
        }

        public static void update() {
            // move items to new homes in groups
            left.getChildren().clear();
            center.getChildren().clear();
            right.getChildren().clear();
            for (int i = 0; i < centerIndex; i++) {
                left.getChildren().add(items[i]);
            }
            center.getChildren().add(items[centerIndex]);
            for (int i = items.length - 1; i > centerIndex; i--) {
                right.getChildren().add(items[i]);
            }
            // stop old timeline if there is one running
            if (timeline!=null) timeline.stop();
            // create timeline to animate to new positions
            timeline = new Timeline();
            // add keyframes for left items
            final ObservableList<KeyFrame> keyFrames = timeline.getKeyFrames();
            for (int i = 0; i < left.getChildren().size(); i++) {
                final PerspectiveImage it = items[i];
                double newX = -left.getChildren().size() *
                        SPACING + SPACING * i + LEFT_OFFSET;
                keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                    new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                    new KeyValue(it.angle, 45.0, INTERPOLATOR)));
            }
            // add keyframe for center item
            final PerspectiveImage centerItem = items[centerIndex];
            keyFrames.add(new KeyFrame(DURATION,
                    new KeyValue(centerItem.translateXProperty(), 0, INTERPOLATOR),
                    new KeyValue(centerItem.scaleXProperty(), 1.0, INTERPOLATOR),
                    new KeyValue(centerItem.scaleYProperty(), 1.0, INTERPOLATOR),
                    new KeyValue(centerItem.angle, 90.0, INTERPOLATOR)));
            // add keyframes for right items
            for (int i = 0; i < right.getChildren().size(); i++) {
                final PerspectiveImage it = items[items.length - i - 1];
                final double newX = right.getChildren().size() *
                        SPACING - SPACING * i + RIGHT_OFFSET;
                keyFrames.add(new KeyFrame(DURATION,
                        new KeyValue(it.translateXProperty(), newX, INTERPOLATOR),
                        new KeyValue(it.scaleXProperty(), SCALE_SMALL, INTERPOLATOR),
                        new KeyValue(it.scaleYProperty(), SCALE_SMALL, INTERPOLATOR),
                        new KeyValue(it.angle, 135.0, INTERPOLATOR)));
            }
            // play animation
            
            
              timeline.play();
              
            
            
        }

        public static void shiftToCenter(PerspectiveImage item) {
            for (int i = 0; i < left.getChildren().size(); i++) { //
                if (left.getChildren().get(i) == item) {
                    int shiftAmount = left.getChildren().size() - i;
                    shift(shiftAmount);
                    return;
                }
            }
            if (center.getChildren().get(0) == item) {
                return;
            }
            for (int i = 0; i < right.getChildren().size(); i++) { //
                if (right.getChildren().get(i) == item) {
                    int shiftAmount = -(right.getChildren().size() - i);
                    shift(shiftAmount);
                    return;
                }
            }
        }

        public static void shift(int shiftAmount) {
            if (centerIndex <= 0 && shiftAmount > 0) return;
            if (centerIndex >= items.length - 1 && shiftAmount < 0) return;
            centerIndex -= shiftAmount;
           
            
              update();
              
           
            
        }
    }

    /**
     * A Node that displays a image with some 2.5D perspective rotation around the Y axis.
     */
    public static class PerspectiveImage extends Parent {
        private static final double REFLECTION_SIZE = 0.25;
        private static final double WIDTH = 200;
        private static final double HEIGHT = WIDTH + (WIDTH*REFLECTION_SIZE);
        private static final double RADIUS_H = WIDTH / 2;
        private static final double BACK = WIDTH / 10;
        private PerspectiveTransform transform = new PerspectiveTransform();
        /** Angle Property */
        private final DoubleProperty angle = new SimpleDoubleProperty(45) {
            @Override protected void invalidated() {
                // when angle changes calculate new transform
                double lx = (RADIUS_H - Math.sin(Math.toRadians(angle.get())) * RADIUS_H - 1);
                double rx = (RADIUS_H + Math.sin(Math.toRadians(angle.get())) * RADIUS_H + 1);
                double uly = (-Math.cos(Math.toRadians(angle.get())) * BACK);
                double ury = -uly;
                transform.setUlx(lx);
                transform.setUly(uly);
                transform.setUrx(rx);
                transform.setUry(ury);
                transform.setLrx(rx);
                transform.setLry(HEIGHT + uly);
                transform.setLlx(lx);
                transform.setLly(HEIGHT + ury);
            }
        };
        public final double getAngle() { return angle.getValue(); }
        public final void setAngle(double value) { angle.setValue(value); }
        public final DoubleProperty angleModel() { return angle; }

        public PerspectiveImage(Image image) {
            ImageView imageView = new ImageView(image);
            imageView.setEffect(ReflectionBuilder.create().fraction(REFLECTION_SIZE).build());
            setEffect(transform);
            getChildren().addAll(imageView);
        }
    }

    
    
    public static void endCycle()
    {
        
        Shelf.clip.setClip(null);
        
    }
  

    /**
     * The main() method is ignored in correctly deployed JavaFX 
     * application. main() serves only as fallback in case the 
     * application can not be launched through deployment artifacts,
     * e.g., in IDEs with limited FX support. NetBeans ignores main().
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
    

