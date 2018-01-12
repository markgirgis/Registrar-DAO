/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import business.ValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import business.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import transferobjects.*;

/**
 *
 * @author markg
 */
public class RegistrarView extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ValidationException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            CoursesLogic logic = new CoursesLogic();
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarView</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarView at " + request.getContextPath() + "</h1>");
            
            out.println("<form>");
            out.println("Student Number:<br>");
            out.println("<input type=\"number\" name=\"student_number\"><br>");            
            out.println("First name:<br>");
            out.println("<input type=\"text\" name=\"firstname\" ><br>");
            out.println("Last name:<br>");
            out.println("<input type=\"text\" name=\"lastname\" ><br>");
            out.println("Date of birth:<br>");
            out.println("<input type=\"date\" name=\"bday\"><br>");
            out.println("Enrolled:<br>");
            out.println("<input type=\"date\" name=\"enrolled\"><br><br>");
            out.println("Paid:<br>");
            out.println("<input type=\"text\" name=\"paid\"><br>");
            out.println("Remaining:<br>");
            out.println("<input type=\"text\" name=\"remainder\"><br><br>");
            out.println("Term:<br>");
            out.println("<input type=\"radio\" name=\"term\" value=\"W\" checked> Winter<br>");
            out.println("<input type=\"radio\" name=\"term\" value=\"F\"> Fall<br>");
            out.println("<input type=\"radio\" name=\"term\" value=\"S\"> Summer<br><br>");
            out.println("Year:<br>");
            out.println("<select name=\"year\" >");
            out.println("<option value=\"2017\">2017</option>");
            out.println("<option value=\"2018\">2018</option>");
            out.println("<option value=\"2019\">2019</option>");
            out.println("<option value=\"2020\">2020</option>");
            out.println("</select><br><br>");
            //for(int i =0;i<logic.getAllCourses().size();i++){
            out.println("Choose Courses:<br>");
            for(Course c : logic.getAllCourses()){
                out.printf("<input type=\"checkbox\" name=\"course_code\" value=\""+c.getCode()+"\"> %s<br>\n", c.getName());
            }
            out.println("OR:");
            out.println("<div><a href=\"AddCourses\">ADD NEW COURSE</a></div>");
            out.println("<br><br><br>");
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            out.println("<pre>");
            out.println("Submitted keys and values:");
            out.println(toStringMap(request.getParameterMap()));
            try{
            
            //** ADDing Students**//
            StudentsLogic studentlogic = new StudentsLogic();
            String birth = request.getParameter("bday");
            String en = request.getParameter("enrolled");
            Date birthday;
            birthday = new Date(Integer.parseInt(birth.split("-")[0]),Integer.parseInt(birth.split("-")[1]),Integer.parseInt(birth.split("-")[2]));
            Date enrolled;
            enrolled = new Date(Integer.parseInt(en.split("-")[0]), Integer.parseInt(en.split("-")[1]), Integer.parseInt(en.split("-")[2]));
            Student student = new Student(Integer.parseInt(request.getParameter("student_number")),
            request.getParameter("firstname"), request.getParameter("lastname"),birthday, enrolled);                   
            studentlogic.addStudent(student);
            //--Student ADDED--//
            
            //**Adding registry**//
            RegistryLogic registryLogic = new RegistryLogic();
            Registry registry ;
            for(int i = 0; i<request.getParameter("course_code").split(",").length;i++){
                registry = new Registry(Integer.parseInt(request.getParameter("student_number")), request.getParameter("course_code"), request.getParameter("term"), Integer.parseInt(request.getParameter("year")));
                registryLogic.addRegistry(registry);
            }
            //--Registry ADDED--//
            
            //**Adding Tuition**//
            TuitionLogic tuitionLogic = new TuitionLogic();
            Tuition tuition = new Tuition(Integer.parseInt(request.getParameter("student_number")), Double.parseDouble(request.getParameter("paid")), Double.parseDouble(request.getParameter("remainder")));
            tuitionLogic.addTuition(tuition);
            //--Tuition ADDED--//

            }catch(Exception e){
                throw new NullPointerException();
            }
            
            out.println("</pre>");
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    

    private String toStringMap(Map<String, String[]> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach((k, v) -> builder.append("Key=").append(k)
                .append(", ")
                .append("Value/s=").append(Arrays.toString(v))
                .append(System.lineSeparator()));
        return builder.toString();
    }
    
    private String getParameter(HttpServletRequest request, String ID) {
        String param = request.getParameter(ID);
        if (param != null) {
            return param.trim();
        }
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ValidationException ex) {
            Logger.getLogger(RegistrarView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ValidationException ex) {
            Logger.getLogger(RegistrarView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
