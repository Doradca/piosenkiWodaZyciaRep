package Zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class DodaniePozDoListyJButton implements ActionListener{
	
	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
	private int nrOd0PozycjiNaOkniePrzedKtoraWladowacWolnaPozycje_zaDuzyNrZnaczyWladowacNaKoniec;
	
	
	public DodaniePozDoListyJButton(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno, int numerPozycjiNaLiscieWOknieOdZera){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
		nrOd0PozycjiNaOkniePrzedKtoraWladowacWolnaPozycje_zaDuzyNrZnaczyWladowacNaKoniec = numerPozycjiNaLiscieWOknieOdZera;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\n\ndodanie pozycji na nowa piosenke do listy");
		System.out.println("__________________________________________________________________________________________");
		
		mapaListyPiosenek.dodajNowyPustyWierszPozycjeWLiscie(nrOd0PozycjiNaOkniePrzedKtoraWladowacWolnaPozycje_zaDuzyNrZnaczyWladowacNaKoniec);
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
	}


}
