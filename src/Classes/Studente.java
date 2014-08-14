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
public class Studente {
    private String nome;
    private String cognome;
    private int id;
    private String login;
    private String pwd;
    
    public Studente(String user){
        this.login = user;
    }
    
    public Studente(int id, String user){
        this.id = id;
        this.login = user;
    }
    
    public Studente(String nome, String cognome, int id, String user, String password){
        this.login = user;
        this.pwd = password;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String toString(){
        return this.login;
    }
}
