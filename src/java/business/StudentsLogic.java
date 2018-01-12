/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.StudentDAO;
import dataaccess.StudentImpl;
import java.util.List;
import transferobjects.Student;

/**
 *
 * @author markg
 */
public class StudentsLogic {
    
    /**
     * identifying the student name max length
     */
    private static final int STUDENT_NAME_MAX_LENGTH = 10;
    /**
     * identifying a StudentDAO variable
     */
    private StudentDAO studentDAO = null;   
    
    /**
     * Default Constructor
     */
    public StudentsLogic(){
        studentDAO = new StudentImpl();
    }
    /**
     * method to get the StudentDAO's list of all students 
     * @return List<Registry>
     */
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }
     /**
     * method to add a registry using StudentDAO's addStudent method
     * @param student  
     */
    public void addStudent(Student student) throws ValidationException {
        cleanStudent(student);
        validateStudent(student);
        studentDAO.addStudent(student);
    }
    /**
     * method to search through the students by the number
     * @param code
     * @return List<Student>
     */
    public List<Student> getStudentsByCode(int code){
        return studentDAO.getStudentByNum(code);
    }
    /**
     * method to clean student's first and last name
     * @param student 
     */
    private void cleanStudent(Student student){
        
        if (student.getFirstName() != null){
            student.setFirstName(student.getFirstName().trim());
        }
        if (student.getLastName()!= null){
            student.setLastName(student.getLastName().trim());
        }     
    }
    /**
     * method to validate the student being added
     * @param s
     * @throws ValidationException 
     */
    private void validateStudent(Student s) throws ValidationException{
        validateString(s.getFirstName(), "first_name", STUDENT_NAME_MAX_LENGTH, false);
        validateString(s.getLastName(), "last_name", STUDENT_NAME_MAX_LENGTH, false);
        for(int i = 0;i<getAllStudents().size();i++){
            if(s.getStudentNum()==getAllStudents().get(i).getStudentNum()){
                throw new ValidationException();
            }
        }
    }
    /**
     * method to validate the string
     * @param value
     * @param fieldName
     * @param maxLength
     * @param isNullAllowed
     * @throws ValidationException 
     */
    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) throws ValidationException {
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
