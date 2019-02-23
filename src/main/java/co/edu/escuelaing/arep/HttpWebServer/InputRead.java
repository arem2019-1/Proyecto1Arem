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

    private String operacion="";
    private String recurso = "";
    private String dirreccion="";
    private Integer dato=0;
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
            String tmp=inputLine.toString();//System.out.println("lololola : "+tmp);
                    String tempp1="";
            if(tmp.contains("/fram")){//System.out.println("miremos 111: "+recurso); 
                    if(recurso.contains("/fram/cuadrado")){
                      tempp1=recurso.replace("/fram/cuadrado/", ""); //System.out.println("miremos dato : "+tempp1);                    
                    }else if(recurso.contains("/fram/suma")){
                       tempp1=recurso.replace("/fram/suma/", "");//System.out.println("miremos dato : "+tempp1);
                    }//REcuperamos el numero o dato//AHora recuperaremos la operacion
                    String temp22=recurso.replace("/fram/","");//AHora separaremos la operacion
                    String ui="/"+tempp1.toString();//System.out.println("miremos si "+ui);
                    String temp33=temp22.replace(ui,"");
                    operacion=temp33.replace("/"+temp33,"");
                    if(tempp1!=""){
                        dato=Integer.parseInt(tempp1);
                    }//System.out.println("MIrar el numero : "+dato);
            }   
        }
    }
    /**
     * @return dirrecion Devuelve la dirrecion a donde se dirigue el usuario
     */
    public String getDirrecion(){
        return dirreccion;
    }
    
    /**
     * @return operacion Devuelve la operacion a que se realizara.
     */
    public String Operacion(){
        return operacion;
    }
    /**
     * @return dato  Devuelve el valor para poder realizar el calculo.
     */

    public int getDato(){
        return dato;
    }
    /**
     * @return dirrecion Devuelve el recurso para poder analizar el mensaje.
     */
    public String getRecurso() {
        return recurso;
    }
    
    public void closeIn() throws IOException {
        this.in.close();
    }

}
