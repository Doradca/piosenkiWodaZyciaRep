package Zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class PrzewinCalaListeWDol  implements ActionListener{

	
	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
//	private int numerPozycjiNaLiscieKomponentuOdZeraNaOknie;
	
	
	public PrzewinCalaListeWDol(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
	//	numerPozycjiNaLiscieKomponentuOdZeraNaOknie = numerPozycjiNaLiscieWOknieOdZera;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\n\nprzewijanie listy piosenek w dol");	
		System.out.println("__________________________________________________________________________________________");
		
		
		mapaListyPiosenek.przewinCalaListeWDol();
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
	}

}