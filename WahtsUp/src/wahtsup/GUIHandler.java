/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wahtsup;

import gui.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author d.gozzi
 */
public class GUIHandler {
    
    public static GUIHandler instance = null;
    public JFrame mainFrame;
    public GUIHandler()
    {
        if(instance != null) return;
        instance = this; 
        mainFrame = new JFrame("WhatsUp");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LoadLogin();
        mainFrame.setVisible(true);
        
    }
    
    Login myLoginPanel = null;
    public  Login getLoginPanel()
    {
        if(myLoginPanel == null) myLoginPanel = new Login();
        return myLoginPanel;
    }
    
    public void LoadLogin()
    {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(getLoginPanel());
        mainFrame.pack();
    }
    
        
    Chat myChatPanel = null;
    public Chat getChatPanel()
    {
        if(myChatPanel == null) myChatPanel = new Chat();
        return myChatPanel;
    }
    public void LoadChat()
    {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(getLoginPanel());
        mainFrame.pack();
    }
    
    Entrata myEntrata = null;
    public Entrata getEntrataPanel()
    {
        if(myEntrata == null) myEntrata = new Entrata();
        return myEntrata;
    }
    public void LoadLoginRoom()
    {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(getEntrataPanel());
        mainFrame.pack();
    }

    Nuova myNuovaPanel = null;
    public Nuova getNuovaPanel()
    {
        if(myNuovaPanel == null) myNuovaPanel = new Nuova();
        return myNuovaPanel;
    }
    public void LoadNewRoomCreator() 
    {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(getNuovaPanel());
        mainFrame.pack();
    }
    
    Stanze myStanzePanel = null;
    public Stanze getStanzePanel()
    {
        if(myStanzePanel == null) myStanzePanel = new Stanze();
        return myStanzePanel;
    }
    public void LoadShowRoom()
    {
        mainFrame.getContentPane().removeAll();
        mainFrame.getContentPane().add(getStanzePanel());
        mainFrame.pack();
        getStanzePanel().AskForCreatedRooms();
    }
}
