/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wahtsup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static wahtsup.WhatsUp.socket;

/**
 *
 * @author davide
 */
public class ListenerClass extends Thread
{

    public BufferedReader listenerFromServer;
    public static ListenerClass instance = null;
    public boolean canRun = true;

    public ListenerClass()
    {
        if (instance != null)
        {
            return;
        }
        instance = this;
        try
        {
            listenerFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex)
        {
            System.out.println("Error Creating listener: " + ex);
        }
        this.start();
    }

    @Override
    public void run()
    {
        String msgFromServer;
        while (canRun)
        {
            try
            {
                msgFromServer = listenerFromServer.readLine();
                System.out.println("Msg From Server: " + msgFromServer);
                MessageHandler.instance.HandleMsg(msgFromServer);
            } catch (IOException ex)
            {
                System.out.println("Error Reading From Socket: " + ex);
            }
        }

    }

    public void StopThread()
    {
        canRun = false;
        try
        {
            listenerFromServer.close();
            this.join();
        } catch (InterruptedException ex)
        {
            System.out.println("Error closing thread: " + ex);
        } catch (IOException ex)
        {
            System.out.println("Error closing thread: " + ex);

        }
    }
}
