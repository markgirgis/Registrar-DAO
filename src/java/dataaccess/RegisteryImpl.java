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
import transferobjects.Registry;

/**
 *
 * @author markg
 */
public class RegisteryImpl implements RegisteryDAO{
    
    /**
     * Two String representing the SQL Query that will be excuted to get all data or insert a new data
     */    
    private static final String GET_ALL_REGISTERIES = "SELECT * FROM Registry";
    private static final String ADD_REGISTERY = "INSERT INTO Registry (student_num, course_num, term, year) VALUES (?, ?, ?, ?)";

    /**
     * Overriden method to return a list of all registrys in the database
     * @return List<Registry>
     */
    @Override
    public List<Registry> getAllRegistries() {
        List<Registry> registrys = Collections.EMPTY_LIST;
        Registry registry;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_REGISTERIES);
            rs = pstmt.executeQuery();
            registrys = new ArrayList<>(100);
            while( rs.next()){
                registry = new Registry();
                registry.setStudentNum(rs.getInt("student_num"));
                registry.setCourseCode(rs.getString("course_num"));
                registry.setTerm(rs.getString("term"));
                registry.setYear(rs.getInt("year"));
                registrys.add(registry);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        return registrys;
    }

    /**
     * Overriden method to add a new Registry to the database
     * @param registry 
     */
    @Override
    public void addRegistry(Registry r) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( ADD_REGISTERY);){
            pstmt.setInt(1,r.getStudentNum());
            pstmt.setString(2, r.getCourseCode());
            pstmt.setString(3, r.getTerm());
            pstmt.setInt(4, r.getYear());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
