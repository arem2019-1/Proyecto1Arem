/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.HttpWebServer;

import co.edu.escuelaing.arep.Sockets.ClientSock;
import co.edu.escuelaing.arep.Sockets.ServerSock;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2098325
 */
public class HttpServer {
    private static InputRead go;
    public static void main(String[] args) throws IOException{
        while(true){
            try(
                    
                    ServerSocket serverSocket= co.edu.escuelaing.arep.Sockets.ServerSock.getNewServerSocket();
                    Socket  clientSoc=ClientSock.getNewClientSock(serverSocket)){
                InputRead go =new InputRead(clientSoc);
                ResourceWriter rw = new ResourceWriter(go.getRecurso(),clientSoc);
                go.closeIn();
            
            }       
        }  
    }
    public static void close() throws IOException{
       go.closeIn();
    }
    
}
