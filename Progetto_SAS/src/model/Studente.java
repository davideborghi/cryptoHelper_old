/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import static controller.Controller.connect;
import db.DbManager;
import java.util.Vector;

/**
 *
 * @author MASTER
 */
public class Studente {
    private String nome;
    private String cognome;
    private String id;
    private String login;
    private String pwd;
    
    public Studente(String user){
        this.login = user;
    }
    
    public Studente(String id, String user){
        this.id = id;
        this.login = user;
    }
    
    public Studente(String nome, String cognome, String id, String user, String password){
        this.login = user;
        this.pwd = password;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }
    
    public Studente(String user, String password, boolean b){
        this.login = user;
        this.pwd = password;
    }
    
    public boolean login(){
        DbManager db = connect();
        System.out.println(login + " " + pwd);
        Vector v = db.eseguiQuery("SELECT * FROM user WHERE username = '"+this.login+"' and password = '"+this.pwd+"';");
        if(v.size() <= 0) return false;
        String s = ((String[])v.elementAt(0))[0];
        this.id = s;
        return true;
    }
    
    public void registra(){
        
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
        if (!db.eseguiAggiornamento("INSERT INTO `cryptohelper`.`user` (`username`, `password`, `nome`, `cognome`) VALUES ('" +this.login+"', '"+this.pwd+"', NULL, NULL);")) {
            System.out.println("Errore nell'aggiornamento!");
            System.out.println(db.getErrore());
        }

        // Ora chiudo la connessione col Database:
        db.disconnetti();
    }
    
    public String getId(){
        return this.id;
    }
    
    public String toString(){
        return this.login;
    }
}
