/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.Sockets;

import java.io.IOException;

/**
 *
 * @author 2098325
 */
public class ServerSock {
    
    public ServerSock (){}
        public static java.net.ServerSocket getNewServerSocket(){
        java.net.ServerSocket serverSocket = null;
        try {
            serverSocket = new java.net.ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("No se pueed saber el puerto :"+getPort()+".");
            System.exit(1);
        }
        return serverSocket;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; 
    }
    
}
