/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.ClassRepDAO;
import dataaccess.ClassRepImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.ClassRep;
/**
 *
 * @author markg
 */
public class ClassRepLogic {
    
    private static final int TERM_MAX_LENGTH = 1;
    private static final int COURSE_CODE_MAX_LENGTH = 45;
    
    private ClassRepDAO classRepDAO = null;
    
    public ClassRepLogic(){
        classRepDAO = new ClassRepImpl();
    }
    
    public List<ClassRep> getAllClassReps(){
        return classRepDAO.getAllClassReps();
    }
    
    public void addClassRep(ClassRep classRep){
        try {
            validateClassRep(classRep);
        } catch (ValidationException ex) {
            Logger.getLogger(ClassRepLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        classRepDAO.addClassRep(classRep);
    }
    
     private void validateClassRep(ClassRep classRep) throws ValidationException{
        validateString(classRep.getCourseCode(), "Course Code", COURSE_CODE_MAX_LENGTH, false);
        validateString(classRep.getTerm(), "Term", TERM_MAX_LENGTH, false);
    }
    
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
