
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        
    public void printAllGenes(String dna){
            int startIndex = 0;
            while (true){
                String currentGene = findGene(dna, startIndex);
                if(currentGene.isEmpty()){
                    break;
                }   
                System.out.println(currentGene);
                startIndex = dna.indexOf(currentGene , startIndex) + currentGene.length();
            }    
    }   
        
    public void testFindStopCodon(){
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxxx";
        int dex = findStopCodon(dna,0,"TAA");
        if (dex != 9) System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if (dex !=21) System.out.println("error on 21");
        dex = findStopCodon(dna,1,"TAA");
        if (dex != -1) System.out.println("error on 26");
        dex = findStopCodon(dna,1,"TAG");
        if (dex != -1) System.out.println("error on 26 TAG");
        System.out.println("Tests finished");
    } 
    /*public void testFindGene(){
        String dna = "TGCATCGGCC";
        System.out.println(" DNA Starnd is " + dna);
        String gene = findGene(dna);
        System.out.println(" Gene is " + gene);
        
        dna = "TGCATGGGCCGGTAA";
        System.out.println(" DNA Starnd is " + dna);
        gene = findGene(dna);
        System.out.println(" Gene is " + gene);
    
        dna = "TGCATGGGCCGGTAAGGCCAATGA";
        System.out.println(" DNA Starnd is " + dna);
        gene = findGene(dna);
        System.out.println(" Gene is " + gene);   
        
        dna = "TGCATGGGCCGTA";
        System.out.println(" DNA Starnd is " + dna);
        gene = findGene(dna);
        System.out.println(" Gene is " + gene);
    
    }   */ 
    public void test(){
    testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
    testOn("");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }    
    
    public void testOn(String dna){
     System.out.println("Testing printAllGenes on " + dna);
     printAllGenes(dna);
    }    
}
