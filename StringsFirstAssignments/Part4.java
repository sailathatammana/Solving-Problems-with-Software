
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.Object;
import edu.duke.*;

public class Part4 {
    public static void main(String args[]){
      URLResource ur = new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
      for (String s : ur.words()) {
      if(s.toLowerCase().indexOf("youtube.com") != -1){
          
          int startquote = s.indexOf("\"");
          int endquote = s.lastIndexOf("\"",startquote+1);
          System.out.println(s.substring(startquote,endquote));
          
          
        }
     
        }
      System.out.println("end");
    }

}