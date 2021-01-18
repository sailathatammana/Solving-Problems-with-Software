
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String stopCodon) {
        String result = "";
        int start = dna.indexOf(startCodon);
            if (start == -1) {
            return "";
            }
    int stop = dna.indexOf(stopCodon,start+3); 
       if (stop == -1) {
        return "";
           }
        if ((stop - start) % 3 == 0) {
            result = dna.substring(start,stop+3); 
        }
        else {
        return "";
        }   
        if (startCodon == startCodon.toUpperCase()) {
            result = result.toLowerCase();
        } 
        else if (startCodon == startCodon.toLowerCase()) {
            result = result.toUpperCase();
        }
    return result;  
    }
    
    public void testSimpleGene () {
        String dna = "gtatgttccactaagc";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna,"atg","taa");
        System.out.println("Gene is " + gene);
        
        dna = "GTATGTTCCACTAAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna,"ATG","TAA");
        System.out.println("Gene is " + gene);       
    }    
}
