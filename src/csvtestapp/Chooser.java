/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvtestapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author andyr
 * @param <T>
 */
//List-based Chooser - typesafe, taken from Bloch28
public class Chooser<T> {
    private final List<T> choiceList;
    
    public Chooser(Collection<T> choices){
        choiceList = new ArrayList<>(choices);
    }
    
    public T choose(){
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
