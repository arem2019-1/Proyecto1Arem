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
    
    public Integer tratar(Integer dato, String ruta) throws IOException {
        Hashtable<String, Object> dicWeb = new Hashtable<String, Object>();
        int resp=0;
        try {

            //Class c = Class.forName("com.mycompany.reflexiontest.Calculadora");
            Class c = Class.class;
            //target/classes/co/edu/escuelaing/arep/reflexion/
            File f = new File("target/classes/co/edu/escuelaing/arep/reflexion");
            System.out.println("lelega aqui?"+f.exists());
            if (f.exists()) {
                File[] ficheros = f.listFiles();

                
                for (File re : ficheros) {
                    System.out.println("miremos lol : "+re.getAbsolutePath());
                    String temp1 = re.toPath().toString();

                    String temp2 = temp1.replace(".class", "");

                    String temp3 = temp2.replace("target/classes/", "");
                    System.out.println("como empezo temp3 "+temp3);
                    String temp4 = temp3.replace("\\", ".");
                    System.out.println("lelega aqui?3 : "+temp4);
                    c = Class.forName(temp4);
                    System.out.println("lelega aqui?2");
                    for (Method m : c.getMethods()) {
                        System.out.println("popo");
                        if (m.isAnnotationPresent(Web.class)) {
                            dicWeb.put(temp4, c);
                            System.out.println("si tiene anota web " + m.getName());
                            try {

                                System.out.println("lolol");
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
                temp="suma";
            }

            System.out.println(q.toGenericString());
            Method[] ml = q.getDeclaredMethods();
            for (Method m : ml) {
                System.out.println(m);
            }
            Method m = c.getDeclaredMethod(temp, int.class);
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
