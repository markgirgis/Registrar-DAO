/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;
import java.sql.Date;
/**
 *
 * @author markg
 */
public class Student {
    
    private int studentNum;
    private String firstName;
    private String lastName;
    private java.sql.Date dateOfBirth;
    private java.sql.Date enrolled;
    
    /**
     * Constructor
     */    
    public Student(){}
    
    public Student(int x, String x2, String x3, Date x4, Date x5){
        setStudentNum(x);
        setFirstName(x2);
        setLastName(x3);
        setDateOfBirth(x4);
        setEnrolled(x5);
    }
    
    /**
     * Setting Student Number
     * @param studentNum 
     */
    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }
    
    /**
     * Accessor for Student Number
     * @return studentNum
     */
    public int getStudentNum() {
        return studentNum;
    }
    
    /**
     * Setting Student first name
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Accessor for Student first name
     * @return 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setting Student last name
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Accessor for Student last name
     * @return 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setting Student birth date
     * @param dateOfBirth 
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Accessor for Student dob
     * @return 
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setting Student enrolling date
     * @param enrolled 
     */
    public void setEnrolled(Date enrolled) {
        this.enrolled = enrolled;
    }

    /**
     * Accessor for Student enrolled date
     * @return 
     */
    public Date getEnrolled() {
        return enrolled;
    }
    
    
    
}
