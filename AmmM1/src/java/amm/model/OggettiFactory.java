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
import java.util.List;

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
    
    public ArrayList<Prodotti> getProdottiList(String text)
    {
        ArrayList<Prodotti> lista = new ArrayList<Prodotti>();
        
        try
        {
            Connection conn = DriverManager.getConnection(connectionString, "AlessandroTola", "0000");
             
            String query = "select * " + 
                "from prodotti " + 
                "where prodotti.nomeprodotto LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // Assegna dati
            text = "%"+text+"%";
            stmt.setString(1, text);
            ResultSet res = stmt.executeQuery();
            
            while(res.next())
            {
                Prodotti m = new Prodotti();
                m.setId(res.getInt("id"));
                m.setNomeProdotto(res.getString("nomeProdotto"));
                m.setLinkFoto(res.getString("linkFoto"));
                m.setPrezzo(res.getDouble("prezzo"));
                m.setQuantita(res.getInt("quantita"));
                m.setDescrizione(res.getString("descrizione"));
                lista.add(m);
            }
            
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {}
        
        return lista;
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
    
    public void EliminaProdotto (int id) throws SQLException{
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
        
        PreparedStatement delProdotto = null;
        
        
        String eliminaProdotto = "DELETE FROM prodotti " +
                                 "WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            delProdotto = conn.prepareStatement(eliminaProdotto);
            //Dati prodotto
            delProdotto.setInt(1, id);
            
            //Controllare se sono andate a buonfine 
            int row = delProdotto.executeUpdate();
            
            if(row != 1){
                conn.rollback();
            }
                
            conn.commit();
            
            
        }catch(SQLException e){
            e.printStackTrace();
            try{
                conn.rollback();
            }catch(SQLException a){
                e.printStackTrace();
            }
            
        }
        finally{
            if(delProdotto != null)
                delProdotto.close();
            conn.setAutoCommit(true);
            conn.close();
        }
    }
    public void ModificaProdotto(int id, String nomeProdotto, String descrizione, double prezzo, String linkFoto, 
            int quantita) throws SQLException{
        
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
        
        PreparedStatement modificaProdotto = null;
        
        
        String modProdotto = "update prodotti set "
                + "nomeprodotto = ?, descrizione = ?, prezzo = ?" +
                ", linkFoto = ?, quantita = ? "
                + "WHERE id = ?";
        
        try{
            conn.setAutoCommit(false);
            
            modificaProdotto = conn.prepareStatement(modProdotto);
            //Dati prodotto
            modificaProdotto.setString(1, nomeProdotto);
            modificaProdotto.setString(2, descrizione);
            modificaProdotto.setDouble(3, prezzo);
            modificaProdotto.setString(4, linkFoto);
            modificaProdotto.setInt(5, quantita);
            modificaProdotto.setInt(6, id);

            //Controllare se sono andate a buonfine 
            int row = modificaProdotto.executeUpdate();
            
            if(row != 1){
                conn.rollback();
            }
                
            conn.commit();
            
            
        }catch(SQLException e){
            e.printStackTrace();
            try{
                conn.rollback();
            }catch(SQLException a){
                e.printStackTrace();
            }
            
        }
        finally{
            if(modificaProdotto != null)
                modificaProdotto.close();
            conn.setAutoCommit(true);
            conn.close();
        }
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
    public boolean acquistaProdotto(int id_prodotto, int id_cliente, int quantita) throws SQLException{
        
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
        double costo = 0;
        int id_venditore = 0;
        boolean transazione = false;
        double saldo = UtentiFactory.getInstance().getSaldoSql(id_cliente);
        
        try{
            Statement stmt = conn.createStatement();
            String venditore = "select * from prodotti";
            ResultSet set = stmt.executeQuery(venditore);
            
            int idPro = 0;
            
            while (set.next()) {
                idPro = set.getInt("id");
                if(idPro == id_prodotto ){
                    id_venditore = set.getInt("seller_id");
                    costo = set.getDouble("prezzo");
                }
            }
        }catch(SQLException e){
        }finally{
            conn.close();
        }
                
        
        
        if(saldo >= costo){
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
                    + "saldo = ? "
                    + "where id = ?";
            String inserProdotto = "insert into storico "
                    + "(id, cliente_id, venditore_id, prodotto_id, quantita) "
                    + "values (default,?,?,?,?)";
            try{
                conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
                conn.setAutoCommit(false);
                deleteProdotto = conn.prepareStatement(rimuoviProdotto);
                addProdotto = conn.prepareStatement(inserProdotto);
                editProdotto = conn.prepareStatement(modificaQuantita);
                editSaldo = conn.prepareStatement(modificaSaldo);

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
                
                saldo = saldo - costo;
                editSaldo.setDouble(1, saldo);
                editSaldo.setInt(2, id_cliente);
                //Controllare se sono andate a buonfine 

                int row = addProdotto.executeUpdate();
                int row4 = editSaldo.executeUpdate();
                if(row != 1 || row4 !=1){
                    conn.rollback();
                }

                conn.commit();
                transazione = true;
            }catch(SQLException e){
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
        
        return transazione;
    }
    
    public ArrayList<Prodotti> sellerItem(int id) throws SQLException{
        
        ArrayList<Prodotti> listaSeller = new ArrayList<Prodotti>();
        
        Connection conn = DriverManager.getConnection(UtentiFactory.getInstance().
                getConnectionString(), "AlessandroTola","0000");
        String query = "select prodotti.id, prodotti.nomeprodotto, prodotti.descrizione, " + 
                "prodotti.prezzo, prodotti.linkfoto, prodotti.quantita " + 
                "from prodotti " + "where prodotti.seller_id = " + id;
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet set = stmt.executeQuery();
        
        while(set.next()){
                Prodotti m = new Prodotti();
                m.setId(set.getInt("id"));
                m.setNomeProdotto(set.getString("nomeProdotto"));
                m.setLinkFoto(set.getString("linkFoto"));
                m.setPrezzo(set.getDouble("prezzo"));
                m.setQuantita(set.getInt("quantita"));
                m.setDescrizione(set.getString("descrizione"));
                listaSeller.add(m);
            }
            stmt.close();
            conn.close();
            return listaSeller;
        
    }
}
