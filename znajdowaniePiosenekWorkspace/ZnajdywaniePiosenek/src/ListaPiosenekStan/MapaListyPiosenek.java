package ListaPiosenekStan;

import java.util.ArrayList;

import javax.swing.JTextArea;

import Komponenty.KomponentyZapodaj;
import OknoGlowne.OknoZrobListePiesniJFrame;
import SkanowaniePiosenek.PiosenkaZPlikuSkan;

public class MapaListyPiosenek {

	private ArrayList<JednaPozycjaNaLiscieMapa> listaPiosenekJednejPozycjiMapa = new ArrayList<JednaPozycjaNaLiscieMapa>();
	private int numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 = 0;


	public MapaListyPiosenek(OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame){
		dodajNowyPustyWierszPozycjeWLiscie(0);
		wyrenderujGotowaListe(oknoZrobListePiesniJFrame, true);
		
	}
	

	public ArrayList<PiosenkaZPlikuSkan> zapodajPiosenkiDoOdpalenia(){
		ArrayList<PiosenkaZPlikuSkan> piosenkiDoOdpalenia = new ArrayList<PiosenkaZPlikuSkan>();
		PiosenkaZPlikuSkan piosenkaOdpal;
		for (int i = 0; i < listaPiosenekJednejPozycjiMapa.size(); i++){
			piosenkaOdpal = listaPiosenekJednejPozycjiMapa.get(i).zapodajPiosenkeDoOdpalenia();
			if (piosenkaOdpal != null) piosenkiDoOdpalenia.add(piosenkaOdpal);
		}
		return piosenkiDoOdpalenia;
	}
	
	
	// wstepnie ok
	public void wyrenderujGotowaListe(OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame, boolean nieRobiTegoZdarzenieZmianySlowWJtextArea){

		// ustaw suwaki gora dol dla calej listy:
		if (numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 == 0) oknoZrobListePiesniJFrame.piesniListaJComp.wGoreJButton.setVisible(false);
		else oknoZrobListePiesniJFrame.piesniListaJComp.wGoreJButton.setVisible(true);
		if (numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + 4 >= listaPiosenekJednejPozycjiMapa.size()) oknoZrobListePiesniJFrame.piesniListaJComp.wDolJButton.setVisible(false);
		else oknoZrobListePiesniJFrame.piesniListaJComp.wDolJButton.setVisible(true);

		// ustaw dodaj nowa pozycje:
		for (int i = 0; i < 5; i++){
			if (i <= listaPiosenekJednejPozycjiMapa.size()) oknoZrobListePiesniJFrame.piesniListaJComp.dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton[i].setVisible(true);
			else oknoZrobListePiesniJFrame.piesniListaJComp.dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton[i].setVisible(false);
		}
		
		// popraw numerki JLabel piosenek:
		for (int i = 0; i < 4; i++){
			KomponentyZapodaj.setZmienNumerPiosenki(oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].numerSzukanejPiosenkiNaLiscieJLabel, numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + i + 1);	
	//		System.out.println(oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].numerSzukanejPiosenkiNaLiscieJLabel.getText());
		}

