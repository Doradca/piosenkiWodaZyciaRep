package OknoGlowne;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;

import Komponenty.KomponentyZapodaj;
import ListaPiosenekStan.MapaListyPiosenek;
import Zdarzenia.PrzewinTekstPiosenki;
public class TekstPiosenkiJComp {

	public JLabel tekstPiosenkiJLabel;
	public JButton wGoreJButton;
	public JButton wDolJButton;
	
	
	protected void poladujZdarzenia(MapaListyPiosenek mapaListyPiosenek, OknoZrobListePiesniJFrame oknoZrobListePiesniJFrame, int numerOd0PozycjiNaOknie){
		wGoreJButton.addActionListener(new PrzewinTekstPiosenki(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie, true));
		wDolJButton.addActionListener(new PrzewinTekstPiosenki(mapaListyPiosenek, oknoZrobListePiesniJFrame, numerOd0PozycjiNaOknie, false));
	}
	
	
	
	public TekstPiosenkiJComp(Container contentPanel, int yStartowyZGory){
		
		
		// wstaw przyciski w gore i w dol:
		wGoreJButton = new JButton("^");
		wGoreJButton.setFont(new Font("arial black", Font.BOLD, 14));
		wGoreJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wGoreJButton);
		wGoreJButton.setBounds(400, yStartowyZGory - 10, 20, 20);
		
		wDolJButton = new JButton("v");
		wDolJButton.setFont(new Font("arial black", Font.BOLD, 12));
		wDolJButton.setMargin(new Insets(2, 2, 2, 2));
		contentPanel.add(wDolJButton);
		wDolJButton.setBounds(400, yStartowyZGory + 50, 20, 20);
		
		// JLabel z tekstem piosenki
		String [] napisNaEtykiecieKolejneLinie = {"aaaaaaaaaabbbbbbbbbbccccccccccdddddddddd",
				"aaaaaaaaaabbbbbbbbbbccccccccccdddddddddd",
				"aaaaaaaaaabbbbbbbbbbccccccccccdddddddddd12345",
				"wznosimy dziœ rêce swe",
				"ca³y œwiat zewangelizowany",
				"aaaaa666666a"};
		tekstPiosenkiJLabel = KomponentyZapodaj.jlabelZapodaj(napisNaEtykiecieKolejneLinie, "0000cc", 8, true, Color.orange);
		contentPanel.add(tekstPiosenkiJLabel);
		tekstPiosenkiJLabel.setBounds(425, yStartowyZGory - 12, 275, 82);
		
	}
}
