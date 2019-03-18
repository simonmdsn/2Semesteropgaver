/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesthandlers;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import saviich_10_9.Species;

/**
 *
 * @author simon
 */
public class ObjectRequestHandler extends AbstractRequestHandler{
     
    Species califCondor = new Species("Calif. Condor", 27, 0.02);
    
    public ObjectRequestHandler(Socket socket) {
        super(socket);
    }
    
    
    //    Challenging: Make a RequestHandler that uses ObjectInputStream to receive an object,
    //    and writes it to System.out by calling toString() on it, and a Client that sends a Serialized object
    //    (e.g. a Species) to the server.

    @Override
    public void run() {
        System.out.println("Begynd");
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)) {
                writer.println("send dit objekt: ");
            
            Object obj = ois.readObject();
            System.out.println("Object: " + obj);
                
        } catch (IOException ex) {
            Logger.getLogger(ObjectRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjectRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
