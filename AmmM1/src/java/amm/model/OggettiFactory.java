/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

import java.util.ArrayList;

/**
 *
 * @author alessandrotola
 */
public class OggettiFactory {
    // Attributi
    private static OggettiFactory singleton;
    public static OggettiFactory getInstance() {
        if (singleton == null) {
            singleton = new OggettiFactory();
        }
        return singleton;
    }
    // Lista Prodotti
    private ArrayList<Prodotti> listaProdotti = new ArrayList<Prodotti>();
    
    public OggettiFactory() {
        
        //Prodotto 1
        Prodotti product_1 = new Prodotti();
        product_1.setNomeProdotto("GT Force");
        product_1.setPrezzo(4000.00);
        product_1.setLinkFoto("Immagini/gtforce.jpg");
        product_1.setQuantita(2);
        product_1.setDescrizione("force gt carbon");
        product_1.setId(10);
        listaProdotti.add(product_1);
        
        //Prodotto 2
        Prodotti product_2 = new Prodotti();
        product_2.setNomeProdotto("Casco Fox");
        product_2.setPrezzo(159.00);
        product_2.setLinkFoto("Immagini/casco.jpg");
        product_2.setQuantita(5);
        product_2.setDescrizione("casco fox rampage");
        product_2.setId(11);
        listaProdotti.add(product_2);
        
        //Prodotto 3
        Prodotti product_3 = new Prodotti();
        product_3.setNomeProdotto("Maglia FOX");
        product_3.setPrezzo(59.00);
        product_3.setLinkFoto("Immagini/fox.jpg");
        product_3.setQuantita(10);
        product_3.setDescrizione("Maglia demo Fox");
        product_3.setId(12);
        listaProdotti.add(product_3);
        
        //Prodotto 4
        Prodotti product_4 = new Prodotti();
        product_4.setNomeProdotto("Pantalone FOX");
        product_4.setPrezzo(99.00);
        product_4.setLinkFoto("Immagini/pantalone.png");
        product_4.setQuantita(3);
        product_4.setDescrizione("Pantalone demo Fox");
        product_4.setId(13);
        listaProdotti.add(product_4);
        
        //Prodotto 5
        Prodotti product_5 = new Prodotti();
        product_5.setNomeProdotto("Guanti FOX");
        product_5.setPrezzo(39.00);
        product_5.setLinkFoto("Immagini/guanti.jpg");
        product_5.setQuantita(7);
        product_5.setDescrizione("Guanti Fox");
        product_5.setId(12);
        listaProdotti.add(product_5);
              
    }
    
    public ArrayList<Prodotti> getProdottiList() {
        return listaProdotti;
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
    
    
    
}
