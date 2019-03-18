/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable_uid;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import serializable_demo.SerializableDemo;

/**
 *
 * @author erso
 */
public class SerializableUIDdemo implements Serializable {

    private int x;
    private String str;

    public SerializableUIDdemo(int x, String str) {
        this.x = x;
        this.str = str;
    }

    @Override
    public String toString() {
        return "SerializableUIDdemo{" + "x=" + x + ", str=" + str + '}';
    }

    public void write2file(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SerializableUIDdemo readFromFile(File file) {
        SerializableUIDdemo suid = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            suid = (SerializableUIDdemo) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suid;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f = new File("SUID demo.obj");
        SerializableUIDdemo sd = new SerializableUIDdemo(27, "Hejsa");

        sd.write2file(f);
        
        System.out.println(sd.readFromFile(f));
    }

}
