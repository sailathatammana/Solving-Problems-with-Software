
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna) {
        String result = "";
        int start = dna.indexOf("ATG");
            if (start == -1) {
    		return "";
            }
	int stop = dna.indexOf("TAA", start+3);	
	   if (stop == -1) {
		return "";
           }
        if ((start - stop) % 3 == 0) {
            result = dna.substring(start,stop+3); 
        }
        else {
		return "";
        }   
	return result;	
    }
    
    public void testSimpleGene () {
        String dna = "ATACCGCTAA";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AGTATGTTCCACTGTGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "AGTATCTTCCACTGTGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        
        dna = "GTATGTTCCACTAAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "GTATGTTCCCTAAGC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }    
}
