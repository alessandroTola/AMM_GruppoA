/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import amm.model.OggettiFactory;
import amm.model.Prodotti;
import amm.model.Utenti;
import amm.model.UtentiFactory;
import amm.model.Venditore;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alessandrotola
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        
        /*creo la variabile di sessione */
        HttpSession session = request.getSession(true);
        
        if(request.getParameter("Submit") != null)
        {
            String username = request.getParameter("userid");
            String password = request.getParameter("pswd");
  
            /*Ttestase se i dati sono null fare a casa */
            ArrayList<Utenti> listaUtenti = UtentiFactory.getInstance().getUserList();

            /* Ciclo per verificare che i dati inseriti sono o di uno studente o professore se no sono sbagliati */
            for(Utenti u : listaUtenti)
            {
                if(u.getUsername().equals(username) && 
                   u.getPassword().equals(password))
                {
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("id", u.getId());
                    session.setAttribute("listaProdotti", OggettiFactory.getInstance().getProdottiList());
                    
                    if(u instanceof Venditore) /* Controllo il tipo di u */
                    {
                        session.setAttribute("venditore", u);
                        session.setAttribute("loggedVenditore", true);
                        session.setAttribute("loggedCliente", false);
                        
                        request.getRequestDispatcher("Venditore_autenticato.jsp").forward(request, response);
                    } else 
                    {
                        session.setAttribute("cliente", u);
                        session.setAttribute("loggedVenditore", false);
                        session.setAttribute("loggedCliente", true);
                        request.getRequestDispatcher("Cliente_autenticato.jsp").forward(request, response);
                    }
                   
                }
            }

        }
            else
                request.getRequestDispatcher("form_login.jsp").forward(request, response);
                /* mostrare un messaggio di errore perche i dati sono sbagliati */
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
