/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import java.util.List;
import transferobjects.Student;

/**
 *
 * @author markg
 */
public interface StudentDAO {
    
     /**
     * method to return a list of all students
     * @return List<Student>
     */
    List<Student> getAllStudents();
    /**
     * method to add a new student
     * @param student 
     */
    void addStudent(Student student);
    /**
     * method to get a student that has a specific number
     * @param num
     * @return List<Student>
     */
    List<Student> getStudentByNum(int num);
    
}
