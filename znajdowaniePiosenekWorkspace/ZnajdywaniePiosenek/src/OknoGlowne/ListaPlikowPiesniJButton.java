package OknoGlowne;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import ListaPiosenekStan.MapaListyPiosenek;
import Zdarzenia.PrzewinPiosenkiPasujace;
import Zdarzenia.WybierzPiosenkePasujaca;

public class ListaPlikowPiesniJButton {
	
	public JButton wGoreJButton;
	public JButton wDolJButton;
	public JButton [] listaZnalezionych5PasujacychPlikowPiesniJButton = new JButton [5];
	
	protected void poladujZdarzenia(MapaListyPiosenek mapaListyPiosenek, OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame, int numerOd0PozycjiNaOknie){
		for (int i = 0; i < listaZnalezionych5PasujacychPlikowPiesniJButton.length; i++){
			listaZnalezionych5PasujacychPlikowPiesniJButton[i].addActionListener(new WybierzPiosenkePasujaca(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie, i));
		}
		wGoreJButton.addActionListener(new PrzewinPiosenkiPasujace(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie, true));
		wDolJButton.addActionListener(new PrzewinPiosenkiPasujace(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie, false));
	}
	
	
	
	
	public ListaPlikowPiesniJButton(Container contentPanel, int yStartowyZGory){
	
		// wstaw przyciski w gore i w dol:
		wGoreJButton = new JButton("^");
		wGoreJButton.setFont(new Font("arial black", Font.BOLD, 14));
		wGoreJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wGoreJButton);
		wGoreJButton.setBounds(158, yStartowyZGory, 20, 20);
		
		wDolJButton = new JButton("v");
		wDolJButton.setFont(new Font("arial black", Font.BOLD, 12));
		wDolJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wDolJButton);
		wDolJButton.setBounds(158, yStartowyZGory + 75, 20, 20);
		
		
		// wstaw przyciski listy plikow
		for (int i = 0; i < listaZnalezionych5PasujacychPlikowPiesniJButton.length; i++){
			listaZnalezionych5PasujacychPlikowPiesniJButton[i] = new JButton("Abyœmy byli jedno (Niech zst¹pi Duch Twój i odnowi ca³¹ ziemiê).odp");
			listaZnalezionych5PasujacychPlikowPiesniJButton[i].setBounds(180, yStartowyZGory + i * 20, 200, 20);
			contentPanel.add(listaZnalezionych5PasujacychPlikowPiesniJButton[i]);
			listaZnalezionych5PasujacychPlikowPiesniJButton[i].setFont(new Font("arial", Font.PLAIN, 10));
			listaZnalezionych5PasujacychPlikowPiesniJButton[i].setMargin(new Insets(2, 2, 2, 2));
		}
		
		
		
	}
	
	

}
