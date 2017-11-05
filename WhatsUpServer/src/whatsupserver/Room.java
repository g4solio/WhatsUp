/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.util.List;

/**
 *
 * @author davide
 */
//C'è troppa luce
public class Room
{

    public String name;
    public String password;
    public int id;
    public List<ConnectedClient> clients;
    public int maxClients;

    public Room(String nameRoom, int maxClientsRoom, int idRoom, String passwordRoom)
    {

        name = nameRoom;
        maxClients = maxClientsRoom;
        id = idRoom;
        password = passwordRoom;

    }

    //1----> Problem Login
    //0----> ClientAccepted
    public int AcceptConnectionByClient(ConnectedClient client, String digitatedPassword)
    {
        if (digitatedPassword.equals(password) && !(password.equals("")))
        {
            return 1;
        }
        if (clients.size() >= maxClients)
        {
            return 2;
        }
        clients.add(client);
        client.roomConnected = this;
        SendSettingsMsgToAllClients("RefreshList");
        return 0;
    }

    public void RemoveClientFromRoom(ConnectedClient client)
    {
        client.roomConnected = null;
        clients.remove(client);
        SendSettingsMsgToAllClients("RefreshList");
    }

    public void SendMsgToAllClients(String message, ConnectedClient emitter)
    {
        //Send The Msg
        message = "<Communication>" + emitter.nickname + ":" + emitter.color + ":" + message;
        for (ConnectedClient client : clients)
        {
            ClientSpeaker.instance.SendMsgToClient(client.clientWriter, message);
        }
    }

    public void SendSettingsMsgToAllClients(String message)
    {
        message = "<Settings>" + message;
        for (ConnectedClient client : clients)
        {
            ClientSpeaker.instance.SendMsgToClient(client.clientWriter, message);
        }
    }

}
