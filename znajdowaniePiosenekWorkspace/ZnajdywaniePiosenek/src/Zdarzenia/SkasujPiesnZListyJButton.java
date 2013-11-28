package Zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class SkasujPiesnZListyJButton implements ActionListener{

	
	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
	private int numerPozycjiNaLiscieKomponentuOdZeraNaOknie;
	
	
	public SkasujPiesnZListyJButton(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno, int numerPozycjiNaLiscieWOknieOdZera){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
		numerPozycjiNaLiscieKomponentuOdZeraNaOknie = numerPozycjiNaLiscieWOknieOdZera;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\n\nkasowanie piosenki z listy");	
		System.out.println("__________________________________________________________________________________________");
		
		
		mapaListyPiosenek.skasujJednaPozycje(numerPozycjiNaLiscieKomponentuOdZeraNaOknie);
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
	}



	
	
}
