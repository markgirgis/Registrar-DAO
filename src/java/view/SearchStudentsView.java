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
import business.*;
import java.util.List;
import transferobjects.Student;

/**
 *
 * @author markg
 */
public class SearchStudentsView extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchStudentsView</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchStudentsView at " + request.getContextPath() + "</h1>");
            out.println("<form method=\"post\">");
            out.println("Search Students by number:");
            out.println("<input type=\"text\" name=\"student_num\" value=\"100000001\">");
            out.println("<input type=\"submit\" value=\"SEARCH\">");
            StudentsLogic studentsLogic = new StudentsLogic();
            List<Student> students = studentsLogic.getStudentsByCode(Integer.parseInt(request.getParameter("student_num")));
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>Num</td>");
            out.println("<td>First Name</td>");
            out.println("<td>Last Name</td>");
            out.println("<td>Birth Date</td>");
            out.println("<td>Enrolled</td>");
            for(Student student : students){
                out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", student.getStudentNum(),
                        student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getEnrolled());
            }
            out.println("</tr>");   
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
//    private String toStringMap(Map<String, String[]> values) {
//        StringBuilder builder = new StringBuilder();
//        values.forEach((k, v) -> builder.append("Key=").append(k)
//                .append(", ")
//                .append("Value/s=").append(Arrays.toString(v))
//                .append(System.lineSeparator()));
//        return builder.toString();
//    }
    
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
        processRequest(request, response);
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
        processRequest(request, response);
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
