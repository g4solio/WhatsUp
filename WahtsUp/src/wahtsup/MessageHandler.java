/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wahtsup;

/**
 *
 * @author daddi
 */
public class MessageHandler
{

    public static MessageHandler instance = null;

    public MessageHandler()
    {
        if (instance != null)
        {
            return;
        }
        instance = this;
    }

    public void HandleMsg(String msg)
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
            //HandleTheComunication
        }
        if (tipeOfMessage.contains("Settings"))
        {
            if(message.contains("AcceptedToRoom"))
            {
                //HandleAcceptation
                return;
            }
            if(message.contains("NotAcceptedToRoom"))
            {
                String[] metaMessage = message.split(":");
                System.out.println("Cannot connect to the room: " + metaMessage[1]);
                //HandleNotAcceptation
                return;
            }
            if(message.contains("RefreshList"))
            {
                WriterClass.instance.WriteToServer("<Settings>PeopleInRoom");
                return;
            }
            if(message.contains("PeopleInRoom"))
            {
                String[] metaMessage = message.split(":");
                for (int i = 1; i < metaMessage.length; i++)
                {
                    System.out.println(metaMessage[i] + " is in my room");
                    //Handle People In Room
                }
                return;
            } 
            if(message.contains("AvailableRooms"))
            {
                String[] metaMessage = message.split(":");
                for (int i = 1; i < metaMessage.length; i+=2)
                {
                    System.out.println(metaMessage[i] + " is an available room with this id: " + metaMessage[i+1]);
                    //Handle available room
                }
                return;
            } 
        }
        return;
    }
}

    
