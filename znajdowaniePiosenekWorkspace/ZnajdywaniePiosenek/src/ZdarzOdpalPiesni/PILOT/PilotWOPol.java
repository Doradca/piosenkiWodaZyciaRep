package ZdarzOdpalPiesni.PILOT;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.OutputStream;
import java.net.Socket;

import funkcjeStat._WczytNa2wat;

public class PilotWOPol extends Thread{

	private Socket socket;
	private static int idPakietu = 0;

	public void run(){
		byte [] pytanieTab = new byte[1000000];
		int pytanieLength;
		try {
			pytanieLength = _WczytNa2wat.wczytajFragmentKolejnyZeStrumienia_wczytujNaInnymWatkuIGoKontroluj_zwrocIleWczytalBajtow(
					socket.getInputStream(),
					pytanieTab, 
					200, 
					555,
					1);
			String pytanie = new String(pytanieTab, 0, pytanieLength, PilotUstawienia.kodowanieCharset);

			System.out.println(pytanie + ";   length = "+pytanieLength);

			akcja(pytanie);
			OutputStream os = socket.getOutputStream();
			os.write(odpowiedzPakiet(idPakietu).getBytes(PilotUstawienia.kodowanieCharset));
			os.flush();
			socket.close();
		} catch (Exception e) {}
	}

	private void akcja(String pytanie){
		if (pytanie.indexOf(PilotUstawienia.htmlPyt_wcisniecieWLewo) >0){
			// zadbanie przed wielokrotnym pytaniem na jedno klikniecie

			if (pytanie.indexOf(PilotUstawienia.htmlPyt_wcisniecieWLewo + idPakietu) > 0){

				try {
					Robot r = null;
					r = new Robot();
					r.keyPress(KeyEvent.VK_UP);
					idPakietu = (int) (Math.random()*Integer.MAX_VALUE);
				} catch (AWTException e) {}	
				return;
			}
		}
		if (pytanie.indexOf(PilotUstawienia.htmlPyt_wcisniecieWPrawo) >0){
			if (pytanie.indexOf(PilotUstawienia.htmlPyt_wcisniecieWPrawo + idPakietu) > 0){
				try {
					Robot r = null;
					r = new Robot();
					r.keyPress(KeyEvent.VK_DOWN);
					idPakietu = (int) (Math.random()*Integer.MAX_VALUE);
				} catch (AWTException e) {}	
				return;
			}
		}




	}

	private static String odpowiedzPakiet(int idPakietu){

		String odpHtml = "<html>\n" +
				"<body>\n" +

				"<div style = 'position:absolute; left:0px; top:0px; width:230px; height:25px;"
				+ "padding: 5px;"
				+ "font-family: arial;"
				+ "font-size: 20px;"
				+ "font-weight: bold;"
				+ "text-decoration: none;"
				+ "text-align: center;"
				+ "color: #008800;"
				+ "border-style: solid;"
				+ "border-width: 4px;"
				+ "border-color: #008800;"
				+ "'>Zapodaj piosenk&#281; pilot</div>\n" +

				"<div style = 'position:absolute; left:434px; top:233px; width:240px; height:47px;"
				+ "padding: 5px;"
				+ "font-family: arial;"
				+ "font-size: 20px;"
				+ "font-weight: bold;"
				+ "text-decoration: none;"
				+ "text-align: center;"
				+ "color: #008800;"
				+ "border-style: solid;"
				+ "border-width: 4px;"
				+ "border-color: #008800;"
				+ "'>&#169; copyright by Doradca Pawe&#322; Magryta</div>\n" +
				
				
				"<a href = 'http://" + PilotWczytaneParam.ip_adres + ":" + PilotWczytaneParam.port + "/"+ PilotUstawienia.htmlPyt_wcisniecieWLewo + idPakietu +"'" +
				" style = 'position:absolute; left:0px; top:39px; width:300px; height:150px;"
				+ "padding: 20px;"
				+ "font-size: 100px;"
				+ "font-weight: bold;"
				+ "text-decoration: none;"
				+ "text-align: center;"
				+ "color: #000088;"
				+ "border-style: solid;"
				+ "border-width: 4px;"
				+ "border-color: #000088;"
				+ "'>&#8592;</a>\n" +
				
				"<a href = 'http://" + PilotWczytaneParam.ip_adres + ":" + PilotWczytaneParam.port + "/"+ PilotUstawienia.htmlPyt_wcisniecieWPrawo + idPakietu +"'" +
				" style = 'position:absolute; left:344px; top:39px; width:300px; height:150px;"
				+ "padding: 20px;"
				+ "font-size: 100px;"
				+ "font-weight: bold;"
				+ "text-decoration: none;"
				+ "text-align: center;"
				+ "color: #000088;"
				+ "border-style: solid;"
				+ "border-width: 4px;"
				+ "border-color: #000088;"
				+ "'>&#8594;</a>\n" +
				"</body>\n" +
				"</html>\n";

		String odpNaglowek = "HTTP/1.1 200 OK\n" +
				"Content-Type: text/html\n" +
				"Content-Length: " + odpHtml.length() + "; charset=utf-8\n\n";

		return odpNaglowek + odpHtml;
	}

	public PilotWOPol(Socket socket_){
		socket = socket_;
	}

}
