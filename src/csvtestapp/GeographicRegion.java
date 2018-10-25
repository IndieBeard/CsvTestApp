/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtestapp;

/**
 *
 * @author andyr
 */
public class GeographicRegion {
    
    private final String name;
    
    private final Double area;
    
    public GeographicRegion(String _name, Double _area){
        name = _name;
        area = _area;
    }
    
    @Override
    public String toString(){
        //Will output name and area in the format for the project
        String output = ("Name = " + name + "Area = " + area);
        return output;
    }
    
}
