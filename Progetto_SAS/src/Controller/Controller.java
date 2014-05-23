/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import Db.DbConnect;
import java.util.Vector;
/**
 *
 * @author MASTER
 */
public class Controller {
    
    public void registra(String username, String password){
        DbConnect db = new DbConnect("cryptoHelper", "root", "root");
        if (!db.connetti()) {
            System.out.println("Errore durante la connessione.");
            System.out.println(db.getErrore());
            System.exit(0);
        }

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
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`user` (`id`, `username`, `password`, `nome`, `cognome`) VALUES (NULL, '" +username+"', '"+password+"', NULL, NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
        }

        // Ora chiudo la connessione col Database:
        db.disconnetti();
    }
}
