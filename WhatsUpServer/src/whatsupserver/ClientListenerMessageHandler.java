/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

import java.awt.Color;

/**
 *
 * @author d.gozzi
 */
public class ClientListenerMessageHandler
{

    public static ClientListenerMessageHandler instance = null;

    public ClientListenerMessageHandler()
    {
        if (instance != null)
        {
            return;
        }
        instance = this;
    }

    public void HandleMsg(ConnectedClient client, String msg)
    {
        if (msg.equals("") || msg.equals(" ") || msg == null)
        {
            return;
        }
        System.out.println("Handling msg: " + msg);
        String[] splittedMsg = msg.split(">", 2);

        String tipeOfMessage = splittedMsg[0];
        String message = splittedMsg[1];
        if (tipeOfMessage.contains("Communication"))
        {
            if (client.roomConnected == null)
            {
                System.out.println("That sould never happen");
            }
            client.roomConnected.SendMsgToAllClients(message, client);
            return;
        }
        if (tipeOfMessage.contains("Settings"))
        {
            if (message.equals("RemoveMeFromRoom"))
            {
                client.roomConnected.RemoveClientFromRoom(client);

                return;
            }
            if (message.contains("AddMeToRoom"))
            {
                String[] metaMessage = message.split(":");
                int success;
                if(metaMessage.length < 3) { success = WhatsUpServer.AddClientToRoom(client, Integer.parseInt(metaMessage[1]), ""); }
                else { success = WhatsUpServer.AddClientToRoom(client, Integer.parseInt(metaMessage[1]), metaMessage[2]); } 
                if (success == 0)
                {
                    ClientSpeaker.instance.SendMsgToClient(client.clientWriter, "<Settings>AcceptedToRoom");
                    return;
                }
                if (success == 1)
                {
                    ClientSpeaker.instance.SendMsgToClient(client.clientWriter, "<Settings>NotAcceptedToRoom:WrongPassword");
                    return;
                }
                if (success == 2)
                {
                    ClientSpeaker.instance.SendMsgToClient(client.clientWriter, "<Settings>NotAcceptedToRoom:TooManyUsers");
                    return;
                }
                if (success == 3)
                {
                    ClientSpeaker.instance.SendMsgToClient(client.clientWriter, "<Settings>NotAcceptedToRoom:RoomNotFound");
                    return;
                }
                //finire If Statemente guardare file "TipeOfMessage"
                return;
            }
            if (message.contains("CreateARoom"))
            {
                String[] metaMessage = message.split(":");
                int success = WhatsUpServer.CreateRoom(client, metaMessage[1], metaMessage[2], Integer.parseInt(metaMessage[3]));
                ClientSpeaker.instance.SendMsgToClient(client.clientWriter, "<Settings>AcceptedToRoom");
                return;
            }
            if (message.contains("Disconnecting"))
            {
                client.Disconnect();
                return;
            }
            if (message.contains("PeopleInRoom"))
            {
                String peopleInRoom = "<Settings>PeopleInRoom";
                for (ConnectedClient clientInRoom : client.roomConnected.clients)
                {
                    peopleInRoom += ":" + clientInRoom.nickname;
                }
                ClientSpeaker.instance.SendMsgToClient(client.clientWriter, peopleInRoom);
                return;
            }
            if (message.contains("ListOfRooms"))
            {
                String availableRooms = "<Settings>AvailableRooms";
                for (Room availableRoom : WhatsUpServer.RoomsList)
                {
                    availableRooms += ":" + availableRoom.name + ":" + availableRoom.id;
                }
                ClientSpeaker.instance.SendMsgToClient(client.clientWriter, availableRooms);
                return;
            }
            if (message.contains("Presentation"))
            {
                String[] metaMessage = message.split(":");
                client.SetUpClient(client.socket.getInetAddress().toString(), metaMessage[1], new Color(Integer.parseInt(metaMessage[2])));
                return;
            }
        }

    }

}
