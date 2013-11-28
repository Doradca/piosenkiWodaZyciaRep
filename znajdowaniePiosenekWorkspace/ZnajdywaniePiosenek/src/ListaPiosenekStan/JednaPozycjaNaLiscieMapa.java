package ListaPiosenekStan;

import javax.swing.JTextArea;

import Komponenty.KomponentyZapodaj;
import OknoGlowne.PozycjaPiesniJComp;
import SkanowaniePiosenek.PiosenkaZPlikuSkan;


public class JednaPozycjaNaLiscieMapa {
	private SlowaSzukaniaMapa slowaSzukaniaMapa;
	private ListaDobrychPiosenekMapa listaDobrychPiosenekMapa;
	private PiosenkaZPlikuSkan wybranaPiosenkaSkan = null; // tytul zmiesci max 59 znakow - utnijmy na 56
	private TekstWybranejPiosenkiMapa tekstWybranejPiosenkiMapa;

	
	protected PiosenkaZPlikuSkan zapodajPiosenkeDoOdpalenia(){
		return wybranaPiosenkaSkan;
	}
	
	
	protected void wyrenderujJednaPozycjeNaPanelWOknie(PozycjaPiesniJComp pozycjaPiesniJComp, boolean nieRobiTegoZdarzenieZmianySlowWJtextArea){
		if (wybranaPiosenkaSkan != null)
			System.out.println(wybranaPiosenkaSkan.getNazwaPlikuPiosenki());

		slowaSzukaniaMapa.wyrenderuj(pozycjaPiesniJComp, nieRobiTegoZdarzenieZmianySlowWJtextArea);
		listaDobrychPiosenekMapa.wyrenderujDobrePiosenki(pozycjaPiesniJComp.listaPlikowPiosenekPasujacychJButton);

		if (wybranaPiosenkaSkan == null) {
			
			// nie ma zadnej wybranej piosenki
			pozycjaPiesniJComp.wybranaPiosenkaTytulJLabel.setVisible(false);
			pozycjaPiesniJComp.wybranaPiosenkaTekstJComp.wDolJButton.setVisible(false);
			pozycjaPiesniJComp.wybranaPiosenkaTekstJComp.wGoreJButton.setVisible(false);
			pozycjaPiesniJComp.wybranaPiosenkaTekstJComp.tekstPiosenkiJLabel.setVisible(false);
		} else {
			
			// jest wybrana piosenka
			pozycjaPiesniJComp.wybranaPiosenkaTytulJLabel.setVisible(true);
			String tytul = wybranaPiosenkaSkan.getNazwaPlikuPiosenki();
			if (tytul.length() > 56) tytul = tytul.substring(0, 56);

			// ustaw tytul napis
			KomponentyZapodaj.setZmienTytulPiosenki(pozycjaPiesniJComp.wybranaPiosenkaTytulJLabel, tytul);

			// wstepnie ustaw tekst piosenki:
			pozycjaPiesniJComp.wybranaPiosenkaTekstJComp.wDolJButton.setVisible(true);
			pozycjaPiesniJComp.wybranaPiosenkaTekstJComp.wGoreJButton.setVisible(true);
			pozycjaPiesniJComp.wybranaPiosenkaTekstJComp.tekstPiosenkiJLabel.setVisible(true);
			tekstWybranejPiosenkiMapa.wyrenderuj(pozycjaPiesniJComp.wybranaPiosenkaTekstJComp);
		}



	}

	protected void przewinTekstPiosenkiWGore(){
		tekstWybranejPiosenkiMapa.przewinTekstPiosenkiWGore();
	}

	protected void przewinTekstPiosenkiWDol(){
		tekstWybranejPiosenkiMapa.przewinTekstPiosenkiWDol();
	}

	protected void przewinDobrePiosenkiWGore(){
		listaDobrychPiosenekMapa.przewinDobrePiosenkiWGore();
	}

	protected void przewinDobrePiosenkiWDol(){
		listaDobrychPiosenekMapa.przewinDobrePiosenkiWDol();
	}


	protected JednaPozycjaNaLiscieMapa(){
		slowaSzukaniaMapa = new SlowaSzukaniaMapa();
		listaDobrychPiosenekMapa = new ListaDobrychPiosenekMapa();
		tekstWybranejPiosenkiMapa = new TekstWybranejPiosenkiMapa();

	}

	protected void wybierzPiosenkeZListyNazwPasujacych(int numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4){
		wybranaPiosenkaSkan = listaDobrychPiosenekMapa.wybierzPiosenkeZListyNazwPasujacych(numerJButtonaNaLiscieDobrychPiosenekNaOknie_0_1_2_3_4);
		tekstWybranejPiosenkiMapa.rozwierszujTekstWybranejPiosenki(wybranaPiosenkaSkan);
	}

	protected void wyszukajOdpowiedniePiosenkiPoSlowachSzukaniaIZaladujJeNaListePlikowNazwJakBylyZmiany_pustaListaSlowSzukaniaZnaczyPowiedzZeNicNiePasuje_wybierzPierwszaPiosenkeJakJakiesSa(){
		wybranaPiosenkaSkan = listaDobrychPiosenekMapa.wyszukajOdpowiedniePiosenkiPoSlowachSzukaniaIZaladujJeNaListePlikowNazwJakBylyZmiany_pustaListaSlowSzukaniaZnaczyPowiedzZeNicNiePasuje_wybierzPierwszaPiosenkeJakJakiesSa(slowaSzukaniaMapa, wybranaPiosenkaSkan);
		if (wybranaPiosenkaSkan != null) tekstWybranejPiosenkiMapa.rozwierszujTekstWybranejPiosenki(wybranaPiosenkaSkan);
	} 

	protected void zaladujSlowaSzukaniaZOknaINicWiecejNieRob(JTextArea slowaWyszukiwaniaPiosenkiJTextArea){
		slowaSzukaniaMapa.zaladujSlowaSzukaniaZOknaINicWiecejNieRob(slowaWyszukiwaniaPiosenkiJTextArea);
	}

}
