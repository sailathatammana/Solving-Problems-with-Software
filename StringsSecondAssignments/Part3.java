
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public int countGenes(String dna){
        int startFrom =0; //Store the starting var
        int count = 0; //start the occurances so far
        while(true){
           String currGene= findGene(dna,startFrom);
            if(currGene.isEmpty())
            { ////////////////////
                break;//break;
              ///////////////////
            }
            else
            {
                ++count;
                
                startFrom = dna.indexOf(currGene , startFrom) + currGene.length();
            }  
        } 
        return count;
    }    
    
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
    
    
    public void testCountGenes(){
    testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
    testOn("");
    testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }    
    
    public void testOn(String dna){
     System.out.println("Testing countGenes on " + dna);
     countGenes(dna);
     System.out.println(countGenes(dna));
    }  
}
