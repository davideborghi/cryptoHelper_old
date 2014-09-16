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
public class UserInfo {
    private int id;
    private String username, nome, cognome;
    
    public UserInfo(int id){
        this.id = id;
    }
    
    public UserInfo(int id, String user){
        this.id = id;
        this.username = user;
    }
    
    public int getId(){
        return this.id;
    }
}
