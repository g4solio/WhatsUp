/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.util.List;

/**
 *
 * @author d.gozzi
 */
public class WhatsUpServer {

    /**
     * @param args the command line arguments
     */
    
    public static List<Room> RoomsList;
    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static int AddClientToRoom(ConnectedClient client, int idRoom, String password)
    {
        for (Room room : RoomsList) {
           if(room.id != idRoom) continue;
           return room.AcceptConnectionByClient(client, password);
        }
        return 2;
    }
    
    public static int CreateRoom(ConnectedClient client, String nameRoom, String password, int numeroMax)
    {
        RoomsList.add(new Room(nameRoom, CreateIdRoom(), numeroMax, password));
        return 0;
    }

    private static int CreateIdRoom() 
    {
        while (true) 
        {            
        
            //generate Id;
            
        }
   
    }
}
