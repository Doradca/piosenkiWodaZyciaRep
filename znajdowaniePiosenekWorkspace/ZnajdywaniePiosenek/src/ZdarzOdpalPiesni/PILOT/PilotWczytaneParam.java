package ZdarzOdpalPiesni.PILOT;

import java.io.File;
import java.io.IOException;

import funkcjeStat.PlikZawart_funkcje;

public class PilotWczytaneParam {
	public static String ip_adres;
	public static int port;
	
	
	

	public static boolean wczytajParametry_trueBlad(){
		File plikAdresIP = new File(PilotUstawienia.ipSerweraPlik_bledyToNieOdpalacSerwera);
		File plikPort = new File(PilotUstawienia.portSerweraPlik_bledyToNieOdpalacSerwera);
		
		if (!plikAdresIP.exists()){
			try {
				plikAdresIP.createNewFile();
			} catch (IOException e) {}
			return true;
		}
		
		if (!plikPort.exists()){
			try {
				plikPort.createNewFile();
			} catch (IOException e) {}
			return true;
		}
		

		System.out.println(plikPort.exists());
		
		
		

		ip_adres = PlikZawart_funkcje.wczytajZPlikuNapis_calaZawartoscPlikuToTenNapis_nullBlad(
				plikAdresIP, PilotUstawienia.kodowanieCharset);
		if (ip_adres == null) return true;
		
		
		int wartoscDoZwrotuWPrzypadkuBledu = -1;
		port = PlikZawart_funkcje.wczytajZPlikuLiczbeInta_calaZawartoscPlikuToTaLiczba(
				plikPort, PilotUstawienia.kodowanieCharset, wartoscDoZwrotuWPrzypadkuBledu);
		

		System.out.println(port);
		if (port == wartoscDoZwrotuWPrzypadkuBledu) return true;

		System.out.println(port);
		
		return false;
	}

}