		// wstepnie pokaz lub ukryj pozycje piesni na liscie:
		for (int i = 0; i < 4; i++){
			if (i < listaPiosenekJednejPozycjiMapa.size()){
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].numerSzukanejPiosenkiNaLiscieJLabel.setVisible(true);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].slowaWyszukiwaniaPiosenkiJTextArea.setVisible(true);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.wGoreJButton.setVisible(true);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.wDolJButton.setVisible(true);
				for (int j = 0; j < oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.listaZnalezionych5PasujacychPlikowPiesniJButton.length; j++)
					oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.listaZnalezionych5PasujacychPlikowPiesniJButton[j].setVisible(true);		

				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTytulJLabel.setVisible(true);

				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTekstJComp.wDolJButton.setVisible(true);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTekstJComp.wGoreJButton.setVisible(true);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTekstJComp.tekstPiosenkiJLabel.setVisible(true);

				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].opcjePozycjiNaLisciePrzesunLubSkasujJComp.skasujJButton.setVisible(true);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].opcjePozycjiNaLisciePrzesunLubSkasujJComp.wDolJButton.setVisible(true);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].opcjePozycjiNaLisciePrzesunLubSkasujJComp.wGoreJButton.setVisible(true);
			}
			else {
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].numerSzukanejPiosenkiNaLiscieJLabel.setVisible(false);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].slowaWyszukiwaniaPiosenkiJTextArea.setVisible(false);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.wGoreJButton.setVisible(false);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.wDolJButton.setVisible(false);
				for (int j = 0; j < oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.listaZnalezionych5PasujacychPlikowPiesniJButton.length; j++)
					oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].listaPlikowPiosenekPasujacychJButton.listaZnalezionych5PasujacychPlikowPiesniJButton[j].setVisible(false);		

				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTytulJLabel.setVisible(false);

				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTekstJComp.wDolJButton.setVisible(false);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTekstJComp.wGoreJButton.setVisible(false);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].wybranaPiosenkaTekstJComp.tekstPiosenkiJLabel.setVisible(false);

				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].opcjePozycjiNaLisciePrzesunLubSkasujJComp.skasujJButton.setVisible(false);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].opcjePozycjiNaLisciePrzesunLubSkasujJComp.wDolJButton.setVisible(false);
				oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[i].opcjePozycjiNaLisciePrzesunLubSkasujJComp.wGoreJButton.setVisible(false);
			}
		}

		// ukryj mozliwosc zamiany sasiednich pozycji na krancowych
		if (numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 == 0) oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[0].opcjePozycjiNaLisciePrzesunLubSkasujJComp.wGoreJButton.setVisible(false);
		int nrPozNaOknie1ZaOstatniaDlaDlugichList = numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + 4;
		if (nrPozNaOknie1ZaOstatniaDlaDlugichList >=  listaPiosenekJednejPozycjiMapa.size()){
			oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[listaPiosenekJednejPozycjiMapa.size() - 1 - numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4].opcjePozycjiNaLisciePrzesunLubSkasujJComp.wDolJButton.setVisible(false);
		}
		
		// wyrenderuj oddzielnie kazdy panel:
		for (int nrPanelaNaOknie = 0; nrPanelaNaOknie < 4; nrPanelaNaOknie++){
			if (nrPanelaNaOknie < listaPiosenekJednejPozycjiMapa.size())
				listaPiosenekJednejPozycjiMapa.get(numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + nrPanelaNaOknie).wyrenderujJednaPozycjeNaPanelWOknie(oknoZrobListePiesniJFrame.piesniListaJComp.pozycje4PiesniJComp[nrPanelaNaOknie], nieRobiTegoZdarzenieZmianySlowWJtextArea);
		}

	}


	// jest ok:

	// ok
	public void zamienPozycjeOJedenWGore(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		JednaPozycjaNaLiscieMapa aktualna = listaPiosenekJednejPozycjiMapa.remove(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4);
		JednaPozycjaNaLiscieMapa poprzednia = listaPiosenekJednejPozycjiMapa.remove(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 - 1);
		listaPiosenekJednejPozycjiMapa.add(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 - 1, aktualna);
		listaPiosenekJednejPozycjiMapa.add(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4, poprzednia);
	}

	// ok
	public void zamienPozycjeOJedenWDol(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		JednaPozycjaNaLiscieMapa nastepna = listaPiosenekJednejPozycjiMapa.remove(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + 1);
		JednaPozycjaNaLiscieMapa aktualna = listaPiosenekJednejPozycjiMapa.remove(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4);
		listaPiosenekJednejPozycjiMapa.add(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4, nastepna);
		listaPiosenekJednejPozycjiMapa.add(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + 1, aktualna);
	}

	// ok
	public void przewinTekstPiosenkiWGore(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		listaPiosenekJednejPozycjiMapa.get(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4).przewinTekstPiosenkiWGore();
	}

	// ok
	public void przewinTekstPiosenkiWDol(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		listaPiosenekJednejPozycjiMapa.get(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4).przewinTekstPiosenkiWDol();
	}

	// ok
	public void przewinDobrePiosenkiWGore(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		listaPiosenekJednejPozycjiMapa.get(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4).przewinDobrePiosenkiWGore();
	}

	// ok
	public void przewinDobrePiosenkiWDol(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		listaPiosenekJednejPozycjiMapa.get(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4).przewinDobrePiosenkiWDol();
	}

	// ok
	public void przewinCalaListeWGore(){
		numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4--;
	}

	// ok
	public void przewinCalaListeWDol(){
		numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4++;
	}

	// ok
	public void skasujJednaPozycje(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		// skasuj wybrany element bo wszystko jest ok
		listaPiosenekJednejPozycjiMapa.remove(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4);
		// jesli na zerowy panel leci wieksza od 0 pozycja i do konca listy zostalo za malo to zmniejsz nr pozycji ktora leci na zerowy panel.
		if (numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 > listaPiosenekJednejPozycjiMapa.size() - 4 && numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 > 0) numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4--;
		if(listaPiosenekJednejPozycjiMapa.size() == 0) {
			dodajNowyPustyWierszPozycjeWLiscie(0);
			
		}
	}

	// ok
	public void dodajNowyPustyWierszPozycjeWLiscie(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_4ZnaczyLadujNaKoniec_PrzedKtoraWladowacWolnaPozycje_zaDuzyNrZnaczyWladowacNaKoniec){
		int nrAdd = numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_4ZnaczyLadujNaKoniec_PrzedKtoraWladowacWolnaPozycje_zaDuzyNrZnaczyWladowacNaKoniec;
		if (nrAdd >= listaPiosenekJednejPozycjiMapa.size()) nrAdd = listaPiosenekJednejPozycjiMapa.size();
		if (numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_4ZnaczyLadujNaKoniec_PrzedKtoraWladowacWolnaPozycje_zaDuzyNrZnaczyWladowacNaKoniec == 4) numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4++;
		listaPiosenekJednejPozycjiMapa.add(nrAdd, new JednaPozycjaNaLiscieMapa());
		System.out.println("______________ start = "+ numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4 + 
				" ________________ 01234numer na oknie = "+numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3_4ZnaczyLadujNaKoniec_PrzedKtoraWladowacWolnaPozycje_zaDuzyNrZnaczyWladowacNaKoniec);
	}

	// ok
	public void wybierzPiosenkeZListyNazwPasujacych(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3, int numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4){
		listaPiosenekJednejPozycjiMapa.get(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4).wybierzPiosenkeZListyNazwPasujacych(numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4);
	}

	// ok
	/* szuka listy piosenek pasujacych do slow kluczowych, ustawia nrGetListyNaZerowyPanel na wartosc 0, jako wybrana piosenke ustawia pierwsza z listy lub null jak nic nie ma */
	public void wyszukajOdpowiednichPiosenekIWybierzDomyslna(int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		listaPiosenekJednejPozycjiMapa.get(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4).wyszukajOdpowiedniePiosenkiPoSlowachSzukaniaIZaladujJeNaListePlikowNazwJakBylyZmiany_pustaListaSlowSzukaniaZnaczyPowiedzZeNicNiePasuje_wybierzPierwszaPiosenkeJakJakiesSa();
	}

	// ok
	public void zaladujSlowaSzukaniaZOknaINicWiecejNieRob(JTextArea slowaWyszukiwaniaPiosenki, int numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3){
		listaPiosenekJednejPozycjiMapa.get(numerKomponentu1PozycjiListyOdZeraNaOknie_0_1_2_3 + numerGetPozycjiZListyLadujacejNaZerowyPanel_DlaSizeMniejszychOd4_zawsze0__wpp_od0_doSizeMinus4).zaladujSlowaSzukaniaZOknaINicWiecejNieRob(slowaWyszukiwaniaPiosenki);
	}

}
