
/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.*;

public class WhichCountriesExport {
	public void countryInfo(CSVParser parser, String testCountry) {
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String country = record.get("Country");
			//Check if it contains exportOfInterest
			if (country.contains(testCountry)) {
				//If so, write down the "Country" from that row
				String exports = record.get("Exports");
				String amount  = record.get("Value (dollars)");
				System.out.println(country + ":"+exports+":"+amount);
			}
		}
	}
	public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2) {
		//for each row in the CSV File
		int count = 0;
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String export = record.get("Exports");
			//Check if it contains exportOfInterest
			if (export.contains(exportItem1) && export.contains(exportItem2) ) {
				//If so, write down the "Country" from that row
				String country = record.get("Country");
				System.out.println(country);
				++count;
				}	
		}	
	}
	public int numberOfExporters(CSVParser parser, String exportItem) {
		//for each row in the CSV File
		int count = 0;
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String export = record.get("Exports");
			//Check if it contains exportOfInterest
			if (export.contains(exportItem)) {
				//If so, write down the "Country" from that row
				//String country = record.get("Country");
				//System.out.println(country);
				++count;
				}	
		}
	return count;	
	}
	public ArrayList bigExporters(CSVParser parser, String input){
	    ArrayList<String> Countries = new ArrayList<String>();
	    for (CSVRecord record: parser){
	        String thresholdString = input;
	    int thresholdLength = thresholdString.length ( );
	    //thresholdLength = 13;  
	    String exportAmount = record.get("Value (dollars)");
	    //System.out.println(exportAmount.length());
	    if ( exportAmount.length() > thresholdLength ) {
	        //System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
	      Countries.add(record.get("Country"));
	    }
	    }
	    //System.out.println(Countries);
	    return Countries;
	}    
	public String[] bigExporter(CSVParser parser, String input){
	    //ArrayList<String> Countries = new ArrayList<String>();
	    String[] Countries_t = new String[5];
	    String thresholdString = input;
	    int thresholdLength = thresholdString.length ( );
	    int index =0;
	    for (CSVRecord record: parser){
	      
	       String exportAmount = record.get("Value (dollars)");
	       //System.out.println(exportAmount.length());
	       if ( exportAmount.length() > thresholdLength ) {
	           //System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
	           //System.out.println(record.get("Country"));
	           Countries_t[index] = record.get("Country");
	           index=index+1;
	      //System.out.println(Countries[index]);
	           }
	    }
	    System.out.println(Countries_t.length);
	     //for(int i=0;i<Countries_t.length;i++){
              //  System.out.println(Countries_t[i]);
            //}
	    return Countries_t;
	}   
        public void test() {
                FileResource fr = new FileResource ();                   
                CSVParser parser = fr.getCSVParser ();
                //countryInfo  (parser,"Nauru");
               //listExportersTwoProducts  (parser,"cotton","flowers");
                //int count = numberOfExporters(parser,"cocoa");
                //System.out.println(count);
                //System.out.println(bigExporters(parser,"$999,999,999,999"));
                String[] data = new String[5];
                data=bigExporter(parser,"$999,999,999,999");
                for(int i=0;i<data.length;i++){
                System.out.println(data[i]);
              }
        }
    }

