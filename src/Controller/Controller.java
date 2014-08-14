/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Classes.Proposta;
import Classes.Session;
import Classes.Studente;
import Classes.UserInfo;
import Db.DbManager;
import java.util.Vector;
/**
 *
 * @author MASTER
 */
public class Controller {
    
    public static DbManager connect(){
        DbManager db = new DbManager("cryptoHelper", "root", "root");
        if (!db.connetti()) {
            System.out.println("Errore durante la connessione.");
            System.out.println(db.getErrore());
            System.exit(0);
        }
        return db;
    }
    
    public static void registra(String username, String password){
        
        DbManager db = connect();
        // Eseguo una query sul database. La tabella si chiama Tbl.
        //Vector v = db.eseguiQuery("SELECT * FROM user;");

        // Stampiamo i risultati:
        /*int i = 0;
        while (i < v.size()) {
            String[] record = (String[]) v.elementAt(i);
            System.out.println("Record numero " + (i + 1));
            for (int j = 0; j < record.length; j++) {
                System.out.println(record[j]);
            }
            i++;
        }*/

        // Eseguo un aggiornamento sul campo 'nomecampo' della tabella Tbl:
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`user` (`username`, `password`, `nome`, `cognome`) VALUES ('" +username+"', '"+password+"', NULL, NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
        }

        // Ora chiudo la connessione col Database:
        db.disconnetti();
    }
    
    public static boolean inserisciProposta(UserInfo user, UserInfo partner, String sdc){
        DbManager db = connect();
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`proposta` (`id`, `id_mittente`, `id_destinatario`, `metodo_cifratura`, `stato`, `notificata`) VALUES (NULL, '" +user.getId()+"', '"+partner.getId()+"', '" + sdc + "', 'in attesa', NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
            return false;
        }
        
        return true;
    }
    
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
    
    
    public static Studente login(String username, String password){
        DbManager db = connect();
        Vector v = db.eseguiQuery("SELECT * FROM user WHERE username = '"+username+"' and password = '"+password+"';");
        if(v.size() <= 0) return new Studente("NO_USER");
        String s = ((String[])v.elementAt(0))[0];
        int id = Integer.parseInt(s);
        return new Studente(id,((String[])v.elementAt(0))[1]);
    }
    
    public static Studente[] recuperaUtenti(){
        DbManager db = connect();
        Vector v = db.eseguiQuery("SELECT * FROM user where username <> '" + Session.getLoggedUser() + "'");
        Studente[] s = new Studente[v.size()];
        for(int i = 0; i<v.size(); i++){
            //System.out.println(((String[])v.elementAt(i))[0]);
            String stringa = ((String[])v.elementAt(i))[0];
            int id = Integer.parseInt(stringa);
            s[i] = new Studente(id, ((String[])v.elementAt(i))[1]);
        }
        return s;
    }
}
