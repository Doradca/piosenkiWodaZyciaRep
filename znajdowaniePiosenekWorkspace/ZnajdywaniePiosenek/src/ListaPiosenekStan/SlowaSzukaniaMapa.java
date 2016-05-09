package ListaPiosenekStan;

import java.util.ArrayList;

import javax.swing.JTextArea;

import OknoGlowne.PozycjaPiesniJComp;

public class SlowaSzukaniaMapa {

	private String napisWPoluSzukaniaJTextArea = "";

	/* ciagi szukania sa sczytywane jako same wielkie angielskie litery, tzn
	 * polskie litery sa zamieniane na angielskie odpowiedniki, a potem upperCase.
	 * inne znaki sa pomijane - jako spacje lub entery. Pomiedzy znakami z ciagu moze byc w piosence dowolnie wiele
	 * spacji i enterow, i maksymalnie 10 niepasujacych znakow - w razie wiekszej liczby ciag nie pasuje 
	 * w dane miejsce piosenki.
	 * 
	 */
	protected ArrayList<char[]> ciagiDuzychAngLiterSzukaniaMax10BledowPrzesuniecDoPasujacejLitery = new ArrayList<char[]>();
	protected boolean szukajLubTrue_szukajIFalse = true;


	protected void wyrenderuj(PozycjaPiesniJComp pozycjaPiesniJComp, boolean nieRobiTegoZdarzenieZmianySlowWJtextArea){
		if (nieRobiTegoZdarzenieZmianySlowWJtextArea){
			pozycjaPiesniJComp.slowaWyszukiwaniaPiosenkiJTextArea.getDocument().removeDocumentListener(pozycjaPiesniJComp.zdarzenieZmianySlowSzukaniaWJTextArea);
			pozycjaPiesniJComp.slowaWyszukiwaniaPiosenkiJTextArea.setText(napisWPoluSzukaniaJTextArea); 
			pozycjaPiesniJComp.slowaWyszukiwaniaPiosenkiJTextArea.getDocument().addDocumentListener(pozycjaPiesniJComp.zdarzenieZmianySlowSzukaniaWJTextArea);
		}
	}


	protected void zaladujSlowaSzukaniaZOknaINicWiecejNieRob(JTextArea slowaWyszukiwaniaPiosenkiJTextArea){
		napisWPoluSzukaniaJTextArea = slowaWyszukiwaniaPiosenkiJTextArea.getText();
		rozparsujNapisSzukaniaPiosenkiDoArrayListy();
	}

	/* sciaga napis do znaku ' lub |. Potem taki napis laduje do parsowania na podciag */
	private void rozparsujNapisSzukaniaPiosenkiDoArrayListy(){
		ciagiDuzychAngLiterSzukaniaMax10BledowPrzesuniecDoPasujacejLitery.clear();
		String podciag = "";
		char z;
		boolean nieMaTrybu = true;
		for (int pozycja = 0; pozycja < napisWPoluSzukaniaJTextArea.length(); pozycja++){
			z = napisWPoluSzukaniaJTextArea.charAt(pozycja);
			if (z == '|'){
				if (nieMaTrybu){
					szukajLubTrue_szukajIFalse = true;
					nieMaTrybu = false;
				}
				char [] podciagChary = parsujPodciag(podciag);
				if (podciagChary != null) ciagiDuzychAngLiterSzukaniaMax10BledowPrzesuniecDoPasujacejLitery.add(podciagChary);
				podciag = "";
			}
			if (z == '\''){
				if (nieMaTrybu){
					szukajLubTrue_szukajIFalse = false;
					nieMaTrybu = false;
				}
				char [] podciagChary = parsujPodciag(podciag);
				if (podciagChary != null) ciagiDuzychAngLiterSzukaniaMax10BledowPrzesuniecDoPasujacejLitery.add(podciagChary);
				podciag = "";
			}
			if (z != '|' && z != '\''){
				podciag += z;
			}
		}
		char [] podciagChary = parsujPodciag(podciag);
		if (podciagChary != null) ciagiDuzychAngLiterSzukaniaMax10BledowPrzesuniecDoPasujacejLitery.add(podciagChary);
	}

	/* z podciagu wybiera polski litery, zamienia je na duze, polskie przerabia na angielskie,
	 * potem laduje same litery do char array, w razie bledu zwraca nulla */
	private char [] parsujPodciag(String podciag){
		if (podciag.length() == 0) return null;
		String ppp = podciag.toUpperCase();
		char znakiDobre [] = new char[ppp.length()];
		int znakiDobreLength = 0;
		char z;
		for (int i = 0; i < ppp.length(); i++){
			z = ppp.charAt(i);
			switch (z){
			case '¥': z = 'A'; break;
			case 'Æ': z = 'C'; break;
			case 'Ê': z = 'E'; break;
			case '£': z = 'L'; break;
			case 'Ñ': z = 'N'; break;
			case 'Ó': z = 'O'; break;
			case 'Œ': z = 'S'; break;
			case '': z = 'Z'; break;
			case '¯': z = 'Z'; break;
			}
			if (z >= 'A' && z <= 'Z'){
				znakiDobre[znakiDobreLength] = z;
				znakiDobreLength++;
			}
		}
		//System.out.println("wszedl = "+znakiDobreLength);
		if (znakiDobreLength > 0){
			char [] podciagZnaki = new char[znakiDobreLength];
			for (int i = 0; i < znakiDobreLength; i++) podciagZnaki[i] = znakiDobre[i];
			return podciagZnaki;
		} else return null;
	}

}
