/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsup;

import javax.swing.JFrame;

/**
 *
 * @author mralsi
 */
public class Whatsup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("WhatsUp");
                frame.add(new AddPanel(frame));
                
                frame.setSize(600,500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
    }
    
}
