package OknoGlowne;



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Komponenty.KomponentyZapodaj;
import ListaPiosenekStan.MapaListyPiosenek;
import Zdarzenia.ZmianaSlowSzukaniaJTArea;

public class PozycjaPiesniJComp {

	public JLabel numerSzukanejPiosenkiNaLiscieJLabel;
	public JTextArea slowaWyszukiwaniaPiosenkiJTextArea;
	public ZmianaSlowSzukaniaJTArea zdarzenieZmianySlowSzukaniaWJTextArea;
	
	public ListaPlikowPiesniJButton listaPlikowPiosenekPasujacychJButton;
	
	public JLabel wybranaPiosenkaTytulJLabel;
	public TekstPiosenkiJComp wybranaPiosenkaTekstJComp;
	public OpcjePozycjiZListyJComp opcjePozycjiNaLisciePrzesunLubSkasujJComp;
	
	
	protected void poladujZdarzenia(MapaListyPiosenek mapaListyPiosenek, OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame, int numerOd0PozycjiNaOknie){
		zdarzenieZmianySlowSzukaniaWJTextArea = new ZmianaSlowSzukaniaJTArea(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie);
		slowaWyszukiwaniaPiosenkiJTextArea.getDocument().addDocumentListener(zdarzenieZmianySlowSzukaniaWJTextArea);
		opcjePozycjiNaLisciePrzesunLubSkasujJComp.poladujZdarzenia(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie);
		listaPlikowPiosenekPasujacychJButton.poladujZdarzenia(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie);
		wybranaPiosenkaTekstJComp.poladujZdarzenia(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie);
	}
	
	
	public PozycjaPiesniJComp(Container contentPanel, int yStartowyZGory){
		String [] nrNapis = {"347"};
		numerSzukanejPiosenkiNaLiscieJLabel = KomponentyZapodaj.jlabelZapodaj( nrNapis, "005500", 14, false, null);
		contentPanel.add(numerSzukanejPiosenkiNaLiscieJLabel);
		numerSzukanejPiosenkiNaLiscieJLabel.setBounds(5, yStartowyZGory, 40, 20);
		
		slowaWyszukiwaniaPiosenkiJTextArea = new JTextArea(5, 20);
		slowaWyszukiwaniaPiosenkiJTextArea.setBorder(BorderFactory.createLineBorder(new Color(0, 80, 0)));
		slowaWyszukiwaniaPiosenkiJTextArea.setFont(new Font("arial", Font.PLAIN, 10));
		slowaWyszukiwaniaPiosenkiJTextArea.setLineWrap(true);
		contentPanel.add(slowaWyszukiwaniaPiosenkiJTextArea);
		slowaWyszukiwaniaPiosenkiJTextArea.setBounds(50, yStartowyZGory-10, 100, 90);
		
		
		
		
		listaPlikowPiosenekPasujacychJButton = new ListaPlikowPiesniJButton(contentPanel, yStartowyZGory - 14);
		
		String [] napisTytulPiosenki = {"Abyœmy byli jedno (Niech zst¹pi Duch Twój i odnowi ziemie ¿"};
		wybranaPiosenkaTytulJLabel = KomponentyZapodaj.jlabelZapodaj(napisTytulPiosenki, "cc0022", 8, false, Color.black);
		contentPanel.add(wybranaPiosenkaTytulJLabel);
		wybranaPiosenkaTytulJLabel.setBounds(400, yStartowyZGory - 14, 300, 15);
		
		wybranaPiosenkaTekstJComp = new TekstPiosenkiJComp(contentPanel, yStartowyZGory+15);
		
		opcjePozycjiNaLisciePrzesunLubSkasujJComp = new 	 OpcjePozycjiZListyJComp(contentPanel, yStartowyZGory - 14);
	}
	
}

