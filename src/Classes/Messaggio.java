/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

import java.awt.List;

/**
 *
 * @author MASTER
 */
public class Messaggio implements MessaggioMittente, MessaggioDestinatario{
    private int id;
    private UserInfo mittente, destinatario;
    private SistemaCifratura sdc;
    private String testo, testoCifrato, lingua, titolo;
    private boolean bozza, letto;
    
    public Messaggio(){
        /*QUERY RESULT*/
    }
    
    public static Messaggio load(int id){
        return new Messaggio();
    }//carica il messaggio
    
    public static List caricaIniviati(Studente s){
        return new List();
    }
    
    public static List caricaBozze(Studente s){
        return new List();
    }
    
    public static List caricaRicevuti(Studente s){
        return new List();
    }
    
    public boolean elimina(){
        return true;
    }
    
    public boolean salva(){
        return true;
    }
    
    public void cifra(){
        
    }
    
    public boolean isBozza(){
        return true;
    }
    
    public boolean save(){
        return true;
    }
    
    public boolean isLetto(){
        return true;
    }
    
}
