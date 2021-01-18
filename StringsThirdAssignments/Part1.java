
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 import edu.duke.*;
 import edu.duke.StorageResource;
 import java.io.File;
 
public class Part1 {
    public int findStopCodon(String dna,int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon,startIndex + 3);
        while (currIndex != -1){
         if ((currIndex - startIndex) % 3 ==0){
             return currIndex;
            }  
         else {
              currIndex = dna.indexOf(stopCodon, currIndex + 1);
         }
        }    
     return -1;  
    }
    
    public String findGene(String dna , int where){
        int startIndex = dna.indexOf("ATG",where);
        if(startIndex == -1){
          return "";  
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if(taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)){
           minIndex = tagIndex;
        } 
        else {
           minIndex = taaIndex; 
        }    
        if(minIndex == -1 || (tgaIndex != -1 && tgaIndex < minIndex)){
           minIndex = tgaIndex;
        }    
        if (minIndex == -1){
            return "";
        }    
        return dna.substring(startIndex,minIndex + 3);
    }    
        
    public StorageResource  getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
            int startIndex = 0;
            while (true){
                String currentGene = findGene(dna, startIndex);
                if(currentGene.isEmpty()){
                    break;
                }
                geneList.add(currentGene);
                startIndex = dna.indexOf(currentGene , startIndex) + currentGene.length();
            }  
        return geneList;    
    }       
    
    public void testOn(String dna){
     System.out.println("Testing printAllGenes on " + dna);
     StorageResource genes = getAllGenes(dna);
     for (String g: genes.data()) {
         System.out.println(g);
        }   
    } 
    
    public void test(){
    testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
    testOn("");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
    
    public void processGene(){
    String g = "AAGGGCC";
    double ratio = cg_ratio(g);
}

public double cg_ratio(String myGene){
    double ratio = 0.0;
    int cgCount = 0;
    int index = 0;
    int len = myGene.length();
    while(index < len){
        char oneCharacter = myGene.charAt(index);
        if(oneCharacter == 'C' || oneCharacter == 'G' ||
            oneCharacter == 'c' || oneCharacter == 'g'){
            cgCount++;
        }
        index = index + 1;
    }
    ratio = ((double) cgCount) / len;
    System.out.println(ratio);
    return ratio;
}
public void processGenes(StorageResource geneList){ 
        int maxGeneLength = 0;
        int numHighRatio = 0;
        int numString = 0;
        int numStringMoreSixty = 0;
        
        for(String gene:geneList.data()){
            if(gene.length()>9){
               System.out.println("Long gene is " + gene);
               numString = numString + 1;
            }  
            if(cg_ratio(gene) > 0.35){
                System.out.println("High ratio gene is "+ gene);
                numHighRatio = numHighRatio +1;
            }
            if(gene.length()>60){
                numStringMoreSixty = numStringMoreSixty +1;
            }
            int currentGeneLength = gene.length();
            if(currentGeneLength > maxGeneLength ){
                maxGeneLength = currentGeneLength;
            }
    }

         System.out.println("Max Gene Length is " + maxGeneLength);
         System.out.println("Number of Strings more than 9 characters is " + numString);
         System.out.println("Number of String with High Ratio is " + numHighRatio);
         System.out.println("The number of the genes whose length is more than 60 is " + numStringMoreSixty);
}
  public int numberOfCTG(String dna){
     int indexCTG = dna.indexOf("CTG");
     int numberOfCTG = 0;
     while(true){
      if(indexCTG == -1){
          break;
        }  
       numberOfCTG =  numberOfCTG +1;
       indexCTG = indexCTG + 3;
       indexCTG = dna.indexOf("CTG", indexCTG);
        
     }
     return numberOfCTG;   
    }

    public void testProcessGene(){
      /* FileResource fr = new FileResource("E:/brca1line.fa");
       String dna = fr.asString().toUpperCase();
       StorageResource sr= getAllGenes(dna);
       processGenes(sr);*/
       URLResource ur = new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa"); 
       String contents = ur.asString();
       StorageResource sr =  getAllGenes(contents);
       processGenes(sr);
       int numberCTG = numberOfCTG(contents);
      System.out.println("The number of CODON CTG is " + numberCTG);
       sr =  getAllGenes("TGGCAGGTGAAGCAAGTCTCAGGGGCCAGCCATGGGACAAGGAACCTAGGACTGGCCTCTGCTG"); //ATGGGACAAGGAACCTAG
       System.out.println(sr); 
       
      
    }
}
