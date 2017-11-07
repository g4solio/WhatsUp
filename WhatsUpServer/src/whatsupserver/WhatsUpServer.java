/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d.gozzi
 */
public class WhatsUpServer {

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Room> RoomsList;
    
    static Random myRandom = null;
    
    public static Random getRandomClass()
    {
        if(myRandom == null) myRandom = new Random();
        return myRandom;
    }
    
    public static void main(String[] args) {
        new ClientListenerMessageHandler();
        new ClientSpeaker();
        RoomsList = new ArrayList<Room>();
        try
        {
            // TODO code application logic here
            ServerSocket serverSocket = new ServerSocket(1050);
            System.out.println("Server Has Been Started");
            while(true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("A new Connection has been accepted");
                new ConnectedClient(socket);
            }
            
        } catch (IOException ex)
        {
            System.out.println("error Starting Server " + ex);
        }
    }
    
    
    
    public static int AddClientToRoom(ConnectedClient client, int idRoom, String password)
    {
        for (Room room : RoomsList) 
        {
            System.out.println(room.id + " == " + idRoom);
           if(room.id != idRoom) continue;
           return room.AcceptConnectionByClient(client, password);
        }
        return 3;
    }
    
    public static int CreateRoom(ConnectedClient client, String nameRoom, String password, int numeroMax)
    {
        int idRoom = CreateIdRoom();
        RoomsList.add(new Room(nameRoom, numeroMax, idRoom, password));
        AddClientToRoom(client, idRoom, password);
        return 0;
    }

    private static int CreateIdRoom() 
    {
        int bound = 100 + RoomsList.size();
        int randomNumber;
        mainLoop : while (true) 
        {            
            randomNumber = getRandomClass().nextInt(bound);
            for (Room room : RoomsList)
            {
                if(room.id == randomNumber) continue mainLoop;
            }
            break;
        }
        System.out.println("Random Number : " + randomNumber);
        return randomNumber;   
    }
    
    public static void RemoveRoom(int idRoom)
    {
        for (Room room : RoomsList) 
        {
            if(room.id != idRoom) continue;
            RoomsList.remove(room);
            return;
        }
    }
}
