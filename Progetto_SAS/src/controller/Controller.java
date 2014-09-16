/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import model.Proposta;
//import Clmodelession;
//import Clasmodeldente;
//import Classemodelnfo;
import db.DbManager;
import java.util.Vector;
import model.Session;
import model.Studente;
/**
 *
 * @author MASTER
 */
public class Controller {
    
    public static DbManager connect(){
        DbManager db = new DbManager("cryptohelper", "root", "root");
        if (!db.connetti()) {
            System.out.println("Errore durante la connessione.");
            System.out.println(db.getErrore());
            System.exit(0);
        }
        return db;
    }
    
    
    
    /*public static boolean inserisciProposta(UserInfo user, UserInfo partner, String sdc){
        DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`proposta` (`id`, `id_mittente`, `id_destinatario`, `metodo_cifratura`, `stato`, `notificata`) VALUES (NULL, '" +user.getId()+"', '"+partner.getId()+"', '" + sdc + "', 'in attesa', NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        
        return true;
    }*/
    
    public static boolean accettaProposta(Proposta p){
        DbManager db = connect();
        if (!db.eseguiAggiornamento("UPDATE `cryptohelper`.`proposta` SET `stato` = 'accettata' WHERE `proposta`.`id` = " + p.getId())) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        return true;
    }
    
    public static boolean rifiutaProposta(Proposta p){
        DbManager db = connect();
        if (!db.eseguiAggiornamento("UPDATE `cryptohelper`.`proposta` SET `stato` = 'rifiutata' WHERE `proposta`.`id` = " + p.getId())) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        return true;
    }
    
    /*public static boolean nuovoMessaggio(String id_destinatario){
        DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`messaggio` (`id`, `id_mittente`, `id_destinatario`, `metodo_cifratura`, `stato`, `notificata`) VALUES (NULL, '" +user.getId()+"', '"+partner.getId()+"', '" + sdc + "', 'in attesa', NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        
        return true;
    }*/
    
    
    
    
    public static Studente[] recuperaUtenti(){
        DbManager db = connect();
        Vector v = db.eseguiQuery("SELECT * FROM user where username <> '" + Session.getLoggedUser() + "'");
        Studente[] s = new Studente[v.size()];
        for(int i = 0; i<v.size(); i++){
            //System.out.println(((String[])v.elementAt(i))[0]);
            String id = ((String[])v.elementAt(i))[0];
            //int id = Integer.parseInt(stringa);
            s[i] = new Studente(id, ((String[])v.elementAt(i))[1]);
        }
        return s;
    }
}
