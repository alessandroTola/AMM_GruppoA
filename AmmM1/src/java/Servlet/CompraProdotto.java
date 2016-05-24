/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import amm.model.Cliente;
import amm.model.OggettiFactory;
import amm.model.Prodotti;
import amm.model.Utenti;
import amm.model.UtentiFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(name = "CompraProdotto", urlPatterns = {"/CompraProdotto"})
public class CompraProdotto extends HttpServlet {

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
        
        int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
        Prodotti prod = OggettiFactory.getInstance()
                .getProdotto(idProdotto);
        request.setAttribute("prodotto", OggettiFactory.getInstance()
                .getProdotto(idProdotto));
        HttpSession session = request.getSession(true);
        int quantita = prod.getQuantita();
        Utenti cliente = new Cliente();
        
        cliente = (Utenti) session.getAttribute("cliente");
        int idCliente = cliente.getId();
        
        double saldo = cliente.getSaldo().getSaldo();
        System.out.println("ecco l'id clienteeee" + saldo);
        
        
        
        try{
            Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
            
            Statement stmt = conn.createStatement();
            String venditore = "select * from prodotti";
            ResultSet set = stmt.executeQuery(venditore);
            
            int idPro = 0;
            int id_venditore = 0;
            double costo = 0;
            while (set.next()) {
                idPro = set.getInt("id");
                if(idPro == idProdotto ){
                    id_venditore = set.getInt("seller_id");
                    costo = set.getDouble("prezzo");
                }
            }
            if(saldo >= costo){
                OggettiFactory.getInstance().acquistaProdotto(idProdotto,id_venditore, idCliente, quantita, saldo, costo);
                request.getRequestDispatcher("ProdottoAcquistato.jsp")
                .forward(request, response);
            }else
                request.getRequestDispatcher("erroreAcquisto.jsp")
                .forward(request, response);
                
        }catch(SQLException e){}
        
        
        
        if(cliente.getSaldo().getSaldo() > prod.getPrezzo()){
            request.setAttribute("disponibilita", true);
            
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
