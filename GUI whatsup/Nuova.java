//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Nuova extends JPanel {
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JLabel jcomp3;
    private JPasswordField JTextFieldPass1;
    private JPasswordField JTextFieldPass2;
    private JTextField JTextFieldNome;
    private JLabel jcomp7;
    private JButton JButtonEsci;
    private JButton JButtonCrea;

    public Nuova() {
        //construct components
        jcomp1 = new JLabel ("Nome stanza:");
        jcomp2 = new JLabel ("Password:");
        jcomp3 = new JLabel ("Conferma password:");
        JTextFieldPass1 = new JPasswordField (5);
        JTextFieldPass2 = new JPasswordField (5);
        JTextFieldNome = new JTextField (5);
        jcomp7 = new JLabel ("Numero MAX persone");
        JButtonEsci = new JButton ("Esci");
        JButtonCrea = new JButton ("Crea");

        //adjust size and set layout
        setPreferredSize (new Dimension (301, 272));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (JTextFieldPass1);
        add (JTextFieldPass2);
        add (JTextFieldNome);
        add (jcomp7);
        add (JButtonEsci);
        add (JButtonCrea);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (70, 25, 100, 25);
        jcomp2.setBounds (85, 55, 100, 25);
        jcomp3.setBounds (25, 85, 130, 25);
        JTextFieldPass1.setBounds (160, 55, 100, 25);
        JTextFieldPass2.setBounds (160, 85, 100, 25);
        JTextFieldNome.setBounds (160, 25, 100, 25);
        jcomp7.setBounds (10, 165, 135, 25);
        JButtonEsci.setBounds (115, 235, 70, 25);
        JButtonCrea.setBounds (190, 235, 100, 25);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Nuova");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Nuova());
        frame.pack();
        frame.setVisible (true);
    }
}