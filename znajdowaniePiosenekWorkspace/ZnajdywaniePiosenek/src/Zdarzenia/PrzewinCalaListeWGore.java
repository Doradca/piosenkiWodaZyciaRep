package Zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class PrzewinCalaListeWGore  implements ActionListener{

	
	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
//	private int numerPozycjiNaLiscieKomponentuOdZeraNaOknie;
	
	
	public PrzewinCalaListeWGore(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
	//	numerPozycjiNaLiscieKomponentuOdZeraNaOknie = numerPozycjiNaLiscieWOknieOdZera;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\n\nprzewijanie listy piosenek w gore");	
		System.out.println("__________________________________________________________________________________________");
		
		
		mapaListyPiosenek.przewinCalaListeWGore();
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
	}

}