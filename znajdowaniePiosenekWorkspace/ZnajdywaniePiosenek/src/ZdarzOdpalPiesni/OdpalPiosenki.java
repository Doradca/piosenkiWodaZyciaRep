package ZdarzOdpalPiesni;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;
import ZdarzOdpalPiesni.PILOT.PilotMainWatek;

public class OdpalPiosenki implements ActionListener{
	
	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;

	public OdpalPiosenki(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\nOdpalPiosenki\n_________________________________________________________");
		oknoZrobListePiesniJFrame.dispose();
		ArrayList<String> sciezkiAbsolutneBezPolskichZnakow = KopieTMP.zrobKopieTMP_iZapodajSciezkiAbsolutneTychKopii(mapaListyPiosenek.zapodajPiosenkiDoOdpalenia());
		for (int i = 0; i < sciezkiAbsolutneBezPolskichZnakow.size(); i++){
			wykonajKomendeCMD('"' + sciezkiAbsolutneBezPolskichZnakow.get(i) + "\"\n");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {}
		}
		System.out.println("koniec CMD");
		
		// uruchom pilot (serwer) jesli sie uda
		new PilotMainWatek().start();
		
		// koncz program
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}

		KopieTMP.chodzWKolkoDoSkasowaniaPlikowIKataloguTMP();
		PilotMainWatek.setCalaAplikacjaOproczSerweraStoi(true);
	}

	private void wykonajKomendeCMD(String komendaZEnteremSlashN){
		String[] cmd = {"cmd"};
		Process pp;
		try {
			pp = Runtime.getRuntime().exec(cmd);

		//	InputStreamReader otwarteCzytanieLiniiZcmd = new InputStreamReader(pp.getInputStream());
			OutputStreamWriter otwartePisanieNaCMD = new OutputStreamWriter(pp.getOutputStream());
			
			System.out.println("\n\n\n_______________________________ komenda ________________________________________");
			System.out.println("\n"+ komendaZEnteremSlashN + "\n\n\n");
			
			otwartePisanieNaCMD.write(komendaZEnteremSlashN + "\nexit\n"); 
			otwartePisanieNaCMD.flush();
			try {
				pp.waitFor();
			} catch (InterruptedException e) {}
			pp.destroy();
		} catch (IOException e1) {}
	}
	
}
