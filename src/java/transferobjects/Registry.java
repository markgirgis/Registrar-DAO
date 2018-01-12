/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

/**
 *
 * @author markg
 */
public class Registry {
    
    int studentNum;
    String courseCode;
    String term;
    int year;
    
    /**
     * default Constructor
     */
    public Registry(){}

    /**
     * Constructor
     * @param studentNumber 
     * @param CourseCode
     * @param Term
     * @param Year
     */
    public Registry(int s, String c, String t, int y) {
        setStudentNum(s);
        setCourseCode(c);        
        setTerm(t);
        setYear(y);
    }

    /**
     * setting Course Code
     * @param courseCode 
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * getting course code
     * @return course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * setting student number
     * @param studentNum 
     */
    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * getting student number
     * @return student number
     */
    public int getStudentNum() {
        return studentNum;
    }
    
    /**
     * setting term
     * @param term 
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * getting Term
     * @return term
     */
    public String getTerm() {
        return term;
    }

    /**
     * setting year
     * @param year 
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * getting year
     * @return year
     */
    public int getYear() {
        return year;
    }
}
