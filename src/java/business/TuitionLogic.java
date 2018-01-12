/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.TuitionDAO;
import dataaccess.TuitionImpl;
import java.util.List;
import transferobjects.Tuition;
/**
 *
 * @author markg
 */
public class TuitionLogic {
    /**
     * identifying a TuitionDAO variable
     */
    private TuitionDAO tuitionDAO = null;
    /**
     * Default constructor
     */
    public TuitionLogic(){
        tuitionDAO = new TuitionImpl();
    }
    /**
     * method to get the tuitionDao list of tuitions
     * @return 
     */
    public List<Tuition> getAllTuition(){
        return tuitionDAO.getAllTuition();
    }
    /**
     * method to add a tuition using the TuitionDAO addTuition method
     * @param tuition
     * @throws ValidationException 
     */
    public void addTuition(Tuition tuition) throws ValidationException{
        tuitionDAO.addTuition(tuition);
    }
    
    
}
