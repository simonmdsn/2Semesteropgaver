/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Novels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class WordCountRunnable implements Runnable {

    private File file;
    
    public WordCountRunnable(String fileName) {
    file = new File(fileName);
    }

    @Override
    public void run() {
        try(Scanner sc = new Scanner(file)) {
            int i = 0;
            while(sc.hasNext()) {
                sc.next().split(" ");
                i++;
            }
            System.out.println(file +" has "+i+" words.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WordCountRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
