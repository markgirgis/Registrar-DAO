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
public class Tuition {
    
    int studentNum;
    double paid;
    double remainder;
    
    /**
     * Default Constructor
     */
    public Tuition(){}

    /**
     * Constructor
     * @param StudentNum
     * @param Paid
     * @param Remaining
     */
    public Tuition(int s, double p, double r ) {
        
        setStudentNum(s);
        setPaid(p);
        setRemainder(r);
    }

    /**
     * setting studentNumber
     * @param studentNum 
     */
    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * getting studentNumber
     * @return studentNumber
     */
    public int getStudentNum() {
        return studentNum;
    }

    /**
     * setting paid
     * @param paid 
     */
    public void setPaid(double paid) {
        this.paid = paid;
    }

    /**
     * getting paid amount
     * @return paid
     */
    public double getPaid() {
        return paid;
    }

    /**
     * setting remainingAmount
     * @param remainder 
     */
    public void setRemainder(double remainder) {
        this.remainder = remainder;
    }

    /**
     * getting remaining amount
     * @return remainder
     */
    public double getRemainder() {
        return remainder;
    }
    
    
    
    
    
    
}
