/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wahtsup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d.gozzi
 */
public class WhatsUp {

    /**
     * @param args the command line arguments
     */
    public static Socket socket;
    
    public static boolean InputFromConsole = true;
    
    public static void main(String[] args) {
        if(InputFromConsole)
        {
            try 
            {
                // TODO code application logic here
                BufferedReader inputKeyboard = new BufferedReader(new InputStreamReader(System.in));
                new WriterClass();
                new ListenerClass();
                new MessageHandler();
                while (true)
                {                

                    String userInput = inputKeyboard.readLine();
                    WriterClass.instance.WriteToServer(userInput);

                }


            } 
            catch (IOException ex) 
            {
                Logger.getLogger(WhatsUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static void SetSocketParameter(String address)
    {
        try 
        {
            socket = new Socket(InetAddress.getByName(address),1050);
        } 
        catch (IOException ex) 
        {
            System.out.println("Error creating Socket: " + ex);
        }

    }
    
}
