package OknoGlowne;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

import ListaPiosenekStan.MapaListyPiosenek;
import Zdarzenia.SkasujPiesnZListyJButton;
import Zdarzenia.ZamienSasiedniePiosenki;

public class OpcjePozycjiZListyJComp {

	public JButton wGoreJButton;
	public JButton wDolJButton;
	public JButton skasujJButton;


	protected void poladujZdarzenia(MapaListyPiosenek mapaListyPiosenek, OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame, int numerOd0PozycjiNaOknie){
		skasujJButton.addActionListener(new SkasujPiesnZListyJButton(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie));
		wGoreJButton.addActionListener(new ZamienSasiedniePiosenki(mapaListyPiosenek, oknoZrobListePiesniJFrame, true, numerOd0PozycjiNaOknie));
		wDolJButton.addActionListener(new ZamienSasiedniePiosenki(mapaListyPiosenek, oknoZrobListePiesniJFrame, false, numerOd0PozycjiNaOknie));
	}


	public OpcjePozycjiZListyJComp(Container contentPanel, int yStartowyZGory){

		// wstaw przyciski w gore i w dol:
		wGoreJButton = new JButton("^");
		wGoreJButton.setFont(new Font("arial black", Font.BOLD, 14));
		wGoreJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wGoreJButton);
		wGoreJButton.setBounds(730, yStartowyZGory, 40, 20);

		wDolJButton = new JButton("v");
		wDolJButton.setFont(new Font("arial black", Font.BOLD, 12));
		wDolJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wDolJButton);
		wDolJButton.setBounds(730, yStartowyZGory + 80, 40, 20);

		skasujJButton = new JButton("x");
		skasujJButton.setFont(new Font("arial black", Font.BOLD, 18));
		skasujJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(skasujJButton);
		skasujJButton.setBounds(735, yStartowyZGory + 35, 30, 30);
	}
}
