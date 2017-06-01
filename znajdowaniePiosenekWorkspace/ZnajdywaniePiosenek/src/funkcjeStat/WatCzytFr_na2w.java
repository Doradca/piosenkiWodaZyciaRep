package funkcjeStat;

import java.io.InputStream;

public class WatCzytFr_na2w extends Thread{
	protected boolean brakRozkazuZatrzymaniaWczytywaniaTegoFragmentu = true;
	private InputStream inStrumienRead;
	protected int wczytanoBajtowFragmentuLacznie = 0;
	protected byte [] tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca;
	protected boolean watekIsRunning_nieSkonczylMetodyRun = true;

	public void run(){
		try {
			int ileWczytanoBajtow_jednymRead = inStrumienRead.read(tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca, wczytanoBajtowFragmentuLacznie,
					tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca.length - wczytanoBajtowFragmentuLacznie);
			while (brakRozkazuZatrzymaniaWczytywaniaTegoFragmentu
					&& ileWczytanoBajtow_jednymRead > 0 
					&& wczytanoBajtowFragmentuLacznie < tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca.length){
				wczytanoBajtowFragmentuLacznie += ileWczytanoBajtow_jednymRead;
				// odczyt
				ileWczytanoBajtow_jednymRead = inStrumienRead.read(tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca, wczytanoBajtowFragmentuLacznie,
						tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca.length - wczytanoBajtowFragmentuLacznie);
			}
		} catch (Exception e) {}
		watekIsRunning_nieSkonczylMetodyRun = false;
	}

	public WatCzytFr_na2w(InputStream inStrumienRead_, byte [] tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca_){
		//wczytGlowny = wczytGlowny_;
		inStrumienRead = inStrumienRead_;
		tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca = tablicaBajtow_naNiaWczytywacOdPoczatku_najlepiejDoKonca_;
	}

}
