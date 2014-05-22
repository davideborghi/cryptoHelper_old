/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package progetto_sas;
import javax.swing.JFrame;
import progetto_sas.GUI.*;

/**
 *
 * @author MASTER
 */
public class Progetto_SAS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login l = new Login();
        l.setVisible(true);
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
