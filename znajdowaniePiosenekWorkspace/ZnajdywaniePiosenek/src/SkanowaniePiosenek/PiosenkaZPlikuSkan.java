package SkanowaniePiosenek;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PiosenkaZPlikuSkan {

	private String nazwaPlikuPiosenki;
	private String sciezkaAbsolutnaDoPlikuPiosenki;
	private String trescPiosenkiWczytanaZPlikuINieRuszana = "";
	private char [] trescPiosenkiSameDuzeAngielskieLiteryLubSama1Spacja;
	
	public String getZapodajSciezkeAbsolutna(){
		return sciezkaAbsolutnaDoPlikuPiosenki;
	}
	
	
	public String getNazwaPlikuPiosenki(){
		return nazwaPlikuPiosenki;
	}
	
	public String getZapodajTrescPiosenkiNieRuszana(){
		return trescPiosenkiWczytanaZPlikuINieRuszana;
	}
	
	public boolean piosenkaPasujeDoWzorca(ArrayList<char[]> ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery, boolean szukajLubTrue_szukajIFalse){
		if (ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.size() == 0) return true;
		if (szukajLubTrue_szukajIFalse){
			for (int i = 0; i < ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.size(); i++){
				if (nazwaPlikuPiosenki.length() > 0) if (jedenNiepustyCiagPasujeDoNazwyPlikuITekstuPiosenki(ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.get(i))) return true;
				if (pasuje_ciagiMajaBycNiepuste(ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.get(i), trescPiosenkiSameDuzeAngielskieLiteryLubSama1Spacja)) return true;
			}
			return false;
		} else {
			boolean niePasuje = true;
			for (int i = 0; i < ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.size(); i++){
				niePasuje = true;
				if (nazwaPlikuPiosenki.length() > 0) if (jedenNiepustyCiagPasujeDoNazwyPlikuITekstuPiosenki(ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.get(i))) niePasuje =  false;
				if (pasuje_ciagiMajaBycNiepuste(ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.get(i), trescPiosenkiSameDuzeAngielskieLiteryLubSama1Spacja)) niePasuje = false;
				if (niePasuje) return false;
			}
			return true;
		}
	}
	
	private boolean jedenNiepustyCiagPasujeDoNazwyPlikuITekstuPiosenki(char [] ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery){
		if (nazwaPlikuPiosenki.length() == 0) return false;
		return pasuje_ciagiMajaBycNiepuste(ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery, zrobSameDuzeAngielskieLiteryAlboZamiastTego1Spacje(nazwaPlikuPiosenki));
	}
	
	private boolean pasuje_ciagiMajaBycNiepuste(char [] ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery, char [] tekst){
		
		int pozC;
		int blad3;
		int pozT;
		for (int poczCwTekscie = 0; poczCwTekscie <= tekst.length - ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.length; poczCwTekscie++){
			pozC = 0;
			pozT = poczCwTekscie;
			blad3 = 0;
			while (pozC < ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.length && blad3 <= 3 && pozT < tekst.length){
				if (ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery[pozC] == tekst[pozT]){
					blad3 = 0;
					pozC++;
					pozT++;
				} else{
					blad3++;
					pozT++;
				}
			}
			if (pozC == ciagiDuzychAngLiterSzukaniaMax3BledyPrzesuniecDoPasujacejLitery.length) return true;
		}
		return false;
	}
	

	public PiosenkaZPlikuSkan(byte [] samTekstPiosenkiUTF8, int samTekstPiosenkiUTF8Length, File plikPiosenkiPrezentacja){
		nazwaPlikuPiosenki = plikPiosenkiPrezentacja.getName();
		sciezkaAbsolutnaDoPlikuPiosenki = plikPiosenkiPrezentacja.getAbsolutePath();
		try {
			trescPiosenkiWczytanaZPlikuINieRuszana = new String(samTekstPiosenkiUTF8, 0, samTekstPiosenkiUTF8Length, "utf-8");
		} catch (UnsupportedEncodingException e) { /*nie bedzie tego bledu bo utf8 jest wspierany*/}

		// jest tresc piosenki, teraz ma byc rozkodowanie na tablice znakow:
		trescPiosenkiSameDuzeAngielskieLiteryLubSama1Spacja = new char[1];
		trescPiosenkiSameDuzeAngielskieLiteryLubSama1Spacja[0] = ' ';
		if (trescPiosenkiWczytanaZPlikuINieRuszana.length() > 0){
			//System.out.println(trescPiosenkiWczytanaZPlikuINieRuszana);
			sparsujZnakiZTresciPiosenki();
		}
	}

	private void sparsujZnakiZTresciPiosenki(){
		String tresc = trescPiosenkiWczytanaZPlikuINieRuszana.toUpperCase();
		char znakiDobre [] = new char[trescPiosenkiWczytanaZPlikuINieRuszana.length()];
		int znakiDobreLength = 0;
		char z;
		for (int i = 0; i < trescPiosenkiWczytanaZPlikuINieRuszana.length(); i++){
			z = tresc.charAt(i);
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
			trescPiosenkiSameDuzeAngielskieLiteryLubSama1Spacja = new char[znakiDobreLength];
			for (int i = 0; i < znakiDobreLength; i++) trescPiosenkiSameDuzeAngielskieLiteryLubSama1Spacja[i] = znakiDobre[i];
			//System.out.println(nazwaPlikuPiosenki);
			//System.out.println(new String(trescPiosenkiSameDuzeAngielskieLitery));
		}
	}
	
	private char [] zrobSameDuzeAngielskieLiteryAlboZamiastTego1Spacje(String cosMinimalnie1Znak){
		
		String tresc = cosMinimalnie1Znak.toUpperCase();
		char znakiDobre [] = new char[cosMinimalnie1Znak.length()];
		int znakiDobreLength = 0;
		char z;
		for (int i = 0; i < znakiDobre.length; i++){
			z = tresc.charAt(i);
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
		char w [] = new char[1];
		w[0] = ' ';
		
		if (znakiDobreLength > 0){
			w = new char[znakiDobreLength];
			for (int i = 0; i < znakiDobreLength; i++) w[i] = znakiDobre[i];
		}
		return w;	
	}


}
