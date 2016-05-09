package OknoGlowne;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Komponenty.KomponentyZapodaj;
import ListaPiosenekStan.MapaListyPiosenek;
import ZdarzOdpalPiesni.OdpalPiosenki;

public class OknoZrobListePiesniJFrame extends JFrame {


	public PiesniListaJComp piesniListaJComp;
	
	private static final long serialVersionUID = 1902298548316626081L;
	private JButton legendaJButton;
	private JButton odpalPiosenkiISkonczProgramJButton;
	private JButton skanujPonowniePiosenkiZPlikowJButton;
	private JButton loadSaveJButton;
	private JLabel copyrightByDoradcaJLabel;
	
	public OknoZrobListePiesniJFrame(){
		ustawWymiaryOknaIExitOnClose();
		wstawPrzyciskiSPozaListyBezZdarzen();
		wstawGlownaListeKomponentowNaPiosenki();
		poladujZdarzenia(new MapaListyPiosenek(this));
	}
	
	// do sprawdzenia i poprawienia !!!
	private void poladujZdarzenia(MapaListyPiosenek mapaListyPiosenek){
		piesniListaJComp.poladujZdarzenia(mapaListyPiosenek, this);
		
		odpalPiosenkiISkonczProgramJButton.addActionListener(new OdpalPiosenki(mapaListyPiosenek, this));
	}
	
	private void wstawGlownaListeKomponentowNaPiosenki(){
		piesniListaJComp = new PiesniListaJComp(this.getContentPane());
	}
	
	private void wstawPrzyciskiSPozaListyBezZdarzen(){
		Container contentPanel = this.getContentPane();
		
		legendaJButton = new JButton("legenda");
		legendaJButton.setBounds(20, 520, 80, 30);
		contentPanel.add(legendaJButton);	
		legendaJButton.setVisible(false);
		
		loadSaveJButton = new JButton("wczytaj / zapisz");
		loadSaveJButton.setBounds(120, 520, 130, 30);
		contentPanel.add(loadSaveJButton);
		loadSaveJButton.setVisible(false);
		
		skanujPonowniePiosenkiZPlikowJButton = new JButton("skanuj pliki piosenek");
		skanujPonowniePiosenkiZPlikowJButton.setBounds(270, 520, 160, 30);
		contentPanel.add(skanujPonowniePiosenkiZPlikowJButton);
		skanujPonowniePiosenkiZPlikowJButton.setVisible(false);
		
		odpalPiosenkiISkonczProgramJButton = new JButton("odpal piosenki");
		odpalPiosenkiISkonczProgramJButton.setBounds(450, 520, 220, 30);
		contentPanel.add(odpalPiosenkiISkonczProgramJButton);
		
		String napis [] = {"&#169 copyright", "by Doradca", "Pawe³ Magryta"};		
		copyrightByDoradcaJLabel = KomponentyZapodaj.jlabelZapodaj(napis, "000055", 10, false, Color.black);
		copyrightByDoradcaJLabel.setBounds(680, 500, 100, 60);
		contentPanel.add(copyrightByDoradcaJLabel);
	}
	
	
	private void ustawWymiaryOknaIExitOnClose(){
		
		// oblicz polozenie okna na srodku:
		Dimension wymiaryEkranu = Toolkit.getDefaultToolkit().getScreenSize();
		int polozenieXOkna = (wymiaryEkranu.width - 800) / 2;
		int polozenieYOkna = (wymiaryEkranu.height - 600) / 2;
		
		// wstaw okno:		
		this.setTitle("Zapodaj piosenki na ¿yczenie Szefowej :)");
		this.createRootPane();
		this.setBounds(polozenieXOkna, polozenieYOkna, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}
	
	
}

