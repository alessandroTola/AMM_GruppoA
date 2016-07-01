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
import java.sql.SQLException;
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
@WebServlet(name = "AzioniVenditore", urlPatterns = {"/AzioniVenditore"})
public class AzioniVenditore extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        int sellerId = (int) session.getAttribute("sellerId");
        System.out.println("Ecco il'id" + sellerId);
        ArrayList<Prodotti> sellerList = OggettiFactory.getInstance().sellerItem(sellerId);
        session.setAttribute("sellerList", sellerList);
        
        if(request.getParameter("Submit") != null)
        {
            String azione = request.getParameter("azione");
            // Lancio la jsp corripondente alla scelta del vendotore 
            if(azione.equals("Nuovo prodotto")){
                request.getRequestDispatcher("AggiungiProdotto.jsp").forward(request, response);
            }
            if(azione.equals("Modifica prodotto")){
                
                request.getRequestDispatcher("ModificaProdotto.jsp").forward(request, response);
            }
            if(azione.equals("Elimina prodotto")){
                
                request.getRequestDispatcher("EliminaProdotto.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AzioniVenditore.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(AzioniVenditore.class.getName()).log(Level.SEVERE, null, ex);
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
