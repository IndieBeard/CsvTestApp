/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtestapp;

import com.opencsv.CSVReaderHeaderAware;
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
    
    public static void main(String[] args) throws IOException {
        ArrayList<GeographicRegion> regions = new ArrayList<>();
        
        
        addToList(regions);
        Chooser chooser = new Chooser<>(regions);
        
        for(int i = 0; i < 10; i++){
            GeographicRegion choice = (GeographicRegion) chooser.choose();
            System.out.println(choice.toString());
        }
    }
    
    //This method will grab the name and area as of 2017, put that information into a GeographicRegion object
    //and add it to the list "regions"
    private static void addToList(ArrayList<GeographicRegion> regionList) throws IOException{

        FileReader fileReader = new FileReader("data.csv");
        CSVReaderHeaderAware csvReader = new CSVReaderHeaderAware(fileReader);
        Map<String, String> mapData;
        
        while ((mapData = csvReader.readMap()) != null){
          
            String name = mapData.get("Country Name");
            String area = mapData.get("2017");
           
            //Check to make sure there is data for each value, if not, then put something in.
            if(name.equals("")){
                name = "NAME NOT FOUND";
            }
            if(area.equals("")){
                area = "0";
            }
            
            regionList.add(new GeographicRegion(name, Double.parseDouble(area)));
        }
        
       
    }
    
}
