package ZdarzOdpalPiesni.PILOT;

import java.io.IOException;
import java.net.ServerSocket;

public class PilotWatSerw extends Thread {

	private ServerSocket serverSocket;
	
	public void run(){
		while(true){
			try {
				new PilotWOPol(serverSocket.accept()).start();
			} catch (IOException e) {
				return;
			}
		}
	}
	
	
	
	public PilotWatSerw(ServerSocket serverSocket_){
		serverSocket = serverSocket_;
	}
	
}
