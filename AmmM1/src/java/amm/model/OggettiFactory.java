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
public class OggettiFactory {
    // Attributi
    private static OggettiFactory singleton;
    String connectionString;

    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    // Lista Prodotti
    private ArrayList<Prodotti> listaProdotti = new ArrayList<Prodotti>();
    
    public OggettiFactory() {
     
    }
    
    public ArrayList<Prodotti> getProdottiList() {
        try{
            Connection conn = DriverManager.getConnection(connectionString, "AlessandroTola", "0000");
            //sql command
            String query = "select * from prodotti";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            //Risultati
            ResultSet set = stmt.executeQuery();
            
            while(set.next()){
                Prodotti m = new Prodotti();
                m.setId(set.getInt("id"));
                m.setNomeProdotto(set.getString("nomeProdotto"));
                m.setLinkFoto(set.getString("linkFoto"));
                m.setPrezzo(set.getDouble("prezzo"));
                m.setQuantita(set.getInt("quantita"));
                m.setDescrizione(set.getString("descrizione"));
                listaProdotti.add(m);
            }
            stmt.close();
            conn.close();
            return listaProdotti;
                
        }catch(SQLException e){
            System.out.println("ERRORE DEL CAZZO");
            e.printStackTrace();
        }

        return null;
    }
    
    public Prodotti getProdotto(int id)
    {
        for(Prodotti u : listaProdotti)
        {
            if(u.getId() == id)
                return u;
        }
        
        return null;
    }
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
    public void RegistrazioneProdotto(String nomeProdotto, String descrizione, double prezzo, String linkFoto, 
            int quantita, int seller_id) throws SQLException{
        
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
        
        PreparedStatement addProdotto = null;
        
        
        String inserProdotto = "insert into prodotti "
                + "(id, nomeProdotto, descrizione, prezzo, linkFoto, quantita, seller_id) "
                + "values (default,?,?,?,?,?,?)";
        
        try{
            conn.setAutoCommit(false);
            
            addProdotto = conn.prepareStatement(inserProdotto);
            //Dati prodotto
            addProdotto.setString(1, nomeProdotto);
            addProdotto.setString(2, descrizione);
            addProdotto.setDouble(3, prezzo);
            addProdotto.setString(4, linkFoto);
            addProdotto.setInt(5, quantita);
            addProdotto.setInt(6, seller_id);
            System.out.println("ERRORE DEL CAZZOooo");

            //Controllare se sono andate a buonfine 
            int row = addProdotto.executeUpdate();
            
            if(row != 1){
                conn.rollback();
            }
                
            conn.commit();
            
            
        }catch(SQLException e){
            System.out.println("ERRORE DEL CAZZOadsd");
            e.printStackTrace();
            try{
                conn.rollback();
            }catch(SQLException a){
                System.out.println("ERRORE DEL CAZZO1");
                e.printStackTrace();
            }
            
        }
        finally{
            if(addProdotto != null)
                addProdotto.close();
            conn.setAutoCommit(true);
            conn.close();
        }

        
    }
    public void acquistaProdotto(int id_prodotto, int id_venditore, int id_cliente, int quantita, double saldo, double costo) throws SQLException{
        
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
        
        PreparedStatement deleteProdotto = null;
        PreparedStatement addProdotto = null;
        PreparedStatement editProdotto = null;
        PreparedStatement editSaldo = null;

        
        String rimuoviProdotto = "delete from prodotti "
                + "where id = ? "
                + "and seller_id = ?";
        String modificaQuantita = "update prodotti set "
                + "quantita = ? "
                + "where id = ?";
        String modificaSaldo = "update clienti set "
                + "saldo = saldo - ? "
                + "where id = ?";
        String inserProdotto = "insert into storico "
                + "(id, cliente_id, venditore_id, prodotto_id, quantita) "
                + "values (default,?,?,?,?)";
        try{
            conn.setAutoCommit(false);
            deleteProdotto = conn.prepareStatement(rimuoviProdotto);
            addProdotto = conn.prepareStatement(inserProdotto);
            editProdotto = conn.prepareStatement(modificaQuantita);
            editSaldo = conn.prepareStatement(modificaSaldo);
            
            System.out.println("ERRORE DEL CAZZO0");

            if( quantita > 1 ){
                quantita = quantita - 1;
                editProdotto.setInt(1, quantita);
                editProdotto.setInt(2, id_prodotto);
                int row3 = editProdotto.executeUpdate();
                if(row3 != 1 ){
                    conn.rollback();
                }
            } else {   
                deleteProdotto.setInt(1, id_prodotto);
                deleteProdotto.setInt(2, id_venditore);
                int row2 = deleteProdotto.executeUpdate();
                if(row2 != 1 ){
                    conn.rollback();
                }
            }
            //Dati prodotto
            addProdotto.setInt(1, id_cliente);
            addProdotto.setInt(2, id_venditore);
            addProdotto.setInt(3, id_prodotto);
            addProdotto.setInt(4, 1);
            
            editSaldo.setDouble(1, costo);
            editSaldo.setInt(2, id_cliente);
            //Controllare se sono andate a buonfine 

            int row = addProdotto.executeUpdate();
            if(row != 1 ){
                conn.rollback();
            }
               
            conn.commit();
                       
        }catch(SQLException e){
            System.out.println("ERRORE DEL CAZZO2");
            e.printStackTrace();
            try
            {
                conn.rollback();
            }catch(SQLException e2)
            {
                
            }
        }
        finally{
            if(addProdotto != null)
                addProdotto.close();
            if(deleteProdotto != null)
                deleteProdotto.close();
            if(editProdotto != null)
                editProdotto.close();
            if(editSaldo != null)
                editSaldo.close();
            conn.setAutoCommit(true);
            conn.close();
        }
    }
}
