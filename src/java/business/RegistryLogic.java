/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.RegisteryDAO;
import dataaccess.RegisteryImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Registry;
/**
 *
 * @author markg
 */
public class RegistryLogic {
    
    /**
    * identifying the term max length
    */    
    private static final int TERM_MAX_LENGTH = 1;
    /**
     * identifying the course code max length
     */
    private static final int COURSE_CODE_MAX_LENGTH = 45;
    /**
     * making use of a RegistryDao Class
     */
    private RegisteryDAO registeryDAO = null;
    /**
     * Default constructor
     */
    public RegistryLogic(){
        registeryDAO = new RegisteryImpl();
    }
    /**
     * method to get the RgistryDAO's list of all registrys 
     * @return List<Registry>
     */
    public List<Registry> getAllRegistrys(){
        return registeryDAO.getAllRegistries();
    }
    /**
     * method to add a registry using RegistryDAO's addRegistry method
     * @param registry 
     */
    public void addRegistry(Registry registry){
        try {
            /**
             * validating Registry that is being added
             */
            validateRegistry(registry);
        } catch (ValidationException ex) {
            Logger.getLogger(RegistryLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        registeryDAO.addRegistry(registry);
    }
    /**
     * method to validate the new registry being added by checking the corse code and term length
     * @param registry
     * @throws ValidationException 
     */
    private void validateRegistry(Registry registry) throws ValidationException{
        validateString(registry.getCourseCode(), "Course Code", COURSE_CODE_MAX_LENGTH, false);
        validateString(registry.getTerm(), "Term", TERM_MAX_LENGTH, false);
    }
    /**
     * method to validate a string 
     * @param value
     * @param fieldName
     * @param maxLength
     * @param isNullAllowed
     * @throws ValidationException 
     */
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) throws ValidationException{
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new ValidationException(String.format("%s cannot be null", fieldName));
        } else if (value.isEmpty()) {
            throw new ValidationException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new ValidationException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }
}
