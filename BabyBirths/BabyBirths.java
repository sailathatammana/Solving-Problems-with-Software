
/**
 * Write a description of BabyBirths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
    }
    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource();
        totalBirths(fr);
     }
     public int getRank( String name, String gender, FileResource fr){
         int temporaryRank = 0;
         int rank = 0;
//FileResource fra = new FileResource();
         for (CSVRecord rec : fr.getCSVParser(false)) {
             if(rec.get(1).equals(gender)) {
             temporaryRank += 1;
             if(rec.get(0).equals(name)) {
                 rank = temporaryRank;
                 break;
             }    
             }   
         }   
     if(rank == 0){
         rank = -1;
        }    
     return rank;    
     }   
     
     public void testGetRank() {
    FileResource fr = new FileResource();
    System.out.println(getRank("Frank","M", fr ));
     }
     
     public String getName(int year, int rank, String gender){
         int count = 0;
         String temporaryName = "";
         String name = "";
         FileResource fr = new FileResource();
         for (CSVRecord rec : fr.getCSVParser(false)) {
             if(rec.get(1).equals(gender)) {
             count += 1;
             if(count == rank) {
                 name = rec.get(0);
                 break;
             }    
             }   
         }   
     return name;    
     }    
     
     public void testGetName() {
    System.out.println(getName(1982 ,450,"M"));
     }
     
     public void whatIsNameInYear(String name, int year, int newYear,
    String gender) {
        FileResource fr = new FileResource(); 
        // Defining variables
        String newname = ""; // inital string
        int rank = getRank( name, gender,fr);
        if (rank != -1) { // rank of baby exists
            newname = getName(newYear, rank, gender);
            if (newname.equals("NO NAME")) {
                newname = "no one";
            }
        }
        else if (rank == -1) {
            newname = "no one";
        }
        if (gender.equals("M")) { // male baby
        System.out.println(name + " born in " + year + " would be " + newname
        + " if he was born in " + newYear);
        }
        else if (gender.equals("F")) { // female baby
        System.out.println(name + " born in " + year + " would be " + newname
        + " if she was born in " + newYear);
        }
    }
     
     public void testWhatIsNameInYear () {
            DirectoryResource dr = new DirectoryResource();
            //FileResource fr = new FileResource();
        whatIsNameInYear("Owen",1974, 2014,"M");
     }
     public int yearOfHighestRank (String name, String gender){ 
            int year = 0; 
            DirectoryResource dr = new DirectoryResource(); 
            int startRank = 0; 
            for (File f : dr.selectedFiles()) { 
            FileResource fr = new FileResource(f); 
            String fName = f.getName(); 
            String find = "yob"; 
            int startPos = fName.indexOf(find); 
            int currYear = Integer.parseInt(fName.substring(startPos + 3, startPos + 7));
            int currRank = getRank(name, gender , fr); 
            if (year == 0){  
                year = currYear; 
                startRank = currRank; 
            } 
            System.out.println(" Current Rank is : "+currRank+" in Year : "+currYear); 
                if (currRank < startRank) { 
                    year = currYear; 
                    startRank = currRank; 
                } 
            if (currRank == -1) { 
            year = currRank; 
            } 
        } 
        return year; 
        } 
     public void testyearOfHighestRank () {
        int year = yearOfHighestRank("Mich","M");
        System.out.println("The year with the highest ranking is "+ year);
     }
     public double getAverageRank (String name , String gender){
         double average = 0.0 ; 
         double rank = 0.0 ; 
         int counter = 1 ; 
         int year = 0 ; 
         String namem = null ;
         DirectoryResource dr = new DirectoryResource() ;
         for(File f : dr.selectedFiles()){
           FileResource fr = new FileResource(f) ;
           //counter++;
           //System.out.println("Counter is " + counter);
           //namem=f.getName();
           //System.out.println("name of file  is " + namem );
           /*int index =name.indexOf("yob",0);
           namem=name.substring(index+3,index+7);
           System.out.println("name of year is " + namem);
           year = Integer.parseInt(namem);*/
          //for( int i = 0; i < 2; i++){
           int currRank = getRank( name, gender,fr); 
           System.out.println("current rank is " + currRank );
           rank = currRank + rank ; 
           average = rank/counter;
           counter++;
           System.out.println("rank final is " + rank );
           System.out.println(average);
          }
        //}
        return average ;
     } 
     public void testGetAverageRank () {
        double rank = getAverageRank("Robert","M");
        System.out.println("Average rank is "+ rank);
     }
     public int getTotalBirthsRankedHigher(int year,String name,String gender){
         FileResource fr = new FileResource();
         int indexRank = getRank(name,gender,fr);
        System.out.println(indexRank);
        int sumBirth=0;
        //FileResource f= new FileResource();
        CSVParser parser = fr.getCSVParser(false);    
        
        if (indexRank==-1){
            return -1;
        }
        else {
        for(CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                //int currRank=getRank(record.get(0),gender);
                //System.out.println(currRank);
                if(record.get(0).equals(name)){
                    //sumBirth+=Integer.parseInt(record.get(2));
                    break;
                }
                else {
                   sumBirth+=Integer.parseInt(record.get(2));
                }    
            }
        }
        }
        //System.out.println("A");
        return sumBirth;
    }
     public void testgetTotalBirthsRankedHigher(){
         int totalRank = getTotalBirthsRankedHigher(1990,"Drew","M");
        System.out.println("Total rank is "+ totalRank);
     }    
     public void printNames () {
        int totalBirths = 0; 
        int totalBoys = 0;
        int totalGirls = 0;
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
             String num = rec.get(1);
            if (rec.get(1).equals("M")) {
                totalBoys++;
            }
            else {
		totalGirls++;
	    }
	}
                System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
        }
    }


