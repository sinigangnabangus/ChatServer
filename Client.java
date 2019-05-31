package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
		
	ClientConnection cc;

	public static void main(String[] args) {
		new Client();
	}
	
	public Client() {
		try {
			Socket s = new Socket("localhost", 9876);
			cc = new ClientConnection(s, this);
			System.out.println("Welcome to JAVA2 Chat Project.  Your username is: Client " +s.getLocalPort()+ "\n");
			cc.start();
			
			
			listenForInput(s.getLocalPort());
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void listenForInput(int localport) {
		
		Scanner console = new Scanner(System.in);
		
		while (true) {
			while(!console.hasNextLine()) {
				try {
					Thread.sleep(1);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String input = console.nextLine();
			
			if(input.equalsIgnoreCase("end")) {
				//break;
				cc.sendStringToServer("Client "+ localport + " disconnected.\n");
				System.exit(1);
			}
			else if(input.equals("")) {
				
			}
			else {
			cc.sendStringToServer("Client "+ localport + ": " + input +"\n" );
			}
		}
		
		//cc.close();
	}
	
}












