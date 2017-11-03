/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupgui;

import java.awt.*;
import javax.swing.*;
import whatsupgui.ColorChooserButton.ColorChangedListener;

/**
 *
 * @author davide
 */
public class WhatsUpGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("WhatsUp");
        JPanel login = new JPanel(/*new GridLayout(5,2,5,5)*/);
        frame.add(login);
        //creo i vari Swing object
            JLabel centro = new JLabel ();
            JLabel nick = new JLabel("Nickname: ");
            JLabel color = new JLabel("Favorite color: ");
            color.setAlignmentX(100);
            JLabel IP = new JLabel("IP: ");
            JLabel host = new JLabel("Host: "); 
            JTextField nickField = new JTextField();
                
            JTextField IPField = new JTextField();
            JTextField hostField = new JTextField();
            JButton continua = new JButton("Continua");
            JCheckBox condizioni = new JCheckBox();
            
            ColorChooserButton colorChooser = new ColorChooserButton(Color.BLACK);
                colorChooser.addColorChangedListener(new ColorChangedListener() {
                    @Override
                    public void colorChanged(Color newColor) {
                            // do something with newColor ...
                    }
                });
            
            login.add(nick);
            login.add(nickField);
            nickField.setPreferredSize(new Dimension(200, 40));
            login.add(color);
            
            login.add(colorChooser);
            login.add(IP);
            login.add(IPField);
            IPField.setPreferredSize(new Dimension(200, 40));
            login.add(host);
            login.add(hostField);
            hostField.setPreferredSize(new Dimension(200, 40));
            login.add(continua);
            login.add(condizioni);

         
        frame.setSize(650, 650);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
                
                
    }
    
}
