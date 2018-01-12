/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CoursesLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Course;

/**
 *
 * @author markg
 */
public class SearchView extends HttpServlet {

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
            out.println("<title>Servlet SearchView</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchView at " + request.getContextPath() + "</h1>");
            out.println("<form method=\"post\">");
            out.println("Search Course:");
            out.println("<input type=\"text\" name=\"course_num\" value=\"CST\">");
            out.println("<input type=\"submit\" value=\"SEARCH\">");
            CoursesLogic logic = new CoursesLogic();
            List<Course> courses = logic.getCoursesByCode(request.getParameter("course_num"));
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>Course Code</td>");
            out.println("<td>Course Name</td>");            
            for(Course course : courses){
                out.printf("<tr><td>%s</td><td>%s</td></tr>", course.getCode(), course.getName());
            }
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
//            out.println("<pre>");
//            out.println("Submitted keys and values:");
//            out.println(toStringMap(request.getParameterMap()));           
//            out.println("</pre>");
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
