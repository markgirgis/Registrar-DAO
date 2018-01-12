/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import transferobjects.Course;
import transferobjects.Tuition;

/**
 *
 * @author markg
 */
public class TuitionImpl implements TuitionDAO{
    
    /**
     * Two Strings representing the SQL Queries that will be uset to get all the tuitions or add a new tuition
     */    
    private static final String GET_ALL_TUITION = "SELECT * FROM Tuition";
    private static final String ADD_TUITION = "INSERT INTO Tuition (student_num, paid, remainder) VALUES (?, ?, ?)";

    /**
     * Overriden method to get all tuitions
     * @return List<Tuition>
     */
    @Override
    public List<Tuition> getAllTuition() {
        List<Tuition> tuitions = Collections.EMPTY_LIST;
        Tuition tuition;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_TUITION);
            rs = pstmt.executeQuery();
            tuitions = new ArrayList<>(100);
            while( rs.next()){
                tuition = new Tuition();
                tuition.setStudentNum(rs.getInt("student_num"));
                tuition.setPaid(rs.getDouble("paid"));
                tuition.setRemainder(rs.getDouble("remainder"));
                tuitions.add(tuition);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TuitionImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return tuitions;
    }
    
    /**
     * Overriden method to add a new Tuition
     * @param tuition 
     */
    @Override
    public void addTuition(Tuition tuition) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( ADD_TUITION);){
            pstmt.setInt(1, tuition.getStudentNum());
            pstmt.setDouble(2, tuition.getPaid());
            pstmt.setDouble(3, tuition.getRemainder());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
