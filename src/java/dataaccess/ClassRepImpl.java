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
import transferobjects.ClassRep;
/**
 *
 * @author markg
 */
public class ClassRepImpl implements ClassRepDAO{
    private static final String GET_ALL_CLASSREPS = "SELECT * FROM Classrep";
    private static final String ADD_CLASSREP = "INSERT INTO Classrep (student_num, course_num, term, year) VALUES (?, ?, ?, ?)";

    @Override
    public List<ClassRep> getAllClassReps() {
       List<ClassRep> classReps = Collections.EMPTY_LIST;
        ClassRep classRep;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_CLASSREPS);
            rs = pstmt.executeQuery();
            classReps = new ArrayList<>(100);
            while( rs.next()){
                classRep = new ClassRep();
                classRep.setStudentNum(rs.getInt("student_num"));
                classRep.setCourseCode(rs.getString("course_num"));
                classRep.setTerm(rs.getString("term"));
                classRep.setYear(rs.getInt("year"));
                classReps.add(classRep);
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
        return classReps;
    }

    @Override
    public void addClassRep(ClassRep classRep) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(ADD_CLASSREP);){
            pstmt.setInt(1,classRep.getStudentNum());
            pstmt.setString(2, classRep.getCourseCode());
            pstmt.setString(3, classRep.getTerm());
            pstmt.setInt(4, classRep.getYear());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
}
