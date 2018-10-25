/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtestapp;

import com.opencsv.CSVReaderHeaderAware;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author andyr
 */
public class CsvTestApp {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    
    
    /*
    PROJECT REQUIREMENTS
    The main method will
    creates a new ArrayList of GeographicRegion objects
    calls a static method in the CsvTestApp class that you write, which adds all 264 or so GeographicRegion objects 
        (from the file API_AG.LND.TOTL.K2_DS2_en_csv_v2_10140368.csv referred to above) to the list using just the name of a 
        geographic region and its area as of 2017. This is data you need to pull from the CSV file. This static method MUST use 
        use a particular method from opencsv to read the CSV data (see REQUIRED METHOD below)
    creates a reference to a new Chooser of GeographicObject, using the constructor for Chooser that is in Bloch's code
    creates a for loop that iterates 10 times such that each iteration calls System.out.println with an argument that is the 
        return value of the choose() method (from the Chooser class) invoked on the reference variable created in the previous 
        step, to print out lines like the following, by invoking an overriden toString() method in the GeographicRegion class
    name: East Asia & Pacific (excluding high income); area: 1.5913501E7 sq. km
    name: IDA only; area: 2.0381681E7 sq. km
    name: Chile; area: 743532.0 sq. km
    name: Malta; area: 320.0 sq. km
    name: Pre-demographic dividend; area: 2.0165531E7 sq. km
    name: OECD members; area: 3.4403746E7 sq. km
    name: Sub-Saharan Africa; area: 2.3618361E7 sq. km
    name: France; area: 547557.0 sq. km
    name: Pre-demographic dividend; area: 2.0165531E7 sq. km
    name: Madagascar; area: 581800.0 sq. km
    
    Advice:
    Read to end of file
    It is allowed to for this project to hard code a loop for the amount of data in the file
    get.country code() file to find the column

    */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<GeographicRegion> regions = new ArrayList<>();
        addToList(regions);
        
    }
    
    //This method will grab the name and area as of 2017, put that information into a GeographicRegion object
    //and add it to the list "regions"
    private static void addToList(ArrayList<GeographicRegion> regionList) throws IOException{
        //create one CSV readers outside of the loop
        //inside of the loop invoke the readmap method on the reader
        FileReader fileReader = new FileReader("data.csv");
        CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(fileReader);
        Map<String, String> mapData;
        
        while ((mapData = csvReader.readMap()) != null){
          
            String name = mapData.get("Country Name");
            String area = mapData.get("2017");
           
            
            if(name.equals("")){
                name = "NAME NOT FOUND";
            }
            if(area.equals("")){
                area = "0";
            }
            
            regionList.add(new GeographicRegion(name, Double.parseDouble(area)));
            
            for (GeographicRegion region : regionList){
                System.out.println(region.toString());
            }
        }
        
       
    }
    
}
