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
public class Cliente extends Utenti{
    
    protected ArrayList<Prodotti> listaAcquisti = new ArrayList<Prodotti>(); 
    
    public Cliente() {
        super();
    }
    
}
