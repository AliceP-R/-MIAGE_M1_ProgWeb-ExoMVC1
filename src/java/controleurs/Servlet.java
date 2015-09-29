package controleurs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeles.User;

/**
 *
 * @author alpottie
 */
@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
        
        User utilisateur = new User(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("mdp")); 
        String cheminComplet = this.getServletContext().getRealPath("/WEB-INF/users.properties"); 
        
        if(utilisateur.comparaison(cheminComplet) == true)
        {
            request.setAttribute("utilisateur", utilisateur);
            RequestDispatcher disp= getServletContext().getRequestDispatcher("/bonjour.jsp");
            disp.forward(request, response);
        }
        else
        {    
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) 
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet controlleur</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> NON </h1>");
                out.println("<h1>Servlet controlleur at " + request.getContextPath() + "</h1>");
                out.println("<h1>nom html " + request.getParameter("nom") + "</h1>");
                out.println("<h1>prenom html" + request.getParameter("prenom") + "</h1>");
                out.println("<h1>mdp html " + request.getParameter("mdp") + "</h1>");
                out.println("<h1>nom " + utilisateur.getNom() + "</h1>");
                out.println("<h1>prenom " + utilisateur.getPrenom() + "</h1>");
                out.println("<h1>mdp " + utilisateur.getMdp() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
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
