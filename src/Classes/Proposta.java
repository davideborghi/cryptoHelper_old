/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import Controller.Controller;

/**
 *
 * @author MASTER
 */
public class Proposta {
    protected int id;
    protected UserInfo proponente, partner;
    protected String sdc, stato;
    protected boolean notificata;
    
    public Proposta(int id, UserInfo proponente, UserInfo partner, String sdc){
        this.id = id;
        this.proponente = proponente;
        this.partner = partner;
        this.sdc = sdc;
        this.stato = "in attesa";
    }
    
    public Proposta(){
        /*query result*/
    }
    
    public UserInfo getPartner(){
        return this.partner;
    }
    
    public boolean inserisciProposta(){
        return Controller.inserisciProposta(new UserInfo(proponente.getId()), new UserInfo(partner.getId()), sdc);
    }
    
    public boolean accetta(){
        return Controller.accettaProposta(this);
    }
    
    public boolean rifiuta(){
        return Controller.rifiutaProposta(this);
    }
    
    public static void load(int id){
        
    }
    
    public  static void caricaAttiva(int idProp, int idPartner){
        
    }
    
    public int getId(){
        return this.id;
    }
    
    public String toString(){
        return "Utente con id " + proponente.getId() + " vuole scambiare un messaggio utilizzando " + sdc;
    }
    
}
