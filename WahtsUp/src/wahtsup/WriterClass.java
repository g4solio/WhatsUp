/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wahtsup;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static wahtsup.WhatsUp.socket;

/**
 *
 * @author davide
 */
public class WriterClass
{

    public PrintWriter writerToServer;
    public static WriterClass instance = null;

    public WriterClass()
    {
        if (instance != null)
        {
            return;
        }
        instance = this;
        try
        {
            writerToServer = new PrintWriter(new OutputStreamWriter(WhatsUp.socket.getOutputStream()));

        } catch (IOException ex)
        {
            System.out.println("Error Instantiatoing the writer: " + ex);
        }
    }

    public void WriteToServer(String msg)
    {
        writerToServer.println(msg);
        writerToServer.flush();

    }
    
    public void WriteComunication(String msgToSend)
    {
        WriteToServer("<Communication>" + msgToSend);
    }

    public void PresentateMySelf(String nickname, Color color)
    {
        WriteToServer("<Settings>Presentation:" + nickname + ":" + color.getRGB());
    }

    public void RemoveMeFromRoom()
    {
        WriteToServer("<Settings>RemoveMeFromRoom");
    }

    public void AddMeToRoom(int idRoom, String passwordRoom)
    {
        WriteToServer("<Settings>AddMeToRoom:" + idRoom + ":" + passwordRoom);
    }

    public void CreateARoom(String nameRoom, String password, int numeroMax)
    {
        WriteToServer("<Settings>CreateARoom:" + nameRoom + ":" + password + ":" + numeroMax);
    }

    public void Disconnecting()
    {
        WriteToServer("<Settings>Disconnecting");
    }

    public void AskForPeopleInRoom()
    {
        WriteToServer("<Settings>PeopleInRoom");
    }

    public void AskForAvailableRooms()
    {
        WriteToServer("<Settings>ListOfRooms");
    }

}
