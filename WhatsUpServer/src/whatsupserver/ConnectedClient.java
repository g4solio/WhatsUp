/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davide
 */
public class ConnectedClient extends Thread
{
    
    public String ip;
    public String nickname;
    public Room roomConnected = null;
    public Color color;
    public Socket socket;
    public PrintWriter clientWriter;
    public BufferedReader clientListener;
    public volatile boolean HasToBeStopped = false;
    public ConnectedClient(Socket clientSocket) throws IOException
    {
        socket = clientSocket;
        clientWriter=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        clientListener = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
        String socketInput;
        while (!HasToBeStopped) 
        {            
            try 
            {
                System.out.println("Cycle " + HasToBeStopped);
                socketInput = clientListener.readLine();
                System.out.println("Msg To be Handled: " + socketInput);
                ClientListenerMessageHandler.instance.HandleMsg(this, socketInput);
            
            } catch (IOException ex) 
            {
                System.out.println("Error reading the socket " + ex);
            }
             
        }
    }
    
    public void Disconnect()
    {
        try
        {
            System.out.println("Disconnecting");
            socket.close();
            if(roomConnected != null)roomConnected.RemoveClientFromRoom(this);
            HasToBeStopped = true;
            clientWriter.close();
            clientListener.close();
            this.join();
            
        } catch (IOException ex)
        {
            System.out.println("Error disconnect client " + ex);
        } catch (InterruptedException ex)
        {
            System.out.println("Error disconnect client " + ex);
        }
        return;
    }
}
