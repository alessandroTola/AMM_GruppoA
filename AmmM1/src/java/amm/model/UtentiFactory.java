/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

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
/*    
    // Lista Clienti
    private ArrayList<Utenti> listaClienti = new ArrayList<Utenti>();
    // Lista Veditori
    private ArrayList<Utenti> listaVenditori = new ArrayList<Utenti>();
*/    
    //Costruttore 
    public UtentiFactory(){
/*  
    
        //Cliente 1
        Cliente client_1 = new Cliente();
        client_1.setNome("Alessandro");
        client_1.setCognome("Tola");
        client_1.setUsername("pippo");
        client_1.setPassword("0");
        client_1.setId(0);
        client_1.getSaldo().setSaldo(505.505);
        listaClienti.add(client_1);
        
        //Cliente 2
        Cliente client_2 = new Cliente();
        client_2.setNome("Giovannino");
        client_2.setCognome("PaneEVino");
        client_2.setUsername("giovi");
        client_2.setPassword("1");
        client_2.setId(1);
        client_2.getSaldo().setSaldo(444.666);
        listaClienti.add(client_2);
        
        //Cliente 3
        Cliente client_3 = new Cliente();
        client_3.setNome("Marteeeeeena");
        client_3.setCognome("Senisis");
        client_3.setUsername("sen");
        client_3.setPassword("3");
        client_3.setId(3);
        client_3.getSaldo().setSaldo(999.9999);
        listaClienti.add(client_3);
        
        //Venditore 1
        Venditore seller_1 = new Venditore();
        seller_1.setNome("Gianni");
        seller_1.setCognome("Agnelli");
        seller_1.setUsername("Coca");
        seller_1.setPassword("4");
        seller_1.getSaldo().setSaldo(10.5);
        listaVenditori.add(seller_1);
        
        //Venditore 2
        Venditore seller_2 = new Venditore();
        seller_2.setNome("Davide");
        seller_2.setCognome("Spano");
        seller_2.setUsername("HTML");
        seller_2.setPassword("5");
        seller_2.getSaldo().setSaldo(0.5);
        listaVenditori.add(seller_2);
        
        //Venditore 3
        Venditore seller_3 = new Venditore();
        seller_3.setNome("Il_BAFFO");
        seller_3.setCognome("Urlatore");
        seller_3.setUsername("tiVendoTutto");
        seller_3.setPassword("6");
        seller_3.getSaldo().setSaldo(10000.5);
        listaVenditori.add(seller_3);
*/        
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
/*
    public ArrayList<Utenti> getClientiList() {
        return listaClienti;
    }
   
    public Utenti getCliente(int id)
    {
        for(Utenti u : listaClienti)
        {
            if(u.getId() == id)
                return u;
        }
        
        return null;
    }
   
    public ArrayList<Utenti> getVenditoriList() {
        return listaVenditori;
    }
    
    public Utenti getVenditori(int id)
    {
        for(Utenti u : listaVenditori)
        {
            if(u.getId() == id)
                return u;
        }
        
        return null;
    }
   
    public ArrayList<Utenti> getUserList() 
    {
        ArrayList<Utenti> listaUtenti = new ArrayList<Utenti>();
        
        listaUtenti.addAll(listaClienti);
        listaUtenti.addAll(listaVenditori);
        
        return listaUtenti;
    }
*/   
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}
