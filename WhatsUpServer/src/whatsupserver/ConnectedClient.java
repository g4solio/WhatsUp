/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.awt.Color;
import java.net.ServerSocket;

/**
 *
 * @author davide
 */
public class ConnectedClient extends Thread
{
    
    public String ip;
    public String nickname;
    public Room roomConnected;
    public Color color;
    public ServerSocket socket;
    
    public ConnectedClient(ServerSocket clientSocket)
    {
        socket = clientSocket;
        this.start();

    }
    
    public void SetUpClient(String ipClient, String nicknameClient, Color colorClient)
    {
        ip = ipClient;
        nickname = nicknameClient;
        color = colorClient;
    }
    
    
    @Override
    public void run()
    {
       
    }
    
}
