/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import transferobjects.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markg
 */
public class StudentImpl implements StudentDAO{
    
    /**
     * Three String representing the SQL Query that is going to be executed in the database
     * 1- GET_ALL_STUDENTS to get all students
     * 2- INSERT_STUDENT to add a new student into the database
     * 3- GET_BY_CODE_STUDENTS to search students by their number
     */    
    private static final String GET_ALL_STUDENTS = "SELECT * FROM Students";
    private static final String INSERT_STUDENT = "INSERT INTO Students (student_num, first_name, last_name, data_birth, enrolled) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_BY_CODE_STUDENTS = "SELECT * FROM Students WHERE student_num = ";

    /**
     * Overriden method to return a list of all students
     * @return List<Student>
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = Collections.EMPTY_LIST;
        Student student;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_STUDENTS);
            rs = pstmt.executeQuery();
            students= new ArrayList<>(100);
            while( rs.next()){
                student = new Student();
                student.setStudentNum(rs.getInt("student_num"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setDateOfBirth(rs.getDate("date_birth"));
                student.setEnrolled(rs.getDate("enrolled"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return students;
        
    }

    /**
     * Overriden method to add a new student
     * @param student 
     */
    @Override
    public void addStudent(Student student) {
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( INSERT_STUDENT);){
            pstmt.setInt(1, student.getStudentNum());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.setDate(4, student.getDateOfBirth());
            pstmt.setDate(5, student.getEnrolled());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * Overriden method to get a student that has a specific number
     * @param num
     * @return List<Student>
     */
    @Override
    public List<Student> getStudentByNum(int num) {
        List<Student> students = Collections.EMPTY_LIST;
        Student student;
        ResultSet rs = null;
        try( Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement( GET_BY_CODE_STUDENTS+num);){
            rs = pstmt.executeQuery();
            students = new ArrayList<>(100);
            while(rs.next()){
                student = new Student();
                student.setStudentNum(rs.getInt("student_num"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setDateOfBirth(rs.getDate("date_birth"));
                student.setEnrolled(rs.getDate("enrolled"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
}
