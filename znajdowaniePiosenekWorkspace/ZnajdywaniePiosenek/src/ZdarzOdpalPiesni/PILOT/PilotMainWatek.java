package ZdarzOdpalPiesni.PILOT;

import java.util.List;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.util.Enumeration;
import java.util.Iterator;

public class PilotMainWatek extends Thread{
	private static boolean calaAplikacjaOproczSerweraSieSkonczyla = false;
	public static void setCalaAplikacjaOproczSerweraStoi(boolean calaAplikacjaOproczSerweraStoi_){
		calaAplikacjaOproczSerweraSieSkonczyla = calaAplikacjaOproczSerweraStoi_;
	}



	public void run(){
		if (inicjalizacja_bledyTrue()) return;
		System.out.println(PilotWczytaneParam.port);
		odpalSerwerIGoPilnuj();
	}

	private static void odpalSerwerIGoPilnuj(){
		try {
			
			

			
			Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
			while(e.hasMoreElements())
			{
				NetworkInterface n = e.nextElement();
				Enumeration<InetAddress> ee = n.getInetAddresses();
				while (ee.hasMoreElements()){
					InetAddress i =  ee.nextElement();
					System.out.println(i.getHostAddress());
				}

				List<InterfaceAddress> ipv6 = n.getInterfaceAddresses();
				Iterator<InterfaceAddress> it = ipv6.iterator();
				while (it.hasNext()){
					InterfaceAddress ia = it.next();
					
					System.out.println(ia.getAddress().getHostAddress() + "       _____________________");
				}
			}

			
			
			
			

			System.out.println(PilotWczytaneParam.port);
			ServerSocket serverSocket = new ServerSocket(PilotWczytaneParam.port);
			PilotWatSerw serwer = new PilotWatSerw(serverSocket);
			serwer.start();
			while( (!calaAplikacjaOproczSerweraSieSkonczyla)
					&& serwer.isAlive()){
				try{
					Thread.sleep(1000);
				} catch(Exception ex){}
			}
			serverSocket.close();
		} catch (Exception e) {}
	}

	private static boolean inicjalizacja_bledyTrue(){
		return PilotWczytaneParam.wczytajParametry_trueBlad();
	}




}
