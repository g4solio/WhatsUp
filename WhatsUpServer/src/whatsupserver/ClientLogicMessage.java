/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatsupserver;

/**
 *
 * @author davide
 */
public class ClientLogicMessage 
{
    public static ClientLogicMessage instance = null;
    
    public ClientLogicMessage()
    {
        if(instance != null) return;
        instance = this;
    }
    
    
    
}
