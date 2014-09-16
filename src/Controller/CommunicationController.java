/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.Messaggio;
import Classes.Proposta;
import Classes.PropostaConfermata;
import Classes.Studente;
import Classes.UserInfo;
import Db.DbManager;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author MASTER
 */
public class CommunicationController extends Controller{
    public static boolean inviaProposta(int id_user, int id_partner, String sdc){ //invio della proposta di cifratura
        Proposta p = new Proposta(0, new UserInfo(id_user), new UserInfo(id_partner), sdc);
        p.inserisciProposta();
        return true;
    }
    
    public static Proposta[] getProposte(int id_user){ //proposte pendenti
        DbManager db = connect();
        Proposta[] p;
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`proposta` WHERE id_destinatario = " + id_user + " && stato = 'in attesa'");
        if(v.size()<= 0) return new Proposta[0];
        else{
            p = new Proposta[v.size()];
            for(int i = 0; i < v.size(); i++){
                p[i] = new Proposta(Integer.parseInt(((String[])v.elementAt(i))[0]), new UserInfo(Integer.parseInt(((String[])v.elementAt(i))[1])), new UserInfo(Integer.parseInt(((String[])v.elementAt(i))[2])), ((String[])v.elementAt(i))[3]);
            }
            return p;
        }
    }
    
    public static PropostaConfermata[] getProposteAccettate(int id_user){ //proposte pendenti
        DbManager db = connect();
        PropostaConfermata[] p;
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`proposta` WHERE id_destinatario = " + id_user + " && stato = 'accettata'");
        if(v.size()<= 0) return new PropostaConfermata[0];
        else{
            p = new PropostaConfermata[v.size()];
            for(int i = 0; i < v.size(); i++){
                p[i] = new PropostaConfermata(Integer.parseInt(((String[])v.elementAt(i))[0]), new UserInfo(Integer.parseInt(((String[])v.elementAt(i))[1])), new UserInfo(Integer.parseInt(((String[])v.elementAt(i))[2])), ((String[])v.elementAt(i))[3]);
            }
            return p;
        }
    }
    
    public static boolean inviaDecisione(Proposta p, String decisione){
        if(decisione.equals("accettata"))
            p.accetta();
        else p.rifiuta();
        return true;
    }
    
    public boolean getAccettazione(String user){
        return true;
    }
    
    public Studente[] getDestinatari(){
        return new Studente[4];
    }
    
    public boolean send(Messaggio m){
        return true;
    }
    
    public Messaggio apriMessaggioRicevuto(int id){
        return new Messaggio();
    }
    
}
