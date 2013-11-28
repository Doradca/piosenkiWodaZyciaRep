package Zdarzenia;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class ZmianaSlowSzukaniaJTArea implements DocumentListener {

	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
	private int numerPozycjiNaLiscieKomponentuOdZeraNaOknie;
	


	public ZmianaSlowSzukaniaJTArea(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno, int numerPozycjiNaLiscieWOknieOdZera){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
		numerPozycjiNaLiscieKomponentuOdZeraNaOknie = numerPozycjiNaLiscieWOknieOdZera;
	}


	@Override
	public void changedUpdate(DocumentEvent arg0) {

		System.out.println("change");
	}


	@Override
	public void insertUpdate(DocumentEvent arg0) {

		System.out.println("insert");
		//System.out.println("\n\n\nzmien slowa szukania i znajdz pasujace piosenki");
		//System.out.println("__________________________________________________________________________________________");
		mapaListyPiosenek.zaladujSlowaSzukaniaZOknaINicWiecejNieRob(oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[numerPozycjiNaLiscieKomponentuOdZeraNaOknie].slowaWyszukiwaniaPiosenkiJTextArea, numerPozycjiNaLiscieKomponentuOdZeraNaOknie);
		mapaListyPiosenek.wyszukajOdpowiednichPiosenekIWybierzDomyslna(numerPozycjiNaLiscieKomponentuOdZeraNaOknie);
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, false);	
		

	}


	@Override
	public void removeUpdate(DocumentEvent arg0) {
		System.out.println("remove");
		mapaListyPiosenek.zaladujSlowaSzukaniaZOknaINicWiecejNieRob(oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[numerPozycjiNaLiscieKomponentuOdZeraNaOknie].slowaWyszukiwaniaPiosenkiJTextArea, numerPozycjiNaLiscieKomponentuOdZeraNaOknie);
		mapaListyPiosenek.wyszukajOdpowiednichPiosenekIWybierzDomyslna(numerPozycjiNaLiscieKomponentuOdZeraNaOknie);
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, false);	
	}
	


}
