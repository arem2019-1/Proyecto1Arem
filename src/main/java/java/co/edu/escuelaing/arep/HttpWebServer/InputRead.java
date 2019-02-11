/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.HttpWebServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author 2098325
 */
public class InputRead {

    private String recurso = "";
    private BufferedReader in;

    public InputRead(Socket cs) throws IOException {
        this.in = new BufferedReader(
                new InputStreamReader(cs.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (!in.ready()) {
                break;
            }
            if (inputLine.contains("GET")) {
                this.recurso = inputLine.split(" ")[1];
                System.out.println("Solicitaron:" + recurso);
            }
            System.out.println("RecibÃ­: " + inputLine);
        }

    }

    public String getRecurso() {
        return recurso;
    }

    public void closeIn() throws IOException {
        this.in.close();
    }

}
