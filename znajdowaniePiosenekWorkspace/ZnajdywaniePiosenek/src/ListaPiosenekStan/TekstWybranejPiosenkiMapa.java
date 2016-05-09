package ListaPiosenekStan;

import java.util.ArrayList;

import Komponenty.KomponentyZapodaj;
import OknoGlowne.TekstPiosenkiJComp;
import SkanowaniePiosenek.PiosenkaZPlikuSkan;

public class TekstWybranejPiosenkiMapa {

	private ArrayList<String> wierszePiosenki45ZnakowMaxNaOknie6Wierszy = new ArrayList<String>();
	private int numerGetPozycjiZListyLadujacejNaZerowyWiersz_DlaSizeMniejszychOd6_zawsze0__wpp_od0_doSizeMinus6 = 0;
	

	protected void wyrenderuj(TekstPiosenkiJComp tekstPiosenkiJComp){
		
		// przyciski gora dol:
		if (numerGetPozycjiZListyLadujacejNaZerowyWiersz_DlaSizeMniejszychOd6_zawsze0__wpp_od0_doSizeMinus6 == 0) tekstPiosenkiJComp.wGoreJButton.setVisible(false);
		else tekstPiosenkiJComp.wGoreJButton.setVisible(true);
		if (numerGetPozycjiZListyLadujacejNaZerowyWiersz_DlaSizeMniejszychOd6_zawsze0__wpp_od0_doSizeMinus6 + 6 >= wierszePiosenki45ZnakowMaxNaOknie6Wierszy.size()) tekstPiosenkiJComp.wDolJButton.setVisible(false);
		else tekstPiosenkiJComp.wDolJButton.setVisible(true);
		
		// tekst:
		String [] wiersze = null;
		if (wierszePiosenki45ZnakowMaxNaOknie6Wierszy.size() > 0){
			int dl = wierszePiosenki45ZnakowMaxNaOknie6Wierszy.size();
			if (dl > 6) dl = 6;
			wiersze = new String[dl];
			for (int i = 0; i < dl; i++) wiersze[i] = wierszePiosenki45ZnakowMaxNaOknie6Wierszy.get(numerGetPozycjiZListyLadujacejNaZerowyWiersz_DlaSizeMniejszychOd6_zawsze0__wpp_od0_doSizeMinus6+i); 
		}
		KomponentyZapodaj.setTekstPiosenki(tekstPiosenkiJComp.tekstPiosenkiJLabel, wiersze);
	}
	
	protected void przewinTekstPiosenkiWGore(){
		numerGetPozycjiZListyLadujacejNaZerowyWiersz_DlaSizeMniejszychOd6_zawsze0__wpp_od0_doSizeMinus6--;
	}
	
	protected void przewinTekstPiosenkiWDol(){
		numerGetPozycjiZListyLadujacejNaZerowyWiersz_DlaSizeMniejszychOd6_zawsze0__wpp_od0_doSizeMinus6++;
	}
	
	protected void rozwierszujTekstWybranejPiosenki(PiosenkaZPlikuSkan wybranaPiosenkaZPlikuSkan){
		String tekst = wybranaPiosenkaZPlikuSkan.getZapodajTrescPiosenkiNieRuszana();
		wierszePiosenki45ZnakowMaxNaOknie6Wierszy.clear();
		numerGetPozycjiZListyLadujacejNaZerowyWiersz_DlaSizeMniejszychOd6_zawsze0__wpp_od0_doSizeMinus6 = 0;
		String jedenWiersz = "";
		for (int i = 0; i < tekst.length(); i++){
			if (tekst.charAt(i) == '\n' || jedenWiersz.length() == 45){
				wierszePiosenki45ZnakowMaxNaOknie6Wierszy.add(jedenWiersz);
				jedenWiersz = "";
			} else jedenWiersz += tekst.charAt(i);
		}
		if (jedenWiersz.length() > 0) wierszePiosenki45ZnakowMaxNaOknie6Wierszy.add(jedenWiersz);
		
	}

}
