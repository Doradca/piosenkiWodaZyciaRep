package ListaPiosenekStan;

import java.util.ArrayList;

import OknoGlowne.ListaPlikowPiesniJButton;
import SkanowaniePiosenek.PiosenkaZPlikuSkan;
import SkanowaniePiosenek.SkanujPiosenkiLibreOfficeUTF8;

public class ListaDobrychPiosenekMapa {
	private ArrayList<PiosenkaZPlikuSkan> znalezionePasujacePiosenkiZPlikuSkan = new ArrayList<PiosenkaZPlikuSkan>();
	private int numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5;

	protected void wyrenderujDobrePiosenki(ListaPlikowPiesniJButton listaPlikowPiosenekPasujacychJButton){
		if (numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5 == 0) listaPlikowPiosenekPasujacychJButton.wGoreJButton.setVisible(false);
		else listaPlikowPiosenekPasujacychJButton.wGoreJButton.setVisible(true);
		if (numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5 + 5 >= znalezionePasujacePiosenkiZPlikuSkan.size()) listaPlikowPiosenekPasujacychJButton.wDolJButton.setVisible(false);
		else listaPlikowPiosenekPasujacychJButton.wDolJButton.setVisible(true);
		for (int i = 0; i < 5; i++){
			if (i < znalezionePasujacePiosenkiZPlikuSkan.size()) {
				listaPlikowPiosenekPasujacychJButton.listaZnalezionych5PasujacychPlikowPiesniJButton[i].setVisible(true);	
				listaPlikowPiosenekPasujacychJButton.listaZnalezionych5PasujacychPlikowPiesniJButton[i].setText(znalezionePasujacePiosenkiZPlikuSkan.get(i + numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5).getNazwaPlikuPiosenki());
			}
			else listaPlikowPiosenekPasujacychJButton.listaZnalezionych5PasujacychPlikowPiesniJButton[i].setVisible(false);
		}
	}

	protected void przewinDobrePiosenkiWGore(){
		numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5--;
	}

	protected void przewinDobrePiosenkiWDol(){
		numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5++;
	}


	protected PiosenkaZPlikuSkan wybierzPiosenkeZListyNazwPasujacych(int numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4){
		return znalezionePasujacePiosenkiZPlikuSkan.get(numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5 + numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4);
	}


	protected PiosenkaZPlikuSkan wyszukajOdpowiedniePiosenkiPoSlowachSzukaniaIZaladujJeNaListePlikowNazwJakBylyZmiany_pustaListaSlowSzukaniaZnaczyPowiedzZeNicNiePasuje_wybierzPierwszaPiosenkeJakJakiesSa(SlowaSzukaniaMapa slowaSzukaniaMapa, PiosenkaZPlikuSkan wczesniejszaPiosenka){
	
		ArrayList<PiosenkaZPlikuSkan> wczesniejszePiosenki = znalezionePasujacePiosenkiZPlikuSkan;
		int wczesniejszyNrGet = numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5;

		// zeskanuj piosenki od nowa
		znalezionePasujacePiosenkiZPlikuSkan = new ArrayList<PiosenkaZPlikuSkan>();		
		numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5 = 0; //???
		if (slowaSzukaniaMapa.ciagiDuzychAngLiterSzukaniaMax10BledowPrzesuniecDoPasujacejLitery.size() == 0) return null;
		for (int nrPiosenki = 0; nrPiosenki < SkanujPiosenkiLibreOfficeUTF8.wszystkieZnalezionePiosenkiLibreOfficeUTF8Skan.size(); nrPiosenki++){
			if (SkanujPiosenkiLibreOfficeUTF8.wszystkieZnalezionePiosenkiLibreOfficeUTF8Skan.get(nrPiosenki).piosenkaPasujeDoWzorca(slowaSzukaniaMapa.ciagiDuzychAngLiterSzukaniaMax10BledowPrzesuniecDoPasujacejLitery, slowaSzukaniaMapa.szukajLubTrue_szukajIFalse)){
				znalezionePasujacePiosenkiZPlikuSkan.add(SkanujPiosenkiLibreOfficeUTF8.wszystkieZnalezionePiosenkiLibreOfficeUTF8Skan.get(nrPiosenki));
			}
		}
		if (znalezionePasujacePiosenkiZPlikuSkan.size() == 0) return null;
		
		// sprawdz czy listy maja to samo
		if (arrayListyZawierajaTeSamePiesniPoTytulachISlowachKolejno(wczesniejszePiosenki, znalezionePasujacePiosenkiZPlikuSkan)){
			numerGetPozycjiZListyLadujacejNaZerowyJButton_DlaSizeMniejszychOd5_zawsze0__wpp_od0_doSizeMinus5 = wczesniejszyNrGet;
			System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooookkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
			return wczesniejszaPiosenka;
		}
		return znalezionePasujacePiosenkiZPlikuSkan.get(0);
	}
	
	private boolean arrayListyZawierajaTeSamePiesniPoTytulachISlowachKolejno(ArrayList<PiosenkaZPlikuSkan> wczesniejszePiosenki, ArrayList<PiosenkaZPlikuSkan> nowePiosenki){
		if (wczesniejszePiosenki.size() != nowePiosenki.size()) return false;
		System.out.println("porownuje ................");
		
		for (int i = 0; i < wczesniejszePiosenki.size(); i++){
			if ( ! wczesniejszePiosenki.get(i).getNazwaPlikuPiosenki().equals(nowePiosenki.get(i).getNazwaPlikuPiosenki())) return false;
			if ( ! wczesniejszePiosenki.get(i).getZapodajTrescPiosenkiNieRuszana().equals(nowePiosenki.get(i).getZapodajTrescPiosenkiNieRuszana())) return false;
		}
		return true;
	}
}
