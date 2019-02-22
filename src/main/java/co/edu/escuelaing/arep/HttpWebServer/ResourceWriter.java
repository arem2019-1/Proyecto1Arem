/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.HttpWebServer;

import co.edu.escuelaing.arep.reflexion.Reflexion;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author 2098325
 */
public class ResourceWriter {
    private final Reflexion fin;
    private final Socket clientSocket;

    public ResourceWriter(String recurso, Socket clientSocket,String dirrecion, Integer dato,String operacion) throws IOException {
        this.fin=new Reflexion();
        this.clientSocket = clientSocket;
        //System.out.println("miremos socket :"+clientSocket);
        //System.out.println("miremos el recurso"+recurso);
        if (recurso.toLowerCase().contains(".html")) {

            htmlResource(recurso);
        }else if (recurso.toLowerCase().contains(".png")) {

            pngRecurso(recurso);
        }  else if (recurso.toLowerCase().contains("/fram")) {
            System.out.println("hola putos");
            framworkPojo(dato, operacion);
            

        }  else {

            errorTipo();
        }
    }
    
    private void errorTipo() {

        try {
            PrintWriter out;
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            String outputLine = "HTTP/1.1 Erro Type Not Implemented\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Error de TIPO</title>\n"
                    + "</head>"
                    + "<body>"
                    + "<h1>No solicito un archivo correcto</h1>"
                    + "<h1>erroType:solo se procesa archivos con .html o .png</h1>"
                    + "</body>"
                    + "</html>";
            out.print(outputLine);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void nFound404() {
        try {
            PrintWriter out;
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            String outputLine = "HTTP/1.1 404 Not Found\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>404 No encontrado</title>\n"
                    + "</head>"
                    + "<body>"
                    + "<h1>Error 404: Contenido del archivo no correto o no encontrado</h1>"
                    + "</body>"
                    + "</html>";

            out.println(outputLine);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void pngRecurso(String resource) {

        try {
            File graphicResource = new File("src/main/resources" + resource);
            FileInputStream inputImage = new FileInputStream(graphicResource);
            byte[] bytes = new byte[(int) graphicResource.length()];
            inputImage.read(bytes);

            DataOutputStream binaryOut;
            binaryOut = new DataOutputStream(clientSocket.getOutputStream());
            binaryOut.writeBytes("HTTP/1.1 200 OK \r\n");
            binaryOut.writeBytes("Content-Type: image/png\r\n");
            binaryOut.writeBytes("Content-Length: " + bytes.length);
            binaryOut.writeBytes("\r\n\r\n");
            binaryOut.write(bytes);
            binaryOut.close();
        } catch (IOException ex) {
            nFound404();
            System.err.println("Error en la lectura de el archivo");
        }

    }

    /**
     * Se encarga de manejar el html almacenado en resources
     *
     * @param resource
     */
    private void htmlResource(String resource) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources" + resource));
            StringBuilder outputLine = new StringBuilder();
            outputLine.append("HTTP/1.1 200 OK\r\n");
            outputLine.append("Content-Type: text/html\n");
            outputLine.append("\r\n\r\n");
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                outputLine.append(bfRead);
            }
            PrintWriter out = new PrintWriter(
                    this.clientSocket.getOutputStream(), true);

            out.println(outputLine.toString());
            out.close();

        } catch (IOException ex) {
            nFound404();
            System.err.println("Error en la lectura de el archivo");
        }
    }

    private void framworkPojo(Integer dato, String ruta) throws IOException {
        int re=fin.tratar(dato, ruta);
        try {
            
            String ffin=Integer.toString(re);
            
            
            PrintWriter out;
            out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            String outputLine = "HTTP/1.1 202 Rsultado de usar el framework\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>El resultaod es </title>\n"+ffin
                    + "</head>"
                    + "<body>"
                    + "<h1>Este fue el resultado de usar alguna de las clases del framework</h1>"
                    + "</body>"
                    + "</html>";

            out.println(outputLine);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
