/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.search;

import javax.swing.*;
import java.io.File;

/**
 *
 * @author nishanbakunts
 */
public class FileChooser {
    
    
       
    
    public File getFile()
            
            
    {   
        
        
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        
        File file = null;
        
        if (result == JFileChooser.APPROVE_OPTION)
         
        {
            file = fc.getSelectedFile();
        }  
           return file; 
        
             
        
      
       
    
    }
    
    
    
}
