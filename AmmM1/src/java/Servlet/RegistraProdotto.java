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
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@WebServlet(name = "RegistraProdotto", urlPatterns = {"/RegistraProdotto"})
public class RegistraProdotto extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);

        if(request.getParameter("Submit") != null)
        {
            // Recupero i dati relativi al prodotto
            String nomeProdotto = request.getParameter("nomeprod");
            String linkFoto = request.getParameter("immagine");
            String descrizione = request.getParameter("descrizione");
            Double prezzo = 0.0;
            Integer quantita = 0;
            if(request.getParameter("prezzo").length()!=0 && request.getParameter("quantita").length()!=0 ){
                prezzo = Double.parseDouble(request.getParameter("prezzo"));
                quantita = Integer.parseInt(request.getParameter("quantita"));
            } else 
                request.getRequestDispatcher("ErroreDatiProdotto.jsp")
               .forward(request, response);
           
            Utenti venditore = (Utenti) session.getAttribute("venditore");
            Integer seller_id = venditore.getId();
                
            // Creo un nuovo prodotto con i dati inseriti dal venditore
            Prodotti nuovoProdotto = new Prodotti();
            session.setAttribute("nuovoProdotto", nuovoProdotto);
            nuovoProdotto.setNomeProdotto(nomeProdotto);
            nuovoProdotto.setDescrizione(descrizione);
            nuovoProdotto.setLinkFoto(linkFoto);
            nuovoProdotto.setPrezzo(prezzo);
            nuovoProdotto.setQuantita(quantita);
            if(!(boolean) session.getAttribute("modifica")){
                try{
                    OggettiFactory.getInstance().RegistrazioneProdotto(nomeProdotto, descrizione, prezzo, linkFoto, 
                        quantita, seller_id);
                }catch(SQLException e){
                }
            } else {
                int idProd = (int) session.getAttribute("prodottoId");
                try{
                    OggettiFactory.getInstance().ModificaProdotto(idProd,nomeProdotto, descrizione, prezzo, linkFoto, 
                        quantita);
                }catch(SQLException e){
                }
            }
            
        }else {
            int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
            //Prodotti modifica = OggettiFactory.getInstance().getProdotto(idProdotto);
            session.setAttribute("modifica", true);
            session.setAttribute("prodottoId", idProdotto);
            request.getRequestDispatcher("AggiungiProdotto.jsp")
               .forward(request, response);
        }
                
        request.getRequestDispatcher("Nuovo_Prodotto.jsp")
               .forward(request, response);
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
    

