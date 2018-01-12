/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.*;

/**
 *
 * @author markg
 */
public class AddCourseView extends HttpServlet {

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
            out.println("<title>Servlet AddCourseView</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"newcss.css\">"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCourseView at " + request.getContextPath() + "</h1>");
            out.println("<form action=\"Sample3\" method=\"post\">");
            out.println("Course Code:<br>");
            out.println("<input type=\"text\" name=\"course_code\" value=\"\"><br>");
            out.println("Couse Name:<br>");
            out.println("<input type=\"text\" name=\"course_name\" value=\"\"><br><br>");
            CoursesLogic logic = new CoursesLogic();
            Course c = new Course(request.getParameter("course_name"), request.getParameter("course_code"));
            try {
                logic.addCourse(c);
            } catch (ValidationException ex) {
                Logger.getLogger(RegistrarView.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<input type=\"submit\" value=\"Add\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
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
