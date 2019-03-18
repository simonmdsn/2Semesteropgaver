/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_server_runnable;



import requesthandlers.AbstractRequestHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import requesthandlers.FlipRequestHandler;
import requesthandlers.ObjectRequestHandler;

/**
 *
 * @author erso
 */
public class TCPServer {


    private int port;
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
            //    requestHandler =  new FlipRequestHandler(socket);
//                requestHandler =  new FileOutRequestHandler(socket, "RequestLog.txt");
                requestHandler = new ObjectRequestHandler(socket);
                
                new Thread(requestHandler).start();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TCPServer server;
        server = new TCPServer( 3333);
        server.start();
    }

}
