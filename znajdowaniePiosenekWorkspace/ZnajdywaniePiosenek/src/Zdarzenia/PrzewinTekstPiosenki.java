package Zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class PrzewinTekstPiosenki implements ActionListener{


	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
	private int numerPozycjiNaLiscieKomponentuOdZeraNaOknie;
	private boolean przewinTrueWGoreFalseWDol;


	public PrzewinTekstPiosenki(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno, int numerPozycjiNaLiscieWOknieOdZera, boolean przewinTrueWGoreFalseWDol_){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
		numerPozycjiNaLiscieKomponentuOdZeraNaOknie = numerPozycjiNaLiscieWOknieOdZera;
		przewinTrueWGoreFalseWDol = przewinTrueWGoreFalseWDol_;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\n\nprzewijanie tekstu piosenki");	
		System.out.println("__________________________________________________________________________________________");

		if (przewinTrueWGoreFalseWDol) mapaListyPiosenek.przewinTekstPiosenkiWGore(numerPozycjiNaLiscieKomponentuOdZeraNaOknie);
		else mapaListyPiosenek.przewinTekstPiosenkiWDol(numerPozycjiNaLiscieKomponentuOdZeraNaOknie);
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
	}

}
