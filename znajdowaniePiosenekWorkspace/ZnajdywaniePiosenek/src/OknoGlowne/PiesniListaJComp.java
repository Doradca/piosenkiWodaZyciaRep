package OknoGlowne;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import ListaPiosenekStan.MapaListyPiosenek;
import Zdarzenia.DodaniePozDoListyJButton;
import Zdarzenia.PrzewinCalaListeWDol;
import Zdarzenia.PrzewinCalaListeWGore;

public class PiesniListaJComp {

	public JButton wGoreJButton;
	public JButton wDolJButton;
	public PozycjaPiesniJComp pozycje4PiesniJComp [] = new PozycjaPiesniJComp[4];
	public JButton [] dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton = new JButton [pozycje4PiesniJComp.length+1];

	
	protected void poladujZdarzenia(MapaListyPiosenek mapaListyPiosenek, OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame){
		for (int i = 0; i < pozycje4PiesniJComp.length; i++) pozycje4PiesniJComp[i].poladujZdarzenia(mapaListyPiosenek, oknoZrobListePiesniJFrame, i);
		for (int i = 0; i < dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton.length; i++) 
			dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton[i].addActionListener(new DodaniePozDoListyJButton(mapaListyPiosenek, oknoZrobListePiesniJFrame, i));
		wGoreJButton.addActionListener(new PrzewinCalaListeWGore(mapaListyPiosenek, oknoZrobListePiesniJFrame));
		wDolJButton.addActionListener(new PrzewinCalaListeWDol(mapaListyPiosenek, oknoZrobListePiesniJFrame));

		
		
	}
	
	
	

	
	
	public PiesniListaJComp(Container contentPanel){

		// wstaw przyciski w gore i w dol:
		wGoreJButton = new JButton("^");
		wGoreJButton.setFont(new Font("arial black", Font.BOLD, 14));
		wGoreJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wGoreJButton);
		wGoreJButton.setBounds(5, 5, 20, 20);
		
		wDolJButton = new JButton("v");
		wDolJButton.setFont(new Font("arial black", Font.BOLD, 12));
		wDolJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wDolJButton);
		wDolJButton.setBounds(5, 490, 20, 20);
		
		// zaladuj przyciski dodaj nowy wiersz
		for (int i = 0; i < dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton.length; i++){
			dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton[i] = new JButton("dodaj now¹ pozycjê");
			dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton[i].setBounds(30, 5 + i * 122, 500, 15);
			contentPanel.add(dodajWierszDlugoscWiekszaO1OdIlosciWierszyPaneliJButton[i]);
		}
		
		// zaladuj komponenty pozycji kolejnych piesni:
		for (int i = 0; i < pozycje4PiesniJComp.length; i++){
			pozycje4PiesniJComp[i] = new PozycjaPiesniJComp(contentPanel, 40 + i * 122);
		}
		
	}


}
