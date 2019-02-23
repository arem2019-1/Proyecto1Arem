/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.arep.reflexion;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2098325
 */
public class Reflexion {

    public Reflexion(){
    
    }
                /**
     * Calcula el resultado por un pojo
     * <p>Calcula el resultado segun el procedimiento que definio el usuario por el broswer</p>
     * @param dato Es con el cual se realizara el calculo.
     * @param ruta  Es con el cual sabremos que operacion se eligio.
     * @return Integer
     */
    public Integer tratar(Integer dato, String ruta) throws IOException {
        Hashtable<String, Object> dicWeb = new Hashtable<String, Object>();
        int resp=0;
        try {
            Class c = Class.class;//Class c = Class.forName("com.mycompany.reflexiontest.Calculadora");
            File f = new File("target/classes/co/edu/escuelaing/arep/reflexion");//target/classes/co/edu/escuelaing/arep/reflexion/
            if (f.exists()) {
                File[] ficheros = f.listFiles();
                for (File re : ficheros) {
                    String temp1 = re.toPath().toString();
                    String temp2 = temp1.replace(".class", "");
                    String temp3 = temp2.replace("target/classes/", "");
                    String temp4 = temp3.replace("/", ".");
                    c = Class.forName(temp4);
                    for (Method m : c.getMethods()) {
                        if (m.isAnnotationPresent(Web.class)) {
                            dicWeb.put(temp4, c);
                            try {
                                System.out.println("Miremos resultado . " + m.invoke(null, dato));
                            } catch (Throwable ex) {
                                System.out.println("Fallo por puto");
                            }
                        }
                    }
                }
            } else {
                System.out.println("No hub nada");
            }
            Class q = Class.class;
            String temp="";
            if (ruta.toString().equals("cuadrado")) {
                q = (Class) dicWeb.get("co.edu.escuelaing.arep.reflexion.Calculadora");
                temp="cuadrado";
            } else if (ruta.equals("suma")) {
                q = (Class) dicWeb.get("co.edu.escuelaing.arep.reflexion.Suma");
                temp="su";
            }
            System.out.println(q.toGenericString());
            Method[] ml = q.getDeclaredMethods();
            for (Method m : ml) {
                System.out.println(m);
            }
            Method m = q.getDeclaredMethod(temp, int.class);
            System.out.println(m);
            System.out.println(m.invoke(null, dato));
            resp=(Integer)m.invoke(null, dato);
            return (Integer)m.invoke(null, dato);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Reflexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
