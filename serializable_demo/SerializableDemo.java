/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializable_demo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class SerializableDemo implements Serializable {

    private int x;
    private String str;

    public SerializableDemo(int x, String str) {
        this.x = x;
        this.str = str;
    }

    @Override
    public String toString() {
        return "SerializableDemo{" + "x=" + x + ", str=" + str + '}';
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<SerializableDemo> list = new LinkedList<>();
        list.add(new SerializableDemo(0, "aaa"));
        list.add(new SerializableDemo(1, "bbb"));
        list.add(new SerializableDemo(2, "ccc"));

        File file = new File("Serial.obj");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file,true))) {
            oos.writeObject(list);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("List written to file\n");

        List<SerializableDemo> l = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serial.obj"))) {

            try {
                while (true) {
                    l = (List<SerializableDemo>) ois.readObject();
                    System.out.println("List read: \n" + l);
                }
            } catch (EOFException eof) {
                System.out.println("No more to read!");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
