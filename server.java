package singlethread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server{

    public void run(){
        int port = 8080;
        ServerSocket socket = new ServerSocket();
        socket.setSoTimeout(10000);
        while(true){
           try{
             System.out.println("Server is listining on port" + port);
            Socket acceptedConnection = socket.accept();
            System.out.println("Connection accepted from client"+ acceptedConnection.getRemoteSocketAddress());
            PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
            BufferedReader fromCliet = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            toClient.println("Hello from the server");
           }
           catch(IOException ex){
            ex.printStackTrace();
           }
        }

    }

    public static void main(String[] args) {
        server server = new server();
        try{
            server.run();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

}