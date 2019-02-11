/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.Sockets;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author 2098325
 */
public class ClientSock {
    
    public ClientSock(){
    
    }
    public static java.net.Socket getNewClientSock(java.net.ServerSocket sc){
        Socket clientSock =null;
        try{
            System.out.println("lISTO para recibir  ");
            clientSock=sc.accept();
        
        }catch(IOException E){
            System.err.println("Accept failed.");
            System.exit(1);
        
        
        }
    
    return clientSock;
    }
    
}
