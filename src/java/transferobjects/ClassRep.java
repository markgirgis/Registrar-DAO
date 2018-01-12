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
public class ClassRep {
   
    int studentNum;
    String courseCode;
    String term;
    int year;
    
    public ClassRep(){}

    public ClassRep(int s, String c, String t, int y) {
        setStudentNum(s);
        setCourseCode(c);        
        setTerm(t);
        setYear(y);
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getStudentNum() {
        return studentNum;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }   
    
    
    
}
