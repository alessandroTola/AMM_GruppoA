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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"}, loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        UtentiFactory.getInstance().setConnectionString(dbConnection);
        OggettiFactory.getInstance().setConnectionString(dbConnection);
    }
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
            /* Recupero i dati d'accesso */
            String username = request.getParameter("userid");
            String password = request.getParameter("pswd");

            Utenti u = UtentiFactory.getInstance().getUtente(username, password);

            if(u != null){

                session.setAttribute("loggedIn", true); //Utente esistente 
                session.setAttribute("id", u.getId());  //Recupero l'id
                /* Controllo il tipo di u */
                if(u.getTipo()) 
                {
                    session.setAttribute("venditore", u);
                    session.setAttribute("sellerId", u.getId());
                    session.setAttribute("loggedVenditore", true);
                    session.setAttribute("loggedCliente", false);
                    /* Lancio la jsp del ventore autenticato */
                    request.getRequestDispatcher("Venditore_autenticato.jsp").forward(request, response);
                } else {
                    session.setAttribute("cliente", u);
                    session.setAttribute("loggedVenditore", false);
                    session.setAttribute("loggedCliente", true);
                    session.setAttribute("listaProdotti", OggettiFactory.getInstance().getProdottiList());
                    /* Lancio la jsp del cliente autenticato */
                    request.getRequestDispatcher("Cliente_autenticato.jsp").forward(request, response);

                }
            } else {
                request.getRequestDispatcher("form_login.jsp").forward(request, response);
            }               
        } 
        if(session.getAttribute("loggedIn") != null){  

            if((boolean) session.getAttribute("loggedVenditore"))
                request.getRequestDispatcher("Venditore_autenticato.jsp").forward(request, response);
            if((boolean) session.getAttribute("loggedCliente"))
                request.getRequestDispatcher("Cliente_autenticato.jsp").forward(request, response);
        } else
            request.getRequestDispatcher("form_login.jsp").forward(request, response);
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
