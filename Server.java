package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
	
	ServerSocket ss;
	ArrayList<ServerConnection> connections = new ArrayList<ServerConnection>();
	boolean shouldRun = true;
	ServerConnection sc;
	
	public static void main(String[] args) {
		new Server();
	}
	
	public Server() {
		try {
			ss = new ServerSocket(9876);
			
			while(shouldRun) {
				System.out.println("WELCOME TO JAVA2 CHAT PROJECT\n");
				System.out.println("Server is ready to accept client connections.\n");
				Socket s = ss.accept();
				System.out.println("Accepted connection from " + s);
				System.out.println("Welcome! \n\n");
				ServerConnection sc = new ServerConnection(s, this);
				sc.start();
				connections.add(sc);
				
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
