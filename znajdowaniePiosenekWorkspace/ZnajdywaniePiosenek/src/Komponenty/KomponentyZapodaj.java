package Komponenty;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class KomponentyZapodaj {

	public static void setTekstPiosenki(JLabel tekst, String [] wierszeTekstuLengthMax6){

		String wiersze = "";
		if (wierszeTekstuLengthMax6 != null) wiersze = wierszeTekstuLengthMax6[0];
		for (int i = 1; i < wierszeTekstuLengthMax6.length; i++) wiersze += "<p>" + wierszeTekstuLengthMax6[i];
		tekst.setText("<html><body>"
				+ "<div style='color: 0000cc; font-size: 8px;'>"
				+ wiersze
				+ "</div>"
				+ "</body></html>");
		tekst.setAlignmentX(JLabel.LEFT);
	}



	public static void setZmienTytulPiosenki(JLabel tytul, String nowyTytul){
		tytul.setText("<html><body>"
				+ "<div style='color: cc0022; font-size: 8px;'>"
				+ nowyTytul
				+ "</div>"
				+ "</body></html>");
		tytul.setAlignmentX(JLabel.LEFT);
	}

	public static void setZmienNumerPiosenki(JLabel numer, int nowyNumer){
		numer.setText("<html><body>"
				+ "<div style='color: 005500; font-size: 14px;'>"
				+ nowyNumer
				+ "</div>"
				+ "</body></html>");
		numer.setAlignmentX(JLabel.LEFT);
	}



	public static JLabel jlabelZapodaj(String [] napisNaEtykiecieKolejneLinie, String kolorHTMLKod, int fontSizePx,
			boolean maBycRamka, Color kolorRamki){

		String napisNaEtykiecie = "";
		if (napisNaEtykiecieKolejneLinie != null){
			napisNaEtykiecie = napisNaEtykiecieKolejneLinie[0];
			for (int i = 1; i < napisNaEtykiecieKolejneLinie.length; i++) napisNaEtykiecie += "<p>" + napisNaEtykiecieKolejneLinie[i];
		}
		JLabel napisEtykieta = new JLabel("<html><body>"
				+ "<div style='color: " + kolorHTMLKod + "; font-size: " + fontSizePx + "px;'>"
				+ napisNaEtykiecie
				+ "</div>"
				+ "</body></html>", JLabel.LEFT);
		if (maBycRamka) napisEtykieta.setBorder(BorderFactory.createLineBorder(kolorRamki));
		napisEtykieta.setVisible(true);
		return napisEtykieta;
	}
}
