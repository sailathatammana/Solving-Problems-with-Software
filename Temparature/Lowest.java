
/**
 * Write a description of Lowest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Lowest {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for (CSVRecord currentRow : parser) {
        if (smallestSoFar == null) {
               smallestSoFar = currentRow; 
        }    
        else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double SmallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
            if (currentTemp < SmallestTemp) {
                //If so update largestSoFar to currentRow
        smallestSoFar = currentRow;
            }
        }    
    }    
    return smallestSoFar;
}
    public void testColdestHourInFile() {
    FileResource fr = new FileResource();
    CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
    System.out.println("coldest temp was " + smallest.get("TemperatureF") +
                                         "at" + smallest.get("TimeEDT"));
    }
    public String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord codestsofar = null;
        String fileName = "";
        File temp = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            System.out.println(f.getName());
             System.out.println(Double.parseDouble(current.get("TemperatureF")));
  
            if(codestsofar == null){
                codestsofar = current;
                temp = f; 
            }
             else {
            double currentTemp = Double.parseDouble(current.get("TemperatureF"));
            double SmallestTemp = Double.parseDouble(codestsofar.get("TemperatureF"));
           // System.out.println(currentTemp);
            //System.out.println(SmallestTemp);
            if (currentTemp < SmallestTemp) {
                codestsofar = current;
                temp = f;    
                //System.out.println(temp.getName());
                //fileName = f.getName();
                //System.out.println(fileName);
            }   
            /*else {
             codestsofar = codestsofar;
                temp = f;    
                //System.out.println(temp.getName());
            }    */
             }
        }
        fileName = temp.getName();
        System.out.println(fileName);
        return fileName;
  }
    public void testFileWithColdestTemperature() {
        String filenameOfColdestDay = fileWithColdestTemperature();
        System.out.println(" File with Coldest Temperature = " + filenameOfColdestDay);   
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord smallestSoFar = null;
        for (CSVRecord currentRow : parser) {
            String temp=currentRow.get("Humidity");
            if(temp.equals("N/A"))// it should skip iteration
                {
                    continue;
                }
        if (smallestSoFar == null) {
               smallestSoFar = currentRow; 
        }    
        else {
            double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
            double SmallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
            if (currentTemp < SmallestTemp) {
                //If so update largestSoFar to currentRow
        smallestSoFar = currentRow;
            }
        }    
    }    
    return smallestSoFar;
    }
    public void testLowestHumidityInFile() {
    FileResource fr = new FileResource();
    CSVRecord smallest = lowestHumidityInFile(fr.getCSVParser());
    System.out.println("Lowest Humidity was " + smallest.get("Humidity") +
                                         "at" + smallest.get("DateUTC"));
    }
    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord codestsofar = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            String temp = current.get("Humidity");
            if(temp.equals("N/A"))// it should skip iteration
                {
                    continue;
                }
            if(codestsofar == null){
                codestsofar = current; 
            }
             else {
            double currentTemp = Double.parseDouble(current.get("Humidity"));
            double SmallestTemp = Double.parseDouble(codestsofar.get("Humidity"));
           // System.out.println(currentTemp);
            //System.out.println(SmallestTemp);
            if (currentTemp < SmallestTemp) {
                codestsofar = current;  
                //System.out.println(temp.getName());
                //fileName = f.getName();
                //System.out.println(fileName);
            }   
            /*else {
             codestsofar = codestsofar;
                temp = f;    
                //System.out.println(temp.getName());
            }    */
             }
        }
        
        return codestsofar;
  }
  public void testLowestHumidityInManyFiles() {
        CSVRecord smallest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + smallest.get("Humidity") +
                                         "at" + smallest.get("DateUTC"));   
    }
    public double averageTemperatureInFile(CSVParser parser) {
    double sum = 0;
    double average = 0;
    int count = 1;
    for (CSVRecord currentRow:parser) {
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        sum += currentTemp;
        average = sum/count;
        count++;
    }
    return average;
    }
    public void testaverageTemperatureInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    double average = averageTemperatureInFile(parser);;
     System.out.println("Average temperature in file is" + average);
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
    double sum = 0;
    double average = 0;
    int count = 1;
    for (CSVRecord currentRow: parser) {
        double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
        double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
        if(currentHumidity >= 80    ) {
            sum += currentTemp;
            average = sum/count;
            count++;
        }
    }
return average;
}

public void testAverageTemperatureWithHighHumidityInFile() {
    FileResource fr = new FileResource();
    CSVParser parser = fr.getCSVParser();
    double average = averageTemperatureWithHighHumidityInFile(parser,80);
    if(average == 0)System.out.println("No temperatures with that humidity");
    else System.out.println("Average temperature when high Humidity is" +average);
}
public CSVRecord ColdestInManyDays() {
		CSVRecord smallestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		// iterate over files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			// use method to get largest in file.
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			if (smallestSoFar == null) {
                                smallestSoFar = currentRow; 
                        }    
                        else {
                            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                            double SmallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
                            if (currentTemp < SmallestTemp) {
                                //If so update largestSoFar to currentRow
                                smallestSoFar = currentRow;
                            }
                            }  
		}
		//The largestSoFar is the answer
		return smallestSoFar;
	}
	
	public void testColdestInManyDays () {
		CSVRecord smallest = ColdestInManyDays();
		System.out.println("Coldest temperature was " + smallest.get("TemperatureF") +
				   " at " + smallest.get("DateUTC"));
	}
}