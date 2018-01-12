/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Tuition;

/**
 *
 * @author markg
 */
public interface TuitionDAO {
    
    /**
     * method to get all tuitions
     * @return List<Tuition>
     */
    List<Tuition> getAllTuition();
     /**
     * method to add a new Tuition
     * @param tuition 
     */
    void addTuition(Tuition tuition);
    
}
