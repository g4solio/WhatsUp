/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.util.List;
import java.util.Random;

/**
 *
 * @author d.gozzi
 */
public class WhatsUpServer {

    /**
     * @param args the command line arguments
     */
    
    public static List<Room> RoomsList;
    
    static Random myRandom = null;
    
    public static Random getRandomClass()
    {
        if(myRandom == null) myRandom = new Random();
        return myRandom;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        
        
        
    }
    
    
    
    public static int AddClientToRoom(ConnectedClient client, int idRoom, String password)
    {
        for (Room room : RoomsList) {
           if(room.id != idRoom) continue;
           return room.AcceptConnectionByClient(client, password);
        }
        return 3;
    }
    
    public static int CreateRoom(ConnectedClient client, String nameRoom, String password, int numeroMax)
    {
        int idRoom = CreateIdRoom();
        RoomsList.add(new Room(nameRoom, idRoom, numeroMax, password));
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
        return randomNumber;   
    }
}
