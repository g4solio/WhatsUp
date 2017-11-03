/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

/**
 *
 * @author d.gozzi
 */
public class ClientListenerMessageHandler 
{

    public static ClientListenerMessageHandler instance = null;
    
    public ClientListenerMessageHandler()
    {
        if(instance != null) return;
        instance = this;
    }
    
    public void HandleMsg(ConnectedClient client, String msg)
    {
        String[]splittedMsg = msg.split(">", 2);

        String tipeOfMessage = splittedMsg[0];
        String message = splittedMsg[1];
        if(tipeOfMessage.contains("Communication"))
        {
            client.roomConnected.SendMsgToAllClients(message, client);
            return;
        }
        if(tipeOfMessage.contains("Settings"))
        {
            if(message.equals("RemoveMeFromRoom"))
            {
                client.roomConnected.RemoveClientFromRoom(client);
                return;
            }
            if(message.contains("AddMeToRoom"))
            {
                String[] metaMessage = message.split(":");
                int success = WhatsUpServer.AddClientToRoom(client, Integer.parseInt(metaMessage[1]), metaMessage[2]);
                if(success == 0)
                {
                    ClientSpeaker.instance.SendMsgToClient(client.clientWriter, "<Settings>AcceptedToRoom");
                }
                //finire If Statemente guardare file "TipeOfMessage"
                return;
            }
            if(message.contains("CreateARoom"))
            {
                
            }
        }
        
    }
    
}
