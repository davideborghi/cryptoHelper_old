/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author MASTER
 */
public class PropostaConfermata extends Proposta{
    
    public PropostaConfermata(int id, UserInfo proponente, UserInfo partner, String sdc){
        this.id = id;
        this.proponente = proponente;
        this.partner = partner;
        this.sdc = sdc;
        this.stato = "in attesa";
    }
    
    
    public String toString(){
        return "Invia messaggio a " + this.partner.getId() + " utilizzando " + this.sdc;
    }
}
