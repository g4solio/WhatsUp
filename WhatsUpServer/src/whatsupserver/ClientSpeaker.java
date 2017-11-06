/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.io.PrintWriter;
import java.net.ServerSocket;

/**
 *
 * @author d.gozzi
 */
public class ClientSpeaker {
    
    public static ClientSpeaker instance = null;
    
    public ClientSpeaker()
    {
        if(instance != null) return;
        instance = this;
    }
    
    public void SendMsgToClient(PrintWriter clientChannel, String msg)
    {
        clientChannel.println(msg);
        clientChannel.flush();
    }
    
    
}
