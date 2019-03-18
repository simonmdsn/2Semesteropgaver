/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools 
    private AbstractRequestHandler requestHandler;
    

    public TCPServer( int port) {
        
        this.port = port;
        
    }

    public void start() {
        try (ServerSocket ss = new ServerSocket(port)) {

            while (true) {
                System.out.println("Server waiting....");
                Socket socket = ss.accept();
                System.out.println("Server has accepted a client on port " + socket.getPort());

//Choose RequestHandler before start:
//                requestHandler =  new FlipRequestHandler(socket);
                //requestHandler =  new FileOutRequestHandler(socket, "| Templates
 * and open the template in the editor.
 */
package requesthandlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class FileOutRequestHandler extends AbstractRequestHandler {

        private File file;
        
public FileOutRequestHandler(Socket socket, String fileName) {
    super(socket);
    file = new File(fileName);
}    
    
    @Override
    public void run() {
        try(Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)) {
            FileWriter fileWriter = new FileWriter(file);


            writer.println("Type msg");
            String revieced = sc.nextLine();

            fileWriter.write(new Date() + "\t" +socket.getInetAddress()+"\t"+revieced);
            fileWriter.flush();
            
            writer.print("done");

            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(FileOutRequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
           
    }
    
}
