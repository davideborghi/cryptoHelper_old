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
public class UserInfo {
    private String id;
    private String username, nome, cognome;
    
    public UserInfo(String id){
        this.id = id;
        DbManager db = connect();
        Vector v = db.eseguiQuery("SELECT * FROM `cryptohelper`.`user` WHERE id = '" + id + "'");
        this.username = ((String[]) v.elementAt(0))[1];
        this.nome = ((String[])v.elementAt(0))[3];
        this.cognome = ((String[]) v.elementAt(0))[4];
        
    }
    
    public UserInfo(String id, String user){
        this.id = id;
        this.username = user;
    }
    
    public String getId(){
        return this.id;
    }
}
