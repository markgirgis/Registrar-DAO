/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CoursesLogic;
import business.RegistryLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Registry;

/**
 *
 * @author markg
 */
@WebServlet(name = "RegistrysView", urlPatterns = {"/Registrys"})
public class RegistrysView extends HttpServlet {

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
            out.println("<title>Servlet RegistrysView</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"tablestyle.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrysView at " + request.getContextPath() + "</h1>");
            RegistryLogic logic = new RegistryLogic();
            List<Registry> registrys  = logic.getAllRegistrys();
            out.println("<table border=\"1\" id=\"customers\">");
            out.println("<tr>");
            out.println("<th>Student Number</th>");
            out.println("<th>Course Code</th>");
            out.println("<th>Term</th>");
            out.println("<th>Year</th>");
            out.println("</tr>");
            for(Registry registry : registrys){
                out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", registry.getStudentNum(), registry.getCourseCode(), registry.getTerm(), registry.getYear());
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
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
