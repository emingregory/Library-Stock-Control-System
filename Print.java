




package stock.search;

import java.awt.print.*;
import java.awt.print.PrinterJob;
import java.awt.PrintJob;
import java.awt.Graphics;

/**
 *
 * @author Bakunts2115
 */

public  class Print implements Printable

{
    
    @Override
    public int print(Graphics g, PageFormat p, int x)
    {
       return x; 
    }
    
    public void start()
    {
        
        PrinterJob job;
        job = PrinterJob.getPrinterJob();
        job.setPrintable(new Print());
        
        boolean doPrint = job.printDialog();
        
        if (doPrint)
        {
            try
            {
                job.print();
               // job.
                      
           }
            catch (PrinterException e)
            {
                
            }
            
         
        }
         
    }
    
    
    
}
