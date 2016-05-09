package Zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class ZamienSasiedniePiosenki  implements ActionListener{

	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
	private boolean zamienZGornaTrue_zamienZDolnaFalse;
	private int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3;


	public ZamienSasiedniePiosenki(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno, boolean zamienZGornaTrue_zamienZDolnaFalse_,
			int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
		zamienZGornaTrue_zamienZDolnaFalse = zamienZGornaTrue_zamienZDolnaFalse_;
		numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 = numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\n\nzamiana sasiednich piosenek");	
		System.out.println("__________________________________________________________________________________________");

		if(zamienZGornaTrue_zamienZDolnaFalse) mapaListyPiosenek.zamienPozycjeOJedenWGore(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3);
		else mapaListyPiosenek.zamienPozycjeOJedenWDol(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3);

		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
	}

}


