package Zdarzenia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ListaPiosenekStan.MapaListyPiosenek;
import OknoGlowne.OknoZrobListePiesniJFrame;

public class WybierzPiosenkePasujaca implements ActionListener{
	
	private MapaListyPiosenek mapaListyPiosenek;
	private OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame;
	private int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3, numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4;
	
	
	public WybierzPiosenkePasujaca(MapaListyPiosenek mapaStanuListyPiosenek, OknoZrobListePiesniJFrame okno, int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_,
			int numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4_){
		mapaListyPiosenek = mapaStanuListyPiosenek;
		oknoZrobListePiesniJFrame = okno;
		numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 = numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_;
		numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4 = numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4_;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("\n\n\nwybranie piosenki z listy pasujacych");
		System.out.println("__________________________________________________________________________________________");
		
		mapaListyPiosenek.wybierzPiosenkeZListyNazwPasujacych(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3, numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4);
		mapaListyPiosenek.wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
	}


}
