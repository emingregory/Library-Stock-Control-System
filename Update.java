package stock.search;

import java.awt.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.*;
import javafx.scene.control.ProgressIndicator;
import java.awt.Toolkit;
import java.awt.Dimension;
/*
*@resource loading.gif
*/

public class Update extends JFrame


{
    static JLabel lbl;
    static ProgressIndicator pi = new ProgressIndicator();
    static Image img = new Image(DisplayShelf.class.getResource("loading"+".gif").toExternalForm(),false);
    static ImageView iView = new ImageView(img);
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    
    
    
   /* public static void begin()
    {
        new Update();
    }
    */
    
    public Update(String label)
            {
               int x = d.width / 3 + 100 ; //- this.getWidth();
               int y = (d.height / 3) - this.getHeight(); 
               this.setTitle("Loading");
               lbl = new JLabel();
               lbl.setForeground(Color.red);
               lbl.setText(label);
               JPanel panel1 = new  JPanel();
               ImageIcon img1 = new ImageIcon(DisplayShelf.class.getResource("loading"+".gif")); 
               //panel1.setLayout(LayoutManager);
               
               panel1.add(new JLabel(img1));
               
               
               panel1.add(lbl);
               //panel1.setBackground(Color.red);
               panel1.setBackground(Color.WHITE);
               this.add(panel1);
               this.setSize(250,175);
               this.setLocation(x, y);
               
               this.setResizable(false);
               //this.setUndecorated(true);
               this.setVisible(true);
               this.setDefaultCloseOperation(JFrame.NORMAL);
               
               
            }
    
    
    public void close()
    {
        
        this.setVisible(false);
        this.dispose();
        
        
    }
    
}
