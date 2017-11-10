//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.*;
import wahtsup.WriterClass;

public class Stanze extends JPanel {
    public JList jcomp1;
    public JButton JButtonNuova;
    public JButton JButtonAggiorna;
    public JButton JButtonEsci;
    public JButton JButtonPartecipa;
    public ArrayList<String> roomsList;
    public ArrayList<Integer> roomsListId;
    
    public Stanze() {
        //construct components
        roomsList = new ArrayList<String>();
        roomsListId = new ArrayList<>();
        jcomp1 = new JList<String>() ;
        JButtonNuova = new JButton ("Nuova stanza");
        JButtonAggiorna = new JButton ("Aggiorna");
        JButtonEsci = new JButton ("Esci");
        JButtonPartecipa = new JButton ("Partecipa");

        //adjust size and set layout
        setPreferredSize (new Dimension (465, 392));
        setLayout (null);

        //add components
        add (jcomp1);
        add (JButtonNuova);
        add (JButtonAggiorna);
        add (JButtonEsci);
        add (JButtonPartecipa);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (110, 20, 330, 300);
        JButtonNuova.setBounds (25, 335, 110, 25);
        JButtonAggiorna.setBounds (170, 335, 85, 25);
        JButtonEsci.setBounds (285, 335, 60, 25);
        JButtonPartecipa.setBounds (350, 335, 90, 25);
        
    }


//    public static void main (String[] args) {
//        JFrame frame = new JFrame ("Stanze");
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new Stanze());
//        frame.pack();
//        frame.setVisible (true);
//    }

    public void AskForCreatedRooms() 
    {
        WriterClass.instance.AskForAvailableRooms();
    }
    
    public void AddNewRoomToList(String roomName, int idRoom)
    {
        roomsList.add(roomName);
        roomsListId.add(idRoom);
    }
    
    public void ResetListRoom()
    {
        roomsList.clear();
        roomsListId.clear();
    }

    public void ResetJList() 
    {
        jcomp1.setListData(new Vector(0));
    }

    public void UpdateJList() 
    {
        jcomp1.setListData(roomsList.toArray());
    }
}
