/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Novels;

import java.io.Serializable;

/**
 *
 * @author simon
 */
public class WordCounter implements Serializable {

    /**
     * @param args the command line arguments
     */        

    public static void main(String argv[]) {
        String[] fileNames = {"src/Novels/alice30.txt", "src/Novels/Snow White.txt"};
        for (String fileName : fileNames) {
            Runnable wcr = new WordCountRunnable(fileName);
            wcr.run();
            // Start a Thread for the Runnable here:
        }
    }
    
    
}
