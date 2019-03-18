/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso
 */
public class CamelWriter {

    private File inFile;
   

    public CamelWriter(String fName) {
        inFile = new File(fName);
    }

    public void readLines() {
        try {
            Scanner sc = new Scanner(inFile);
            while(sc.hasNextLine()) {
                convert2camel(sc.nextLine());
                }                           
            // Benyt en Scanner til at læse inFile én linje ad gangen
            // Kald convert2camel med hver linje.
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CamelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void convert2camel(String line) {
        String[] strArray = line.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            if (i == 0) {
                sb.append(strArray[i].toLowerCase());
            } else {
                sb.append(strArray[i].substring(0, 1).toUpperCase()).append(strArray[i].substring(1));
            }

        }
        System.out.println(sb);
        // Split line til et String[] af de enkelte ord i linjen
        // Konverter 1. ord til små og resten til stort begyndelsesbogstav
        // Sammensæt ordene til ét langt ord og udskriv.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CamelWriter cw = new CamelWriter("src\\camelwriter\\ohfuckyeah.txt");
        cw.readLines();
        cw = new CamelWriter("src\\camelwriter\\MaryAnn.txt");
        cw.readLines();
        cw = new CamelWriter("src\\camelwriter\\OhLand.txt");
        cw.readLines();
    }

}
