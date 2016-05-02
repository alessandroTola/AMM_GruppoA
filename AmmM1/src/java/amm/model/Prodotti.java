/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.model;

/**
 *
 * @author alessandrotola
 */
public class Prodotti {
    
    protected int id;
    protected String nomeProdotto;
    protected String descrizione;
    protected String linkFoto;
    protected Double prezzo;
    protected int quantita;

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeProdotto
     */
    public String getNomeProdotto() {
        return nomeProdotto;
    }

    /**
     * @param nomeProdotto the nomeProdotto to set
     */
    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    /**
     * @return the linkFoto
     */
    public String getLinkFoto() {
        return linkFoto;
    }

    /**
     * @param linkFoto the linkFoto to set
     */
    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    /**
     * @return the prezzo
     */
    public Double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the quantita
     */
    public int getQuantita() {
        return quantita;
    }

    /**
     * @param quantita the quantita to set
     */
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    
}
