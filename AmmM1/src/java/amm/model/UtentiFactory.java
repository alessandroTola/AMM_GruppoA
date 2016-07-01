/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alessandrotola
 */
public class UtentiFactory {
    // Attributi
    private static UtentiFactory singleton;
    String connectionString; 
    
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
  
    //Costruttore 
    public UtentiFactory(){

    }

    /* Metodi */
    public Utenti getUtente(String username, String password){
        
        try{
            Connection conn = DriverManager.getConnection(connectionString, "AlessandroTola", "0000");
            //sql command
            String query = "select * from venditori where  "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            //dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //Risultati
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                Venditore venditore = new Venditore();
                venditore.setId(set.getInt("id"));
                venditore.setNome(set.getString("nome"));
                venditore.setCognome(set.getString("cognome"));
                venditore.setUsername(set.getString("username"));
                venditore.setPassword(set.getString("password"));
                venditore.setTipo(true);
                
                //nuova query, corsi assegnati
                query = "select prodotti.id, prodotti.nomeProdotto, prodotti.descrizione, "
                        + "prodotti.prezzo, prodotti.linkFoto, prodotti.quantita "
                        + "from prodotti " 
                        + "join venditori "
                        + "on prodotti.seller_id = venditori.id "
                        + "where prodotti.seller_id = " + venditore.getId();
                Statement st = conn.createStatement();
                ResultSet res2 = st.executeQuery(query);
                while(res2.next()){
                    Prodotti m = new Prodotti();
                    m.setId(res2.getInt("id"));
                    m.setNomeProdotto(res2.getString("nomeProdotto"));
                    m.setLinkFoto(res2.getString("linkFoto"));
                    m.setPrezzo(res2.getDouble("prezzo"));
                    m.setQuantita(res2.getInt("quantita"));
                    m.setDescrizione(res2.getString("descrizione"));
                    venditore.listaProdotti.add(m);
                }
                st.close();
                stmt.close();
                conn.close();
                
                return venditore;
            }
            
            query = "select * from clienti where  "
                    + "password = ? and username = ?";
            stmt = conn.prepareStatement(query);
            //dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //Risultati
            set = stmt.executeQuery();
            if(set.next()){
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nome"));
                cliente.setCognome(set.getString("cognome"));
                cliente.setUsername(set.getString("username"));
                cliente.setPassword(set.getString("password"));
                cliente.setSaldo(set.getDouble("saldo"));
                cliente.setTipo(false);
         
                stmt.close();
                conn.close();
                
                return cliente;
            }
            
            stmt.close();
            conn.close();
                
        }catch(SQLException e){
            System.out.println("ERRORE DEL CAZZO");
            e.printStackTrace();
        }
        return null;

    }

    public double getSaldoSql(int id_cliente) throws SQLException {
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
        
        int idClient = 0;
        double saldoClient = 0;
        try{
            Statement stmt = conn.createStatement();
            String saldo = "select * from clienti";
            ResultSet set = stmt.executeQuery(saldo);
            
            while (set.next()) {
                idClient = set.getInt("id");
                if(idClient == id_cliente ){
                    saldoClient = set.getDouble("saldo");
                }
            }
        }catch(SQLException e){
        }finally{
            conn.close();
        }
        
        return saldoClient;
    }
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
    
}

